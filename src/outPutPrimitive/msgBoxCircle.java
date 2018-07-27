package outPutPrimitive;
//中点圆算法的对话框类
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class msgBoxCircle extends JFrame implements ActionListener{
	JTextField [] text = new JTextField [3];
	JLabel [] label = new JLabel [3];
	JButton ok,cancel;
	static int [] value = {0,0,0};
	public msgBoxCircle(String name){
		super(name);
		setSize(380,180);
		
		setLookAndFeel();
		GridLayout grid = new GridLayout(4,2,5,5);
		setLayout(grid);
		for(int i = 0;i < text.length;i++){
			text[i] = new JTextField(String.valueOf(value[i]),5);
		}
		label[0] = new JLabel("圆心x");
		label[1] = new JLabel("圆心y");
		label[2] = new JLabel("半径");
		for(int i = 0;i < text.length;i++){
			add(label[i]);
			add(text[i]);
		}
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
