package test;

import java.sql.*;

import bean.employee;

public class StatementLogin {

	public static void main(String[] args) {
		
		Connection conn=null;
	     Statement stm=null;
	     ResultSet rs=null;
		try {
				Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false";
	    conn=DriverManager.getConnection(url,"root","root");
		String password="123 or 1=1";
		String sql="select * from employee where name='狄仁杰' and password="+password;

		    stm=conn.createStatement();
		  rs=stm.executeQuery(sql);

		  while(rs.next()) {
			
			  employee  employee=new employee();
				 employee.setId(rs.getInt(1));
				 employee.setName(rs.getString(2));
				 employee.setPasswd(rs.getString(3));
				 employee.setAge(rs.getString(4));
				 employee.setAddress(rs.getString(5));
				 System.out.println(employee.toString());

			}
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}finally {
						try {	
							if(rs!=null)
							   rs.close();
							if(stm!=null)
						        stm.close();
							if(conn!=null)
						        conn.close();
						} catch (SQLException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
				}
			
		    
		
	    }
	}