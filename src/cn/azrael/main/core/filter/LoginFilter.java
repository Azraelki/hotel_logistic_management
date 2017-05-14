package cn.azrael.main.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.azrael.main.core.constant.Constant;
import cn.azrael.main.core.permission.PermissionCheck;
import cn.azrael.main.user.entity.User;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String uri = request.getRequestURI();
		//判断当前请求地址是否为登陆的请求
		if(!uri.contains("sys/login_")){
			//非登录请求
			if(request.getSession().getAttribute(Constant.USER)!=null){
				//已经登陆过
				User user = (User)request.getSession().getAttribute(Constant.USER);
				//获取spring容器
				WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
				PermissionCheck pc = (PermissionCheck) applicationContext.getBean("permissionCheck");
				//判断是否访问各个子系统
				if(uri.contains("/user/")){
					if(pc.isAccessible(user, "yhgl")){
						//有权限，放行
						System.out.println("用户管理");
						chain.doFilter(request, response);
					}else{
						//没有权限，跳转到没有权限提示
						response.sendRedirect(request.getContextPath()+"/sys/login_toNoPermissionUI.action");
					}
				}else if(uri.contains("/linen/")){
					if(pc.isAccessible(user, "bcgl")){
						//有权限，放行
						System.out.println("布草管理");
						chain.doFilter(request, response);
					}else{
						//没有权限，跳转到没有权限提示
						response.sendRedirect(request.getContextPath()+"/sys/login_toNoPermissionUI.action");
					}
				}else if(uri.contains("/purchase/")){
					if(pc.isAccessible(user, "cggl")){
						//有权限，放行
						System.out.println("采购管理");
						chain.doFilter(request, response);
					}else{
						//没有权限，跳转到没有权限提示
						response.sendRedirect(request.getContextPath()+"/sys/login_toNoPermissionUI.action");
					}
				}else if(uri.contains("/food/")){
					if(pc.isAccessible(user, "cygl")){
						//有权限，放行
						System.out.println("餐饮管理");
						chain.doFilter(request, response);
					}else{
						//没有权限，跳转到没有权限提示
						response.sendRedirect(request.getContextPath()+"/sys/login_toNoPermissionUI.action");
					}
				}else if(uri.contains("/facilitie/")){
					if(pc.isAccessible(user, "sswh")){
						//有权限，放行
						System.out.println("设施管理");
						chain.doFilter(request, response);
					}else{
						//没有权限，跳转到没有权限提示
						System.out.println("没有权限");
						response.sendRedirect(request.getContextPath()+"/sys/login_toNoPermissionUI.action");
					}
				}else if(uri.contains("/sys/home")){
					chain.doFilter(request, response);
				}else if(uri.contains("/system")){
					if(pc.isAccessible(user, "xtwh")){
						//放行
						System.out.println("系统维护");
						chain.doFilter(request, response);
					}else{
						//没有权限，跳转到没有权限提示
						System.out.println("没有权限");
						response.sendRedirect(request.getContextPath()+"/sys/login_toNoPermissionUI.action");
					}
				}
			}else{
				//没有登录，跳转到登录页面
				System.out.println("没有登录");
				response.sendRedirect(request.getContextPath()+"/sys/login_toLoginUI.action");
			}
		}else{
			//登陆请求直接放行
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
