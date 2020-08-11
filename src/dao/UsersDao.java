package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.employee;

public class UsersDao {

	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rst=null;
	
	//每一个方法都需要获取conn,提取形成一个独立的方法用于减少代码的操作
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false";
		    conn=DriverManager.getConnection(url,"root","root");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {	
				
				if(pst!=null)
			        pst.close();
				if(conn!=null)
			        conn.close();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {	
				
				if(pst!=null)
			        pst.close();
				if(conn!=null)
			        conn.close();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
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
	
	//?表示一个占位符，当预编译sql语句通过pst对象为对应的占位符赋值
	String sql="insert into employee values(null,?,?,?,?)";
	//防止sql注入，先将sql编译，将所有的填写的值，使用一定的符号表示
	     pst=conn.prepareStatement(sql);
	   pst.setString(1,e.getName());
	   pst.setString(2, e.getAge());
	   pst.setString(3,e.getAddress());
	   pst.setString(4,e.getPasswd());
	//执行sql，返回受影响行数，executeUpdate方法执行的是更新方法，增删改都属于表的更新
	   int row=pst.executeUpdate();
	   
	   if(row>0) {
	   return true;
	   }
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}finally {
				try {	
					
					if(pst!=null)
				        pst.close();
					if(conn!=null)
				        conn.close();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
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
			//执行sql，返回受影响行数，executeUpdate方法执行的是更新方法，增删改都属于表的更新
			   int row=pst.executeUpdate();
			   if(row>0) {
			   return true;
			   }
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}finally {
						try {	
							
							if(pst!=null)
						        pst.close();
							if(conn!=null)
						        conn.close();
						} catch (SQLException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
				
		}
		return true;
		
	}
	
	}

