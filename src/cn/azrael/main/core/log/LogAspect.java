package cn.azrael.main.core.log;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

import cn.azrael.main.core.constant.Constant;
import cn.azrael.main.core.exception.ServiceException;
import cn.azrael.main.system.entity.SystemLog;
import cn.azrael.main.system.service.SystemLogService;
import cn.azrael.main.user.entity.User;
/**
 * 切面实体，实现日志的aop管理
 * @author lenovo
 *
 */
@Aspect
public class LogAspect implements Ordered{
	public SystemLogService systemLogService;
	public void setSystemLogService(SystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}
	/**
	 * 操作成功时添加log
	 * @param jp 切入点，可以获取切入点处方法的数据
	 * @param dl 切入点函数的注释
	 * @throws ServiceException 
	 */
	@AfterReturning("within(cn.azrael.main.*.service..*)&&@annotation(dl)")
	public void addLogSuccess(JoinPoint jp,DescripLog dl) throws ServiceException{
		Object[] parames = jp.getArgs();//获取目标方法体参数
		String params = parseParames(parames);
		//获取目标类名
		String className = jp.getTarget().getClass().toString();
		className = className.substring(className.indexOf("cn"));
		//获取方法名
		String signature = jp.getSignature().toString();
		String methodName = signature.substring(signature.lastIndexOf(".")+1,signature.indexOf("("));
		
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute(Constant.USER);
		String userName = user == null?"无登陆":user.getEmployeeId().getName();
		SystemLog systemLog = new SystemLog();
		systemLog.setClassName(className);
		systemLog.setDate(new Date().getTime()/1000.0);
		systemLog.setDesc(dl.desc());
		systemLog.setFlag(1);
		systemLog.setMethodName(methodName);
		systemLog.setParams(params);
		systemLog.setUser(userName);
		systemLogService.addLog(systemLog);
		Log log = LogFactory.getLog(getClass());
		log.info(dl.desc());
	}
	@AfterThrowing(pointcut="within(cn.azrael.main.*.service..*)&&@annotation(dl)",throwing="ex")
	public void addLog(JoinPoint jp,DescripLog dl,Exception ex) throws ServiceException{
		System.out.println("hello-------------");
		Object[] parames = jp.getArgs();//获取目标方法体参数
		String params = parseParames(parames);
		//获取目标类名
		String className = jp.getTarget().getClass().toString();
		className = className.substring(className.indexOf("cn"));
		//获取方法名
		String signature = jp.getSignature().toString();
		String methodName = signature.substring(signature.lastIndexOf(".")+1,signature.indexOf("("));
		
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute(Constant.USER);
		String userName = user.getEmployeeId().getName();
		
		SystemLog systemLog = new SystemLog();
		systemLog.setClassName(className);
		systemLog.setDate(new Date().getTime()/1000.0);
		systemLog.setDesc(dl.desc());
		systemLog.setFlag(0);
		systemLog.setMethodName(methodName);
		systemLog.setParams(params);
		systemLog.setUser(userName);
		systemLog.setError(ex.toString());//记录异常信息
		systemLogService.addLog(systemLog);
		Log log = LogFactory.getLog(getClass());
		log.error(dl.desc()+":"+ex.toString());
	}
	//解析参数函数，返回字符串
	private String parseParames(Object[] parames) {
		String str = "";
		for (Object object : parames) {
			str = str + object.toString();
		}
		if(str.length() > 1){
			str = str.substring(0, str.length()-1);
		}
		return str;
	}
	@Override
	public int getOrder() {
		return 1;
	}
}
