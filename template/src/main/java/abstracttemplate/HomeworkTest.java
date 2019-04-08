package abstracttemplate;

public class HomeworkTest {
    public static void main(String[] args) {
        HomeworkTemplate mathHomework = new DoMathHomework(true);
        mathHomework.homeworkProcess();

        HomeworkTemplate englishHomework = new DoEnglishHomework();
        englishHomework.homeworkProcess();
    }
}
