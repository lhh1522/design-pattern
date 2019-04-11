package guava;

public class Question {
    private String userName;
    private String content;
    private GPer gper;

    //使用委派模式在沽泡社区提问
    public Question(String userName, String content) {
        this.userName = userName;
        this.content = content;
        gper = GPer.getInstance();
        gper.publishQuestion(this);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGperName() {
        return gper.getName();
    }
}
