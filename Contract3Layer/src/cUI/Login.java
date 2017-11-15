package cUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cModel.Model;
import userDefined.MyFont;

public class Login extends JDialog implements ActionListener{
	JLabel label1,label2,label3;
	JTextField textField1;
	JPasswordField passwordField1;
	JButton blog,bcancer;
	Font font1;

	//	public static void main(String[] args) {
	//		Login login=new Login();
	//	}

	public Login(){
		label1=new JLabel("请输入用户名：");
		label1.setBounds(60, 190, 150, 30);
		label1.setFont(MyFont.f1);
		this.add(label1);

		label2=new JLabel("(或员工号)");
		label2.setForeground(Color.red);
		label2.setFont(MyFont.f2);
		label2.setBounds(100,210,100,30);
		this.add(label2);

		label3=new JLabel ("请输入密码：");
		label3.setBounds(60,240,150,30);
		label3.setFont(MyFont.f2);
		this.add(label3);

		textField1=new JTextField(20);
		textField1.setFocusable(true);
		textField1.setBounds(180,190,120,30);
		textField1.setFont(MyFont.f1);
		//默认账号
		textField1.setText("fanfan");
		this.add(textField1);
		textField1.setBorder(BorderFactory.createLoweredBevelBorder());

		passwordField1=new JPasswordField();
		passwordField1.setFocusable(true);
		passwordField1.setBounds(180,240,120,30);
		//默认密码
		passwordField1.setText("123456");
		this.add(passwordField1);
		passwordField1.setBorder(BorderFactory.createLoweredBevelBorder());

		blog=new JButton("确 定");
		blog.addActionListener(this);
		blog.setActionCommand("login");
		blog.setBounds(105,300,75,30);
		blog.setFont(font1);
		blog.setForeground(Color.blue);
		this.add(blog);

		bcancer=new JButton("取 消");
		bcancer.addActionListener(this);
		bcancer.setActionCommand("cancer");
		bcancer.setBounds(215,300,75,30);
		bcancer.setFont(font1);
		bcancer.setForeground(Color.blue);
		this.add(bcancer);

		this.setLayout(null);
		BackImage backImage=new BackImage();
		backImage.setBounds(0,0,360,360);
		this.add(backImage);
		this.setUndecorated(true);
		this.setSize(360, 360);
		int width=getToolkit().getDefaultToolkit().getScreenSize().width;
		int height=getToolkit().getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200,height/2-200);
		this.setVisible(true);


	}


	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("cancer")){
			System.out.println("取消");
			this.dispose();
		}
		else if(e.getActionCommand().equals("login")){
			System.out.println("登录");
			String userName=this.textField1.getText().trim();
			String password=new String(this.passwordField1.getPassword());
			//System.out.println(userName);
			//System.out.println(password);
			Model model=new Model();
			String state="1";
			try {
				state = model.checkUser(userName, password);
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			}
			if(state.equals("馆长")||state.equals("管理员")||state.equals("主任"))
			{
				try {
					new OperateUI();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(this,"用户名或密码错误");
			}
			this.dispose();
			
			//System.out.println(state);
			
			
		}
	}

}


class BackImage extends JPanel{
	Image image;
	public BackImage(){
		try
		{
			image=ImageIO.read(new File("image/login.gif"));
		}
		catch(Exception e){}
	}

	public void paint(Graphics g)
	{
		g.drawImage(image,0,0,360,360,this);
	}
}


