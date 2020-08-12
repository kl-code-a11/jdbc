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
		
		//?��ʾһ��ռλ������Ԥ����sql���ͨ��pst����Ϊ��Ӧ��ռλ����ֵ
		String sql="insert into employee values(null,?,?,?)";
		//��ֹsqlע�룬�Ƚ�sql���룬�����е���д��ֵ��ʹ��һ���ķ��ű�ʾ
		     pst=conn.prepareStatement(sql);
		     //ռλ����λ�ô�1��ʼ
		     pst.setString(1, "�Ÿ�");
		     pst.setString(2, "100");
		     pst.setString(3, "�㶫ʡ������");
		   int row=pst.executeUpdate();
		   System.out.println("���"+row+"�����ݳɹ�");
		
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally {
					try {	
						
						if(pst!=null)
					        pst.close();
						if(conn!=null)
					        conn.close();
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
			}
		
	    }
	}