package cn.azrael.main.core.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	//系统用户在session中的标识
	public static String USER = "SYS_USER";
	/*----------------------系统权限集合--------------------------*/
	public static String PRIVILEGE_YHGL = "yhgl";
	public static String PRIVILEGE_BCGL = "bcgl";
	public static String PRIVILEGE_CGGL = "cggl";
	public static String PRIVILEGE_CYGL = "cygl";
	public static String PRIVILEGE_SSWH = "sswh";
	
	public static Map<String,String> PRIVILEGE_MAP = new HashMap<String,String>();
	static{
		PRIVILEGE_MAP.put(PRIVILEGE_YHGL, "用户管理");
		PRIVILEGE_MAP.put(PRIVILEGE_BCGL, "布草管理");
		PRIVILEGE_MAP.put(PRIVILEGE_CGGL, "采购管理");
		PRIVILEGE_MAP.put(PRIVILEGE_CYGL, "餐饮管理");
		PRIVILEGE_MAP.put(PRIVILEGE_SSWH, "设施维护");
	}
}
