package local.tux;


import java.io.OutputStream;



public class ThumbnailFactory {



	/**
	 * Create a reduced jpeg version of an image. The width/height
	 * ratio is preserved.
	 *
	 * @param data raw data of the image
	 * @param thumbWidth maximum width of the reduced image
	 * @param thumbHeight maximum heigth of the reduced image
	 * @param quality jpeg quality of the reduced image
	 * @param out produce a reduced jpeg image if the image represented
	 * by data is bigger than the maximum dimensions of the reduced
	 * image, otherwise data is written to this stream 
	 */
	   public static void createThumb(byte[] data, int thumbWidth,
			   int thumbHeight, OutputStream out) throws Exception {

		   //TODO : implement this
	   }
}
