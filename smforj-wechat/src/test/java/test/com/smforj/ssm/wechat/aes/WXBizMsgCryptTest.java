package test.com.smforj.ssm.wechat.aes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.smforj.ssm.wechat.aes.AesException;
import com.smforj.ssm.wechat.aes.WXBizMsgCrypt;
import com.smforj.ssm.wechat.aes.WXBizMsgCryptImpl;

public class WXBizMsgCryptTest {
	String encodingAesKey = "s8vFF4f6AWay3uAdJh79WD6imaam4BV6Kl4eL4UzgfM";
	String token = "smforj";
	String timestamp = "1471223618";
	String nonce = "1172721634";
	String appId = "wxe930a8c273b921e9";
	String echostr = "5448455673471530827";
	String signature = "c30b13f81eae957b865a27b35fe30a9a60ce4c35";
	
	
	String replyMsg = "我是中文abcd123";
	String xmlFormat = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
	String afterAesEncrypt = "jn1L23DB+6ELqJ+6bruv21Y6MD7KeIfP82D6gU39rmkgczbWwt5+3bnyg5K55bgVtVzd832WzZGMhkP72vVOfg==";
	String randomStr = "aaaabbbbccccdddd";

	String replyMsg2 = "<xml><ToUserName><![CDATA[oia2Tj我是中文jewbmiOUlr6X-1crbLOvLw]]></ToUserName><FromUserName><![CDATA[gh_7f083739789a]]></FromUserName><CreateTime>1407743423</CreateTime><MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[eYJ1MbwPRJtOvIEabaxHs7TX2D-HV71s79GUxqdUkjm6Gs2Ed1KF3ulAOA9H1xG0]]></MediaId><Title><![CDATA[testCallBackReplyVideo]]></Title><Description><![CDATA[testCallBackReplyVideo]]></Description></Video></xml>";
	String afterAesEncrypt2 = "jn1L23DB+6ELqJ+6bruv23M2GmYfkv0xBh2h+XTBOKVKcgDFHle6gqcZ1cZrk3e1qjPQ1F4RsLWzQRG9udbKWesxlkupqcEcW7ZQweImX9+wLMa0GaUzpkycA8+IamDBxn5loLgZpnS7fVAbExOkK5DYHBmv5tptA9tklE/fTIILHR8HLXa5nQvFb3tYPKAlHF3rtTeayNf0QuM+UW/wM9enGIDIJHF7CLHiDNAYxr+r+OrJCmPQyTy8cVWlu9iSvOHPT/77bZqJucQHQ04sq7KZI27OcqpQNSto2OdHCoTccjggX5Z9Mma0nMJBU+jLKJ38YB1fBIz+vBzsYjrTmFQ44YfeEuZ+xRTQwr92vhA9OxchWVINGC50qE/6lmkwWTwGX9wtQpsJKhP+oS7rvTY8+VdzETdfakjkwQ5/Xka042OlUb1/slTwo4RscuQ+RdxSGvDahxAJ6+EAjLt9d8igHngxIbf6YyqqROxuxqIeIch3CssH/LqRs+iAcILvApYZckqmA7FNERspKA5f8GoJ9sv8xmGvZ9Yrf57cExWtnX8aCMMaBropU/1k+hKP5LVdzbWCG0hGwx/dQudYR/eXp3P0XxjlFiy+9DMlaFExWUZQDajPkdPrEeOwofJb";

	
	/***
	 * 微信传过来的加密文件
	 */
	String AesEncryptMsg = "<xml><ToUserName><![CDATA[gh_92c7f0e041ff]]></ToUserName>" +
			"<Encrypt><![CDATA[7RdTujoKqTgFuPCIdjgs5tkehixAhzQ9g3BBwQMtqMAAwzLITOoalj7GxcWsQxLjlv0kxVxcFMe5glm2Ed4txCYRvXUfiKAQlfZUJYWrTb92Q/wK/8NNys65CiGb00h1vcmgq/0JcWz0iP6QV9k4xxF+HLb5EVfB+juJ1omdzc6llnlPYK9Y/zXuJgSYI9V6Qs/iPpCX2/0ezzasExZlkBGrrBOuHkx3f4le5zbEdu7mfjxo2oEDAG1JTiQcPw0XtiYunHsnUMQnW+e2z9/yPdmXDkku8Xcgy7e1q314P0BuHs2mQC69dAwmDF+spCArh2VVcUkY/SrZiX5Iw8uEfW8riWbzf3v5Kxe+KuC/Fr2f3a3WDTjnsK/JhRiykq0QjBxv7u14horNXc0fAMU1Y/QYj4N4Z0lcMJlQS+lSFYJ86ZsdRcfgTtNDovtLudc5LrZRF5j34WFx6v9OAoC3waTrkW/r6bfUXU5L7I7iuTh6xoP+5dkI08a3RmQas6zSwX/qPSuzPFKeiwdINUwUeznfCAD6GyIWQqRFag/QXp+EVNBHmCeAVTEIYlrzeFxZslQDcWWkUyegcPQXAdD8l0J38hd3wgIcqHNJfO+W8wb2LmNeMZam2x4wFOJ04igD3//xI/lRLbLNYIOZam7tTaDoosdiwA3P+QrDf922TB7cH2IPfsXKCcVRMnABi4HyMcANrlyRWwghWxCw7FwJr2DCw+2lpcw+CrrkeSOrTdesALV1eXHI/u6ZJViAT1d7]]></Encrypt></xml>";
	
	
	@BeforeClass
	@Ignore
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	@Ignore
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	@Ignore
	public void setUp() throws Exception {

	}

