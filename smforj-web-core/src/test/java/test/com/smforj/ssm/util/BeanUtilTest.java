package test.com.smforj.ssm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.smforj.ssm.frame.core.utils.BeanUtils;

public class BeanUtilTest {

	/**
	 * @param args
	 * @date 2016-8-2 下午5:34:34
	 */
	public static void main(String[] args) { 
		
		
		Address a1 = new Address();
		a1.setAddr("addr1");
		Address a2 = new Address();
		a2.setAddr("addr2");
		List<Address> list = new ArrayList<Address>();
		list.add(a1);
		list.add(a2);
		
		Person p = new Person();
		p.setId("pid");
		p.setName("pname");
		
		Map<String,Object> map = BeanUtils.toMap(p);
		
		for(Object obj : map.values())
		{
			System.out.println(obj);
		} 
		p.setList(list);
		
		map = BeanUtils.toMap(p);
		for(Object obj : map.values())
		{
			System.out.println(obj);
		}

	}

}
