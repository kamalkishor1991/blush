package org.numixproject.blush;


import org.junit.Test;

public class TransformerTest {
    @Test
    public void testDarken() {
        Color color = Color.WHITE;
        Color darkerColor = color.transform(Darken.class, .5);
        System.out.println(darkerColor);
        assert  darkerColor.equals(new Color(128, 128, 128)) == true;
    }
}
