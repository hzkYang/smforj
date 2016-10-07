package com.smforj.ssm.encrypt.md5;

import java.math.BigInteger;
import java.security.MessageDigest;

import com.smforj.ssm.encrypt.Encrypt;

/**
 * MD5(Message Digest algorithm 5，信息摘要算法) 
 * 通常我们不直接使用上述MD5加密。通常将MD5产生的字节数组交给BASE64再加密一把，得到相应的字符串
 * Digest:汇编 
*/
public class MD5 implements Encrypt{

	 public static final String KEY_MD5 = "MD5";  
	 protected static MD5 md5 = new MD5();

	 /***
	  * 
	  * @param inputStr
	  * @return
	  * @date 2016-9-8 下午1:15:33
	  */
     public static String getMd5(String inputStr)
     {
    	System.out.println("=======加密前的数据:"+inputStr);
    	return md5.encode(inputStr);
     }   
     
	@Override
	public String encode(String str) { 
        BigInteger bigInteger=null; 
        try {
	         MessageDigest md = MessageDigest.getInstance(KEY_MD5);   
	         byte[] inputData = str.getBytes(); 
	         md.update(inputData);   
	         bigInteger = new BigInteger(md.digest());   
        } catch (Exception e) {e.printStackTrace();}   
        return bigInteger.toString(16);
	}
}
