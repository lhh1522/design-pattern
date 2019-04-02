package strategy.pay;

public class WeixinPay extends Payment {
    public String getName() {
        return "微信";
    }

    protected double queryBalance(String userId) {
        return 200;
    }
}
