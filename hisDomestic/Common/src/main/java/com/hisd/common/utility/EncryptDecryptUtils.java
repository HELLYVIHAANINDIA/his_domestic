package com.hisd.common.utility;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Service
public class EncryptDecryptUtils {
	private static final String ALGO = "AES";
	 private static final boolean ISSECURE = true;
	    private static final String PASSWORD = "@Dev1238";
	    private static final String SECRETKEY = "DES";
	    private static final String UTF8 = "UTF-8";
	
	@Value("#{projectProperties['registrationkey']}")
    private static String registrationkey;
	
	public static String encrypt(String Data,byte[] keyValue) throws Exception {
		Key key = generateKey(keyValue);
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}
	
	public static String decrypt(String encryptedData,byte[] keyValue) throws Exception {
		Key key = generateKey(keyValue);
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}
	
	private static Key generateKey(byte[] keyValue) throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}
	
	public static String encryptParam(String encryptedData) throws Exception {
		DESKeySpec keySpec = new DESKeySpec(PASSWORD.getBytes(UTF8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SECRETKEY);
        SecretKey key = keyFactory.generateSecret(keySpec);
        Cipher cipher = Cipher.getInstance(SECRETKEY); // cipher is not thread safe
        cipher.init(Cipher.ENCRYPT_MODE, key);
        sun.misc.BASE64Encoder base64encoder = new BASE64Encoder();
        String plainTextPassword = encryptedData;
        byte[] cleartext = plainTextPassword.getBytes(UTF8);
        return base64encoder.encode(cipher.doFinal(cleartext)).replace("/", "$$").replaceAll("\r\n", "");
	}

	public String decryptParam(final String encrypt) {
        String decrypt = null;
        try {
            if (StringUtils.hasLength(encrypt)) {
                DESKeySpec keySpec = new DESKeySpec(PASSWORD.getBytes(UTF8));
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(SECRETKEY);
                SecretKey key = keyFactory.generateSecret(keySpec);
                sun.misc.BASE64Decoder base64decoder = new BASE64Decoder();
                Cipher cipher = Cipher.getInstance(SECRETKEY); // cipher is not thread safe
                String test = encrypt.replace("$$", "/").replace(" ", "+");
                byte[] encrypedPwdBytes = base64decoder.decodeBuffer(test);
                cipher = Cipher.getInstance(SECRETKEY);// cipher is not thread safe
                cipher.init(Cipher.DECRYPT_MODE, key);
                byte[] plainTextPwdBytes = (cipher.doFinal(encrypedPwdBytes));
                decrypt = new String(plainTextPwdBytes, UTF8);
            }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return decrypt;
    }
}