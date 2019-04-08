package adapter;

public interface IPassportForThird {
    ResultMsg loginForQQ(String id);
    ResultMsg loginForWechat(String id);
    ResultMsg loginForRegister(String userName, String password);
}
