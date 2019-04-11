package guava;

import com.google.common.eventbus.EventBus;

public class GuavaObserverTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        Teacher teacher = new Teacher("Tom");

        Question question = new Question("honghao", "这道题怎么做？");

        eventBus.register(teacher);
        eventBus.post(question);
    }
}
