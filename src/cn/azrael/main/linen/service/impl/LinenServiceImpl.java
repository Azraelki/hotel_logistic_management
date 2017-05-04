package cn.azrael.main.linen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.linen.dao.LinenDao;
import cn.azrael.main.linen.dao.LinensInfoDao;
import cn.azrael.main.linen.entity.Linen;
import cn.azrael.main.linen.entity.LinensInfo;
import cn.azrael.main.linen.service.LinenService;
@Service("linenService")
public class LinenServiceImpl extends BaseServiceImpl<Linen> implements LinenService{
	private LinenDao linenDao;
	private LinensInfoDao linensInfoDao;
	@Resource
	public void setLinensInfoDao(LinensInfoDao linensInfoDao) {
		this.linensInfoDao = linensInfoDao;
	}
	@Resource
	public void setLinenDao(LinenDao linenDao) {
		setBaseDao(linenDao);
		this.linenDao = linenDao;
	}
	@Override
	public void saveLinenAndLinensInfo(Linen linen, List<LinensInfo> linensInfo) {
		//保存清单
		linenDao.save(linen);
		//保存清单详细
		for(LinensInfo ls: linensInfo){
			if(ls == null){
				continue;
			}
			ls.setLinenId(linen);
			linensInfoDao.save(ls);
		}
	}
}
