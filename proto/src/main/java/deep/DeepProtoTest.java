package deep;

public class DeepProtoTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("Jim");
        user1.setAge(22);
        Address address = new Address();
        address.setCity("Shanghai");
        user1.setAddress(address);

        User user2 = (User) user1.clone();
        System.out.println(user1.getAddress() == user2.getAddress());
    }
}
