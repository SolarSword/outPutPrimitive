package outPutPrimitive;
//��ɫ����ѡ���
import javax.swing.*;

import outPutPrimitive.PPane;
import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;

public class comboBoxColor extends JFrame implements ActionListener{
	JLabel colour = new JLabel("��ɫ");
	String [] colorOptions = {"��",//0,0,225 blue
							  "��",//0,255,0 green
							  "��",//255,0,0 red
							  "��",//0,255,255 cyan
							  "Ʒ��",//255,0,255 magenta
							  "��",//255,255,0 yellow
							  "��",//255,200,0 orange
							  "��",//255,175,175 pink
							  "��",//128,128,128 gray
							  "��",//0,0,0 black
							  }; 
	JComboBox<String> op = new JComboBox<String>(colorOptions);
	JButton ok,cancel;
	public comboBoxColor(){
		super("��ɫѡ��");
		setSize(280,100);
		setLookAndFeel();
		GridLayout grid = new GridLayout(2,2,5,5);
		setLayout(grid);
		add(colour);
		add(op);
		ok = new JButton("ȷ��");
		cancel = new JButton("ȡ��");
		//op.addItemListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		add(ok);
		add(cancel);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent evt){
		if(evt.getActionCommand() == "ȷ��"){
			switch(String.valueOf(op.getSelectedItem())){
			case "��":
				PPane.c = Color.blue;
				break;
			case "��":
				PPane.c = Color.green;
				break;
			case "��":
				PPane.c = Color.red;
				break;
			case "��":
				PPane.c = Color.cyan;
				break;
			case "Ʒ��":
				PPane.c = Color.magenta;
				break;
			case "��":
				PPane.c = Color.yellow;
				break;
			case "��":
				PPane.c = Color.orange;
				break;
			case "��":
				PPane.c = Color.pink;
				break;
			case "��":
				PPane.c = Color.gray;
				break;
			case "��":
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
