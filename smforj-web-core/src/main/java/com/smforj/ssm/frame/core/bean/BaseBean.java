package com.smforj.ssm.frame.core.bean;

import java.util.Date;

import com.smforj.ssm.frame.core.dao.domain.Identifiable;

/***
 * 包含主键的UUID
 * 
 * @author Haijun Gao 
 * @date 2016-7-31 上午10:28:30
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public abstract class BaseBean implements Identifiable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6629475602273015237L;
	/***
	 * uuid 为了兼容已经系统的id
	 */
	protected String uuid;  
	
	protected Date createdate;
	
	protected Date updatedate;
	
	protected Integer status; 
	
	private Boolean isdeleted;
	
	/***
	 * 获取主键或uuid
	 */
	@Override
	public String getId() { 
		return uuid;
	}

	/***
	 * 设置主键或uuid
	 */
	@Override
	public void setId(String id) { 
		uuid = id;
	} 
	/***
	 * 获取状态 0 禁用 1启用 
	 * @date 2016-9-8 下午1:01:38
	 */
	public Integer getStatus() {
		return status;
	}

	/***
	 * 设置状态 0 禁用 1启用
	 * @param status
	 * @date 2016-9-8 下午1:01:38
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/***
	 * 获取创建时间
	 * @return
	 * @date 2016-9-8 下午1:01:10
	 */
	public Date getCreatedate() {
		return createdate;
	}

	/***
	 * 设置创建时间
	 * @param createdate
	 * @date 2016-9-8 下午1:00:57
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	/***
	 * 获取更新时间
	 * @return
	 * @date 2016-9-8 下午12:58:23
	 */
	public Date getUpdatedate() {
		return updatedate;
	}

	/***
	 * 设置更新时间
	 * @param updatedate
	 * @date 2016-9-8 下午12:58:13
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	} 
	/***
	 * 获取是否删除标志
	 * @return
	 * @date 2016-9-8 下午12:57:39
	 */ 
	public Boolean getIsdeleted() {
		return isdeleted == null ? isdeleted = false : isdeleted;
	}
	/***
	 * 设置是否删除
	 * @param isDeleted
	 * @date 2016-9-8 下午12:57:55
	 */ 
	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	} 
	
	
}
