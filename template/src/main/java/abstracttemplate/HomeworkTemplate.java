package abstracttemplate;

public abstract class HomeworkTemplate {
    public final void homeworkProcess() {
        takeOutHomework();
        takeOutPen();
        if (needCalculator()) {
            takeOutCalculator();
        }
        doHomework();
        finishHomework();
    }

    protected void takeOutHomework() {
        System.out.println("拿出作业");
    }

    protected void takeOutPen() {
        System.out.println("拿出笔");
    }

    protected void takeOutCalculator() {
        System.out.println("拿出计算器");
    }

    protected void finishHomework() {
        System.out.println("完成作业");
    }

    protected abstract void doHomework();

    protected boolean needCalculator() {
        return false;
    }
}
