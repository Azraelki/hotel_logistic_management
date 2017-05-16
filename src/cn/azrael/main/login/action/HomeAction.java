package cn.azrael.main.login.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import cn.azrael.main.core.constant.Constant;
import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.user.entity.User;
import cn.azrael.main.user.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{
	@Resource
	private UserService userService;
	private String old;
	private String first;
	private String second;
	private String message;
	//跳转到首页
	public String execute(){
		return "home";
	}
	//修改密码
	public String json() throws ServiceException{
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute(Constant.USER);
		if(old!=null && old.equals(user.getPassword())){
			if(first!=null && second!=null){
				if(first.equals(second)){
					user.setPassword(first);
					userService.update(user);
					message = "密码修改成功";
				}else{
					message = "两次密码输入不一致！";
				}
			}else{
				message = "新密码输入不能为空！";
			}
		}else{
			message = "原始密码错误,无法修改！";
		}
		return "json";
	}
	
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
