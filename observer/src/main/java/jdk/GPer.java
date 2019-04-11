package jdk;

import java.util.Observable;

// 被观察者
public class GPer extends Observable {
    private String name = "沽泡社区";
    private volatile static GPer gper = null;
    private GPer() {}

    public static GPer getInstance() {
        if (gper == null) {
            synchronized (GPer.class) {
                if (gper == null)
                    gper = new GPer();
            }
        }
        return gper;
    }

    public String getName() {
        return this.name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
