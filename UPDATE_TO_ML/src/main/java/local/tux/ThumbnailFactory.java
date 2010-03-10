package local.tux;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import org.hibernate.util.LinkedHashCollectionHelper;


public class ThumbnailFactory {

	/**
     * Convenience method that returns a scaled instance of the
     * provided {@code BufferedImage}.
     *
     * @param img the original image to be scaled
     * @param targetWidth the desired width of the scaled instance,
     *    in pixels
     * @param targetHeight the desired height of the scaled instance,
     *    in pixels
     * @param hint one of the rendering hints that corresponds to
     *    {@code RenderingHints.KEY_INTERPOLATION} (e.g.
     *    {@code RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR},
     *    {@code RenderingHints.VALUE_INTERPOLATION_BILINEAR},
     *    {@code RenderingHints.VALUE_INTERPOLATION_BICUBIC})
     * @param higherQuality if true, this method will use a multi-step
     *    scaling technique that provides higher quality than the usual
     *    one-step technique (only useful in downscaling cases, where
     *    {@code targetWidth} or {@code targetHeight} is
     *    smaller than the original dimensions, and generally only when
     *    the {@code BILINEAR} hint is specified)
     * @return a scaled version of the original {@code BufferedImage}
     */

	public static BufferedImage getThumbnail(BufferedImage image,
			int maxThumbWidth, int maxThumbHeight) {
		RenderingHints hint = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		return getThumbnail(image, maxThumbWidth, maxThumbHeight, hint);
	}
	/**
	 * 
	 * @param image
	 * @param maxThumbWidth
	 * @param maxThumbHeight
	 * @param hints
	 * @return
	 */
	public static BufferedImage getThumbnail(BufferedImage image,
			int maxThumbWidth, int maxThumbHeight, RenderingHints hints) {
		BufferedImage thumbnail = null;
		if (image != null) {
			AffineTransform tx = new AffineTransform();
			// Determine scale so image is not larger than the max height and/or
			// width.
			double scale = scaleToFit(image.getWidth(), image.getHeight(),
					maxThumbWidth, maxThumbHeight);

			tx.scale(scale, scale);

			double d1 = (double) image.getWidth() * scale;
			double d2 = (double) image.getHeight() * scale;
			thumbnail = new BufferedImage(
					((int) d1) < 1 ? 1 : (int) d1, // don't allow width to be
													// less than 1
					((int) d2) < 1 ? 1 : (int) d2, // don't allow height to be
													// less than 1
					image.getType() == BufferedImage.TYPE_CUSTOM ? BufferedImage.TYPE_INT_RGB
							: image.getType());
			Graphics2D g2d = thumbnail.createGraphics();
			g2d.setRenderingHints(hints);
			g2d.drawImage(image, tx, null);
			g2d.dispose();
		}
		return thumbnail;
	}

	private static double scaleToFit(double w1, double h1, double w2, double h2) {
		double scale = 1.0D;
		if (w1 > h1) {
			if (w1 > w2)
				scale = w2 / w1;
			h1 *= scale;
			if (h1 > h2)
				scale *= h2 / h1;
		} else {
			if (h1 > h2)
				scale = h2 / h1;
			w1 *= scale;
			if (w1 > w2)
				scale *= w2 / w1;
		}
		return scale;
	}

}
