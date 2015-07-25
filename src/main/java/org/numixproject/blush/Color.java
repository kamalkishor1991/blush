package org.numixproject.blush;

/**
 * Representation of color.
 * Color instance can not be changed after it is created.
 */
public final class Color implements ColorModel {

    /**
     * The color white.  In the default sRGB space.
     
     */
    public final static Color WHITE = new Color(255, 255, 255);

    /**
     * The color light gray.  In the default sRGB space.
     
     */
    public final static Color LIGHT_GRAY = new Color(192, 192, 192);


    /**
     * The color gray.  In the default sRGB space.
     
     */
    public final static Color GRAY = new Color(128, 128, 128);


    /**
     * The color dark gray.  In the default sRGB space.
     
     */
    public final static Color DARK_GRAY = new Color(64, 64, 64);


    /**
     * The color black.  In the default sRGB space.
     
     */
    public final static Color BLACK = new Color(0, 0, 0);


    /**
     * The color red.  In the default sRGB space.
     
     */
    public final static Color RED = new Color(255, 0, 0);

    /**
     * The color pink.  In the default sRGB space.
     
     */
    public final static Color PINK = new Color(255, 175, 175);


    /**
     * The color orange.  In the default sRGB space.
     
     */
    public final static Color ORANGE =  new Color(255, 200, 0);

    /**
     * The color yellow.  In the default sRGB space.
     
     */
    public final static Color YELLOW = new Color(255, 255, 0);

    /**
     * The color green.  In the default sRGB space.
     
     */
    public final static Color GREEN = new Color(0, 255, 0);


    /**
     * The color magenta.  In the default sRGB space.
     
     */
    public final static Color MAGENTA = new Color(255, 0, 255);;


    /**
     * The color cyan.  In the default sRGB space.
     
     */
    public final static Color CYAN = new Color(0, 255, 255);

    /**
     * The color blue.  In the default sRGB space.
     
     */
    public final static Color BLUE = new Color(0, 0, 255);

    private final int value;

    /**
     * Creates an opaque sRGB color with the specified red, green,
     * and blue values in the range (0 - 255).
     * The actual color used in rendering depends
     * on finding the best match given the color space
     * available for a given output device.
     * Alpha is defaulted to 255.
     *
     * @throws IllegalArgumentException if <code>r</code>, <code>g</code>
     *        or <code>b</code> are outside of the range
     *        0 to 255, inclusive
     * @param r the red component
     * @param g the green component
     * @param b the blue component
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     * @see #getRGBA()
     */
    public Color(int r, int g, int b) {
        this(r, g, b, 255);
    }

    /**
     * Creates an sRGB color with the specified red, green, blue, and alpha
     * values in the range (0 - 255).
     *
     * @throws IllegalArgumentException if <code>r</code>, <code>g</code>,
     *        <code>b</code> or <code>a</code> are outside of the range
     *        0 to 255, inclusive
     * @param r the red component
     * @param g the green component
     * @param b the blue component
     * @param a the alpha component
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     * @see #getAlpha
     * @see #getRGBA()
     */
    public Color(int r, int g, int b, int a) {
        value = ((a & 0xFF) << 24) |
                ((r & 0xFF) << 16) |
                ((g & 0xFF) << 8)  |
                ((b & 0xFF) << 0);
        testColorValueRange(r, g, b, a);
    }

    /**
     * Creates an sRGB color with the specified combined RGBA value consisting
     * of the alpha component in bits 24-31, the red component in bits 16-23,
     * the green component in bits 8-15, and the blue component in bits 0-7.
     *
     * @param rgba the combined RGBA components
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     * @see #getRGBA()
     */
    public Color(int rgba) {
        value = rgba;
    }


    /**
     * Creates an opaque sRGB color with the specified red, green, and blue
     * values in the range (0.0 - 1.0).  Alpha is defaulted to 1.0.  The
     * actual color used in rendering depends on finding the best
     * match given the color space available for a particular output
     * device.
     *
     * @throws IllegalArgumentException if <code>r</code>, <code>g</code>
     *        or <code>b</code> are outside of the range
     *        0.0 to 1.0, inclusive
     * @param r the red component
     * @param g the green component
     * @param b the blue component
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     * @see #getRGBA()
     */
    public Color(float r, float g, float b) {
        this((int) (r * 255 + 0.5), (int) (g * 255 + 0.5), (int) (b * 255 + 0.5));
        testColorValueRange(r,g,b,1.0f);
    }


    /**
     * Creates an sRGB color with the specified red, green, blue, and
     * alpha values in the range (0.0 - 1.0).  The actual color
     * used in rendering depends on finding the best match given the
     * color space available for a particular output device.
     * @throws IllegalArgumentException if <code>r</code>, <code>g</code>
     *        <code>b</code> or <code>a</code> are outside of the range
     *        0.0 to 1.0, inclusive
     * @param r the red component
     * @param g the green component
     * @param b the blue component
     * @param a the alpha component
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     * @see #getAlpha
     * @see #getRGBA
     */
    public Color(float r, float g, float b, float a) {
        this((int) (r * 255 + 0.5), (int) (g * 255 + 0.5), (int) (b * 255 + 0.5), (int) (a * 255 + 0.5));

    }


