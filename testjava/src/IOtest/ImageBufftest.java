package IOtest;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class ImageBufftest {
	public ImageBufftest() {		
	}	
	public void name() {		
	}	
	public void show(Graphics graphics,Image image0,Image image1) {
		
		Random random=new Random();
		int image_x=random.nextInt(500);	
		int image_y=random.nextInt(500);
		System.out.println(image_x);
		graphics.drawImage(image0,image_x,image_y,33,33,null);
		
		image_x=random.nextInt(500);	
		image_y=random.nextInt(500);
		System.out.println(image_x);
		graphics.drawImage(image1,image_x,image_y,33,33,null);	
	}
}

