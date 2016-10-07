package test.com.smforj.ssm.util;

import java.util.List;
import java.util.Set;

public class Person { 
	
	private String id;
	private String name;
	
	private List<Address> list;
	private Set<Address> set;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address> getList() {
		return list;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}
	public Set<Address> getSet() {
		return set;
	}
	public void setSet(Set<Address> set) {
		this.set = set;
	} 
}
