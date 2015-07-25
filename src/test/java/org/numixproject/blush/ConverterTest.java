package org.numixproject.blush;


import org.junit.Test;

public class ConverterTest {
    @Test
    public void testHSLConverter() {
        Color c = new Color(255, 0, 0);
        HSLColorModel hslColorModel = c.convert(HSLConverter.class);
        assert hslColorModel.getHue() == 0;
        assert hslColorModel.getBrightness() == 1;
        assert hslColorModel.getSaturation() == 1;
    }
}
