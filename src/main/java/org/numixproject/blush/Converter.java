package org.numixproject.blush;
/*
A Color converter
<B>NOTE:</B> <B>The Implementation of Converter should have a public constructor with no parameters.</B>
*/
public interface Converter<T extends ColorModel> {
    /**
     * This method will convert Color c to a model type T
     * @param c
     * @return New ColorModel that will have information of Converted model.
     */
    public T convert(Color c);
}
