package pl.wujko.one_more.code.item;

import pl.wujko.one_more.code.constance.EntryTypeEnum;
import pl.wujko.one_more.code.constance.PizzaConstants;

import java.util.List;

/**
 * Created by Agata on 2015-06-25.
 */
@Deprecated
public class CartEntry {
    private Cart cart;
    private List<Entry> entryList;
    private int price;
    private EntryTypeEnum type;

    public CartEntry(Cart cart, List<Entry> entryList) {
        this.cart = cart;
        this.entryList = entryList;
        setEntryType();
    }

    public int getPrice() {
        recalculatePrice();//musi zostać w tym miejscu!
        return price;
    }

    private void recalculatePrice()
    {
        price = 0;
        for (Entry entry : entryList)
        {
            price += entry.getPrice();
        }
        if (isPizza() && cart.useDiscount())
        {
            price -= PizzaConstants.PIZZA_DISCOUNT;
        }
    }

    public boolean isPizza() {
        return type.equals(EntryTypeEnum.TOPPINGS)
            || type.equals(EntryTypeEnum.COMPOSITION);
    }

    private void setEntryType() {
        if (!entryList.isEmpty())
        {
            this.type = entryList.get(0).getType();
        }
    }
}
