package com.smforj.ssm.sys.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smforj.ssm.frame.core.dao.BaseDao;
import com.smforj.ssm.frame.core.service.impl.BaseServiceImpl;
import com.smforj.ssm.sys.web.bean.SysDictionary;
import com.smforj.ssm.sys.web.dao.SysDictionaryDao;
import com.smforj.ssm.sys.web.service.SysDictionaryService;

/**
 * 字典信息服务类接口实现
 * @author LiuJunGuang
 * @date 2014年3月7日下午2:27:08
 */
@Service
public class SysDictionaryServiceImpl extends BaseServiceImpl<SysDictionary> implements SysDictionaryService {
	@Autowired
	private SysDictionaryDao sysDictionaryDao;

	@Override
	protected BaseDao<SysDictionary> getBaseDao() {
		return sysDictionaryDao;
	}

}
