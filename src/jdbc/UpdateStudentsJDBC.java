package jdbc;

import java.sql.*;

public class UpdateStudentsJDBC {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pst=null;
		try {
				Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false";
	    conn=DriverManager.getConnection(url,"root","root");
		
		//?表示一个占位符，当预编译sql语句通过pst对象为对应的占位符赋值
		String sql="update employee set age= ?,name=? where id= ?";
		//防止sql注入，先将sql编译，将所有的填写的值，使用一定的符号表示
		     pst=conn.prepareStatement(sql);
		     pst.setString(1, "130");
		     pst.setString(2,"杜甫");
		     pst.setInt(3, 4);
		//执行sql，返回受影响行数，executeUpdate方法执行的是更新方法，增删改都属于表的更新
		   int row=pst.executeUpdate();
		   System.out.println("修改"+row+"行数据成功");
		
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