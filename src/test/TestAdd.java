package test;

import java.util.Scanner;

import bean.employee;
import dao.UsersDao;

public class TestAdd {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.println("�������ݡ�����");
		employee employee=new employee();
		System.out.println("������������");
	    employee.setName(in.next());
		System.out.println("���������䣺");
		employee.setAge(in.next());
		System.out.println("�������ַ��");
		employee.setAddress(in.next());
		System.out.println("���������룺");
		employee.setPasswd(in.next());
		
		UsersDao ud=new UsersDao();
		if(ud.register(employee)){
			System.out.println("��ӽ�ɫ�ɹ�");
			//����list���ϣ�ѭ��ud.findAll()����list����
			System.out.println("��ɫ�б�:");
			for(employee e:ud.findAll()) {
			System.out.println(e.toString());
			}
		}else
		{
			System.out.println("���ʧ��");
		}
		
	}

}
