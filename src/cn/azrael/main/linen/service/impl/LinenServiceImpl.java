package cn.azrael.main.linen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.linen.dao.LinenDao;
import cn.azrael.main.linen.entity.Linen;
import cn.azrael.main.linen.service.LinenService;
@Service("linenService")
public class LinenServiceImpl extends BaseServiceImpl<Linen> implements LinenService{
	private LinenDao linenDao;
	@Resource
	public void setLinenDao(LinenDao linenDao) {
		setBaseDao(linenDao);
		this.linenDao = linenDao;
	}
}
