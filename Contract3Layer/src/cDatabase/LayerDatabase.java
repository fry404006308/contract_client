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
	
	//这个Refresh()方法很明显不应该是写在这里的，应该是写在模型中的才对
	//这里为了测试，但是还是没有必要用
	
	
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
			//下面该调用ResultSet2Table了，将ResultSet转化为table
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

	//本来在更新中真的不应该把查询加上，但是为了外面的方便，我可以就这样先加上
	//算了，还是不加吧
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