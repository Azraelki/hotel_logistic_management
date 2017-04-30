package cn.azrael.main.facilitie.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.facilitie.dao.FacilitieDao;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.facilitie.service.FacilitieService;
@Service("facilitieService")
public class FacilitieServiceImpl extends BaseServiceImpl<Facilitie> implements FacilitieService{
	private FacilitieDao facilitieDao;
	@Resource
	public void setFacilitieDao(FacilitieDao facilitieDao) {
		setBaseDao(facilitieDao);
		this.facilitieDao = facilitieDao;
	}
}
