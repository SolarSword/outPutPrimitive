package outPutPrimitive;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import outPutPrimitive.PPane;
import outPutPrimitive.msgBoxLine;
import outPutPrimitive.msgBoxCircle;
import outPutPrimitive.msgBoxEllipse;
import outPutPrimitive.comboBoxColor;
//�����,���ذ�ť�������û�����
public class Primitive extends JFrame implements ActionListener{
	PPane pan;
	//��ͼ�˵�
	JMenuBar bar;
	JMenu draw;
	JMenu exterior;//���
	JMenu others;
	//��ť
	//��ͼ
	JMenuItem dda;
	JMenuItem bresenham;
	JMenuItem circleMid;
	JMenuItem ellipseMid;
	//���
	JMenuItem setColor;
	JMenuItem axis;
	JMenuItem grid;
	//����ѡ��
	JMenuItem clear;

	//���캯����ɽ��沼��
	public Primitive () {
		super("���׻�ͼ");
		setSize(820,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		//������ͼ���
		pan = new PPane();
		//������ͼ�˵�
		draw = new JMenu("��ͼ");
		exterior = new JMenu("���");
		others = new JMenu("����ѡ��");
		
		dda = new JMenuItem("DDA����");
		bresenham = new JMenuItem("Bresenham����");
		circleMid = new JMenuItem("�е�Բ");
		ellipseMid = new JMenuItem("�е���Բ");
		
		setColor = new JMenuItem("��ɫ");
		axis = new JMenuItem("����/��ʾ������");
		grid = new JMenuItem("����/��ʾ������");
		
		clear = new JMenuItem("���");
		
		bar = new JMenuBar();
		//�˵���Ŀ���
		bar.add(draw);
		bar.add(exterior);
		bar.add(others);
		
		draw.add(dda);
		draw.add(bresenham);
		draw.addSeparator();
		draw.add(circleMid);
		draw.add(ellipseMid);
		
		exterior.add(setColor);
		exterior.add(axis);
		exterior.add(grid);
		
		others.add(clear);
		//�˵���Ŀ��Ӧ����
		dda.addActionListener(this);
		bresenham.addActionListener(this);
		circleMid.addActionListener(this);
		ellipseMid.addActionListener(this);
		
		setColor.addActionListener(this);
		axis.addActionListener(this);
		grid.addActionListener(this);
		
		clear.addActionListener(this);
		
		add(bar);
		add(pan);
		setJMenuBar(bar);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt){
		
		//ѡ��ͼ
		switch(evt.getActionCommand()){
		case "DDA����":
			newWindowsLine("DDA�����㷨��������");
			pan.flag[0] = true;
			break;
		case "Bresenham����":
			newWindowsLine("Bresenham�����㷨��������");
			pan.flag[1] = true;
			break;
		case "�е�Բ":
			newWindowsCircle("�е�Բ�㷨��������");
			pan.flag[2] = true;
			break;
		case "�е���Բ":
			newWindowsEllipse("�е���Բ�㷨��������");
			pan.flag[3] = true;
			break;
		case "��ɫ":
			newWindowsColor();
			break;
		case "����/��ʾ������":
			if(pan.showAxis)
				pan.showAxis = false;
			else
				pan.showAxis = true;
			break;
		case "����/��ʾ������":
			if(pan.showGrid)
				pan.showGrid = false;
			else
				pan.showGrid = true;
			break;
		case "���":
			pan.clear();
			break;
		}
	}
	
	private void newWindowsLine(String name){
		msgBoxLine b = new msgBoxLine(name);
		pan.para1 = b.value;
	}
	
	private void newWindowsCircle(String name){
		msgBoxCircle b = new msgBoxCircle(name);
		pan.para2 = b.value;
	}
	
	private void newWindowsEllipse(String name){
		msgBoxEllipse b = new msgBoxEllipse(name);
		pan.para3 = b.value;
	}
	
	private void newWindowsColor(){
		comboBoxColor bc = new comboBoxColor();
	}
	
	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception exc){
			System.out.println("Couldn't use the system " + "look and feel: " + exc);
		}
	}
	
	public static void main(String[] arg){
		Primitive pp = new Primitive();
	}
}




