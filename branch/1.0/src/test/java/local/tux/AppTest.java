package local.tux;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.cedarsoft.image.ImageConverter;
import com.cedarsoft.image.ImageUtil;

import junit.framework.TestCase;

public class AppTest extends TestCase {
    public void testGetHello() throws Exception {
        assertEquals("Hello", App.getHello());
    }
    
    public void testThumb() throws IOException{

    	String file = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg";
    	//FileInputStream inputStream = new FileInputStream(new File());
    	//Image image = Toolkit.getDefaultToolkit().getImage(file);
    	//BufferedImage bufferedImage = new BufferedImage
    	BufferedImage bufferedImage = ImageUtil.readImage(file);
    	ImageConverter converter = new ImageConverter();
    	BufferedImage thumb = converter.resize(bufferedImage, new Dimension(100, 100));
    	ImageUtil.writeImage(thumb, "j:\\1.jpg");
    	
    }
}
