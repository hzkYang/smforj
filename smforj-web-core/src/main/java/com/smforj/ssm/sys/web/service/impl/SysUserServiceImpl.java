package com.smforj.ssm.sys.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smforj.ssm.encrypt.md5.MD5;
import com.smforj.ssm.frame.core.dao.BaseDao;
import com.smforj.ssm.frame.core.service.impl.BaseServiceImpl;
import com.smforj.ssm.sys.web.bean.SysUser;
import com.smforj.ssm.sys.web.dao.SysUserDao;
import com.smforj.ssm.sys.web.service.SysUserService;

/***
 * 用户服务接口的实现
 * 
 * @author Haijun Gao 
 * @date 2016-9-8 上午10:16:19
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	protected BaseDao<SysUser> getBaseDao() {
		return sysUserDao;
	} 

	@Override
	public SysUser getUser(String username, String password) {
		SysUser query = new SysUser();
		query.setUsername(username);
		query.setPassword(MD5.getMd5(password));
		return this.queryOne(query);  
	}

	@Override
	public void insert(SysUser entity) { 
		entity.setPassword(MD5.getMd5(entity.getPassword()));
		super.insert(entity);
	}

	@Override
	@Transactional
	public void insertInBatch(List<SysUser> entityList) {
		for(SysUser entity : entityList)
			entity.setPassword(MD5.getMd5(entity.getPassword()));
		super.insertInBatch(entityList);
	}

	@Override
	public int updateById(SysUser entity) {
		entity.setPassword(MD5.getMd5(entity.getPassword()));
		return super.updateById(entity);
	}

	@Override
	public int updateByIdSelective(SysUser entity) {
		entity.setPassword(MD5.getMd5(entity.getPassword()));
		return super.updateByIdSelective(entity);
	}

	@Override
	@Transactional
	public void updateInBatch(List<SysUser> entityList) {
		for(SysUser entity : entityList)
			entity.setPassword(MD5.getMd5(entity.getPassword()));
		super.updateInBatch(entityList);
	}
	
	

}
