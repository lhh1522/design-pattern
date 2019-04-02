package strategy.pay;

import strategy.MsgResult;

public abstract class Payment {
    public abstract String getName();

    protected abstract double queryBalance(String userId);

    public MsgResult payOrder(double amount, String userId) {
        if (queryBalance(userId) < amount) {
            return new MsgResult(500, "支付失败", "余额不足");
        }
        return new MsgResult(200, "支付成功", "支付金额：" + amount);
    }
}
