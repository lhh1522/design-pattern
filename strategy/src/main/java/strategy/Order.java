package strategy;

import strategy.pay.Payment;
import strategy.pay.PaymentStrategy;

public class Order {
    private String userId;
    private String orderid;
    private double amount;

    public Order(String userId, String orderid, double amount) {
        this.userId = userId;
        this.orderid = orderid;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public MsgResult pay() {
        return pay(PaymentStrategy.ALIPAY);
    }

    public MsgResult pay(String payment) {
        Payment paym = PaymentStrategy.getPay(payment);
        System.out.println("本次订单的金额为：" + this.amount);
        System.out.println("开始扣款。。。");
        return paym.payOrder(this.amount, this.userId);
    }
}
