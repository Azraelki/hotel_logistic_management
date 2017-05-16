package cn.azrael.main.linen.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.springframework.stereotype.Service;

import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.core.log.DescripLog;
import cn.azrael.main.core.service.impl.BaseServiceImpl;
import cn.azrael.main.core.util.ExcelUtil;
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
	@DescripLog(desc="保存布草洗涤单和清单内容")
	@Override
	public void saveLinenAndLinensInfo(Linen linen, List<LinensInfo> linensInfo) throws ServiceException{
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
	@DescripLog(desc="导出布草洗涤清单")
	@Override
	public void exportExcel(Linen linen, ServletOutputStream outputStream) throws ServiceException{
		ExcelUtil.exportLinenExcel(linen, outputStream);
	}
}
