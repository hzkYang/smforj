package com.smforj.ssm.sys.web.bean;

import java.util.Date;

import com.smforj.ssm.frame.core.bean.BaseBean;

public class SysOperlog extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7947055042852557974L;
	
	
	private Integer lid;
	private String userid;
	private String operurl;
	private String opercontent;
	private String operip;
	private String remark;
	private Date operdate;
	
	
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOperurl() {
		return operurl;
	}
	public void setOperurl(String operurl) {
		this.operurl = operurl;
	}
	public String getOpercontent() {
		return opercontent;
	}
	public void setOpercontent(String opercontent) {
		this.opercontent = opercontent;
	}
	public String getOperip() {
		return operip;
	}
	public void setOperip(String operip) {
		this.operip = operip;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getOperdate() {
		return operdate;
	}
	public void setOperdate(Date operdate) {
		this.operdate = operdate;
	} 

}
