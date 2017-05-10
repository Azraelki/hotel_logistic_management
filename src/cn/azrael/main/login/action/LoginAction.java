package cn.azrael.main.login.action;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import cn.azrael.main.core.constant.Constant;
import cn.azrael.main.user.entity.Employee;
import cn.azrael.main.user.entity.User;
import cn.azrael.main.user.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	@Resource
	private UserService userService;
	private User user;
	private String loginResult;
	private String rememberMe;
	//跳转到登录界面
	public String toLoginUI(){
		if(ServletActionContext.getRequest().getSession().getAttribute(Constant.USER)!=null){
			return "home";
		}
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		for (Cookie c : cookies) {
			if("user.employeeId.phoneNumber".equals(c.getName())){
				user = new User();
				Employee e = new Employee();
				e.setPhoneNumber(c.getValue());
				user.setEmployeeId(e);
			}
		}
		return "loginUI";
	}
	//登陆
	public String login(){
		if(user!=null && user.getEmployeeId()!=null){
			if(StringUtils.isNotBlank(user.getEmployeeId().getPhoneNumber())&&StringUtils.isNotBlank(user.getPassword())){
				//根据电话和密码查询用户
				User u = userService.findByPhoneAndPassword(user.getEmployeeId().getPhoneNumber(),user.getPassword());
				if(u!=null){
					//登陆成功
					ServletActionContext.getRequest().getSession().setAttribute(Constant.USER, u);
					//将用户登录信息保存到日志中
					Log log = LogFactory.getLog(getClass());
					log.info("用户为："+ u.getEmployeeId().getName()+" 的用户登陆了系统。");
					//判定是否需要设置或删除cookie
					System.out.println(rememberMe);
					if("remember".equals(rememberMe)){
						if(StringUtils.isNotBlank(rememberMe)){
							Cookie cookieName = new Cookie("user.employeeId.phoneNumber", u.getEmployeeId().getPhoneNumber());
							cookieName.setMaxAge(30*24*60*60);
							ServletActionContext.getResponse().addCookie(cookieName);
						}
					}else{
						Cookie[] cookies = ServletActionContext.getRequest().getCookies();
						for(Cookie c:cookies){
							if("user.employeeId.phoneNumber".equals(c.getName())){
								c.setMaxAge(0);
								ServletActionContext.getResponse().addCookie(c);
							}
						}
					}
					//重定向到首页
					return "home";
				}else{
					loginResult = "帐号或密码不正确！";
				}
			}else{
				loginResult = "帐号或密码不能为空！";
			}
		}else{
			loginResult = "请输入帐号和密码！";
		}
		return toLoginUI();
	}
	//退出，注销
	public String logout(){
		//清除session中的用户信息
		ServletActionContext.getRequest().getSession().removeAttribute(Constant.USER);
		return toLoginUI();
	}
	//跳转到没有权限提示页面
	public String toNoPermissionUI(){
		return "noPermissionUI";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getLoginResult() {
		return loginResult;
	}
	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}
	public String getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
	
}
