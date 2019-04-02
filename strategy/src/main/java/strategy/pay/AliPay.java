package strategy.pay;

public class AliPay extends Payment {
    public String getName() {
        return "支付宝";
    }

    protected double queryBalance(String userId) {
        return 500;
    }
}
