package myjdkproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyProxy {
    private static final String ln = "\r\n";
    public static Object newProxyInstance(MyClassLoader classLoader, Class<?> [] interfaces, MyInvocationHandler handler) {
        //2.动态生成$Proxy0代码
        String src = generateClass(interfaces);

        //2、Java文件输出磁盘
        String srcPath = MyProxy.class.getResource("").getPath();
        File srcFile = new File(srcPath + "$Proxy0.java");
        try {
            FileWriter fw = new FileWriter(srcFile);
            fw.write(src);
            fw.flush();
            fw.close();

            //3、把生成的.java文件编译成.class文件
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = javaCompiler.getStandardFileManager(null, null, null);
            Iterable iter = manager.getJavaFileObjects(srcFile);

            JavaCompiler.CompilationTask task = javaCompiler.getTask(null, manager, null, null, null, iter);
            task.call();
            manager.close();

            //4、编译生成的.class文件加载到JVM中来
            Class proxyClass = classLoader.findClass("$Proxy0");

            //5、返回字节码重组以后的新的代理对象
            Constructor constructor = proxyClass.getConstructor(MyInvocationHandler.class);
            srcFile.delete();
            return constructor.newInstance(handler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateClass(Class<?> [] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package myjdkproxy;" + ln);
        sb.append("import myjdkproxy.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements ");
        for (Class inter : interfaces) {
            sb.append(inter.getName() + ",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(" {" + ln);
            sb.append("private MyInvocationHandler h;" + ln);
            sb.append("public $Proxy0(MyInvocationHandler h) {" + ln);
                sb.append("this.h = h;" + ln);
            sb.append("}" + ln);

        for (Class inter : interfaces) {
            for (Method m : inter.getMethods()) {
                Class<?>[] params = m.getParameterTypes();

                StringBuffer paramNames = new StringBuffer();
                StringBuffer paramClasses = new StringBuffer();
                StringBuffer paramValues = new StringBuffer();

                for (int i = 0; i < params.length; i ++) {
                    Class clzz = params[i];
                    String type = clzz.getName();
                    String paramName = toFirstLowerCase(clzz.getSimpleName());
                    paramNames.append(type + " " + paramName);
                    paramClasses.append(type + ".class");
                    paramValues.append(paramName);
                    if (i < params.length-1) {
                        paramClasses.append(",");
                        paramNames.append(",");
                        paramValues.append(",");
                    }
                }

                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() +") {" + ln);
                    sb.append("try{" + ln);
                        sb.append("Method m = " + inter.getName() + ".class.getMethod(\"" + m.getName() + "\", new Class[]{" + paramClasses.toString() + "});" + ln);
                        sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + "this.h.invoke(this, m, new Object[]{" + paramValues + "});" + ln);
                    sb.append("}catch(Error _ex) { }");
                    sb.append("catch(Throwable e){" + ln);
                    sb.append("throw new UndeclaredThrowableException(e);" + ln);
                    sb.append("}");
                    sb.append(getReturnEmptyCode(m.getReturnType()));
                sb.append("}");
            }
        }

        sb.append("}" + ln);

        return sb.toString();
    }

    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
    static {
        mappings.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == void.class){
            return "";
        }else {
            return "return null;";
        }
    }

    private static boolean hasReturnValue(Class<?> returnType) {
        return returnType != void.class;
    }

    private static String toFirstLowerCase(String src) {
        char[] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
