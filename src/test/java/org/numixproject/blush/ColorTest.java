package org.numixproject.blush;
import org.junit.Test;

import java.util.Random;

public class ColorTest {
    @Test
    public void testBasicColor() {
        for (int i = 0; i < 10000000; i++) {
            int randomColor = new Random().nextInt();
            Color c = new Color(randomColor);
            assert c.getRGBA() == randomColor;
        }
    }



}
