package com.smforj.ssm.sys.web.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.smforj.ssm.frame.core.dao.domain.Identifiable;
import com.smforj.ssm.frame.core.status.EnumDictionaryType;
import com.smforj.ssm.frame.core.status.EnumStatus;

public class SysDictionary implements Identifiable {

	/**
	 * @fields serialVersionUID 
	 */
	private static final long serialVersionUID = 3660184499862071843L;

	/**
	 * @fields id 主键
	 */
	private String dicId;

	/**
	 * @fields dicName 字典名称
	 */
	private String dicName;

	/**
	 * @fields dicValue 字典值  
	 */
	private String dicValue;
	/**
	 * @fields dicGroup 字典分组
	 */
	private String dicGroup;
	/**
	 * @fields dicType 字典类型
	 */
	private EnumDictionaryType dicType;
	/**
	 * @fields dicOrder 字典排序 
	 */
	private Integer dicOrder;
	/**
	 * @fields dicStatus 字典状态
	 */
	private EnumStatus dicStatus;

	/**
	 * @fields parent 父节点
	 */
	private String dicParentId;

	public String getDicId() {
		return dicId;
	}

	public void setDicId(String dicId) {
		this.dicId = dicId;
	}

	public EnumStatus getDicStatus() {
		return dicStatus;
	}

	public void setDicStatus(EnumStatus dicStatus) {
		this.dicStatus = dicStatus;
	}

	public String getDicName() {
		return dicName;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	public String getDicValue() {
		return dicValue;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}

	public String getDicGroup() {
		return dicGroup;
	}

	public void setDicGroup(String dicGroup) {
		this.dicGroup = dicGroup;
	}

	public Integer getDicOrder() {
		return dicOrder;
	}

	public EnumDictionaryType getDicType() {
		return dicType;
	}

	public void setDicType(EnumDictionaryType dicType) {
		this.dicType = dicType;
	}

	public void setDicOrder(Integer dicOrder) {
		this.dicOrder = dicOrder;
	}

	public String getDicParentId() {
		return dicParentId;
	}

	public void setDicParentId(String dicParentId) {
		this.dicParentId = dicParentId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public String getId() {
		return this.dicId;
	}

	@Override
	public void setId(String id) {
		this.dicId = id;
	}
}
