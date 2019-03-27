package myjdkproxy;


public class MyJDKDynamicProxyTest {
    public static void main(String[] args) {
        Person person = (Person)new HomeworkProxy().getInstance(new Student());
        person.doHomework();
    }
}
