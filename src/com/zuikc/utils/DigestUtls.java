package com.zuikc.utils;


import com.mchange.util.Base64Encoder;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtls {

    //Base64编码
    public static  String base64Encoder(String str){
        BASE64Encoder base64Encoder=new BASE64Encoder();
        return base64Encoder.encode(str.getBytes());
    }

    //Base64解码
    public static  String base64Decoder(String str){
        BASE64Decoder base64Decoder=new BASE64Decoder();
        try {
            byte []bys=base64Decoder.decodeBuffer(str);
            return new String(bys);
        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }


    }


    //传入明文返回密文
      public static String md5(String str){
                try {
                    MessageDigest messageDigest=MessageDigest.getInstance("md5");
                    byte[]arr=str.getBytes();
                    byte[]sercet= messageDigest.digest(arr);
                    return new BigInteger(1,sercet).toString(16);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
