package pl.wujko.one_more.frontend.utils;

/**
 * Created by Agata on 2015-11-29.
 */
public class PriceUtils
{
    public static String convertPrice(int price)
    {
        StringBuilder result = new StringBuilder();
        int integer = price / 100;
        int afterComa = price % 100;

        if (integer < 10)
        {
            result.append('0');
        }
        result.append(integer).append('.');
        if (afterComa < 10)
        {
            result.append('0');
        }
        result.append(afterComa).append(" zł");

        return  result.toString();
    }
}
