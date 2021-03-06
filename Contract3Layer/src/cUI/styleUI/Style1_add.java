package cUI.styleUI;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Style1_add extends JDialog{
	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14;
	JTextField textField1,textField2,textField3,textField4,textField5,textField6,textField7,textField8,textField9;
	JTextField textField10,textField11,textField12,textField13;
	JButton button1;
	JButton button2;
	JPanel panel1,panel2,panel3,panel4;
	//modify   file upload
	JButton button3;
	JLabel label2_1;
	
	public Style1_add(Frame fck,String ckm,Boolean msck){
		super(fck,ckm,msck);
		label1=new JLabel("              合同ID        ");
		label2=new JLabel("              合同编号 ");
		label3=new JLabel("              合同名称 ");
		label4=new JLabel("              合同分类 ");
		label5=new JLabel("              合同甲方 ");
		label6=new JLabel("              合同乙方 ");
		label7=new JLabel("              合同金额 ");
		label8=new JLabel("              开始时间 ");
		label9=new JLabel("              结束时间 ");
		label10=new JLabel("              收付款 ");
		label11=new JLabel("              合同操作员");
		label12=new JLabel("              合同简介");
		label13=new JLabel("              合同上传 ");
		label14=new JLabel("              合同上传 ");

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

		button1=new JButton("按钮一");
		button2=new JButton("取消");
		//getButton1().setText("增加");
		//button1.setText("增加");

		//upload
		button3=new JButton("选择你要上传的文件");
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
		panel2.add(getButton3());

		panel3.add(getButton1());
		panel3.add(getButton2());

		this.add(panel1,BorderLayout.WEST);
		this.add(panel2);
		this.add(panel3,BorderLayout.SOUTH);
		this.add(panel4,BorderLayout.EAST);

		this.setSize(370,270);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/4,height/4);
		this.setResizable(false);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}

	public JButton getButton1() {
		return button1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

	public JButton getButton3() {
		return button3;
	}

	public void setButton3(JButton button3) {
		this.button3 = button3;
	}
}
