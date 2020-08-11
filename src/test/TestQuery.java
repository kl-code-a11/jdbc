package test;

import java.util.List;

import bean.employee;
import dao.UsersDao;

public class TestQuery {
	public static void main(String[] args) {
		UsersDao ud=new UsersDao();
		List<employee> list=ud.findAll();
		for(employee e:list) {
			System.out.println(e.toString());
		}
		
	}

}
