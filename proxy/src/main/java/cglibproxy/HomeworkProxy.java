package cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//cglib动态代理是生成子类的FastClass,来调父类的方法，但由于需要生成3个class，故编译效率更慢，
//但不需要反射调用代理类的方法，故运行效率比jdk动态代理更高
public class HomeworkProxy implements MethodInterceptor {
    public Object getInstance(Class<?> clazz) {
        //proxy工具类
        Enhancer enhancer = new Enhancer();
        //设置需要代理的类，是生成的类的父类
        enhancer.setSuperclass(clazz);
        //设置回调，在生成的子类中会调用this的intercept方法
        enhancer.setCallback(this);
        //创建子类
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        //子类调用父类方法
        Object obj = methodProxy.invokeSuper(o, objects);
        after();
        return obj;
    }
    private void before() {
        System.out.println("Pay for Homework!");
    }

    private void after() {
        System.out.println("Commit Homework!");
    }

}
