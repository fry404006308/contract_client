package cUI.styleUI;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//控件的类化处理，现在不建议弄
public class AddUI extends Style1_add implements ActionListener{

	public AddUI(Frame fck, String ckm, Boolean msck) {
		super(fck, ckm, msck);
		button1.setText("增加");
		button1.addActionListener(this);
		button1.setActionCommand("add1");
		button2.setText("取消1");
		button2.addActionListener(this);
		button2.setActionCommand("cancel1");
		button3.setActionCommand("upload1");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
