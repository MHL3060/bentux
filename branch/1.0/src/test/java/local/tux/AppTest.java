package local.tux;


import junit.framework.TestCase;

public class AppTest extends TestCase {
    public void testGetHello() throws Exception {
        assertEquals("Hello", App.getHello());
    }
    /*
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
    
    
    public void testGenerateThumbs() throws IOException{
    	String inDir = "j:\\images\\app";
    	File dir = new File(inDir);
    	String[] files = dir.list();
    	
    	for (String filename : files){
    		if (filename.endsWith("jpg")){
	    		BufferedImage bufferedImage = ImageUtil.readImage(inDir + File.separatorChar + filename);
	    		ImageConverter converter = new ImageConverter();
	        	BufferedImage thumb = converter.resize(bufferedImage, new Dimension(170, 170));
	        	ImageUtil.writeImage(thumb, inDir + File.separatorChar + "thumb" + File.separatorChar + filename);
    		}
    	}
    	
    	
    	
    	
    }
    */
}
