package strategy;

public class MsgResult {
    private int code;
    private String message;
    private Object data;

    public MsgResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String toString() {
        return ("支付状态：[" + code + "]," + message + ",交易详情：" + data);
    }
}
