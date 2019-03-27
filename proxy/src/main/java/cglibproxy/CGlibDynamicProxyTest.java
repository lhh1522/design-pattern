package cglibproxy;

public class CGlibDynamicProxyTest {
    public static void main(String[] args) {
        Student person = (Student)new HomeworkProxy().getInstance(Student.class);
        person.doHomework();
    }
}
