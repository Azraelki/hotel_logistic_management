package cn.azrael.main.login.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{
	//跳转到首页
	public String execute(){
		return "home";
	}
}
