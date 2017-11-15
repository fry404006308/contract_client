package cUI;
import userDefined.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;

import cModel.Model;
import cModel.RefreshTable;
import cUI.Query.*;
import cUI.left.*;


public class OperateUI extends JFrame implements ActionListener,MouseListener{
	Image titleIcon,timeImage;
	//菜单
	JMenuBar menuBar;
	JMenu menu1,menu2,menu3,menu4,menu5,menu6;
	JMenuItem menuItem1,menuItem2,menuItem3,menuItem4,menuItem5,menuItem6,menuItem7,menuItem8,menuItem9;
	JMenuItem menuItem1_1,menuItem1_2,menuItem1_3,menuItem1_4,menuItem1_5,menuItem1_6,menuItem1_7,menuItem1_8,menuItem1_9;
	JMenuItem menuItem2_1,menuItem2_2,menuItem2_3,menuItem2_4,menuItem2_5,menuItem2_6,menuItem2_7,menuItem2_8,menuItem2_9;
	JMenuItem menuItem3_1,menuItem3_2,menuItem3_3,menuItem3_4,menuItem3_5,menuItem3_6,menuItem3_7,menuItem3_8,menuItem3_9;
	JMenuItem menuItem4_1,menuItem4_2,menuItem4_3,menuItem4_4,menuItem4_5,menuItem4_6,menuItem4_7,menuItem4_8,menuItem4_9;
	JMenuItem menuItem4_1_1,menuItem4_1_2,menuItem4_1_3,menuItem4_1_4,menuItem4_1_5,menuItem4_1_6,menuItem4_1_7,menuItem4_1_8;
	JMenuItem menuItem4_1_9,menuItem4_1_10,menuItem4_1_11,menuItem4_1_12,menuItem4_1_13,menuItem4_1_14,menuItem4_1_15,menuItem4_1_16;
	JMenuItem menuItem4_1_17,menuItem4_1_18,menuItem4_1_19;
	JMenu menu4_1,menu4_2,menu4_3,menu4_4,menu4_5,menu4_6;
	JMenuItem menuItem5_1,menuItem5_2,menuItem5_3,menuItem5_4,menuItem5_5,menuItem5_6,menuItem5_7,menuItem5_8,menuItem5_9;
	JMenuItem menuItem5_10,menuItem5_11,menuItem5_12,menuItem5_13,menuItem5_14,menuItem5_15;
	JMenuItem menuItem6_1,menuItem6_2,menuItem6_3,menuItem6_4,menuItem6_5,menuItem6_6,menuItem6_7,menuItem6_8,menuItem6_9;
	JMenuItem menuItem7_1,menuItem7_2,menuItem7_3,menuItem7_4,menuItem7_5,menuItem7_6,menuItem7_7,menuItem7_8,menuItem7_9;
	ImageIcon imageIcon1,imageIcon2,imageIcon3,imageIcon4,imageIcon5;
	//工具
	JToolBar toolBar;
	JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;
	
	//主要部分
	JPanel panel1,panel2,panel3,panel4,panel5;
	JPanel panel3_1,panel3_2,panel3_3,panel3_4,panel3_5,panel3_6,panel3_7;
	Image image1,image2;
	ImagePanel imagePanel,imagePanel2;
	JLabel label1_1,label1_2,label1_3,label1_4,label1_5,label1_6,label1_7,label1_8;
	JLabel label2_1,label2_2;
	//add
	JLabel label1_9;
	JLabel label_add;
	JPanel panel_add;
	public static JTable table;


	JScrollPane scrollPane;

	Image image3;
	JLabel label3_1,label3_2,label3_3,label3_4,label3_5,label3_6,label3_7;
	CardLayout cardLayout2,cardLayout3;
	JSplitPane splitPane;
	JLabel timeNow;
	javax.swing.Timer time;
	 
	public static void main(String[] args) throws Exception{
		OperateUI operateUI=new OperateUI();
	}
	
