package jdbc;

import java.sql.*;

public class JDBC {
public static void main(String[] args) {
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	try {
	//1����������
			Class.forName("com.mysql.jdbc.Driver");
	//2��������������ȡconnection
			/*jdbc:<��Э��>://���ݿ��ַ:�˿ں�/�������ݿ�
			 * Э�飺JDBC URL�е�Э������jdbc
			 * ��Э�飺��Э�����ڱ�ʶһ�����ݿ����������
			 *���ݿ��ַ������ʹ��localhost������127.0.0.1
			 *�˿ں�:mysql���ݿ�Ĭ��3306 
			
		*/
	String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false";
       conn=DriverManager.getConnection(url,"root","root");
	System.out.println(conn);
	
	//3��ͨ��Connection����PreparedStatement����
	String sql="select * from student";
	     pst=conn.prepareStatement(sql);
	//4��ִ��sql�����ؽ����ResultSet
	//��ѯ����executQuery����������һ�������
	    rs=pst.executeQuery();
	//rs.next()�����жϽ�������Ƿ�����һ�����ݣ����򷵻�true
	while(rs.next()) {
		//�ӽ�����л�ȡ���ݣ���ȡ�ķ�����ͨ����Ӧ�����ͻ�ȡ����ȡʱ����ͨ���еı�Ż�ȡ
		int id=rs.getInt(1);
		//ͨ���е����ƻ�ȡ���е��������߼��������
		String name=rs.getString(2);
		String sex=rs.getString(4);
		String address=rs.getString(5);
		
		int age=rs.getInt("age");
		int math=rs.getInt(6);
		int english=rs.getInt(7);
		
          System.out.println("�û�id:"+id+",����:"+name+",����:"+age+",�Ա�:"+sex+",��ַ:"
        		  +address+",��ѧ�ɼ�:"+math+",Ӣ��ɼ�:"+english);
	}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
		}
	
    }
}
