package pl.wujko.one_more.frontend.utils;

import com.jgoodies.forms.layout.FormLayout;

/**
 * Created by Agata on 2015-10-06.
 */
public class FormLayoutUtils
{
    //FOOD
    private static final String DEFAULT_START = "f:p:g";

    private static final String DEFAULT_NEXT = ", 1dlu, " + DEFAULT_START;

    //CART
    public static final String CART_START = "f:m";

    public static final String CART_NEXT = ", 2dlu, " + CART_START;

    public static FormLayout createCartListLayout(int rows)
    {
        StringBuilder builder = new StringBuilder(CART_START);
        for (int i = 1; i < rows; ++i)
        {
            builder.append(CART_NEXT);
        }
        return new FormLayout("f:p:g", builder.toString());
    }

    public static FormLayout createDefaultEntryLayout(int size)
    {
        return new FormLayout(getSpecs(size), getSpecs(1));
    }

    public static FormLayout createDefaultFoodLayout(int columns, int rows)
    {
        return new FormLayout(getSpecs(columns), getSpecs(rows));
    }

    private static String getSpecs(int count)
    {
        StringBuilder specs = new StringBuilder(DEFAULT_START);
        int i = 1;
        while (count > i)
        {
            specs.append(DEFAULT_NEXT);
            ++i;
        }

        return specs.toString();
    }
}
