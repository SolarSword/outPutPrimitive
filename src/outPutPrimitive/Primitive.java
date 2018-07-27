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
//框架类,加载按钮，监听用户输入
public class Primitive extends JFrame implements ActionListener{
	PPane pan;
	//画图菜单
	JMenuBar bar;
	JMenu draw;
	JMenu exterior;//外观
	JMenu others;
	//按钮
	//绘图
	JMenuItem dda;
	JMenuItem bresenham;
	JMenuItem circleMid;
	JMenuItem ellipseMid;
	//外观
	JMenuItem setColor;
	JMenuItem axis;
	JMenuItem grid;
	//其他选项
	JMenuItem clear;

	//构造函数完成界面布置
	public Primitive () {
		super("简易绘图");
		setSize(820,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		//创建绘图面板
		pan = new PPane();
		//创建绘图菜单
		draw = new JMenu("绘图");
		exterior = new JMenu("外观");
		others = new JMenu("其他选项");
		
		dda = new JMenuItem("DDA画线");
		bresenham = new JMenuItem("Bresenham画线");
		circleMid = new JMenuItem("中点圆");
		ellipseMid = new JMenuItem("中点椭圆");
		
		setColor = new JMenuItem("颜色");
		axis = new JMenuItem("隐藏/显示坐标轴");
		grid = new JMenuItem("隐藏/显示网格线");
		
		clear = new JMenuItem("清除");
		
		bar = new JMenuBar();
		//菜单项目添加
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
		//菜单项目响应设置
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
		
		//选择画图
		switch(evt.getActionCommand()){
		case "DDA画线":
			newWindowsLine("DDA画线算法参数设置");
			pan.flag[0] = true;
			break;
		case "Bresenham画线":
			newWindowsLine("Bresenham画线算法参数设置");
			pan.flag[1] = true;
			break;
		case "中点圆":
			newWindowsCircle("中点圆算法参数设置");
			pan.flag[2] = true;
			break;
		case "中点椭圆":
			newWindowsEllipse("中点椭圆算法参数设置");
			pan.flag[3] = true;
			break;
		case "颜色":
			newWindowsColor();
			break;
		case "隐藏/显示坐标轴":
			if(pan.showAxis)
				pan.showAxis = false;
			else
				pan.showAxis = true;
			break;
		case "隐藏/显示网格线":
			if(pan.showGrid)
				pan.showGrid = false;
			else
				pan.showGrid = true;
			break;
		case "清除":
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




