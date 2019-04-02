package strategy.pay;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategy {
    public static final String ALIPAY = "AliPay";
    public static final String WEIXINPAY = "WeixinPay";

    private static Map<String, Payment> payMap = new HashMap<String, Payment>();
    static {
        payMap.put(ALIPAY, new AliPay());
        payMap.put(WEIXINPAY, new WeixinPay());
    }

    public static Payment getPay(String payment) {
        if (payMap.containsKey(payment)) {
            return payMap.get(payment);
        } else {
            return payMap.get(ALIPAY);
        }
    }
}
