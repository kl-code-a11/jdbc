package test;

import bean.employee;
import dao.UsersDao;

public class Testlogin {
	public static void main(String[] args) {

		UsersDao  ud=new UsersDao();
		employee employee=ud.login("������","123");
		if(employee==null) {
			System.out.println("�û���¼ʧ��");
		}
		else {
		System.out.println(employee.toString());
		}
		
		
	}

}
