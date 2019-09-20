package com.dk.learndemo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;


/**
 * @Description : MacTest
 * @Date : 2019/9/20
 * @Author :
 */
public class MacTest {

    //秘钥（必须要是通信双方共享的）
    static final String STR_KEY = "266f5fe18e714688a083df4ca9f78064";

    /**
     * 其中，Mac.getInstance支持的算法有：HmacMD5、HmacSHA1、HmacSHA256等等
     * 全部支持的算法见官方文档：
     * https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Mac
     */
    public static byte[] mac(String algorithm, Key key, byte[] data) throws Exception {
        Mac mac = Mac.getInstance(algorithm);
        //这里是关键，需要一个key（这里就是和普通的消息摘要的区别点）
        mac.init(key);

        byte[] result = mac.doFinal(data);
        return result;
    }

    public static void main(String[] args) throws Exception {
        byte[] data = Files.readAllBytes(Paths.get("C:\\Users\\DK\\Downloads/apache-tomcat-8.5.45.tar.gz"));

        //这边的字符串填上或者不填有什么区别么 对于解密的时候有什么影响
        Key key = new SecretKeySpec(STR_KEY.getBytes(), "");

        //结果证明这边的第二个参数随便些什么都不会有影响。
        Key key2 = new SecretKeySpec(STR_KEY.getBytes(), "111");

        //使用MD5算法计算摘要
        byte[] md5Digest = mac("HmacMD5", key, data);

        //使用SHA256算法计算摘要
        byte[] shaDigest = mac("HmacSHA256", key, data);

        //这边是用Key2来计算摘要
        byte[] shaDigest2 = mac("HmacSHA256", key2, data);

        //把摘要后的结果转换成十六进制的字符串（也可以使用Base64进行编码）
        System.out.println(Hex.encodeHexString(md5Digest));
        System.out.println(Hex.encodeHexString(shaDigest));
        System.out.println(Hex.encodeHexString(shaDigest2));
    }
}