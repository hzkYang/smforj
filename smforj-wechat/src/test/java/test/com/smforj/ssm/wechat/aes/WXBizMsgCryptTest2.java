package test.com.smforj.ssm.wechat.aes;

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
import com.smforj.ssm.wechat.aes.WXBizMsgCryptImpl;

public class WXBizMsgCryptTest2 { 
	
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
	public void test() throws AesException, ParserConfigurationException, SAXException, IOException
	{

		//
		// 第三方回复公众平台
		// 
		// 需要加密的明文
		String encodingAesKey = "s8vFF4f6AWay3uAdJh79WD6imaam4BV6Kl4eL4UzgfM";
		String token = "smforj";
		String timestamp = "1472541015";
		String nonce = "46328643";
		String appId = "wxe930a8c273b921e9";
		String replyMsg = "<xml><ToUserName><![CDATA[opQSRwWhh9sCHQejRW4V8SlhkFNI]]></ToUserName><FromUserName><![CDATA[gh_92c7f0e041ff]]></FromUserName>" +
		  		"<CreateTime><![CDATA[1472540956158]]></CreateTime><MsgType><![CDATA[text]]></MsgType><FuncFlag><![CDATA[0]]>" +
		  		"</FuncFlag><Content><![CDATA[]]></Content></xml>";
		WXBizMsgCryptImpl pc = new WXBizMsgCryptImpl(token, encodingAesKey, appId);
		String mingwen = pc.encryptMsg(replyMsg, timestamp, nonce);
		System.out.println("加密后: " + mingwen);

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader sr = new StringReader(mingwen);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);

		Element root = document.getDocumentElement();
		NodeList nodelist1 = root.getElementsByTagName("Encrypt");
		NodeList nodelist2 = root.getElementsByTagName("MsgSignature");

		String encrypt = nodelist1.item(0).getTextContent();
		String msgSignature = nodelist2.item(0).getTextContent();

		String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
		String fromXML = String.format(format, encrypt);

		//
		// 公众平台发送消息给第三方，第三方处理
		//

		// 第三方收到公众号平台发送的消息
		String result2 = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
		System.out.println("解密后明文: " + result2);
		
		//pc.verifyUrl(null, null, null, null);
	} 
}
