package com.smforj.ssm.sys.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.smforj.ssm.frame.core.dao.impl.BaseDaoImpl;
import com.smforj.ssm.sys.web.bean.SysOperlog;
import com.smforj.ssm.sys.web.dao.OperlogDao;

/***
 * 用户信息实现对象 该类实现了注解,子系统可以再次实现该对象
 * 
 * @author Haijun Gao 
 * @date 2016-9-8 上午9:35:18
 * @desp http://www.cnblogs.com/saga5998/
 * @email 573107773@qq.com
 */
@Repository
public class OperlogDaoImpl extends BaseDaoImpl<SysOperlog> implements OperlogDao {

}
