package cn.azrael.main.user.service;

import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.azrael.main.core.service.BaseService;
import cn.azrael.main.linen.entity.Linen;
import cn.azrael.main.user.entity.Role;
import cn.azrael.main.user.entity.User;

public interface UserService extends BaseService<User>{
	//根据用户返回权限集合
	public List<Role> findRoleByUser(User user);
	//根据员工电话和用户密码查询员工
	public User findByPhoneAndPassword(String phone,String password);
}
