package jdbc;

import java.sql.*;

public class DeleteStudentsJDBC {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pst=null;
		try {
				Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false";
	    conn=DriverManager.getConnection(url,"root","root");
		
		//?��ʾһ��ռλ������Ԥ����sql���ͨ��pst����Ϊ��Ӧ��ռλ����ֵ
		String sql="delete from employee  where id= ?";
		//��ֹsqlע�룬�Ƚ�sql���룬�����е���д��ֵ��ʹ��һ���ķ��ű�ʾ
		     pst=conn.prepareStatement(sql);
		    
		     pst.setString(1, "4");
		//ִ��sql��������Ӱ��������executeUpdate����ִ�е��Ǹ��·�������ɾ�Ķ����ڱ��ĸ���
		   int row=pst.executeUpdate();
		   System.out.println("ɾ��"+row+"�����ݳɹ�");
		
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