package cn.azrael.main.system.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.constant.Constant;
import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.system.entity.SystemLog;
import cn.azrael.main.system.service.SystemLogService;
import cn.azrael.main.user.entity.Job;
import cn.azrael.main.user.entity.Role;
import cn.azrael.main.user.service.JobService;
import cn.azrael.main.user.service.RoleService;

import com.opensymphony.xwork2.ActionContext;

public class SystemAction extends BaseAction{
	@Resource
	private RoleService roleService;
	@Resource
	private SystemLogService systemLogService;
	@Resource
	private JobService jobService;
	private SystemLog systemLog;
	private List<Role> roleList;
	private String privilegeStr;
	private String[] privileges;
	private Job job;
	private String logTime;
	private Double beginDate;
	private Double endDate;
	public String execute() throws Exception {
		return "default";
	}
	/**
	 *日志信息查询 
	 */
	public String logInfo(){
		QueryHelper queryHelper = new QueryHelper(SystemLog.class, "sl");
		try{
			if(systemLog!=null){
				if(systemLog.getFlag()!=null && systemLog.getFlag()!=-1){
					queryHelper.addCondition("sl.flag=?", systemLog.getFlag());
				}
				
			}
			if(beginDate != null){
				System.out.println(beginDate);
				queryHelper.addCondition("sl.date >= ?", beginDate);
			}
			if(endDate != null){
				System.out.println(endDate);
				queryHelper.addCondition("sl.date <= ?", endDate);
			}
			queryHelper.addOrderByProperty("sl.date", QueryHelper.ORDER_BY_DESC);
			pageResult = jobService.getPageResult(queryHelper, getPageNo(), getPageSize());
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
		return "logInfo";
	}
	/**
	 * 日志详情
	 */
	public String logDetail(){
		if(systemLog!=null && systemLog.getId()!=null){
			systemLog = systemLogService.findObjectById(systemLog.getId());
			Date date = new Date(systemLog.getDate().longValue()*1000);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			logTime = sdf.format(date);
		}
		return "logDetail";
	}
	/**
	 *权限展示 
	 */
	public String roleInfo(){
		//加载权限
		ActionContext.getContext().getContextMap().put("roleList", roleService.findObjects());
		//加载权限全称
		ActionContext.getContext().getContextMap().put("roleMap", Constant.PRIVILEGE_MAP);
		QueryHelper queryHelper = new QueryHelper(Job.class, "j");
		try{
			queryHelper.addOrderByProperty("j.id", QueryHelper.ORDER_BY_ASC);
			pageResult = jobService.getPageResult(queryHelper, getPageNo(), getPageSize());
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
		return "roleInfo";
	}
	//权限编辑页面
	public String roleEditUI(){
		//加载职务信息列表
		ActionContext.getContext().getContextMap().put("jobList", jobService.findObjects());
		//加载权限全称
		ActionContext.getContext().getContextMap().put("roleMap", Constant.PRIVILEGE_MAP);
		if(job!=null && job.getId()!=null){
			job = jobService.findObjectById(job.getId());
			roleList = roleService.findByType(job.getId());
			for (Role e : roleList) {
				privilegeStr = privilegeStr+e.getPrivilege()+";";
			}
		}
		return "roleEditUI";
	}
	//权限编辑
	public String editRole() throws ServiceException{
		if(job!=null && job.getId()!=null){
			if(privileges!=null && privileges.length > 0){
				for(String s : privileges){
					Role role = roleService.findByTypeAndPrivilege(job.getId(),s);
					if(role != null)
						continue;
					role = new Role();
					role.setType(job.getId());
					role.setPrivilege(s);
					roleService.save(role);
				}
			}else{
				roleService.deleteByType(job.getId());
			}
			return "rolelist";
		}
		return "addRole";
	}
	
	public String[] getPrivileges() {
		return privileges;
	}
	public void setPrivileges(String[] privileges) {
		this.privileges = privileges;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	public String getPrivilegeStr() {
		return privilegeStr;
	}
	public void setPrivilegeStr(String privilegeStr) {
		this.privilegeStr = privilegeStr;
	}
	public SystemLog getSystemLog() {
		return systemLog;
	}
	public void setSystemLog(SystemLog systemLog) {
		this.systemLog = systemLog;
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
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	
}
