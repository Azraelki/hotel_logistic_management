package cn.azrael.main.linen.service;

import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.linen.entity.Linen;
import cn.azrael.main.linen.entity.LinensInfo;

public interface LinenService extends BaseService<Linen>{
	//保存布草洗涤单和清单内容
	public void saveLinenAndLinensInfo(Linen linen,List<LinensInfo> linensInfo)throws ServiceException;
	//导出信息为excel
	public void exportExcel(Linen linen, ServletOutputStream outputStream)throws ServiceException;
}
