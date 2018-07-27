package outPutPrimitive;

import java.awt.Color;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.*;
import javax.swing.*;

//��壬��ͼ���������
public class PPane extends JPanel {
	Graphics2D comp2D;
	boolean [] flag = new boolean [] {false,false,false,false};//��ͼָʾ����
	int [] para1 = new int [] {0,0,0,0};//ֱ�ߵĲ���
	int [] para2 = new int [] {0,0,0};//Բ�Ĳ���
	int [] para3 = new int [] {0,0,0,0};//��Բ�Ĳ���
	static Color c = Color.red;
	boolean showAxis = true;
	boolean showGrid = false;
	boolean delay = true;
	//����
	public void paintComponent(Graphics comp){
		comp2D = (Graphics2D)comp;//��������ʾһ�ֿ��������л�ͼ�ġ�������
		//����
		comp2D.setColor(Color.white);
		comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Rectangle2D.Float background = new Rectangle2D.Float(0F,0F,getSize().width,getSize().height);
		comp2D.fill(background);
		Stroke l = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
	            BasicStroke.JOIN_ROUND, 3.5f, new float[] { 10, 0, },
	            0f);
		comp2D.setStroke(l);
		//������
		if(showAxis){
			comp2D.setColor(Color.orange);
			Line2D.Float xAxis = new Line2D.Float(0, 225, 800, 225);//x��,ԭ�������൱�ڣ�225��400��
			Line2D.Float yAxis = new Line2D.Float(400,0,400,450);//y��
			Line2D.Float mark1 = new Line2D.Float(500,215,500,225);//100���
			Line2D.Float mark2 = new Line2D.Float(400,125,410,125);
			comp2D.draw(xAxis);
			comp2D.draw(yAxis);
			comp2D.draw(mark1);
			comp2D.draw(mark2);
			//��ͷ
			GeneralPath arrowX = new GeneralPath();
			arrowX.moveTo(790, 225);
			arrowX.lineTo(785, 220);
			arrowX.lineTo(800, 225);
			arrowX.lineTo(785, 230);
			arrowX.lineTo(790, 225);
			comp2D.fill(arrowX);
			
			GeneralPath arrowY = new GeneralPath();
			arrowY.moveTo(400, 10);
			arrowY.lineTo(395, 15);
			arrowY.lineTo(400, 0);
			arrowY.lineTo(405, 15);
			arrowY.lineTo(400, 10);
			comp2D.fill(arrowY);
			//���ֱ�ע
			comp2D.setColor(Color.black);
			comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//��������
			comp2D.drawString("O", 385, 245);//ԭ��
			comp2D.drawString("x", 785, 245);
			comp2D.drawString("y", 385, 25);
			comp2D.drawString("100",490, 245);
			comp2D.drawString("100",375, 130);
		}
		
