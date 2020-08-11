package test;

import bean.employee;
import dao.UsersDao;

public class Testlogin {
	public static void main(String[] args) {

		UsersDao  ud=new UsersDao();
		employee employee=ud.login("武则天","123");
		if(employee==null) {
			System.out.println("用户登录失败");
		}
		else {
		System.out.println(employee.toString());
		}
		
		
	}

}
