package outPutPrimitive;
//颜色下拉选择框
import javax.swing.*;

import outPutPrimitive.PPane;
import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;

public class comboBoxColor extends JFrame implements ActionListener{
	JLabel colour = new JLabel("颜色");
	String [] colorOptions = {"蓝",//0,0,225 blue
							  "绿",//0,255,0 green
							  "红",//255,0,0 red
							  "青",//0,255,255 cyan
							  "品红",//255,0,255 magenta
							  "黄",//255,255,0 yellow
							  "橙",//255,200,0 orange
							  "粉",//255,175,175 pink
							  "灰",//128,128,128 gray
							  "黑",//0,0,0 black
							  }; 
	JComboBox<String> op = new JComboBox<String>(colorOptions);
	JButton ok,cancel;
	public comboBoxColor(){
		super("颜色选择");
		setSize(280,100);
		setLookAndFeel();
		GridLayout grid = new GridLayout(2,2,5,5);
		setLayout(grid);
		add(colour);
		add(op);
		ok = new JButton("确定");
		cancel = new JButton("取消");
		//op.addItemListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		add(ok);
		add(cancel);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent evt){
		if(evt.getActionCommand() == "确定"){
			switch(String.valueOf(op.getSelectedItem())){
			case "蓝":
				PPane.c = Color.blue;
				break;
			case "绿":
				PPane.c = Color.green;
				break;
			case "红":
				PPane.c = Color.red;
				break;
			case "青":
				PPane.c = Color.cyan;
				break;
			case "品红":
				PPane.c = Color.magenta;
				break;
			case "黄":
				PPane.c = Color.yellow;
				break;
			case "橙":
				PPane.c = Color.orange;
				break;
			case "粉":
				PPane.c = Color.pink;
				break;
			case "灰":
				PPane.c = Color.gray;
				break;
			case "黑":
				PPane.c = Color.black;
				break;
			}
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
