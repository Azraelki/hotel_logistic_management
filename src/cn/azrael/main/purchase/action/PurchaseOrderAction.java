package cn.azrael.main.purchase.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.facilitie.entity.Facilitie;
import cn.azrael.main.facilitie.service.FacilitieService;
import cn.azrael.main.purchase.entity.PurchaseInfo;
import cn.azrael.main.purchase.entity.PurchaseOrder;
import cn.azrael.main.purchase.service.PurchaseInfoService;
import cn.azrael.main.purchase.service.PurchaseOrderService;
import cn.azrael.main.user.service.EmployeeService;

public class PurchaseOrderAction extends BaseAction{
	@Resource
	private PurchaseOrderService purchaseOrderService;
	@Resource
	private FacilitieService facilitieService;
	@Resource
	private PurchaseInfoService purchaseInfoService;
	@Resource
	private EmployeeService employeeService;
	private PurchaseOrder purchaseOrder;
	private List<PurchaseInfo> purchaseInfo;
	private Facilitie facilitie;
	private Double beginDate;
	private Double endDate;
	private String message;
	public String execute(){
		return "default";
	}
	/**
	 * 采购单列表信息
	 */
	public String info() throws Exception{
		QueryHelper queryHelper = new QueryHelper(PurchaseOrder.class, "po");
		try {
			System.out.println(pageNo);
			if(beginDate != null){
				System.out.println(beginDate);
				queryHelper.addCondition("po.date >= ?", beginDate);
			}
			if(endDate != null){
				System.out.println(endDate);
				queryHelper.addCondition("po.date <= ?", endDate);
			}
			queryHelper.addOrderByProperty("po.date", QueryHelper.ORDER_BY_DESC);
			pageResult = purchaseOrderService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "info";
	}
	/**
	 * 修改订单状态
	 */
	public String change() throws Exception{
		QueryHelper queryHelper = new QueryHelper(PurchaseOrder.class, "po");
		try {
			System.out.println(pageNo);
			queryHelper.addCondition("po.status!=?", 1);
			queryHelper.addOrderByProperty("po.date", QueryHelper.ORDER_BY_DESC);
			pageResult = purchaseOrderService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "change";
	}
	/**
	 * 导出洗涤单
	 */
	public void exportExcel(){
		try{
			if(purchaseOrder!=null && purchaseOrder.getId()!=null){
				purchaseOrder = purchaseOrderService.findObjectById(purchaseOrder.getId());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String fileName = "物资申购单"+sdf.format(new Date(purchaseOrder.getDate().longValue()*1000))+".xlsx";
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/x-execl");
				response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes(),"ISO-8859-1"));
				ServletOutputStream outputStream = response.getOutputStream();
				purchaseOrderService.exportExcel(purchaseOrder,outputStream);
				if(outputStream!=null){
					outputStream.close();
				}
			}
		}catch(Exception e){
			
		}
	}
	/**
	 * 清单详情
	 */
	public String detail() {
		System.out.println(pageNo);
		QueryHelper queryHelper = new QueryHelper(PurchaseInfo.class, "pi");
		if(purchaseOrder!=null && purchaseOrder.getId()!=null){
			purchaseOrder = purchaseOrderService.findObjectById(purchaseOrder.getId());
			queryHelper.addCondition("pi.purchaseOrderId.id=?", purchaseOrder.getId());
			pageResult = purchaseInfoService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
			if(pageResult.getTotalPageCount() == 1){
				this.setPageNo(1);
				pageResult = purchaseInfoService.getPageResult(queryHelper, this.getPageNo(), this.getPageSize());
			}
		}
		return "detail";
	}
	/**
	 * 添加页面
	 */
	public String add() throws Exception{
		//TODO
		if(purchaseInfo!=null){
			for(PurchaseInfo pi:purchaseInfo){
				System.out.println(pi);
			}
		}
		//加载布草种类列表
		ActionContext.getContext().getContextMap().put("facilitieList", facilitieService.findObjects());
		try {
			//判断传入信息不为空
			if(purchaseOrder!=null && purchaseInfo!=null){
				if(StringUtils.isNotBlank(purchaseOrder.getEmployeeId().getName())){
					//获取负责人的信息
					purchaseOrder.setEmployeeId(employeeService.findByName(purchaseOrder.getEmployeeId().getName()));
					purchaseOrder.setStatus(0);
					if(purchaseOrder.getEmployeeId()!=null){
						//保存清单
						purchaseOrderService.save(purchaseOrder);
						//保存清单详细
						for(PurchaseInfo pi: purchaseInfo){
							if(pi == null){
								continue;
							}
							pi.setTotal(pi.getPrice()*pi.getPurchaseNum());
							pi.setPurchaseOrderId(purchaseOrder);
							purchaseInfoService.save(pi);
						}
						message = "添加成功!";
					}else{
						message = "没有此员工!";
					}
				}
			}
		} catch (Exception e) {
			message = "添加失败!";
			throw new RuntimeException();
		}
		return "add";
	}
	/**
	 * 编辑页面
	 */
	public String editUI(){
		if(purchaseOrder!=null && purchaseOrder.getId()!=null){
			purchaseOrder = purchaseOrderService.findObjectById(purchaseOrder.getId());
			System.out.println(purchaseOrder.getEmployeeId());
		}
		return "editUI";
	}
	/**
	 * 编辑
	 */
	public String edit() throws Exception{
		try {
			if(purchaseOrder!=null){
				if(purchaseOrder.getStatus() == 1){
					purchaseOrderService.changeAndUpdate(purchaseOrder);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "change";
	}
	/**
	 * 删除当前清单和清单中的数据
	 */
	public String delete() throws Exception{
		try {
			if(purchaseOrder!=null){
				purchaseOrderService.deleteAndUpdate(purchaseOrder);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return "list";
	}
	/**
	 * 批量删除
	 */
	public String deleteSelected() throws Exception{
		if(selectedRow!=null){
			for(String s:selectedRow){
				try {
					purchaseOrderService.findObjectById(s);
					purchaseOrderService.deleteAndUpdate(purchaseOrder);
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
		return "list";
	}
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public List<PurchaseInfo> getPurchaseInfo() {
		return purchaseInfo;
	}
	public void setPurchaseInfo(List<PurchaseInfo> purchaseInfo) {
		this.purchaseInfo = purchaseInfo;
	}
	public Facilitie getFacilitie() {
		return facilitie;
	}
	public void setFacilitie(Facilitie facilitie) {
		this.facilitie = facilitie;
	}
	public Double getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Double beginDate) {
		this.beginDate = beginDate;
	}
	public Double getEndDate() {
		return endDate;
	}
	public void setEndDate(Double endDate) {
		this.endDate = endDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