	public void initMenu()
	{
		imageIcon1=new ImageIcon("image/jm1_icon1.jpg");
		imageIcon2=new ImageIcon("image/jm1_icon2.jpg");
		imageIcon3=new ImageIcon("image/jm1_icon3.jpg");
		imageIcon4=new ImageIcon("image/jm1_icon4.jpg");
		imageIcon5=new ImageIcon("image/jm1_icon5.jpg");
		menu1=new JMenu("系统管理");
		menu1.setFont(MyFont.f1);
		menuItem1=new JMenuItem("切换用户",imageIcon1);
		menuItem1.setFont(MyFont.f2);
		menuItem2=new JMenuItem("修改登录密码",imageIcon2);
		menuItem2.setFont(MyFont.f2);
		menuItem3=new JMenuItem("登陆管理",imageIcon3);
		menuItem3.setFont(MyFont.f2);
		menuItem4=new JMenuItem("数据库备份",imageIcon4);
		menuItem4.setFont(MyFont.f2);
		menuItem5=new JMenuItem("退出系统",imageIcon5);
		menuItem5.setFont(MyFont.f2);
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		menu1.add(menuItem4);
		menu1.add(menuItem5);
		menu2=new JMenu("基础资料");
		menu2.setFont(MyFont.f1);
		menuItem2_1=new JMenuItem("往来单位资料",imageIcon1);
		menuItem2_1.setFont(MyFont.f2);
		menu2.add(menuItem2_1);
		menu3=new JMenu("合同操作");
		menu3.setFont(MyFont.f1);
		menuItem3_1=new JMenuItem("新增合同",imageIcon1);
		menuItem3_1.setFont(MyFont.f2);
		menuItem3_2=new JMenuItem("修改合同",imageIcon2);
		menuItem3_2.setFont(MyFont.f2);
		menuItem3_3=new JMenuItem("删除合同",imageIcon3);
		menuItem3_3.setFont(MyFont.f2);
		menu3.add(menuItem3_1);
		menu3.add(menuItem3_2);
		menu3.add(menuItem3_3);
		menu4=new JMenu("合同查询");
		menu4.setFont(MyFont.f1);
		menu4_1=new JMenu("简单查询");
		menu4_1.setFont(MyFont.f2);
		menu4_2=new JMenu("组合查询");
		menu4_2.setFont(MyFont.f2);
		menu4.add(menu4_1);
		menu4.add(menu4_2);
		//简单查询下面的条目
		menuItem4_1_1=new JMenuItem("按合同ID查询");
		menuItem4_1_1.setFont(MyFont.f2);
		menuItem4_1_1.addActionListener(this);
		menuItem4_1_1.setActionCommand("qurey_simple_CID");

		
		menuItem4_1_2=new JMenuItem("按合同编号查询");
		menuItem4_1_2.setFont(MyFont.f2);
		menuItem4_1_2.addActionListener(this);
		menuItem4_1_2.setActionCommand("qurey_simple_CNumber");
		

		menuItem4_1_3=new JMenuItem("按合同名称查询");
		menuItem4_1_3.setFont(MyFont.f2);
		menuItem4_1_3.addActionListener(this);
		menuItem4_1_3.setActionCommand("qurey_simple_CName");

		menuItem4_1_4=new JMenuItem("按合同分类查询");
		menuItem4_1_4.setFont(MyFont.f2);
		menuItem4_1_4.addActionListener(this);
		menuItem4_1_4.setActionCommand("qurey_simple_CClassify");
		

		menuItem4_1_5=new JMenuItem("按合同甲方查询");
		menuItem4_1_5.setFont(MyFont.f2);
		menuItem4_1_5.addActionListener(this);
		menuItem4_1_5.setActionCommand("qurey_simple_COne");
		

		menuItem4_1_6=new JMenuItem("按合同乙方查询");
		menuItem4_1_6.setFont(MyFont.f2);
		menuItem4_1_6.addActionListener(this);
		menuItem4_1_6.setActionCommand("qurey_simple_CTwo");
		

		menuItem4_1_7=new JMenuItem("按合同金额查询");
		menuItem4_1_7.setFont(MyFont.f2);
		menuItem4_1_7.addActionListener(this);
		menuItem4_1_7.setActionCommand("qurey_simple_CMoney");
		
		menuItem4_1_8=new JMenuItem("按合同开始时间查询");
		menuItem4_1_8.setFont(MyFont.f2);
		menuItem4_1_8.addActionListener(this);
		menuItem4_1_8.setActionCommand("qurey_simple_CBeginTime");
		

		menuItem4_1_9=new JMenuItem("按合同结束时间查询");
		menuItem4_1_9.setFont(MyFont.f2);
		menuItem4_1_9.addActionListener(this);
		menuItem4_1_9.setActionCommand("qurey_simple_CDeadline");
		
		menuItem4_1_10=new JMenuItem("按合同收付款情况查询");
		menuItem4_1_10.setFont(MyFont.f2);
		menuItem4_1_10.addActionListener(this);
		menuItem4_1_10.setActionCommand("qurey_simple_CPay");
		

		menuItem4_1_11=new JMenuItem("按合同上传情况查询");
		menuItem4_1_11.setFont(MyFont.f2);
		menuItem4_1_11.addActionListener(this);
		menuItem4_1_11.setActionCommand("qurey_simple_CUpload");
		

		menuItem4_1_12=new JMenuItem("按合同操作员查询");
		menuItem4_1_12.setFont(MyFont.f2);
		menuItem4_1_12.addActionListener(this);
		menuItem4_1_12.setActionCommand("qurey_simple_COperator");
		menu4_1.add(menuItem4_1_1);
		menu4_1.add(menuItem4_1_2);
		menu4_1.add(menuItem4_1_3);
		menu4_1.add(menuItem4_1_4);
		menu4_1.add(menuItem4_1_5);
		menu4_1.add(menuItem4_1_6);
		menu4_1.add(menuItem4_1_7);
		menu4_1.add(menuItem4_1_8);
		menu4_1.add(menuItem4_1_9);
		menu4_1.add(menuItem4_1_10);
		menu4_1.add(menuItem4_1_11);
		menu4_1.add(menuItem4_1_12);
		
		
		
		
		
		menu5=new JMenu("合同汇总");
		menu5.setFont(MyFont.f1);
		
		
		menuItem5_2=new JMenuItem("按合同ID汇总",imageIcon2);
		menuItem5_2.setFont(MyFont.f2);
		menuItem5_2.addActionListener(this);
		menuItem5_2.setActionCommand("collect_CID");
		menuItem5_3=new JMenuItem("按合同编号汇总",imageIcon3);
		
		menuItem5_3.setFont(MyFont.f2);
		menuItem5_3.addActionListener(this);
		menuItem5_3.setActionCommand("collect_CNumber");
		menuItem5_4=new JMenuItem("按合同姓名汇总",imageIcon4);
		
		menuItem5_4.setFont(MyFont.f2);
		menuItem5_4.addActionListener(this);
		menuItem5_4.setActionCommand("collect_CName");
		menuItem5_5=new JMenuItem("按合同分类汇总",imageIcon5);
		menuItem5_5.setFont(MyFont.f2);
		menuItem5_5.addActionListener(this);
		menuItem5_5.setActionCommand("collect_CClassify");
		menuItem5_6=new JMenuItem("按合同甲方汇总",imageIcon1);
		menuItem5_6.setFont(MyFont.f2);
		menuItem5_6.addActionListener(this);
		menuItem5_6.setActionCommand("collect_COne");
		menuItem5_7=new JMenuItem("按合同乙方汇总",imageIcon2);
		menuItem5_7.setFont(MyFont.f2);
		menuItem5_7.addActionListener(this);
		menuItem5_7.setActionCommand("collect_CTwo");
		menuItem5_8=new JMenuItem("按合同金额汇总",imageIcon3);
		menuItem5_8.setFont(MyFont.f2);
		menuItem5_8.addActionListener(this);
		menuItem5_8.setActionCommand("collect_CMoney");
		menuItem5_9=new JMenuItem("按合同开始时间汇总",imageIcon4);
		menuItem5_9.setFont(MyFont.f2);
		menuItem5_9.addActionListener(this);
		menuItem5_9.setActionCommand("collect_CBeginTime");
		menuItem5_10=new JMenuItem("按合同结束时间汇总",imageIcon5);
		menuItem5_10.setFont(MyFont.f2);
		menuItem5_10.addActionListener(this);
		menuItem5_10.setActionCommand("collect_CDeadline");
		menuItem5_11=new JMenuItem("按合同收付款情况汇总",imageIcon5);
		menuItem5_11.setFont(MyFont.f2);
		menuItem5_11.addActionListener(this);
		menuItem5_11.setActionCommand("collect_CPay");
		menuItem5_12=new JMenuItem("按合同上传情况汇总",imageIcon5);
		menuItem5_12.setFont(MyFont.f2);
		menuItem5_12.addActionListener(this);
		menuItem5_12.setActionCommand("collect_CUpload");
		menuItem5_13=new JMenuItem("按合同操作员汇总",imageIcon5);
		menuItem5_13.setFont(MyFont.f2);
		menuItem5_13.addActionListener(this);
		menuItem5_13.setActionCommand("collect_COperator");
		
		
		menu5.add(menuItem5_2);
		menu5.add(menuItem5_3);
		menu5.add(menuItem5_4);
		menu5.add(menuItem5_5);
		menu5.add(menuItem5_6);
		menu5.add(menuItem5_7);
		menu5.add(menuItem5_8);
		menu5.add(menuItem5_9);
		menu5.add(menuItem5_10);
		menu5.add(menuItem5_11);
		menu5.add(menuItem5_12);

		menu6=new JMenu("帮助");
		menu6.setFont(MyFont.f1);

		menuItem6_1=new JMenuItem("帮助",imageIcon1);
		menuItem6_1.setFont(MyFont.f2);
		menuItem6_2=new JMenuItem("关于",imageIcon2);
		menuItem6_2.setFont(MyFont.f2);
		menu6.add(menuItem6_1);
		menu6.add(menuItem6_2);
		menuBar=new JMenuBar();
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		menuBar.add(menu5);
		menuBar.add(menu6);
		this.setJMenuBar(menuBar);
	}
	public void initToolBar(){
		toolBar=new JToolBar();
		toolBar.setFloatable(false);
		button1=new JButton(new ImageIcon("image/jb1.jpg"));
		button2=new JButton(new ImageIcon("image/jb2.jpg"));
		button3=new JButton(new ImageIcon("image/jb3.jpg"));
		button4=new JButton(new ImageIcon("image/jb4.jpg"));
		button5=new JButton(new ImageIcon("image/jb5.jpg"));
		button6=new JButton(new ImageIcon("image/jb6.jpg"));
		button7=new JButton(new ImageIcon("image/jb7.jpg"));
		button8=new JButton(new ImageIcon("image/jb8.jpg"));
		button9=new JButton(new ImageIcon("image/jb9.jpg"));
		button10=new JButton(new ImageIcon("image/jb10.jpg"));
		toolBar.add(button1);
		toolBar.add(button2);
		toolBar.add(button3);
		toolBar.add(button4);
		toolBar.add(button5);
		toolBar.add(button6);
		toolBar.add(button7);
		toolBar.add(button8);
		toolBar.add(button9);
		toolBar.add(button10);
		this.add(toolBar,BorderLayout.NORTH);
	}
	
