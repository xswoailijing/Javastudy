package IOtest;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;



public class Imagetest  {
	Image image;
     public static Image getimage(String path) {
    	 
    	 URL url= Imagetest.class.getClassLoader().getResource(path);    	 
    	 BufferedImage img=null;
    	 try {
    		 img=ImageIO.read(url);	
    		 System.err.printf("图片读取成功");
    		 } catch (Exception e) {
			System.err.printf("图片读取出错%s",e);
			// TODO: handle exception
		} 	
		return img;
		
	}
}
