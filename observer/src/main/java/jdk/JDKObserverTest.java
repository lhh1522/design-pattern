package jdk;

public class JDKObserverTest {
    public static void main(String[] args) {
        GPer gper = GPer.getInstance();
        Question question = new Question();
        question.setUserName("honghao");
        question.setContent("这道题怎么做?");

        Teacher teacher = new Teacher("Tom");
        gper.addObserver(teacher);
        gper.publishQuestion(question);
    }
}
