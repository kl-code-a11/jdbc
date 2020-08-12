package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.employee;

public class UsersDao {

	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rst=null;
	
	//ÿһ����������Ҫ��ȡconn,��ȡ�γ�һ�������ķ������ڼ��ٴ���Ĳ���
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false";
		    conn=DriverManager.getConnection(url,"root","root");
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<employee> findAll(){
		List<employee> list=new ArrayList<>();
		String sql="select * from employee";
		try {
			pst=getConnection().prepareStatement(sql);
			 rst=pst.executeQuery(); 
			
			while(rst.next()) {
			 employee employee=new employee();
			 employee.setId(rst.getInt(1));
			 employee.setName(rst.getString(2));
			 employee.setAge(rst.getString(3));
			 employee.setAddress(rst.getString(4));
			 employee.setPasswd(rst.getString(5));
			 list.add(employee);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {	
				
				if(pst!=null)
			        pst.close();
				if(conn!=null)
			        conn.close();
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		return list ;
		
	}
	
	public employee login(String name,String passwd) {
		employee employee=null;
		String sql="select * from employee where name= ? and password= ?";
		try {
			pst=getConnection().prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, passwd);
			 rst=pst.executeQuery();
			while(rst.next()) {
			 employee=new employee();
			 employee.setId(rst.getInt(1));
			 employee.setName(rst.getString(2));
			 employee.setPasswd(rst.getString(3));
			 employee.setAge(rst.getString(4));
			 employee.setAddress(rst.getString(5));
			
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {	
				
				if(pst!=null)
			        pst.close();
				if(conn!=null)
			        conn.close();
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		return employee;
		
	}
	public boolean register(employee e) { 
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
	        String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false";
            conn=DriverManager.getConnection(url,"root","root");
	
	//?��ʾһ��ռλ������Ԥ����sql���ͨ��pst����Ϊ��Ӧ��ռλ����ֵ
	String sql="insert into employee values(null,?,?,?,?)";
	//��ֹsqlע�룬�Ƚ�sql���룬�����е���д��ֵ��ʹ��һ���ķ��ű�ʾ
	     pst=conn.prepareStatement(sql);
	   pst.setString(1,e.getName());
	   pst.setString(2, e.getAge());
	   pst.setString(3,e.getAddress());
	   pst.setString(4,e.getPasswd());
	//ִ��sql��������Ӱ��������executeUpdate����ִ�е��Ǹ��·�������ɾ�Ķ����ڱ�ĸ���
	   int row=pst.executeUpdate();
	   
	   if(row>0) {
	   return true;
	   }
		} catch (Exception e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}finally {
				try {	
					
					if(pst!=null)
				        pst.close();
					if(conn!=null)
				        conn.close();
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
		}
	return false;
    }
	
	
	public boolean updateID(String id,String password) {
		try {
			String sql="update employee set password= ? where id= ?";
			pst=getConnection().prepareStatement(sql);
		
			  pst.setString(1, "password");
			     pst.setString(2, "id");
			//ִ��sql��������Ӱ��������executeUpdate����ִ�е��Ǹ��·�������ɾ�Ķ����ڱ�ĸ���
			   int row=pst.executeUpdate();
			   if(row>0) {
			   return true;
			   }
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}finally {
						try {	
							
							if(pst!=null)
						        pst.close();
							if(conn!=null)
						        conn.close();
						} catch (SQLException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
				
		}
		return true;
		
	}
	
	}