    /**
     * Returns the red component in the range 0-255 in the default sRGB
     * space.
     * @return the red component.
     * @see #getRGBA
     */
    public int getRed() {
        return (getRGBA() >> 16) & 0xFF;
    }

    /**
     * Returns the green component in the range 0-255 in the default sRGB
     * space.
     * @return the green component.
     * @see #getRGBA()
     */
    public int getGreen() {
        return (getRGBA() >> 8) & 0xFF;
    }

    /**
     * Returns the blue component in the range 0-255 in the default sRGB
     * space.
     * @return the blue component.
     * @see #getRGBA()
     */
    public int getBlue() {
        return (getRGBA() >> 0) & 0xFF;
    }

    /**
     * Returns the alpha component in the range 0-255.
     * @return the alpha component.
     * @see #getRGBA()
     */
    public int getAlpha() {
        return (getRGBA() >> 24) & 0xff;
    }

    /**
     * Returns the RGBA value representing the color in the default sRGBA
     * (Bits 24-31 are alpha, 16-23 are red, 8-15 are green, 0-7 are
     * blue).
     * @return the RGB value of the color in the default sRGB
     *         <code>ColorModel</code>.
     * @see java.awt.image.ColorModel#getRGBdefault
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     */
    public int getRGBA() {
        return value;
    }

    /**
     * Returns a string representation of this <code>Color</code>. This
     * method is intended to be used only for debugging purposes.  The
     * content and format of the returned string might vary between
     * implementations. The returned string might be empty but cannot
     * be <code>null</code>.
     *
     * @return  a string representation of this <code>Color</code>.
     */
    @Override
    public String toString() {
        return getClass().getName() + "[r=" + getRed() + ",g=" + getGreen() + ",b=" + getBlue() + "]";
    }

    /**
     *
     * @param clazz class implementation of Transform interface.
     * @return New transformed color using Class<? extends Transform>
     * @throws RuntimeException if not able to initialize the Transform instance.
     */
    public <T> Color  transform(Class<? extends Transform<T>> clazz, T t)  {
        try {
            Transform<T> transform = clazz.newInstance();
            return transform.transform(this, t);
        } catch (InstantiationException e) { // decide on if
            e.printStackTrace();
            throw new RuntimeException("Unable to create instance of class");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to create instance of class");
        }

    }


    /**
     *
     * @param clazz class implementation of Converter interface.
     * @return New transformed color using Class<? extends Converter>
     * @throws RuntimeException if not able to initialize the Transform instance.
     */
    public <T extends ColorModel> T convert(Class<? extends Converter<T>> clazz)  {
        try {
            Converter<T> converter= clazz.newInstance();
            return converter.convert(this);
        } catch (InstantiationException e) { // decide on if
            e.printStackTrace();
            throw new RuntimeException("Unable to create instance of class");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to create instance of class");
        }

    }

    /**
     * Checks the color <code>float</code> components supplied for
     * validity.
     * Throws an <code>IllegalArgumentException</code> if the value is out
     * of range.
     * @param r the Red component
     * @param g the Green component
     * @param b the Blue component
     **/
    private static void testColorValueRange(float r, float g, float b, float a) {
        boolean rangeError = false;
        String badComponentString = "";
        if ( a < 0.0 || a > 1.0) {
            rangeError = true;
            badComponentString = badComponentString + " Alpha";
        }
        if ( r < 0.0 || r > 1.0) {
            rangeError = true;
            badComponentString = badComponentString + " Red";
        }
        if ( g < 0.0 || g > 1.0) {
            rangeError = true;
            badComponentString = badComponentString + " Green";
        }
        if ( b < 0.0 || b > 1.0) {
            rangeError = true;
            badComponentString = badComponentString + " Blue";
        }
        if ( rangeError == true ) {
            throw new IllegalArgumentException("Color parameter outside of expected range:"
                    + badComponentString);
        }
    }
    /**
     * Checks the color integer components supplied for validity.
     * Throws an {@link IllegalArgumentException} if the value is out of
     * range.
     * @param r the Red component
     * @param g the Green component
     * @param b the Blue component
     **/
    private static void testColorValueRange(int r, int g, int b, int a) {
        boolean rangeError = false;
        String badComponentString = "";

        if ( a < 0 || a > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Alpha";
        }
        if ( r < 0 || r > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Red";
        }
        if ( g < 0 || g > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Green";
        }
        if ( b < 0 || b > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Blue";
        }
        if ( rangeError == true ) {
            throw new IllegalArgumentException("Color parameter outside of expected range:"
                    + badComponentString);
        }
    }
}
