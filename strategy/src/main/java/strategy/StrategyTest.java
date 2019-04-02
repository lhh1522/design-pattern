package strategy;

import strategy.pay.PaymentStrategy;

public class StrategyTest {
    public static void main(String[] args) {
        Order order = new Order("123", "321", 300.0);
        System.out.println(order.pay());

        System.out.println(order.pay(PaymentStrategy.WEIXINPAY));
    }
}
