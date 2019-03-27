package myjdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HomeworkProxy implements MyInvocationHandler {
    private Object obj;

    // 1.获取实例对象
    public Object getInstance(Object obj) {
        this.obj = obj;
        Class clazz = obj.getClass();
        return MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(this.obj, args);
        after();
        return object;
    }

    private void before() {
        System.out.println("Pay for Homework!");
    }

    private void after() {
        System.out.println("Commit Homework!");
    }
}
