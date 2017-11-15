package cUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
//����ˢ�����⣬��һ������ʱ���Ǳ�֤ÿ�β�������������һ�����ݿ⣬������ˢ��
//�ڶ����ʱ���ǲ�����֮�����½����ݿ���������ҵĵ���������Ϊ��������ܹ��������м�ģ�͵���һ��
//ÿ��һ�����ݿ�󣬲�Ϊ�յ����ݿ����Ӳ��֣��Ҷ����������
//����ÿһ���½�һ�����ݿ���󣬶����൱����������һ�����ݿ�
//���ǰ�sql����ָ��һ�𴫹�ȥ��
//ÿ�����ӣ�ɾ�����޸�֮�󣬶�����һ���ѯ����ɾ�ģ����ר�����������ɾ�ľ����ˣ���Ҫ��ѯ��ʱ��Ͳ�ѯ����
//ÿ��ѯһ�Σ��ҾͰ����Ժ����ݿ��йص����ӹر���һ�Σ�
//�����ٴ�ִ�в�����ʱ���������������һ�����ݿ⣬������ִ����һ����Щ���ݿ����ӵ����
//���ݿ�����Ҳ���������
//��ʵ����Ҫ��ô����ȥ��table����ֵ��ֻҪ��֤ÿһ�β�ѯ������ÿһ�β�����Ĳ�ѯ��������������һ�����ݿ�
//��ѯ֮��ص���Щ����
//���㲻֪�����������ʱ�򣬿��Բ�����ȷ����������һ�飬��ͨ���еĹؼ�
//ȷ��ÿһ���ˣ������ÿһ���ַֹ���ȷ������������˾�֪��ȥ������
//һ���ִ���Ĺ��ܵ�һ�������ܵĵ�һ��
//�޸������1������֮��ر���������	2��ÿһ�����Ӷ���֤���������ݿ�
//3�����������ӵ����ݸ�table��table���Ǳ�����Ȼ���Զ�����
//���������ݿ������д�������У���Ȼ���Ա�֤ÿһ���ѯ�������������ݿ�

/*
 * �����ݿⲿ�֣�������к����ݿ��йص���������
 * ���ݿⷵ�ص�Ӧ���Ǳ�
 * Ҳ����˵���ݲ�����������Ӧ�õõ��ģ�Ҳ�����õ���Ӧ�ã�Ҳ���Ǳ�
 * �������ݿⷵ�ص�һ���Ǳ�
 * �����ݿ�Ľӿڿ϶���sql��ѯ����paras[]�����������ʵ����������������������sql���ԣ���ֻ����������һ�ָ���ȫ��д��
 * 
 * �������ھͽ��۾��ǣ�
 * ���ݿⲿ�ֵĽӿ���sql���ԣ�����ֵ��table��
 * 
 * ����д����д���ʱ���Ȼû����ϸȥ������Ĺ��ܣ�û����ϸȥ�����ⲿ���ض��Ĺ��ܺͰ��������ϻ�ӣ�ֻҪ֪������Ҫʲô���Ը�ʲô�Ϳ�����
 * д��д����֮ǰ��Ȼû�����������������������붼��Ц
 * ���������Լ��ķ�װ֮���Լ�д�������ݿ����Ķ�����
 * 
 * ��
 * ģ�Ͳ��
 * �����
 * ��������
 * 
 * ���棺
 * ְ�𣬸�����ƽ��棬���õĽ��棬�������
 * �ӿڣ�����Ҫ
 * ����ֵ�����ּ����Ľ��
 * 
 * ��ع��ܣ�
 * ����϶�Ҫ�������������ĸ�������ļ�������
 * 
 * ģ�Ͳ��أ�
 * ������˵���ܲ�
 * ��Ȼ�����ӽ�������ݿ�
 * ��ô���ǽ��ܽ��沿�ֵķ���ֵ
 * ����sql���
 * 
 * ����ִ�к�
 * 
 * �������ú��ٰ����ݿ�Ľ��  ���
 * �ù���
 * ���ݸ������������
 * 
 * �ܽ᣺
 * ����㣺
 * ���룺���ݿ����ݣ���Ϊ���壩
 * ����������¼�����
 * 
 * ģ�Ͳ㣺
 * ���룺�����¼�����
 * �����sql���
 * 
 * ���ݲ㣺
 * ���룺sql���
 * ����������ݣ�
 * 
 * ����һ��˫·��ѭ���ṹ��
 * ���Ժ�ƽ�⣬ԭ����ˣ��ü�
 * 
 * 
 * 
 * ��������ͼ
 * ��Ȼ����������
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
