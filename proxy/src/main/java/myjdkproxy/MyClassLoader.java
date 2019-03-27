package myjdkproxy;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private File classPathFile;

    public MyClassLoader() {
        String classPath = MyClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    public Class<?> findClass(String name) {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;

        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream fis = null;
                ByteArrayOutputStream baos = null;
                try {
                    fis = new FileInputStream(classFile);
                    baos = new ByteArrayOutputStream();

                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = fis.read(buff)) != -1) {
                        baos.write(buff, 0, len);
                    }
                    return defineClass(className, baos.toByteArray(), 0, baos.size());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
