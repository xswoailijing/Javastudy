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
    		 System.err.printf("ͼƬ��ȡ�ɹ�");
    		 } catch (Exception e) {
			System.err.printf("ͼƬ��ȡ����%s",e);
			// TODO: handle exception
		} 	
		return img;
		
	}
}
