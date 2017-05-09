package cn.azrael.main.purchase.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.facilitie.service.FacilitieService;
import cn.azrael.main.purchase.entity.PurchaseInfo;
import cn.azrael.main.purchase.entity.PurchaseOrder;
import cn.azrael.main.purchase.service.PurchaseInfoService;
import cn.azrael.main.purchase.service.PurchaseOrderService;

public class PurchaseInfoAction extends BaseAction{
	@Resource
	private PurchaseInfoService purchaseInfoService;
	@Resource
	private FacilitieService facilitieService;
	@Resource
	private PurchaseOrderService purchaseOrderService;
	private List<PurchaseInfo> purchaseInfoList;
	private PurchaseOrder purchaseOrder;
	private PurchaseInfo purchaseInfo;
	private Facilitie facilitie;
	
	private String message;
	public String execute(){
		return "default";
	}
	/**
	 * 采购单列表信息
	 */
	public String info() throws Exception{
		//加载设施列表
		ActionContext.getContext().getContextMap().put("facilitieList", facilitieService.findObjects());
		QueryHelper queryHelper = new QueryHelper(PurchaseInfo.class, "pi");
		try {
			System.out.println(pageNo);
			if(facilitie!=null){
				System.out.println(facilitie.getId());
				if(facilitie.getId().length() >= 10){
					queryHelper.addCondition("pi.facilitieId.id=?", facilitie.getId());
				}
			}
			queryHelper.addCondition("pi.purchaseOrderId.status=?", 1);
			pageResult = purchaseInfoService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "info";
	}
	/**
	 * 编辑界面
	 */
	public String editUI(){
		System.out.println(pageNo);
		//加载设施列表
		ActionContext.getContext().getContextMap().put("facilitieList", facilitieService.findObjects());
		if(purchaseInfo!=null && purchaseInfo.getId()!=null){
			purchaseInfo = purchaseInfoService.findObjectById(purchaseInfo.getId());
		}
		return "editUI";
	}
	/**
	 * 编辑
	 */
	public String edit(){
		System.out.println(pageNo);
		try {
			if(purchaseInfo!=null){
				purchaseOrder = purchaseOrderService.findObjectById(purchaseInfo.getPurchaseOrderId().getId());
				if(purchaseOrder.getStatus() == 1){
					purchaseInfoService.editAndUpdateFacilitie(purchaseInfo);
				}else{
					purchaseInfoService.update(purchaseInfo);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	/**
	 * 删除单个记录
	 */
	public String delete() throws Exception{
		System.out.println(pageNo);
		try {
			if(purchaseInfo!=null){
				purchaseInfo = purchaseInfoService.findObjectById(purchaseInfo.getId());
				purchaseOrder = purchaseOrderService.findObjectById(purchaseInfo.getPurchaseOrderId().getId());
				if(purchaseOrder.getStatus()==1){
					purchaseInfoService.deleteAndUpdateFacilitie(purchaseInfo);
				}else{
					purchaseInfoService.delete(purchaseInfo.getId());
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "list";
	}

	public List<PurchaseInfo> getPurchaseInfoList() {
		return purchaseInfoList;
	}

	public void setPurchaseInfoList(List<PurchaseInfo> purchaseInfoList) {
		this.purchaseInfoList = purchaseInfoList;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public PurchaseInfo getPurchaseInfo() {
		return purchaseInfo;
	}

	public void setPurchaseInfo(PurchaseInfo purchaseInfo) {
		this.purchaseInfo = purchaseInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public Facilitie getFacilitie() {
		return facilitie;
	}
	public void setFacilitie(Facilitie facilitie) {
		this.facilitie = facilitie;
	}
	
	
}
