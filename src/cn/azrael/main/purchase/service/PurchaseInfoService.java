package cn.azrael.main.purchase.service;

import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.purchase.entity.PurchaseInfo;

public interface PurchaseInfoService extends BaseService<PurchaseInfo>{
	//修改PurchaseInfo并更新facilitie
	public void editAndUpdateFacilitie(PurchaseInfo purchaseInfo);
	//修改PurchaseInfo并更新facilitie
	public void deleteAndUpdateFacilitie(PurchaseInfo purchaseInfo);
}
