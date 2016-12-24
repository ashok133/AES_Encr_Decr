/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aesproject;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.InvalidKeySpecException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 *
 * @author Apk & Purvak
 */
public class AESAlgorithm {
    
    public static String algo = "AES" ;
    public byte[] keyValue ;
    
    //Constructor 
    public AESAlgorithm(String key){
        keyValue = key.getBytes();
    }
    
    public Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, algo);
        return key ;
    }
    
    public String encrypt (String msg) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance (algo);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(msg.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue ;
    }
    
    public String decrypt (String msg) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(algo);
        c.init(Cipher.ENCRYPT_MODE, key) ;
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(msg) ;
        byte[] decValue = c.doFinal(decordedValue) ;
        String decryptedValue = new String(decValue) ;
        return decryptedValue;
    }
}

//End of package