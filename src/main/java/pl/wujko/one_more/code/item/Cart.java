package pl.wujko.one_more.code.item;

import pl.wujko.one_more.code.constance.Properties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Agata on 2015-06-25.
 */
public class Cart
{
    private List<CartEntry> cartEntryList = new ArrayList<CartEntry>();
    private Date time;
    private int price = 0;
    private int pizzaCount = 0;

    public Cart()
    {
        time = new Date();
    }

    public void addToCart(CartEntry entry)
    {
        cartEntryList.add(entry);
        if (entry.isPizza())
        {
            ++pizzaCount;
        }
        recalculatePrice();
    }

    public void removeFromCart(CartEntry entry)
    {
        if (entry.isPizza())
        {
            --pizzaCount;
        }
        cartEntryList.remove(entry);
        recalculatePrice();
    }

    private void recalculatePrice()
    {
        price = 0;
        for (CartEntry entry : cartEntryList)
        {
            price += entry.getPrice();
        }
    }

    public boolean useDiscount()
    {
        return pizzaCount >= Properties.COUNT_OF_PIZZA_TO_DISCOUNT;
    }

    public int getPrice()
    {
        return price;
    }
}
