package cDatabase;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class LayerDatabase {

	private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://127.0.0.1:1433;databaseName=ContractM_conplex";
	private static final String NAME="sa";
	private static final String PASSWORD="1314";

//	public static void main(String[] args) throws Exception {
//		TestUI testUI=new TestUI();
//	}
	
	//���Refresh()���������Բ�Ӧ����д������ģ�Ӧ����д��ģ���еĲŶ�
	//����Ϊ�˲��ԣ����ǻ���û�б�Ҫ��
	
	
	public JTable QueryDatabase(String sql,String []paras) throws Exception{
		JTable table=new JTable();
		try {
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(URL,NAME,PASSWORD);
			PreparedStatement ppsm=conn.prepareStatement(sql);
			for(int i=0;i<paras.length;i++)
			{
				ppsm.setString(i+1, paras[i]);
			}
			ResultSet rs=ppsm.executeQuery();
			//����õ���ResultSet2Table�ˣ���ResultSetת��Ϊtable
			ResultSet2Table resultSet2Table=new ResultSet2Table();
			table=resultSet2Table.CompleteRs2T(rs);

			if(rs!=null) rs.close();
			if(ppsm!=null) ppsm.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return table;
	}

	//�����ڸ�������Ĳ�Ӧ�ðѲ�ѯ���ϣ�����Ϊ������ķ��㣬�ҿ��Ծ������ȼ���
	//���ˣ����ǲ��Ӱ�
	public void UpdateDatabase(String sql,String []paras) throws ClassNotFoundException{
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(URL,NAME,PASSWORD);
			PreparedStatement ppsm=conn.prepareStatement(sql);
			for(int i=0;i<paras.length;i++)
			{
				ppsm.setString(i+1, paras[i]);
			}
			ppsm.executeUpdate();
			if(ppsm!=null) ppsm.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

class TestUI extends JFrame{
	
	public TestUI() throws Exception{
		String sql="select * from Contract";
		String paras[]={};
		LayerDatabase layerDatabase=new LayerDatabase();
		
		JTable table=new JTable();
		table=layerDatabase.QueryDatabase(sql, paras);
		JScrollPane scrollPane=new JScrollPane(table);
		this.add(scrollPane);
		
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}