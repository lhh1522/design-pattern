package jdkDynamicProxy;

public class JDKDynamicProxyTest {
    public static void main(String[] args) {
        Person person = (Person)new HomeworkProxy().getInstance(new Student());
        person.doHomework();
    }
}
