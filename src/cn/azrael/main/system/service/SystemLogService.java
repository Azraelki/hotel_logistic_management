package cn.azrael.main.system.service;

import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.system.entity.SystemLog;

public interface SystemLogService extends BaseService<SystemLog>{
	//添加log
	public void addLog(SystemLog systemLog);
}
