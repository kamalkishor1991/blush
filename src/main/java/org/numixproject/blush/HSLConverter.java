package org.numixproject.blush;


public class HSLConverter implements Converter<HSLColorModel> {
    /**
     * Converts the components of a color, as specified by the default RGB
     * model, to an equivalent set of values for hue, saturation, and
     * brightness that are the three components of the HSB model.
     * <p>
     * The method
     * returns the array <code>hsbvals</code>, with the values put into
     * that array.
     * @param     c   Color
     * @return    an HSLColorModel of three elements containing the hue, saturation,
     *                     and brightness
     */
    @Override
    public HSLColorModel convert(final Color c) {
        return new HSLColorModel() {
            private float r[] = HSLConverter.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue());
            @Override
            public float getHue() {
                return r[0];
            }

            @Override
            public float getSaturation() {
                return r[1];
            }

            @Override
            public float getBrightness() {
                return r[2];
            }

            @Override
            public int getRed() {
                return c.getRed();
            }

            @Override
            public int getGreen() {
                return c.getGreen();
            }

            @Override
            public int getBlue() {
                return c.getBlue();
            }

            @Override
            public int getAlpha() {
                return c.getAlpha();
            }
        };
    }


    //using methods from java.awt.Color
    /**
     * Converts the components of a color, as specified by the default RGB
     * model, to an equivalent set of values for hue, saturation, and
     * brightness that are the three components of the HSB model.
     * <p>
     * The method
     * returns the array <code>hsbvals</code>, with the values put into
     * that array.
     * @param     r   the red component of the color
     * @param     g   the green component of the color
     * @param     b   the blue component of the color
     * @return    an array of three elements containing the hue, saturation,
     *                     and brightness (in that order), of the color with
     *                     the indicated red, green, and blue components.
     */
    private static float[] RGBtoHSB(int r, int g, int b) {
        float hue, saturation, brightness;
        float hsbvals[] = new float[3];
        int cmax = (r > g) ? r : g;
        if (b > cmax) cmax = b;
        int cmin = (r < g) ? r : g;
        if (b < cmin) cmin = b;

        brightness = ((float) cmax) / 255.0f;
        if (cmax != 0)
            saturation = ((float) (cmax - cmin)) / ((float) cmax);
        else
            saturation = 0;
        if (saturation == 0)
            hue = 0;
        else {
            float redc = ((float) (cmax - r)) / ((float) (cmax - cmin));
            float greenc = ((float) (cmax - g)) / ((float) (cmax - cmin));
            float bluec = ((float) (cmax - b)) / ((float) (cmax - cmin));
            if (r == cmax)
                hue = bluec - greenc;
            else if (g == cmax)
                hue = 2.0f + redc - bluec;
            else
                hue = 4.0f + greenc - redc;
            hue = hue / 6.0f;
            if (hue < 0)
                hue = hue + 1.0f;
        }
        hsbvals[0] = hue;
        hsbvals[1] = saturation;
        hsbvals[2] = brightness;
        return hsbvals;
    }
}
