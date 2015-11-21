package pl.wujko.one_more.frontend.utils;

import com.jgoodies.forms.layout.FormLayout;

/**
 * Created by Agata on 2015-10-06.
 */
public class FormLayoutUtils
{
    //FOOD
    private static final String DEFAULT_START = "f:m:g(0.1)";

    private static final String DEFAULT_NEXT = ", 1dlu, " + DEFAULT_START;

    private static final String MAX_NEXT = ", 1dlu, f:p:g(0.9)";

    //CART
    public static final String CART_START = "f:m";

    public static final String CART_NEXT = ", 2dlu, " + CART_START;

    public static FormLayout createCartListLayout(int rows)
    {
        StringBuilder builder = new StringBuilder(CART_START);
        for (int i = 0; i < rows; ++i)
        {
            builder.append(CART_NEXT);
        }
        return new FormLayout("f:p:g", builder.toString());
    }

    public static FormLayout createDefaultCartEntryLayout(int size)
    {
        return new FormLayout(getCartEntrySpecs(size), getSpecs(1));
    }

    public static FormLayout createDefaultFoodLayout(int columns, int rows)
    {
        return new FormLayout(getSpecs(columns), getSpecs(rows));
    }

    private static String getCartEntrySpecs(int count)
    {
        StringBuilder specs = new StringBuilder(DEFAULT_START);
        int i = 1;
        while (count > i)
        {
            if (count - 4 == i)
            {
                specs.append(MAX_NEXT);
            }
            else
            {
                specs.append(DEFAULT_NEXT);
            }
            ++i;
        }

        return specs.toString();
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
