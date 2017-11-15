package cUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
//数据刷新问题，第一遍做的时候是保证每次操作后重新连了一遍数据库，所以能刷新
//第二遍的时候是操作完之后是新建数据库对象，现在我的第三遍是因为加了三层架构，多了中间模型的那一层
//每做一遍数据库后，不为空的数据库连接部分，我都给它清空了
//所以每一次新建一个数据库对象，都是相当于重新连了一遍数据库
//都是把sql语句和指令一起传过去的
//每做增加，删除，修改之后，都做了一遍查询，增删改，你就专心做好你的增删改就行了，需要查询的时候就查询好了
//每查询一次，我就把所以和数据库有关的链接关闭了一次，
//当我再次执行操作的时候就像是重新连了一遍数据库，都重新执行了一遍那些数据库连接的语句
//数据库连接也就四条语句
//其实不需要怎么特意去改table表格的值，只要保证每一次查询，或者每一次操作后的查询，都是重新连了一次数据库
//查询之后关掉那些连接
//当你不知道错在哪里的时候，可以参照正确的重新来想一遍，想通其中的关键
//确保每一个人，程序的每一部分分工明确，所以哪里错了就知道去哪里找
//一部分代码的功能单一化，功能的单一化
//修改意见：1、连接之后关闭所有连接	2、每一次连接都保证是重连数据库
//3、把以上连接的内容给table，table若是变了自然会自动更新
//把连接数据库的内容写在连接中，自然可以保证每一遍查询都可以重连数据库

/*
 * 在数据库部分，解决所有和数据库有关的所有问题
 * 数据库返回的应该是表
 * 也就是说数据操作过后我们应该得到的（也期望得到的应该）也就是表
 * 所以数据库返回的一定是表
 * 而数据库的接口肯定是sql查询语句和paras[]数组参数，其实这两个合起来就是完整的sql语言，我只不过是用了一种更安全的写法
 * 
 * 所以现在就结论就是：
 * 数据库部分的接口是sql语言，返回值是table表
 * 
 * 我在写程序写类的时候居然没有仔细去想想类的功能，没有仔细去想想这部分特定的功能和把它封进黑匣子，只要知道它需要什么可以干什么就可以了
 * 写类写功能之前居然没有想想这个，现在真的是想想都搞笑
 * 这样经过自己的封装之后，自己写过的数据库在哪都能用
 * 
 * 那
 * 模型层和
 * 界面层
 * 的作用呢
 * 
 * 界面：
 * 职责，负责设计界面，做好的界面，组件监听
 * 接口：不需要
 * 返回值：各种监听的结果
 * 
 * 相关功能：
 * 界面肯定要负责起这个界面的各个组件的监听工作
 * 
 * 模型层呢？
 * 或者是说功能层
 * 既然是连接界面和数据库
 * 那么就是接受界面部分的返回值
 * 传出sql语句
 * 
 * 这样执行后
 * 
 * 这样做好后，再把数据库的结果  表格
 * 拿过来
 * 传递给界面用于输出
 * 
 * 总结：
 * 界面层：
 * 输入：数据库数据（表为载体）
 * 输出：各种事件监听
 * 
 * 模型层：
 * 输入：各种事件监听
 * 输出：sql语句
 * 
 * 数据层：
 * 输入：sql语句
 * 输出：表（数据）
 * 
 * 这是一个双路的循环结构，
 * 所以很平衡，原来如此，好简单
 * 
 * 
 * 
 * 我来画个图
 * 果然是助人自助
 * 
 * 
 * */
public class FirstUI extends JWindow implements Runnable{
	JProgressBar progressBar;
	JLabel label;
	int width,height;
	
	public static void main(String[] args){
		FirstUI firstUI=new FirstUI();
		//System.out.println("firstUI");
		Thread thread=new Thread(firstUI);
		thread.start();
	}
	
	public FirstUI(){
		label=new JLabel(new ImageIcon("image/index.gif"));
		
		progressBar=new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setIndeterminate(false);
		progressBar.setBorderPainted(false);
		progressBar.setBackground(Color.darkGray);
		
		this.add(label,BorderLayout.NORTH);
		this.add(progressBar,BorderLayout.SOUTH);
		
		this.setSize(400,263);
		width=Toolkit.getDefaultToolkit().getScreenSize().width;
		height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200,height/2-150);
		this.setVisible(true);
		
	}
	
	public void run() {
		int []progressValue={0,1,5,8,14,17,26,35,38,43,49,56,65,71,75,78,86,94,98,99,100};
		for(int i=0;i<progressValue.length;i++){
			try {
				Thread.sleep(200);
			} catch (Exception e) {}
			progressBar.setValue(progressValue[i]);
		}
		new Login();
		this.dispose();
	}
	
}
