package cn.azrael.main.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.system.dao.SystemLogDao;
import cn.azrael.main.system.entity.SystemLog;
import cn.azrael.main.system.service.SystemLogService;
@Service("systemLogService")
public class SystemLogServiceImpl extends BaseServiceImpl<SystemLog> implements SystemLogService{
	private SystemLogDao systemLogDao;
	@Resource
	public void setSystemLogDao(SystemLogDao systemLogDao) {
		setBaseDao(systemLogDao);
		this.systemLogDao = systemLogDao;
	}
	@Override
	public void addLog(SystemLog systemLog) {
		systemLogDao.save(systemLog);
	}
}