	@After
	@Ignore
	public void tearDown() throws Exception {
	} 
	
	@Test
	@Ignore
	public void testDecrypt() throws AesException
	{
		  WXBizMsgCryptImpl pc = new WXBizMsgCryptImpl(token, encodingAesKey, appId);
		   
		  String msg_signature = "8cde9307abe05b718812f93f9e48eb261f80e91b";
		  String msg_timestamp = "1472524313";
		  String msg_nonce = "84116712";
		  String pastData = "<xml><ToUserName><![CDATA[gh_92c7f0e041ff]]></ToUserName><Encrypt><![CDATA[cW+UZAdlJlsu7a7g6XLjhsCjmECwzYLPJL55JqeVL28o3SbJ+quoBWfvcU2y2qcH4EUZu2AEBypNknjjmwXMz7xj3zETFtmEGdUBMidNbp/c3gVlNCpuZo3iO7jjg5irncL8mDQYoMV5aG7FnFg6vZQ0zHB6MX7dBhg4agGnoJbblbAl4N8/uUBMM9gan9gRLVagOjoSYxDUBD3IpzzBcrGsUOIxs0Kdg7mkzY/kGIGoURcKPRrvCHu3+KOeND32XSU02bFMcLdwLnJeUfpIiOxpzgX3+my5VS6YX+ysZMe7t5rBH2NcNrqm+CSNuGJME45b/PQ/983TwlQWqsLNii5E9ZeSTSBFq4tIHk8JWpSqaliUfMw8D/yF0gsNeXVZv7w0LevUJtk/v8v3r5G3/HANiLAX6V91y9aPxUgww04=]]></Encrypt></xml>";
	      String afterEncrpt = pc.decryptMsg(msg_signature, msg_timestamp, msg_nonce, pastData); 
	      System.out.println(afterEncrpt);
	}
	
