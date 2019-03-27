package staticproxy;

public class Friend {
    private Person person;
    public Friend(Person person) {
        this.person = person;
    }

    public void doHomeworkProxy() {
        person.doHomework();
    }
}
