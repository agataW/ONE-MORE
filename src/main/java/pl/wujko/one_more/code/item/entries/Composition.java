package pl.wujko.one_more.code.item.entries;

import pl.wujko.one_more.code.constance.EntryTypeEnum;
import pl.wujko.one_more.code.item.Entry;

import java.util.List;

/**
 * Created by Agata on 2015-10-06.
 */
public class Composition extends Entry
{
    private List<Topping> toppingList;

    public List<Topping> getToppingList()
    {
        return toppingList;
    }

    public void setToppingList(List<Topping> toppingList)
    {
        this.toppingList = toppingList;
    }

    @Override
    public EntryTypeEnum getType()
    {
        return EntryTypeEnum.COMPOSITION;
    }
}
