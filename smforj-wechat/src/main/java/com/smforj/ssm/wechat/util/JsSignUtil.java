package com.smforj.ssm.wechat.util; 

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

/***
 * 官方给的使用js的验证工具
 * 
 * @author Haijun Gao 
 * @date 2016-8-22 上午10:15:31
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class JsSignUtil { 
	
	public static String accessToken = null;
	
    public static Map<String, String> sign(String url) {
    	accessToken = AccessTokenUtil.getAccessToken(Constants.APPID, Constants.AppSecret,0).getAccess_token();
    	String jsapi_ticket = JsapiTicketUtil.getJsapiTicket(accessToken).getTicket(); 
    	
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;
        System.out.println(string1);

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        ret.put("appId", Constants.APPID);

        System.out.println("1.ticket(原始)="+jsapi_ticket);
        System.out.println("2.url="+ret.get("url"));
        System.out.println("3.jsapi_ticket（处理后）="+ret.get("jsapi_ticket"));
        System.out.println("4.nonceStr="+ret.get("nonceStr"));
        System.out.println("5.signature="+ret.get("signature"));
        System.out.println("6.timestamp="+ret.get("timestamp"));
        
        return ret;
    }
    
    
    /**
     * 随机加密
     * @param hash
     * @return
     */
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    /**
     * 产生随机串--由程序自己随机产生
     * @return
     */
    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    /**
     * 由程序自己获取当前时间
     * @return
     */
    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
    
    public static void main(String[] args) { 

        // 注意 URL 一定要动态获取，不能 hardcode
        String url = "http://example.com";
        Map<String, String> ret = sign(url);
        for (Entry<String, String> entry : ret.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    };
}

