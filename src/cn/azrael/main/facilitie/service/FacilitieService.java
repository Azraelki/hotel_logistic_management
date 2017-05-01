package cn.azrael.main.facilitie.service;

import java.util.List;

import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.facilitie.entity.Facilitie;

public interface FacilitieService extends BaseService<Facilitie>{
	public List<Facilitie> findByType(int type);
}