		if(showGrid){
			Stroke dash = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_ROUND, 3.5f, new float[] { 10, 5, },
            0f);
    		comp2D.setStroke(dash);
    		for(int i = 1;i < 8;i++){//����
    			Line2D.Float g = new Line2D.Float(100 * i,0,100 * i,450);
    			comp2D.draw(g);
    		}
    		for(int i = 0;i < 5;i++){//����
    			Line2D.Float g = new Line2D.Float(0,100 * i + 25,800,100 * i + 25);
    			comp2D.draw(g);
    		}
    		Stroke li = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
    	            BasicStroke.JOIN_ROUND, 3.5f, new float[] { 10, 0, },
    	            0f);
    		comp2D.setStroke(li);
		}
		
		//��ѯ���λ�����Ϊtrue�ͻ������ͼ��
		if(flag[0])lineDDA(comp2D,para1[0],para1[1],para1[2],para1[3],c);
		if(flag[1])lineBre(comp2D,para1[0],para1[1],para1[2],para1[3],c);
		if(flag[2])circleMidPoint(comp2D,para2[0],para2[1],para2[2],c);
		if(flag[3])ellipseMidPoint(comp2D,para3[0],para3[1],para3[2],para3[3],c);
		
		
	    repaint();  
	         
	}
	
	
	public void clear(){
		for(int i = 0;i < flag.length;i++)
			flag[i] = false;
		for(int i = 0;i < para1.length;i++){
			para1[i] = 0;
			para3[i] = 0;
		}
		for(int i = 0;i < para2.length;i++){
			para2[i] = 0;
		}
	}
	public Graphics2D getComp(){
		return comp2D;
	}
	//������һЩ��������
	//�������ص�
	private void setPixel(Graphics2D c,int x,int y){
		Ellipse2D.Float e = new Ellipse2D.Float(x,y,1,1);
		c.fill(e);
	}
	//��������
	private int round(float a){
		return (int)(a < 0 ? a - 0.5 : a + 0.5);
	}
	private int round(double a){
		return (int)(a + 0.5);
	}
	//Բ�ϵ�Ļ��ƺ���
	private void circlePlotPoints(Graphics2D c,int xc,int yc,int x,int y){
		setPixel(c,xc + x + 400,- (yc + y) + 225);
		setPixel(c,xc - x + 400,- (yc + y) + 225);
		setPixel(c,xc + x + 400,- (yc - y) + 225);
		setPixel(c,xc - x + 400,- (yc - y) + 225);
		setPixel(c,xc + y + 400,- (yc + x) + 225);
		setPixel(c,xc - y + 400,- (yc + x) + 225);
		setPixel(c,xc + y + 400,- (yc - x) + 225);
		setPixel(c,xc - y + 400,- (yc - x) + 225);
	}
	//��Բ�ϵ�Ļ��ƺ���
	private void ellipsePlotPoint(Graphics2D c,int xc,int yc,int x,int y){
		setPixel(c,xc + x + 400,-(yc + y) + 225);
		setPixel(c,xc - x + 400,-(yc + y) + 225);
		setPixel(c,xc + x + 400,-(yc - y) + 225);
		setPixel(c,xc - x + 400,-(yc - y) + 225);
	}
	//��ͼ����
	//DDA
	private void lineDDA(Graphics2D c,int x0,int y0,int xEnd,int yEnd,Color color){
		float x,y;
		float xInc,yInc;//����
		int steps = Math.abs(xEnd - x0) > Math.abs(yEnd - y0) ? Math.abs(xEnd - x0) : Math.abs(yEnd - y0);
		x = (float)x0;
		y = (float)y0;
		xInc = (float)(xEnd - x0) / steps;
		yInc = (float)(yEnd - y0) / steps;
		c.setColor(color);
		for(int i = 0; i < steps; i++)
		{
			setPixel(c,round(x)+400, -round(y)+225);//ƽ��ԭ�㣬����y����ת180�㣬�͵õ�����������任	
			x += xInc;
			y += yInc;
			
		}
	}
	//Bresenham
	private void lineBre(Graphics2D c,int x0,int y0,int xEnd,int yEnd,Color color){
		int x = x0;
		int y = y0;
		int dx = Math.abs(xEnd - x0);
		int dy = Math.abs(yEnd - y0);
		int s1 = xEnd > x0 ? 1:-1;
		int s2 = yEnd > y0 ? 1:-1;
		boolean interchange = false;
		c.setColor(color);
		if(dy > dx){
			int temp = dx;
			dx = dy;
			dy = temp;
			interchange = true;
		}
		int p = 2 * dy - dx;
		for(int i = 0;i < dx;i++){
			setPixel(c,round(x)+400, -round(y)+225);
			if(p >= 0){
				if(!interchange)
					y += s2;
				else 
					x += s1;
				p -= 2 * dx;
			}
			if(!interchange)
				x += s1;
			else
				y += s2;
			p +=2 * dy;
		}
	}
	//�е�Բ
	private void circleMidPoint(Graphics2D c,int xc,int yc,int radius,Color color){
		int p = 1 - radius;
		int x = 0;
		int y = radius;
		c.setColor(color);
		circlePlotPoints(c,xc,yc,x,y);
		while(x < y){
			x++;
			if(p < 0)
				p += 2 * x + 1;
			else{
				y--;
				p += 2 * (x - y) + 1;
			}
			circlePlotPoints(c,xc,yc,x,y);
		}
	}
	//�е���Բ
	private void ellipseMidPoint(Graphics2D c,int xc,int yc,int rx,int ry,Color color){
		int rx2 = rx * rx;
		int ry2 = ry * ry;
		int p;
		int x = 0;
		int y = ry;
		int px = 0;
		int py = 2 * rx2 * y;
		p = round(ry2 - (rx2 * ry) + (0.25 * rx2));//�����������������float����double����,������һ��
		c.setColor(color);
		ellipsePlotPoint(c,xc,yc,x,y);
		//��һ����
		while(px < py){
			x++;
			px += 2 * ry2;
			if(p < 0)
				p += ry2 + px;
			else {
				y--;
				py -= 2 * rx2;
				p += ry2 + px - py;
			}
			ellipsePlotPoint(c,xc,yc,x,y);
		}
		//�ڶ�����
		p = round(ry2 * (x + 0.5) * (x + 0.5) + rx2 * (y - 1) * (y - 1) - rx2 * ry2);
		while(y > 0){
			y--;
			py -= 2 * rx2;
			if(p > 0)
				p += rx2 - py;
			else{
				x++;
				px += 2 * ry2;
				p += rx2 - py + px;
			}
			ellipsePlotPoint(c,xc,yc,x,y);
		}
	}
}