	public void initAllPanel() throws Exception{
		panel1=new JPanel(new BorderLayout());
		try {
			image1=ImageIO.read(new File("image/jp1_bg.jpg"));
			image2=ImageIO.read(new File("image/label_1.gif"));
		} catch (Exception e) {}
		Cursor myCursor=new Cursor(Cursor.HAND_CURSOR);
		imagePanel=new ImagePanel(image1);
		imagePanel2=new ImagePanel(image2);
		this.imagePanel.setLayout(new GridLayout(9,1));
		label1_1=new JLabel();
		imagePanel2.add(label1_1);
		imagePanel.add(imagePanel2);
		
		label1_2=new JLabel("到 期 提 醒",new ImageIcon("image/label_2.jpg"),0);
		label1_2.setFont(MyFont.f4);
		label1_2.setCursor(myCursor);
		label1_2.setEnabled(false);
		label1_2.addMouseListener(this);
		imagePanel.add(label1_2);
		
		label1_3=new JLabel("查 询 合 同",new ImageIcon("image/label_3.jpg"),0);
		label1_3.setFont(MyFont.f4);
		label1_3.setCursor(myCursor);
		label1_3.setEnabled(false);
		label1_3.addMouseListener(this);
		imagePanel.add(label1_3);
		
		label1_4=new JLabel("增 加 合 同",new ImageIcon("image/label_4.jpg"),0);
		label1_4.setFont(MyFont.f4);
		label1_4.setCursor(myCursor);
		label1_4.setEnabled(false);
		label1_4.addMouseListener(this);
		imagePanel.add(label1_4);
		
		label1_5=new JLabel("删 除 合 同",new ImageIcon("image/label_5.jpg"),0);
		label1_5.setFont(MyFont.f4);
		label1_5.setCursor(myCursor);
		label1_5.setEnabled(false);
		label1_5.addMouseListener(this);
		imagePanel.add(label1_5);
		
		label1_6=new JLabel("修 改 合 同",new ImageIcon("image/label_6.jpg"),0);
		label1_6.setFont(MyFont.f4);
		label1_6.setCursor(myCursor);
		label1_6.setEnabled(false);
		label1_6.addMouseListener(this);
		imagePanel.add(label1_6);
		
		label1_7=new JLabel("上 传 合 同",new ImageIcon("image/label_7.jpg"),0);
		label1_7.setFont(MyFont.f4);
		label1_7.setCursor(myCursor);
		label1_7.setEnabled(false);
		label1_7.addMouseListener(this);
		imagePanel.add(label1_7);
		
		label1_8=new JLabel("下 载 合 同",new ImageIcon("image/label_8.jpg"),0);
		label1_8.setFont(MyFont.f4);
		label1_8.setCursor(myCursor);
		label1_8.setEnabled(false);
		label1_8.addMouseListener(this);
		imagePanel.add(label1_8);
		
		label1_9=new JLabel("刷 新 合 同",new ImageIcon("image/label_2.jpg"),0);
		label1_9.setFont(MyFont.f4);
		label1_9.setCursor(myCursor);
		label1_9.setEnabled(false);
		label1_9.addMouseListener(this);
		imagePanel.add(label1_9);
		
		panel1.add(imagePanel);
		
		panel4=new JPanel(new BorderLayout());
		
		this.cardLayout2=new CardLayout();
		panel2=new JPanel(cardLayout2);
		label2_1=new JLabel(new ImageIcon("image/jp2_left.jpg"));
		label2_1.addMouseListener(this);
		label2_2=new JLabel(new ImageIcon("image/jp2_right.jpg"));
		label2_2.addMouseListener(this);
		panel2.add(label2_1,"0");
		panel2.add(label2_2,"1");
		
		this.cardLayout3=new CardLayout();
		panel3=new JPanel(cardLayout3);
		try {
			image3=ImageIO.read(new File("image/jp3_5.jpg"));
		} catch (Exception e1) {}
		panel_add=new JPanel();
		panel_add.setLayout(new BorderLayout());
		label_add=new JLabel("合同信息",JLabel.CENTER);
		label_add.setFont(new Font("宋体",Font.PLAIN,26));
		label_add.setForeground(Color.BLUE);
		Model model=new Model();
		table=new JTable();
		table=model.refresh();
		scrollPane=new JScrollPane(table);
		
		panel_add.add(scrollPane);
		
		panel_add.add(label_add,"North");
		
		
		

		panel3.add(panel_add,"0");
		
		panel4.add(panel2,BorderLayout.WEST);
		panel4.add(panel3,BorderLayout.CENTER);
		splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,panel1,panel4);
		splitPane.setDividerLocation(150);
		splitPane.setDividerSize(0);
		this.add(splitPane,BorderLayout.CENTER);
		
	}
	
	public void initPanel5(){
		panel5=new JPanel();
		panel5.setLayout(new BorderLayout());
		time=new Timer(1000,this);
		time.start();
		timeNow=new JLabel(Calendar.getInstance().getTime().toLocaleString());
		timeNow.setFont(MyFont.f3);
		try {
			timeImage=ImageIO.read(new File("image/time_bg.jpg"));
		} catch (Exception e) {}
		ImagePanel imagePanel=new ImagePanel(timeImage);
		imagePanel.setLayout(new BorderLayout());
		imagePanel.add(timeNow,BorderLayout.EAST);
		panel5.add(imagePanel);
		this.add(panel5,BorderLayout.SOUTH);
	}
	
	public OperateUI() throws Exception{
		try {
			titleIcon=ImageIO.read(new File("image/title.gif"));
		} catch (IOException e) {}
		this.setIconImage(titleIcon);
		this.setTitle("华中师大合同管理系统");
		this.initMenu();
		this.initToolBar();
		this.initAllPanel();
		this.initPanel5();
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width/6*5,(height-32)/6*5);
		this.setLocation(width/12, height/12);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==this.label1_2)
		{
	
			DeadlineUI deadlineUI=new DeadlineUI(this,"设置到期提醒",true);
			
		}
		else if(e.getSource()==this.label1_3)
		{
			System.out.println("查询合同");
			RefreshTable refreshTable=new RefreshTable();
			table.setModel(refreshTable);
		}
		else if(e.getSource()==this.label1_4)
		{
			System.out.println("增加合同");
			AddUI addUI=new AddUI(this,"增加合同信息",true);
			RefreshTable refreshTable=new RefreshTable();
			table.setModel(refreshTable);
			System.out.println(table.getRowCount()+"add里面");
			//控件被改变就会立即显示出来
			//这就说明 上面的控件没有被改变，也就是refresh返回的table和原来的table一模一样
			//label1_4.setText("aa");
			RefreshTable refreshTable3=new RefreshTable();
			table.setModel(refreshTable3);
		}
		else if(e.getSource()==this.label1_5)
		{
			//删除里面也要做一个删除服务器合同的这么一个操作
			//其实这个操作可有可无，那些合同记录留着也未必不是什么坏事
			System.out.println("删除合同");
			//删除操作成功，只是没有刷新
			int line=this.table.getSelectedRow();
			if(line==-1)
			{
				JOptionPane.showMessageDialog(this,"请选中要删除的行");
				return;
			}
			Model model1=new Model();
			String id=model1.getID(line);
			String[] paras={id};
			System.out.println(id);
			model1.delete(paras, line);
			RefreshTable refreshTable=new RefreshTable();
			table.setModel(refreshTable);
			System.out.println(table.getRowCount()+"delete里面");
			
			RefreshTable refreshTable1=new RefreshTable();
			table.setModel(refreshTable1);
		}
		else if(e.getSource()==this.label1_6)
		{
			System.out.println("修改合同");
			int line=this.table.getSelectedRow();
			if(line==-1)
			{
				JOptionPane.showMessageDialog(this,"请选中要修改的行");
				return;
			}
			Model model1=new Model();
			String id=model1.getID(line);
			System.out.println("line："+line);
			ModifyUI modifyUI=new ModifyUI(this,"修改合同信息",true,line,id);
			RefreshTable refreshTable=new RefreshTable();
			table.setModel(refreshTable);
			
			
		}
		else if(e.getSource()==this.label1_7)
		{
			System.out.println("上传合同");
			//上传
			int line=this.table.getSelectedRow();
			if(line==-1)
			{
				JOptionPane.showMessageDialog(this,"请选中要上传合同的行");
				return;
			}
			Model model1=new Model();
			String id=model1.getID(line);
			model1.upload(id);
			//上传后我要把表格显示的内容修改一下
			String cUpload="已上传";
			String[] paras={cUpload,id};
			model1.ModifyAfterUpload(paras);
			//刷新表格
			RefreshTable refreshTable=new RefreshTable();
			table.setModel(refreshTable);
		}
		else if(e.getSource()==this.label1_8)
		{
			//下载
			System.out.println("下载合同");
			int line=this.table.getSelectedRow();
			if(line==-1)
			{
				JOptionPane.showMessageDialog(this,"请选中要下载合同的行");
				return;
			}
			Model model1=new Model();
			String id=model1.getID(line);
			model1.download(id);
			RefreshTable refreshTable=new RefreshTable();
			table.setModel(refreshTable);
			
		}
		else if(e.getSource()==this.label1_9)
		{
			//预览
			System.out.println("刷新合同");
			RefreshTable refreshTable=new RefreshTable();
			table.setModel(refreshTable);
		}
		
		else if(e.getSource()==label2_1)
		{
			this.splitPane.setDividerLocation(0);
			this.cardLayout2.show(panel2,"1");
		}
		else if(e.getSource()==label2_2)
		{
			this.splitPane.setDividerLocation(150);
			this.cardLayout2.show(panel2,"0");
		}
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==this.label1_2)
		{
			this.label1_2.setEnabled(true);
		}
		else if(e.getSource()==this.label1_3)
		{
			this.label1_3.setEnabled(true);
		}
		else if(e.getSource()==this.label1_4)
		{
			this.label1_4.setEnabled(true);
		}
		else if(e.getSource()==this.label1_5)
		{
			this.label1_5.setEnabled(true);
		}
		else if(e.getSource()==this.label1_6)
		{
			this.label1_6.setEnabled(true);
		}
		else if(e.getSource()==this.label1_7)
		{
			this.label1_7.setEnabled(true);
		}
		else if(e.getSource()==this.label1_8)
		{
			this.label1_8.setEnabled(true);
		}
		else if(e.getSource()==this.label1_9)
		{
			this.label1_9.setEnabled(true);
		}
		
	}

	
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==this.label1_2)
		{
			this.label1_2.setEnabled(false);
		}
		else if(e.getSource()==this.label1_3)
		{
			this.label1_3.setEnabled(false);
		}
		else if(e.getSource()==this.label1_4)
		{
			this.label1_4.setEnabled(false);
		}
		else if(e.getSource()==this.label1_5)
		{
			this.label1_5.setEnabled(false);
		}
		else if(e.getSource()==this.label1_6)
		{
			this.label1_6.setEnabled(false);
		}
		else if(e.getSource()==this.label1_7)
		{
			this.label1_7.setEnabled(false);
		}
		else if(e.getSource()==this.label1_8)
		{
			this.label1_8.setEnabled(false);
		}
		else if(e.getSource()==this.label1_9)
		{
			this.label1_9.setEnabled(false);
		}
		
	}


	public void actionPerformed(ActionEvent e) {
		
		this.timeNow.setText("当前系统时间："+Calendar.getInstance().getTime().toLocaleString()+" ");
		
		if(e.getActionCommand().equals("collect_CID"))
    	{
			JTable table2=new JTable();
			System.out.println("按合同ID汇总");
			String sql="select * from Contract order by CID";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		else if(e.getActionCommand().equals("collect_CNumber"))
    	{
			JTable table2=new JTable();
			System.out.println("按合同编号汇总");
			String sql="select * from Contract order by CNumber";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		else if(e.getActionCommand().equals("collect_CName"))
    	{
			JTable table2=new JTable();
			System.out.println("table2.getValueAt(0, 1):"+table.getValueAt(0, 1));
			System.out.println("按合同姓名汇总");
			String sql="select * from Contract order by CName";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable13=new RefreshTable(table2);
			System.out.println("table2.getValueAt(0, 1):"+table2.getValueAt(0, 1));
			table.setModel(refreshTable13);
			
    	}
		else if(e.getActionCommand().equals("collect_CClassify"))
    	{
			JTable table2=new JTable();
			String sql="select * from Contract order by CClassify";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		else if(e.getActionCommand().equals("collect_COne"))
    	{
			JTable table2=new JTable();
			String sql="select * from Contract order by COne";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		else if(e.getActionCommand().equals("collect_CTwo"))
    	{
			JTable table2=new JTable();
			String sql="select * from Contract order by CTwo";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		else if(e.getActionCommand().equals("collect_CMoney"))
    	{
			JTable table2=new JTable();
			String sql="select * from Contract order by CMoney";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		else if(e.getActionCommand().equals("collect_CBeginTime"))
    	{
			JTable table2=new JTable();
			String sql="select * from Contract order by CBeginTime";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		else if(e.getActionCommand().equals("collect_CDeadline"))
    	{
			JTable table2=new JTable();
			String sql="select * from Contract order by CDeadline";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		else if(e.getActionCommand().equals("collect_CPay"))
    	{
			JTable table2=new JTable();
			String sql="select * from Contract order by CPay";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		else if(e.getActionCommand().equals("collect_CUpload"))
    	{
			JTable table2=new JTable();
			String sql="select * from Contract order by CUpload";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		else if(e.getActionCommand().equals("collect_COperator"))
    	{
			JTable table2=new JTable();
			String sql="select * from Contract order by COperator";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		else if(e.getActionCommand().equals("collect_CBrief"))
    	{
			JTable table2=new JTable();
			String sql="select * from Contract order by CBrief";
			String[] paras={};
			Model model=new Model();
			table2=model.qurey(sql, paras);
			RefreshTable refreshTable=new RefreshTable(table2);
			table.setModel(refreshTable);
    	}
		//合同查询块
		else if(e.getActionCommand().equals("qurey_simple_CID"))
    	{
			Qurey_simple_CID qurey_simple_CID=new Qurey_simple_CID(this,"设置要查询的合同ID",true);
    	}
		else if(e.getActionCommand().equals("qurey_simple_CNumber"))
    	{
			Qurey_simple_CNumber qurey_simple_CNumber=new Qurey_simple_CNumber(this,"设置要查询的合同编号",true);
    	}
		else if(e.getActionCommand().equals("qurey_simple_CName"))
    	{
			Qurey_simple_CName qurey_simple_CName=new Qurey_simple_CName(this,"设置要查询的合同名字",true);
    	}
		else if(e.getActionCommand().equals("qurey_simple_CClassify"))
    	{
			Qurey_simple_CClassify qurey_simple_CClassify=new Qurey_simple_CClassify(this,"设置要查询的合同分类",true);
    	}
		else if(e.getActionCommand().equals("qurey_simple_COne"))
    	{
			Qurey_simple_COne qurey_simple_COne=new Qurey_simple_COne(this,"设置要查询的合同甲方",true);
    	}
		else if(e.getActionCommand().equals("qurey_simple_CTwo"))
    	{
			Qurey_simple_CTwo qurey_simple_CTwo=new Qurey_simple_CTwo(this,"设置要查询的合同乙方",true);
    	}
		else if(e.getActionCommand().equals("qurey_simple_CMoney"))
    	{
			Qurey_simple_CMoney qurey_simple_CMoney=new Qurey_simple_CMoney(this,"设置要查询的合同金额",true);
    	}
		else if(e.getActionCommand().equals("qurey_simple_CBeginTime"))
    	{
			Qurey_simple_CBeginTime qurey_simple_CBeginTime=new Qurey_simple_CBeginTime(this,"设置要查询的合同开始时间",true);
    	}
		else if(e.getActionCommand().equals("qurey_simple_CDeadline"))
    	{
			Qurey_simple_CDeadline qurey_simple_CDeadline=new Qurey_simple_CDeadline(this,"设置要查询的合同截止时间",true);
    	}
		else if(e.getActionCommand().equals("qurey_simple_CPay"))
    	{
			Qurey_simple_CPay qurey_simple_CPay=new Qurey_simple_CPay(this,"设置要查询的合同收付款情况",true);
    	}
		else if(e.getActionCommand().equals("qurey_simple_CUpload"))
    	{
			Qurey_simple_CUpload qurey_simple_CUpload=new Qurey_simple_CUpload(this,"设置要查询的合同上传情况",true);
    	}
		else if(e.getActionCommand().equals("qurey_simple_COperator"))
    	{
			Qurey_simple_COperator qurey_simple_COperator=new Qurey_simple_COperator(this,"设置要查询的操作员",true);
    	}
		
	}
}
