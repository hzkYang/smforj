package com.smforj.ssm.frame.core.bean;

/***
 * 分页 使用于分页对象
 * 针对mysql
 * 
 * @author Haijun Gao 
 * @date 2016-9-8 上午10:03:24
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
public class PageBean extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2416081783895705261L;
	/***
	 * 排序
	 */
	private String sorting;
	/***
	 * 偏移
	 */
	private String offset;
	/***
	 * 限制
	 */
	private String limit; 
	
	/***
	 * 获取排序字段
	 * @return
	 * @date 2016-8-3 上午11:57:28
	 */
	public String getSorting() {
		return sorting;
	}

	/***
	 * 设置排序字段
	 * @param sorting
	 * @date 2016-8-3 上午11:57:53
	 */
	public void setSorting(String sorting) {
		this.sorting = sorting;
	}

	/**
	 * 获取偏量 用于分页查询
	 * @return
	 * @date 2016-8-3 上午11:58:13
	 */
	public String getOffset() {
		return offset;
	}

	/**
	 * 设置偏量 用于分页查询
	 * @param offset
	 * @date 2016-8-3 上午11:58:42
	 */
	public void setOffset(String offset) {
		this.offset = offset;
	}

	/***
	 * 获取 Limit 用于分页查询
	 * @return
	 * @date 2016-8-3 下午12:00:01
	 */
	public String getLimit() {
		return limit;
	}

	/***
	 * 设置Limit 用于分页查询
	 * @param limit
	 * @date 2016-8-3 下午12:00:29
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	} 

}
