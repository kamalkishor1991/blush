package org.numixproject.blush;

/**
 * A color transformation.
 *<B>NOTE:</B> <B>The Implementation of Transform should have a public constructor with no parameters.</B>
 */
public interface Transform<T> {
    /**
     * Transforms Color
     * @param color Input Color
     * @return Transformed Color
     */
    public Color transform(Color color, T value);
}
