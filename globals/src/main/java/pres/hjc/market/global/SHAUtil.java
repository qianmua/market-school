package pres.hjc.market.global;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/6/20  19:21
 * @description :
 */
public class SHAUtil {
    private static final String SHA = "SHA";

    /**
     * 加密
     * @param data psw
     * @return psw
     * @throws NoSuchAlgorithmException err
     */
    @Deprecated
    public static String encrptMD5(byte data) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(SHA);

        instance.update(data);
        return new String(instance.digest());
    }

    /**
     * 加密
     * @param content psw
     * @return psw
     */
    public static String encrptMD5(final String content){
        try {
            MessageDigest sha = MessageDigest.getInstance(SHA);
            byte[] shaByte = sha.digest(content.getBytes());
            StringBuilder hexValue = new StringBuilder();
            for (byte b : shaByte) {
                //将其中的每个字节转成十六进制字符串：byte类型的数据最高位是符号位，通过和0xff进行与操作，转换为int类型的正整数。
                String toHexString = Integer.toHexString(b & 0xff);
                hexValue.append(toHexString.length() == 1 ? "0" + toHexString : toHexString);
            }
            return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


/*

    public static void main(String[] args) {
        String encrypt = SHAEncrypt("123456");
        String encrypt2 = SHAEncrypt("123456");

        try {
            String v1 = encrptSHA("123456");
            String v2 = SHAEncrypt(v1);
            System.out.println(v2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

//
//        System.out.println(encrypt);
//        System.out.println(encrypt2);
    }
*/

    /**
     * 短地址 加密
     * @param url u
     * @return p
     */
    public static String encreptUrl(String url){
        try {
            byte[] salt = "JKDSPnBKYJ2E7kEg9mYSteK4AXE8ywUB96y8gjDFhfy".getBytes(StandardCharsets.UTF_8);
            String checkSalt = "C2NkXy3ECJn9AcMB976DnBKYJ2E7kEg9mYSte";
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(salt);
            byte[] bytes = url.getBytes(StandardCharsets.UTF_8);
            byte[] encryptUrl = messageDigest.digest(bytes);
            String semiFinishedProducts = new String(Base64.encode(encryptUrl));
            //加密url的长度我设置的6位. 加密的url取三位。剩下三位分别给静态盐1位和动态盐2位
            String urlKey = semiFinishedProducts.substring(0,4);
            //位置可以在0-32位之间。这里可以选择位置。但是解密的时候就必须用同样的位置
            String staticSalt = Objects.requireNonNull(md5Util(urlKey + checkSalt)).substring(5,6);
            String dynaSalt = Objects.requireNonNull(md5Util("" + UUID.randomUUID())).substring(6,9);
            String encrypted = urlKey+staticSalt+dynaSalt;
            //标记量。用来加强短链接检查.这里输出查看下
            String sig = md5Util(encrypted);
//            String domain = "www.baidu.com/";
//            String subDomain = "demo/";
            String encryptedUrl = /*domain+subDomain+*/encrypted;
            //把 sig ,encryptedUrl ,originalUrl,key。存到数据库
            return encryptedUrl;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 短地址 解密
     * @param encrpetUrl p
     * @param sig u
     * @return u
     */
    public static String getOriginUrl(String encrpetUrl,String sig){
        encrpetUrl = encrpetUrl.substring(encrpetUrl.lastIndexOf("/")+1);
        String key = encrpetUrl.substring(0,4);
        String staticSalt = encrpetUrl.substring(4,5);
        //和上面的检查盐一样
        String checkSalt = "C2NkXy3ECJn9AcMB976DnBKYJ2E7kEg9mYSte";
        //静态盐检查
        String correctStaticSalt = Objects.requireNonNull(md5Util(key + checkSalt)).substring(5,6);
        if (!staticSalt.equals(correctStaticSalt)){
            System.out.println(1);
            return "error";
        }
        String correctSig = md5Util(encrpetUrl);
        if (!sig.equals(correctSig)){
            return "error";
        }
        //检查完毕。 没问题就通过key查询数据库。拿到原始url
        System.out.println(encrpetUrl);
        return correctSig;
    }

    /**
     *  md5 验证
     * @param semiFinishedProducts md5
     * @return info
     */
    public static String md5Util(String semiFinishedProducts){
        MessageDigest lDigest = null;
        try {
            lDigest = MessageDigest.getInstance("MD5");
            lDigest.update(semiFinishedProducts.getBytes());
            BigInteger lHashInt = new BigInteger(1, lDigest.digest());
            return String.format("%1$032X", lHashInt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public static void main(String[] args) {
        String str = "/ft/main?test=good&watch=100";
        String vara = encreptUrl(str);
        System.out.println(vara);
        // 验证 密码 相等
        str = md5Util("wh1XF86D");
        vara = getOriginUrl("wh1XF4B3",str);

    }*/


}
