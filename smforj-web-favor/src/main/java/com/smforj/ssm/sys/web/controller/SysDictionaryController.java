package com.smforj.ssm.sys.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smforj.ssm.frame.core.service.BaseService;
import com.smforj.ssm.frame.core.web.controller.BaseControllerImpl;
import com.smforj.ssm.sys.web.bean.SysDictionary;
import com.smforj.ssm.sys.web.bean.query.SysDictionaryQuery;
import com.smforj.ssm.sys.web.service.SysDictionaryService;

/**
 * 字典信息的基本操作
 * @author LiuJunGuang
 * @date 2014年3月5日上午10:30:16
 */
@Controller
@RequestMapping("/sys/dictionary")
public class SysDictionaryController extends BaseControllerImpl<SysDictionary, SysDictionaryQuery> {
	@Autowired
	private SysDictionaryService sysDictionaryService;

	@Override
	protected BaseService<SysDictionary> getBaseService() {
		return sysDictionaryService;
	}

}
