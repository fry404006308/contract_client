package cUI.Query;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import cModel.Model;
import cModel.RefreshTable;
import cUI.OperateUI;
import userDefined.MyFont;
import cUI.*;

public class Qurey_simple_COne extends JDialog implements ActionListener{
	JLabel label1,label2;
	JTextField textField1,textField2;
	JButton button1,button2;
	JPanel panel1,panel2,panel3,panel4;
	JTable table;
	public Qurey_simple_COne(Frame fck,String ckm,Boolean msck){
		super(fck,ckm,msck);
		
		label1=new JLabel("请设置要查询的合同甲方：");
		label1.setFont(MyFont.f0);
		label2=new JLabel("合同甲方：");
		label1.setFont(MyFont.f3);
		
		textField1=new JTextField(15);
		
		button1=new JButton("确定");
		button1.addActionListener(this);
		button1.setActionCommand("set1");
		button2=new JButton("取消");
		button2.addActionListener(this);
		button2.setActionCommand("cancel1");
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();

		panel1.setLayout(new GridLayout(1,1));
		panel2.setLayout(new GridLayout(1,1));
		panel1.add(label2);
		panel2.add(textField1);
		panel4.add(panel1);
		panel4.add(panel2);
		
		panel3.add(button1);
		panel3.add(button2);
		
		//this.add(panel1,BorderLayout.WEST);
		this.add(label1,BorderLayout.NORTH);
		this.add(panel4);
		this.add(panel3,BorderLayout.SOUTH);
		//this.add(panel4,BorderLayout.EAST);
		
		this.setSize(470,130);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/4,height/4);
		this.setResizable(false);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
	
	
	public JTable deadlineAlarm(){
		table=new JTable();
		String sql="select * from Contract where COne=?";
		String day=textField1.getText();
		String paras[]={day};
		Model model=new Model();
		table=model.qurey(sql, paras);
		System.out.println("table.getRowCount():"+table.getRowCount());
		return table;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("set1")){
			System.out.println("确定");
			this.deadlineAlarm();
			
				try {
					RefreshTable refreshTable=new RefreshTable(table);
					//原来可以这么弄，想了好久
					//静态对象的使用
					OperateUI operateUI = null;
					operateUI.table.setModel(refreshTable);
					
					
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
			
			
			this.dispose();
		}
		else if(e.getActionCommand().equals("cancel1")){
			System.out.println("取消");
			this.dispose();
		}
		
	}
	
}