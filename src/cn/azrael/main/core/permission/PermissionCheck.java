package cn.azrael.main.core.permission;

import java.util.List;

import javax.annotation.Resource;

import cn.azrael.main.user.entity.Role;
import cn.azrael.main.user.entity.User;
import cn.azrael.main.user.service.UserService;

public class PermissionCheck {
	@Resource
	private UserService userService;
	
	public boolean isAccessible(User user,String code){
		//获取用户对应的权限
		List<Role> list = userService.findRoleByUser(user);
		//对比权限，看是否拥有相应权限
		if(list != null && list.size() > 0){
			for (Role role : list) {
				if(code.equals(role.getPrivilege())){
					//说明有权限
					return true;
				}
			}
		}
		return false;
	}
}
