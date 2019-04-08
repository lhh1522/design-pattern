package adapter.adapters;

import adapter.ResultMsg;

public class LoginForWechat implements LoginAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWechat;
    }

    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
