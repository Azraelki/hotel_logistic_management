package cn.azrael.main.linen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.linen.dao.LinensInfoDao;
import cn.azrael.main.linen.entity.LinensInfo;
import cn.azrael.main.linen.service.LinensInfoService;
@Service("linensInfoService")
public class LinensInfoServiceImpl extends BaseServiceImpl<LinensInfo> implements LinensInfoService{
	private LinensInfoDao linensInfoDao;
	@Resource
	public void setLinensInfoDao(LinensInfoDao linensInfoDao) {
		setBaseDao(linensInfoDao);
		this.linensInfoDao = linensInfoDao;
	}
}
