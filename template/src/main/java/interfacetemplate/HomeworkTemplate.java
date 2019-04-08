package interfacetemplate;

// 接口方式实现
public class HomeworkTemplate {
    private Homework homework;

    public HomeworkTemplate(Homework homework) {
        this.homework = homework;
    }

    public final void homeworkProcess() {
        takeOutHomework();
        takeOutPen();
        homework.doHomework();
        finishHomework();
    }

    protected void takeOutHomework() {
        System.out.println("拿出作业");
    }

    protected void takeOutPen() {
        System.out.println("拿出笔");
    }

    protected void finishHomework() {
        System.out.println("完成作业");
    }
}
