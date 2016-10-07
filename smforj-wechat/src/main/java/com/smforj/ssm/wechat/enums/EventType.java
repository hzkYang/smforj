package com.smforj.ssm.wechat.enums;

import java.util.HashMap;
import java.util.Map;
 

/**
* 菜单的响应动作类型
* @author ghj
*
*/
public enum EventType {
   /// <summary>
   /// 标识非菜单数据
   /// </summary>
   None("none"),
   /// <summary>
   /// 普通按钮事件
   /// </summary>
   Click("click"),
   /// <summary>
   /// 外部链接
   /// </summary>
   View("view"),
   /// <summary>
   /// 订阅
   /// </summary>
   Subscribe("subscribe"),
   /// <summary>
   /// 取消订阅
   /// </summary>
   Unsubscribe("unsubscribe"),
   
   Null("null");
   
   private String eventType = "";

   EventType(String evnetType) {
       this.eventType = evnetType;
   }

   /**
    * @return the msgType
    */
   @Override
   public String toString() {
       return eventType;
   } 
   
   // Implementing a fromString method on an enum type
   private static final Map<String, EventType> stringToEnum = new HashMap<String, EventType>();
   
   static {
       // Initialize map from constant name to enum constant
       for(EventType key : values()) {
           stringToEnum.put(key.toString(), key);
       }
   }
   
   // Returns Blah for string, or null if string is invalid
   public static EventType fromString(String symbol) {  
   	EventType mk = stringToEnum.get(symbol);  
   	return mk == null ? EventType.Null : mk; 
   }
}
