package cn.azrael.main.facilitie.service;

import java.util.List;

import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.facilitie.entity.Facilitie;

public interface FacilitieService extends BaseService<Facilitie>{
	//根据类型查找
	public List<Facilitie> findByType(int type);
	//根据姓名查找
	public List<Facilitie> findByName(String name);
	//登记损坏布草信息，并更新布草信息
	public void invalidAndUpdate(Facilitie facilitie)throws ServiceException;
}
