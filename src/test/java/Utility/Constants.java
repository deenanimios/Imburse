package Utility;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Constants {

    public static String REST_BASE_API = "https://sandbox-api.imbursepayments.com";
    public static String AUTHENTICATION_ENDPOINT = "/v1/identity/hmac";
    public static String ORDER_MANAGEMENT_ENDPOINT = "/v1/order-management";
    public static String PUBLIC_KEY = "7934d5e6-260c-46d5-9309-e72a59cb90cd";
    public static String PRIVATE_KEY = "aWRpTN9tRsf2EyM8rcvz7bohO/fAg6IF+daZ1JYE9AM=";
    public static String TENANT_ID = "782f1b71-7ca4-4465-917f-68d58ffbec8b";
    public static String ACCOUNT_ID = "6423ae63-59b6-4986-a949-c910ac622471";
    public static String SCHEME_ID = "654EB81FF7F07F7CF5A1EE3FF6972E90";


    public static String generatesHmac(String publicKey, String privateKey) {

        byte[] privateKeyBytes = Base64.decodeBase64(privateKey);
        String bodySignature = "";
        long timestamp = new Date().getTime() / 1000;
        long nonce = timestamp;
        String unsignedSignature = publicKey + ":" + nonce + ":" + timestamp + ":" + bodySignature;
        byte[] utf8Signature = unsignedSignature.getBytes(StandardCharsets.UTF_8);
        byte[] hashedSignature = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_256, privateKeyBytes).doFinal(utf8Signature);
        String signedSignature = new String(Base64.encodeBase64(hashedSignature));
        String hmac = publicKey + ":" + nonce + ":" + timestamp + ":" + signedSignature;

        return hmac;
    }
}
