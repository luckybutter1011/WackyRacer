/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wackyracer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.ColorModel;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;

public class ColorizeOp implements BufferedImageOp {

    private final Color color;
    private final float alpha;

    public ColorizeOp(Color color, float alpha) {
        this.color = color;
        this.alpha = alpha;
    }

    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dst) {
        if (dst == null) {
            ColorModel cm = src.getColorModel();
            WritableRaster wr = src.copyData(null);
            dst = new BufferedImage(cm, wr, cm.isAlphaPremultiplied(), null);
        }

        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        float[] scales = {red / 255f, green / 255f, blue / 255f, alpha};
        float[] offsets = {0, 0, 0, 0};

        Kernel kernel = new Kernel(1, 1, scales);
        BufferedImage temp = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = temp.createGraphics();
        g2.drawImage(src, 0, 0, null);
        g2.dispose();
        BufferedImageOp colorConvert = new ColorConvertOp(null);
        colorConvert.filter(temp, temp);

        WritableRaster srcRaster = temp.getRaster();
        WritableRaster dstRaster = dst.getRaster();
        int[] pixel = new int[4];

        for (int y = 0; y < src.getHeight(); y++) {
            for (int x = 0; x < src.getWidth(); x++) {
                srcRaster.getPixel(x, y, pixel);
                pixel[0] = (int) (pixel[0] * scales[0] + offsets[0]);
                pixel[1] = (int) (pixel[1] * scales[1] + offsets[1]);
                pixel[2] = (int) (pixel[2] * scales[2] + offsets[2]);
                pixel[3] = (int) (pixel[3] * scales[3] + offsets[3]);
                dstRaster.setPixel(x, y, pixel);
            }
        }

        return dst;
    }

    @Override
    public Rectangle2D getBounds2D(BufferedImage bi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BufferedImage createCompatibleDestImage(BufferedImage bi, ColorModel cm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Point2D getPoint2D(Point2D pd, Point2D pd1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RenderingHints getRenderingHints() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
