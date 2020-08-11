package test;

import java.util.Scanner;

import bean.employee;
import dao.UsersDao;

public class TestAdd {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.println("插入数据。。。");
		employee employee=new employee();
		System.out.println("请输入姓名：");
	    employee.setName(in.next());
		System.out.println("请输入年龄：");
		employee.setAge(in.next());
		System.out.println("请输入地址：");
		employee.setAddress(in.next());
		System.out.println("请输入密码：");
		employee.setPasswd(in.next());
		
		UsersDao ud=new UsersDao();
		if(ud.register(employee)){
			System.out.println("添加角色成功");
			//返回list集合，循环ud.findAll()返回list集合
			System.out.println("角色列表:");
			for(employee e:ud.findAll()) {
			System.out.println(e.toString());
			}
		}else
		{
			System.out.println("添加失败");
		}
		
	}

}
