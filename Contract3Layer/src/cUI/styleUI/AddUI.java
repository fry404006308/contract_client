package cUI.styleUI;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//�ؼ����໯�������ڲ�����Ū
public class AddUI extends Style1_add implements ActionListener{

	public AddUI(Frame fck, String ckm, Boolean msck) {
		super(fck, ckm, msck);
		button1.setText("����");
		button1.addActionListener(this);
		button1.setActionCommand("add1");
		button2.setText("ȡ��1");
		button2.addActionListener(this);
		button2.setActionCommand("cancel1");
		button3.setActionCommand("upload1");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
