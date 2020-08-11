package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;;

public class AddStudentsJDBC {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pst=null;
		try {
				Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false";
	    conn=DriverManager.getConnection(url,"root","root");
		
		//?表示一个占位符，当预编译sql语句通过pst对象为对应的占位符赋值
		String sql="insert into employee values(null,?,?,?)";
		//防止sql注入，先将sql编译，将所有的填写的值，使用一定的符号表示
		     pst=conn.prepareStatement(sql);
		     //占位符的位置从1开始
		     pst.setString(1, "杜甫");
		     pst.setString(2, "100");
		     pst.setString(3, "广东省广州市");
		   int row=pst.executeUpdate();
		   System.out.println("添加"+row+"行数据成功");
		
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
					try {	
						
						if(pst!=null)
					        pst.close();
						if(conn!=null)
					        conn.close();
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
			}
		
	    }
	}