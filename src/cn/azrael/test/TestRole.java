package cn.azrael.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.azrael.main.user.entity.Role;
import cn.azrael.main.user.service.RoleService;

public class TestRole {
	private ApplicationContext ac;
	private RoleService rs;
	@Before
	public void loadCtx(){
		ac = new ClassPathXmlApplicationContext(new String[] {"classpath:spring.xml"});
		rs = (RoleService) ac.getBean("roleService");
	}
	@Test
	public void testSave()throws Exception{
		Role role = new Role();
		role.setType(1);
		role.setPrivilege("yhgl");
		rs.save(role);
		role.setPrivilege("bcgl");
		rs.save(role);
		role.setPrivilege("cggl");
		rs.save(role);
		role.setPrivilege("cygl");
		rs.save(role);
		role.setPrivilege("sswh");
		rs.save(role);
		role.setType(2);
		role.setPrivilege("yhgl");
		rs.save(role);
		role.setPrivilege("bcgl");
		rs.save(role);
		role.setPrivilege("cggl");
		rs.save(role);
		role.setPrivilege("cygl");
		rs.save(role);
		role.setPrivilege("sswh");
		rs.save(role);
		role.setType(5);
		role.setPrivilege("sswh");
		rs.save(role);
		role.setType(6);
		role.setPrivilege("cygl");
		rs.save(role);
	}
}
