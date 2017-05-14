package cn.azrael.main.system.action;

import java.util.List;

import javax.annotation.Resource;

import cn.azrael.main.core.action.BaseAction;
import cn.azrael.main.core.constant.Constant;
import cn.azrael.main.core.util.QueryHelper;
import cn.azrael.main.user.entity.Job;
import cn.azrael.main.user.entity.Role;
import cn.azrael.main.user.service.JobService;
import cn.azrael.main.user.service.RoleService;

import com.opensymphony.xwork2.ActionContext;

public class SystemAction extends BaseAction{
	@Resource
	private RoleService roleService;
	@Resource
	private JobService jobService;
	private List<Role> roleList;
	private String privilegeStr;
	private String[] privileges;
	private Job job;
	public String execute() throws Exception {
		return "default";
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
	//editui
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
	public String editRole(){
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
	
}