	@Test
	//@Ignore
	public void testEncryptMsg() throws AesException
	{
		  WXBizMsgCryptImpl pc = new WXBizMsgCryptImpl(token, encodingAesKey, appId); 
		  String msg_timestamp = "1472541015";
		  String msg_nonce = "46328643";
		  String pastData = "<xml><ToUserName><![CDATA[opQSRwWhh9sCHQejRW4V8SlhkFNI]]></ToUserName><FromUserName><![CDATA[gh_92c7f0e041ff]]></FromUserName>" +
		  		"<CreateTime><![CDATA[1472540956158]]></CreateTime><MsgType><![CDATA[text]]></MsgType><FuncFlag><![CDATA[0]]>" +
		  		"</FuncFlag><Content><![CDATA[]]></Content></xml>";
	      String afterEncrpt = pc.encryptMsg( pastData,msg_timestamp, msg_nonce); 
	      System.out.println(afterEncrpt); 
	}

	@Ignore
	@Test 
	public void testNormal() throws ParserConfigurationException, SAXException, IOException {
		try {
		    WXBizMsgCryptImpl pc = new WXBizMsgCryptImpl(token, encodingAesKey, appId);
			String afterEncrpt = pc.encryptMsg(replyMsg, timestamp, nonce);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(afterEncrpt);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encrypt");
			NodeList nodelist2 = root.getElementsByTagName("MsgSignature");

			String encrypt = nodelist1.item(0).getTextContent();
			String msgSignature = nodelist2.item(0).getTextContent();
			String fromXML = String.format(xmlFormat, encrypt);

			// 第三方收到公众号平台发送的消息
			String afterDecrpt = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
			assertEquals(replyMsg, afterDecrpt);
		} catch (AesException e) {
			fail("正常流程，怎么就抛出异常了？？？？？？");
		}
	}
	
	@Ignore
	@Test
	public void testAesEncrypt() {
		try {
			WXBizMsgCrypt pc = new WXBizMsgCryptImpl(token, encodingAesKey, appId);
			assertEquals(afterAesEncrypt, pc.encrypt(randomStr, replyMsg));
		} catch (AesException e) {
			e.printStackTrace();
			fail("no异常");
		}
	}

	@Ignore
	@Test
	public void testAesEncrypt2() {
		try {
			WXBizMsgCrypt pc = new WXBizMsgCryptImpl(token, encodingAesKey, appId);
			assertEquals(afterAesEncrypt2, pc.encrypt(randomStr, replyMsg2));

		} catch (AesException e) {
			e.printStackTrace();
			fail("no异常");
		}
	}

	@Ignore
	@Test
	public void testIllegalAesKey() {
		try {
			new WXBizMsgCryptImpl(token, "abcde", appId);
		} catch (AesException e) {
			assertEquals(AesException.IllegalAesKey, e.getCode());
			return;
		}
		fail("错误流程不抛出异常？？？");
	}

	@Ignore
	@Test
	public void testValidateSignatureError() throws ParserConfigurationException, SAXException,
			IOException {
		try {
			WXBizMsgCryptImpl pc = new WXBizMsgCryptImpl(token, encodingAesKey, appId);
			String afterEncrpt = pc.encryptMsg(replyMsg, timestamp, nonce);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(afterEncrpt);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encrypt");

			String encrypt = nodelist1.item(0).getTextContent();
			String fromXML = String.format(xmlFormat, encrypt);
			pc.decryptMsg("12345", timestamp, nonce, fromXML); // 这里签名错误
		} catch (AesException e) {
			assertEquals(AesException.ValidateSignatureError, e.getCode());
			return;
		}
		fail("错误流程不抛出异常？？？");
	}

	@Ignore
	@Test
	public void testVerifyUrl() throws AesException {
		WXBizMsgCryptImpl wxcpt = new WXBizMsgCryptImpl("smforj",
				"s8vFF4f6AWay3uAdJh79WD6imaam4BV6Kl4eL4UzgfM", "wxe930a8c273b921e9");
		String signature = "c30b13f81eae957b865a27b35fe30a9a60ce4c35";
		String timeStamp = "1471223618";
		String nonce = "1172721634";
		String echoStr = "5448455673471530827";
		wxcpt.verifyURL(signature, timeStamp, nonce, echoStr);
		// 只要不抛出异常就好
	}
}
