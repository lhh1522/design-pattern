package staticproxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        Friend friend = new Friend(new Me());
        friend.doHomeworkProxy();

    }
}
