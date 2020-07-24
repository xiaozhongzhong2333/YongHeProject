package com.zb.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102600767243";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCrgd+j28foi/1NNtNVObmSPsEe7Igh91grXNdVwQ0hQwP1X7bTUdjUya7Z31VEn9LoTyUViMcbimw5n1WPEmFh4pNruwMbNU1s7Aq3Fne5hlSuHduLmBYXnfGVR0siT+yD7hn45+7WHYLwX5i6ozTwHbwOsNSqVIISmXhlTVZnRj1dbnZljlV/eSx4eTQqxV7i0TGkvljo+e7OfCG/dfgjzGn+JkGeN1EcQ6bU4R+B+CkHPK7D2KQNU5irwIKnAD8GqJfUzfv338X8RFpS5n62yzRzhDzt3rDqaLxbJJYDk5WUDvJI6HMixa2dLBBVaJ6NLZbPu1PFQfOnjjEDux23AgMBAAECggEAVUH7rdY823Jz2iWOCwjmIjhGApxs1A3Ea9H8TenpIAbTefA5z3UZiDY2UKKAHdwhmVB2y+yxphQ61q5JdxUZCfL7fAt8cNMfiS0R6pAltjl78Q5wrEVPfjAK/z1wsT7wAWmkyaJqjVAgXmP3ZZhqYY82hEsNfRsDikF2o009zZpBbvtA3k7fCEEpVoBTLs+KCEUwWQVhMYj7RYTbEn+BZR9ge5yTb8R3k21AGdmyBvfFTEjRHck/qiQpO5kZ0SGlXhmYe6PT06jTFqUc9+4fiNr5lZpmGlgH06H7VAISzOr/7WE5rXGZMaM4J0+OeiNOB3D6qwGYYqtum/NE6WCooQKBgQDf8udmSELt83zbLgs/0k13IjIt6o8gxfmrdogwtxNYayDrdA0RfFkHR+GpOtzOkT7RxSd0avDyregeozRtVViIhvq4BNYiKz5hCFP4h57fhPAuT7DCU3JPvV/2y9RK4USr6T7WbcCZSk6iwf02zrdJYpDeQgKMw7PmaXN9nnRhBwKBgQDEDZp7Fh9Vy4W/ByNEstfn0Rjmdo3nhCFUjl4IgFSTMOl+4J7TXDKbpWb35WQEfoUdnNsHnMkxb7vqDnAdMNBLbBUC71uUHsVglo4Xb2XEx2TOtNGaa+tydTm/9Q+6LksCNkvCUZw0X6nYSXRAbT4w0XMMzidjjCsWjxiIeJoh0QKBgA34IOcIauRc49ToMltwytQ7ldW3Y+Yvczt20Vf4k4RYal1Fh+snToZdvX3I5i0cckazfZqNcSoyHuCKXaLUSAl8IfeIlbLb77AtzM8b5pUavcClx+jXO7ItpebHIB7rnlT636iQgAsPz4fngdwBWP2C4HZ8t5wAOSCOQ136nFfRAoGAE6/eBGArU101mAIqe3qODbxEiNf81fPBuRD2xlnEpGcz+0apDEZk2pZYaapCSeU+jsOyhugql+lFcHJ0tamyMPCwh3PruUsBvPpBWH8aNBFlwRANQDl4Ei1NWEZOhv6hD57OKrwxOF0m3A48Oz/9D7/okq+c6vUnWoOSDho2OBECgYEApW2AvOMkbyb93klLtcXAnufV/brLU6+s0UYxfatAokIJxjsr8OktT9m1zQUhHOMxGxP5vQmnckIQDbqpa5PQUFsmE/c8qPpkF7lHnNY3oDf/GqeJLsxW4gXTqjO6l0+0+f7LHYFiIH1i1th49KZnigv4Mt9cI6MhuoSqheILwGk=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4Hfo9vH6Iv9TTbTVTm5kj7BHuyIIfdYK1zXVcENIUMD9V+201HY1Mmu2d9VRJ/S6E8lFYjHG4psOZ9VjxJhYeKTa7sDGzVNbOwKtxZ3uYZUrh3bi5gWF53xlUdLIk/sg+4Z+Ofu1h2C8F+YuqM08B28DrDUqlSCEpl4ZU1WZ0Y9XW52ZY5Vf3kseHk0KsVe4tExpL5Y6Pnuznwhv3X4I8xp/iZBnjdRHEOm1OEfgfgpBzyuw9ikDVOYq8CCpwA/BqiX1M3799/F/ERaUuZ+tss0c4Q87d6w6mi8WySWA5OVlA7ySOhzIsWtnSwQVWiejS2Wz7tTxUHzp44xA7sdtwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "localhost:8080/yongHeProjecy/paysuccess";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "localhost:8080/yongHeProjecy/paysuccess.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

