package outPutPrimitive;

import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

public class msgBoxLine extends JFrame implements ActionListener {
	//文本编辑框的字母是大写
	JTextField [] text = new JTextField [4];
	JLabel [] label = new JLabel [4];
	JButton ok,cancel;
	JLabel [] blank = new JLabel []{new JLabel(" "),new JLabel(" ")};
	static int [] value = {0,0,0,0};
	
	public msgBoxLine(String name){
		super(name);
		setSize(380,150);
		
		setLookAndFeel();
		GridLayout grid = new GridLayout(3,4,5,5);
		setLayout(grid);
		for(int i = 0;i < text.length;i++){
			text[i] = new JTextField(String.valueOf(value[i]),5);
		}
		label[0] = new JLabel("x1");
		label[1] = new JLabel("y1");
		label[2] = new JLabel("x2");
		label[3] = new JLabel("y2");
		for(int i = 0;i < text.length;i++){
			add(label[i]);
			add(text[i]);
		}
		add(blank[0]);
		add(blank[1]);
		ok = new JButton("确定");
		cancel = new JButton("取消");
		ok.addActionListener(this);
		cancel.addActionListener(this);
		add(ok);
		add(cancel);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt){
		if(evt.getActionCommand() == "确定"){
			for(int i = 0;i < text.length;i++)
				value[i] = Integer.parseInt(text[i].getText());
		}
		dispose();
	}
	
	
	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception exc){
			System.out.println("Couldn't use the system " + "look and feel: " + exc);
		}
	}
}
