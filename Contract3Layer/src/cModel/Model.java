package cModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import cDatabase.*;



public class Model extends JDialog{
	private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://127.0.0.1:1433;databaseName=ContractM_conplex";
	private static final String NAME="sa";
	private static final String PASSWORD="1314";
	public Model(){}
	//带sql的各种方法
	public JTable qurey(String sql,String[] paras){
		JTable table=new JTable();

		LayerDatabase layerDatabase=new LayerDatabase();
		try {
			table=layerDatabase.QueryDatabase(sql, paras);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}

	public String checkUser(String username,String password) throws ClassNotFoundException{
		JTable table=new JTable();
		String state=null;
		String sql="select UState from UserTable U,Login L where U.ULID=L.LID and L.LUsername=? and  L.LPassword=?";
		String paras[]={username,password};

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(URL,NAME,PASSWORD);
			PreparedStatement ppsm=conn.prepareStatement(sql);
			for(int i=0;i<paras.length;i++)
			{
				ppsm.setString(i+1, paras[i]);
			}
			ResultSet rs=ppsm.executeQuery();
			if(rs.next())
			{
				state=rs.getString(1);
			}
			if(rs!=null) rs.close();
			if(ppsm!=null) ppsm.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(state);
		return state;
	}
	
	
	
	//刷新表
	public JTable refresh(){
		JTable table=new JTable();
		String sql="select * from Contract";
		String[] paras={};


		LayerDatabase layerDatabase=new LayerDatabase();
		try {
			table=layerDatabase.QueryDatabase(sql, paras);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}

	public JTable add(String[] paras){
		JTable table=new JTable();
		String sql="insert into Contract values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		LayerDatabase layerDatabase=new LayerDatabase();
		try {
			layerDatabase.UpdateDatabase(sql, paras);
			table=this.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RefreshTable refreshTable=new RefreshTable();
		table.setModel(refreshTable);
		return table;
	}
	
	//我状态好的时候效率好高啊
	public JTable delete(String[] paras,int line){
		JTable table=new JTable();
		//错误的原因是因为我删都删了，这里还在调用被删的那一行的id，来一起删除删除合同
		//很明显增加了一起删除文件功能之后，就出现了这个问题，而且也还导致文件也没有删成功
		//其实可以很容易的想到错误的原因的
		String id=this.getID(line);
		String sql="delete from Contract where CID=?";
		LayerDatabase layerDatabase=new LayerDatabase();
		try {
			layerDatabase.UpdateDatabase(sql, paras);
			table=this.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(this,"删除成功");
		
		//找要删除文件的源路径
		//因为增加的时候我没有刷新这个里面的那个表，所以这个里面的vector里面的行数还是以前的，
		//所以删除的时候肯定是越界访问，但是数据库里面却可以成功把这条信息给删了
		String srcFile="contract/"+id+".pdf";
		File file=new File(srcFile);
		System.out.println("file.exists():"+file.exists());
		if(file.exists()){
			file.delete();
		}
		return table;
	}
	//修改
	public JTable modify(String[] paras,int line){
		JTable table=new JTable();
		//注意注意，传参数过来的时候记得挪位置
		String sql="update Contract set CNumber=?,CName=?,CClassify=?,COne=?,CTwo=?,CMoney=?,CBeginTime=?,CDeadline=?,CPay=?,CUpload=?,COperator=?,CBrief=? where CID=?";
		LayerDatabase layerDatabase=new LayerDatabase();
		try {
			layerDatabase.UpdateDatabase(sql, paras);
			table=this.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(this,"修改成功");
		RefreshTable refreshTable=new RefreshTable();
		table.setModel(refreshTable);
		return table;
	}
	//上传
	public JTable upload(String id){
		JTable table=new JTable();
		System.out.println("上传");
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("文件上传");
		fileChooser.showOpenDialog(null);
		fileChooser.setVisible(true);
		String srcPath=fileChooser.getSelectedFile().getAbsolutePath();
		System.out.println(srcPath);

		String destFile="contract/"+id+".pdf";
		System.out.println(destFile);
		try{
			FileInputStream in=new FileInputStream(srcPath);
			FileOutputStream out=new FileOutputStream(destFile);
			byte[] buf=new byte[8*1024];
			int b;
			while((b=in.read(buf, 0, buf.length))!=-1){
				out.write(buf,0,b);
				out.flush();//最好加上
			}
			System.out.println("上传成功！！");
			in.close();
			out.close();
			//在数据库里更新
			//sql语句肯定是在这边传，因为这边是需求满足
			//直接在数据库里面改数据，在这边刷新数据就可以了
			JOptionPane.showMessageDialog(this,"上传成功");
			table=this.refresh();

		}
		catch (Exception ex3){
			ex3.printStackTrace();
		}
		return table;
	}
	
	//上传之后要把数据库里面的上没上传修改为上传
	//一定要勤写备注，不刚刚就忘记了，勤写备注特别节约时间
	public JTable ModifyAfterUpload(String[] paras){
		JTable table=new JTable();
		//注意注意，传参数过来的时候记得挪位置
		String sql="update Contract set CUpload=? where CID=?";
		LayerDatabase layerDatabase=new LayerDatabase();
		try {
			layerDatabase.UpdateDatabase(sql, paras);
			table=this.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return table;
	}

	public JTable download(String id){
		System.out.println("下载");

		JTable table=new JTable();

		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("选择要存放下载文件的位置");
		fileChooser.showOpenDialog(null);
		fileChooser.setVisible(true);
		String destPath=fileChooser.getSelectedFile().getAbsolutePath();
		System.out.println(destPath);

		String endFileName=".pdf";
		if(!destPath.endsWith(endFileName)){
			destPath+=endFileName;
		}

		String srcFile="contract/"+id+".pdf";

		String destFile=destPath;
		System.out.println(destFile);
		try{
			FileInputStream in=new FileInputStream(srcFile);
			FileOutputStream out=new FileOutputStream(destFile);
			byte[] buf=new byte[8*1024];
			int b;
			while((b=in.read(buf, 0, buf.length))!=-1){
				out.write(buf,0,b);
				out.flush();//最好加上
			}
			System.out.println("下载成功！！");
			in.close();
			out.close();
			JOptionPane.showMessageDialog(this,"下载成功");
			//下载操作不需要连数据库不需要刷新
			table=this.refresh();
		}
		catch (Exception ex3){
			ex3.printStackTrace();
		}
		return table;
	}

	public String getID(int line){

		JTable table=this.refresh();
		String id=table.getValueAt(line, 0).toString();
		return id;
	}
}
