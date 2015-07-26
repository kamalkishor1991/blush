package org.numixproject.blush;

public class Darken implements Transform<Double> {
    @Override
    public Color transform(Color color, Double value) {
        int red   = (int) Math.round (color.getRed()   * (1.0 - value));
        int green = (int) Math.round (color.getGreen() * (1.0 - value));
        int blue  = (int) Math.round (color.getBlue()  * (1.0 - value));

        if (red   < 0) red   = 0; else if (red   > 255) red   = 255;
        if (green < 0) green = 0; else if (green > 255) green = 255;
        if (blue  < 0) blue  = 0; else if (blue  > 255) blue  = 255;

        int alpha = color.getAlpha();

        return new Color (red, green, blue, alpha);

    }
}
