package jdbc;

import java.sql.*;

public class JDBC {
public static void main(String[] args) {
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	try {
	//1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
	//2、管理驱动并获取connection
			/*jdbc:<子协议>://数据库地址:端口号/具体数据库
			 * 协议：JDBC URL中的协议总是jdbc
			 * 子协议：子协议用于标识一个数据库的驱动程序
			 *数据库地址：本地使用localhost或者是127.0.0.1
			 *端口号:mysql数据库默认3306 
			
		*/
	String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false";
       conn=DriverManager.getConnection(url,"root","root");
	System.out.println(conn);
	
	//3、通过Connection创建PreparedStatement对象
	String sql="select * from student";
	     pst=conn.prepareStatement(sql);
	//4、执行sql并返回结果集ResultSet
	//查询调用executQuery方法，返回一个结果集
	    rs=pst.executeQuery();
	//rs.next()用于判断结果集中是否有下一行数据，有则返回true
	while(rs.next()) {
		//从结果集中获取数据，获取的方法是通过对应的类型获取，获取时可以通过列的编号获取
		int id=rs.getInt(1);
		//通过列的名称获取，列的名称是逻辑表的名称
		String name=rs.getString(2);
		String sex=rs.getString(4);
		String address=rs.getString(5);
		
		int age=rs.getInt("age");
		int math=rs.getInt(6);
		int english=rs.getInt(7);
		
          System.out.println("用户id:"+id+",姓名:"+name+",年龄:"+age+",性别:"+sex+",地址:"
        		  +address+",数学成绩:"+math+",英语成绩:"+english);
	}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
				try {	
					if(rs!=null)
					   rs.close();
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
