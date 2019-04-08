package interfacetemplate;

public class HomeworkTest {
    public static void main(String[] args) {
        HomeworkTemplate mathHomework = new HomeworkTemplate(new MathHomework());
        mathHomework.homeworkProcess();

        HomeworkTemplate englishHomework = new HomeworkTemplate(new EnglishHomework());
        englishHomework.homeworkProcess();
    }
}
