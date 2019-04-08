package abstracttemplate;

public class DoMathHomework extends HomeworkTemplate {
    private boolean calculatorFlag = false;

    public DoMathHomework(boolean calculatorFlag) {
        this.calculatorFlag = calculatorFlag;
    }

    protected void doHomework() {
        System.out.println("做数学作业");
    }

    @Override
    protected boolean needCalculator() {
        return this.calculatorFlag;
    }
}
