package cn.azrael.test.action;

import org.springframework.beans.factory.annotation.Autowired;

import cn.azrael.test.service.TestService;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	@Autowired
	private TestService testService;
	
	public String execute(){
		testService.say();
		return SUCCESS;
	}
}
