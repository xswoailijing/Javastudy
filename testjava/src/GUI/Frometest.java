package GUI;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.PaintEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.util.Random;

import IOtest.ImageBufftest;
import IOtest.Imagetest;

public class Frometest extends Frame  {
	Image image0;
	Image image1;
	/**
	 * 
	 */
	public Frometest() {
		
		// TODO 自动生成的构造函数存根
	}
	public void showwindow() {
		setBounds(11, 11, 666, 444);
		setVisible(true);
		image0=Imagetest.getimage("res/cj.jpg");
		image1=Imagetest.getimage("res/a.jpg");
		Thread thread=new Threadtest(image0,image1);	
		thread.start();		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void paint(Graphics graphics,Image image0,Image image1) {
			new ImageBufftest().show(graphics,image0,image1);

		
		
	}
	class Threadtest extends Thread  {	
		Image image0;	
		Image image1;
		public Threadtest(Image image0,Image image1) {
			this.image0=image0;	
			this.image1=image1;	
			// TODO 自动生成的构造函数存根
		}
		//重画窗口的线程类		
		public void run() {
			//把缓冲图片添加到线程内，防止一直读取图片			
			while (true) {			
				new Frometest().paint(getGraphics(),this.image0,image1);
				new Frometest().repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					System.err.println("线程出错");
					e.printStackTrace();
				}
			}

		}		
	}


}
