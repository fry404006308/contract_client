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
	//��sql�ĸ��ַ���
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
	
	
	
	//ˢ�±�
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
	
	//��״̬�õ�ʱ��Ч�ʺø߰�
	public JTable delete(String[] paras,int line){
		JTable table=new JTable();
		//�����ԭ������Ϊ��ɾ��ɾ�ˣ����ﻹ�ڵ��ñ�ɾ����һ�е�id����һ��ɾ��ɾ����ͬ
		//������������һ��ɾ���ļ�����֮�󣬾ͳ�����������⣬����Ҳ�������ļ�Ҳû��ɾ�ɹ�
		//��ʵ���Ժ����׵��뵽�����ԭ���
		String id=this.getID(line);
		String sql="delete from Contract where CID=?";
		LayerDatabase layerDatabase=new LayerDatabase();
		try {
			layerDatabase.UpdateDatabase(sql, paras);
			table=this.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(this,"ɾ���ɹ�");
		
		//��Ҫɾ���ļ���Դ·��
		//��Ϊ���ӵ�ʱ����û��ˢ�����������Ǹ���������������vector���������������ǰ�ģ�
		//����ɾ����ʱ��϶���Խ����ʣ��������ݿ�����ȴ���Գɹ���������Ϣ��ɾ��
		String srcFile="contract/"+id+".pdf";
		File file=new File(srcFile);
		System.out.println("file.exists():"+file.exists());
		if(file.exists()){
			file.delete();
		}
		return table;
	}
	//�޸�
	public JTable modify(String[] paras,int line){
		JTable table=new JTable();
		//ע��ע�⣬������������ʱ��ǵ�Ųλ��
		String sql="update Contract set CNumber=?,CName=?,CClassify=?,COne=?,CTwo=?,CMoney=?,CBeginTime=?,CDeadline=?,CPay=?,CUpload=?,COperator=?,CBrief=? where CID=?";
		LayerDatabase layerDatabase=new LayerDatabase();
		try {
			layerDatabase.UpdateDatabase(sql, paras);
			table=this.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(this,"�޸ĳɹ�");
		RefreshTable refreshTable=new RefreshTable();
		table.setModel(refreshTable);
		return table;
	}
	//�ϴ�
	public JTable upload(String id){
		JTable table=new JTable();
		System.out.println("�ϴ�");
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("�ļ��ϴ�");
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
				out.flush();//��ü���
			}
			System.out.println("�ϴ��ɹ�����");
			in.close();
			out.close();
			//�����ݿ������
			//sql���϶�������ߴ�����Ϊ�������������
			//ֱ�������ݿ���������ݣ������ˢ�����ݾͿ�����
			JOptionPane.showMessageDialog(this,"�ϴ��ɹ�");
			table=this.refresh();

		}
		catch (Exception ex3){
			ex3.printStackTrace();
		}
		return table;
	}
	
	//�ϴ�֮��Ҫ�����ݿ��������û�ϴ��޸�Ϊ�ϴ�
	//һ��Ҫ��д��ע�����ով������ˣ���д��ע�ر��Լʱ��
	public JTable ModifyAfterUpload(String[] paras){
		JTable table=new JTable();
		//ע��ע�⣬������������ʱ��ǵ�Ųλ��
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
		System.out.println("����");

		JTable table=new JTable();

		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("ѡ��Ҫ��������ļ���λ��");
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
				out.flush();//��ü���
			}
			System.out.println("���سɹ�����");
			in.close();
			out.close();
			JOptionPane.showMessageDialog(this,"���سɹ�");
			//���ز�������Ҫ�����ݿⲻ��Ҫˢ��
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
