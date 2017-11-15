package cUI.left;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import cModel.Model;


public class ModifyUI extends JDialog implements ActionListener{

	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14;
	JTextField textField1,textField2,textField3,textField4,textField5,textField6,textField7,textField8,textField9;
	JTextField textField10,textField11,textField12,textField13;
	JButton button1,button2;
	JPanel panel1,panel2,panel3,panel4;
	//modify   file upload
	JButton button3;
	JLabel label2_1;
	int line;
	String id;

	public ModifyUI(Frame fck,String ckm,Boolean msck,int line,String id){
		super(fck,ckm,msck);
		this.line=line;
		this.id=id;
		System.out.println("id��"+id);
		System.out.println("this.id��"+this.id);
		System.out.println("������line��"+line);
		System.out.println("������this.line��"+this.line);
		label1=new JLabel("              ��ͬID ");
		label2=new JLabel("              ��ͬ��� ");
		label3=new JLabel("              ��ͬ���� ");
		label4=new JLabel("              ��ͬ���� ");
		label5=new JLabel("              ��ͬ�׷� ");
		label6=new JLabel("              ��ͬ�ҷ� ");
		label7=new JLabel("              ��ͬ��� ");
		label8=new JLabel("              ��ʼʱ�� ");
		label9=new JLabel("              ����ʱ�� ");
		label10=new JLabel("              �ո��� ");
		label11=new JLabel("              ��ͬ�ϴ�");
		label12=new JLabel("              ��ͬ����Ա");
		label13=new JLabel("              ��ͬ��� ");
		label14=new JLabel("              ��ͬ�ϴ� ");

		textField1=new JTextField(5);
		textField2=new JTextField(5);
		textField3=new JTextField(5);
		textField4=new JTextField(5);
		textField5=new JTextField(5);
		textField6=new JTextField(5);
		textField7=new JTextField(5);
		textField8=new JTextField(5);
		textField9=new JTextField(5);
		textField10=new JTextField(5);
		textField11=new JTextField(5);
		textField12=new JTextField(5);
		textField13=new JTextField(5);
		
		Model model=new Model();
		JTable table=model.refresh();
		
		textField1=new JTextField(5);
		textField1.setText((String)table.getValueAt(line,0).toString());
		textField1.setEditable(false);
		textField2=new JTextField(5);
		textField2.setText((String)table.getValueAt(line,1).toString());
		textField3=new JTextField(5);
		textField3.setText((String)table.getValueAt(line,2).toString());
		textField4=new JTextField(5);
		textField4.setText((String)table.getValueAt(line,3).toString());
		textField5=new JTextField(5);
		textField5.setText((String)table.getValueAt(line,4).toString());
		textField6=new JTextField(5);
		textField6.setText((String)table.getValueAt(line,5).toString());
		textField7=new JTextField(5);
		textField7.setText((String)table.getValueAt(line,6).toString());
		textField8=new JTextField(5);
		textField8.setText((String)table.getValueAt(line,7).toString());
		textField9=new JTextField(5);
		textField9.setText((String)table.getValueAt(line,8).toString());
		textField10=new JTextField(5);
		textField10.setText((String)table.getValueAt(line,9).toString());
		textField11=new JTextField(5);
		textField11.setText((String)table.getValueAt(line,10).toString());
		textField12=new JTextField(5);
		textField12.setText((String)table.getValueAt(line,11).toString());
		textField13=new JTextField(5);
		textField13.setText((String)table.getValueAt(line,12).toString());
		

		button1=new JButton("�޸�");
		button1.addActionListener(this);
		button1.setActionCommand("modify1");
		button2=new JButton("ȡ��");
		button2.addActionListener(this);
		button2.setActionCommand("cancel1");

		//upload
		button3=new JButton("ѡ����Ҫ�ϴ����ļ�");
		button3.addActionListener(this);
		button3.setActionCommand("upload1");

		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();

		panel1.setLayout(new GridLayout(14,1));
		panel2.setLayout(new GridLayout(14,1));
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(label3);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		panel1.add(label7);
		panel1.add(label8);
		panel1.add(label9);
		panel1.add(label10);
		panel1.add(label11);
		panel1.add(label12);
		panel1.add(label13);
		panel1.add(label14);

		panel2.add(textField1);
		panel2.add(textField2);
		panel2.add(textField3);
		panel2.add(textField4);
		panel2.add(textField5);
		panel2.add(textField6);
		panel2.add(textField7);
		panel2.add(textField8);
		panel2.add(textField9);
		panel2.add(textField10);
		panel2.add(textField11);
		panel2.add(textField12);
		panel2.add(textField13);
		panel2.add(button3);

		panel3.add(button1);
		panel3.add(button2);

		this.add(panel1,BorderLayout.WEST);
		this.add(panel2);
		this.add(panel3,BorderLayout.SOUTH);
		this.add(panel4,BorderLayout.EAST);

		this.setSize(470,370);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/4,height/4);
		this.setResizable(false);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}



	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("modify1")){
			System.out.println("�޸�");
			String paras[]=new String[13];
			paras[0]=textField2.getText();
			paras[1]=textField3.getText();
			paras[2]=textField4.getText();
			paras[3]=textField5.getText();
			paras[4]=textField6.getText();
			paras[5]=textField7.getText();
			paras[6]=textField8.getText();
			paras[7]=textField9.getText();
			paras[8]=textField10.getText();
			paras[9]=textField11.getText();
			paras[10]=textField12.getText();
			paras[11]=textField13.getText();
			paras[12]=textField1.getText();
			//������������� nvarchar ת��Ϊ numeric ʱ����
			if(paras[5].equals(""))
			{
				paras[5]="0";
			}
			Model model=new Model();
			model.modify(paras, line);
		

			this.dispose();
		}
		else if(e.getActionCommand().equals("cancel1")){
			System.out.println("ȡ��");
			this.dispose();
		}
		else if(e.getActionCommand().equals("upload1")){
			System.out.println("�ϴ�");
			Model model=new Model();
			//����һ�ָ��õĻ��id�ķ���
			//����˵��Ĳ�Ҫƣ�͹�����֮ǰ��д��ʲô�����𣿣���������
			//String id=textField1.getText();
			model.upload(id);
			textField11.setText("���ϴ�");

		}
	}

}