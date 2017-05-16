package cn.azrael.main.purchase.service;


import javax.servlet.ServletOutputStream;

import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.purchase.entity.PurchaseOrder;

public interface PurchaseOrderService extends BaseService<PurchaseOrder>{
	//改变订单状态时更改设施的数目
	public void changeAndUpdate(PurchaseOrder purchaseOrder)throws ServiceException;
	//删除时更改设施的数目
	public void deleteAndUpdate(PurchaseOrder purchaseOrder)throws ServiceException;
	//导出采购清单
	public void exportExcel(PurchaseOrder purchaseOrder,
			ServletOutputStream outputStream)throws ServiceException;
}
