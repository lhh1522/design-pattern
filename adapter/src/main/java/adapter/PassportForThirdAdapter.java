package adapter;

import adapter.adapters.LoginAdapter;
import adapter.adapters.LoginForQQAdapter;
import adapter.adapters.LoginForWechat;
import adapter.service.SiginService;

public class PassportForThirdAdapter extends SiginService implements IPassportForThird {
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    public ResultMsg loginForWechat(String id) {
        return processLogin(id, LoginForWechat.class);
    }

    public ResultMsg loginForRegister(String userName, String password) {
        super.regist(userName, password);
        return super.login(userName, password);
    }

    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz) {
        try {
            LoginAdapter loginAdapter = clazz.newInstance();

            if (loginAdapter.support(loginAdapter)) {
                return loginAdapter.login(key, loginAdapter);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
