package pl.wujko.one_more.code.service.impl;

import pl.wujko.one_more.code.dao.impl.ToppingDao;
import pl.wujko.one_more.code.item.entries.Topping;
import pl.wujko.one_more.code.service.ToppingService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agata on 2015-05-18.
 */
public class ToppingServiceImpl implements ToppingService
{
    @Resource
    private ToppingDao toppingDao;

    private List<Topping> toppingList;

    @Override
    public List<Topping> findAll()
    {
        if (toppingList == null)
        {
            toppingList = toppingDao.findAll();
        }
        return toppingList;
    }

    @Override
    public List<Topping> findAllVisible()
    {
        if (toppingList == null)
        {
            findAll();
        }
        List<Topping> result = new ArrayList<Topping>(toppingList);

        for (Topping topping : toppingList)
        {
            if (!topping.isVisible())
            {
                result.remove(topping);
            }
        }

        return result;
    }

    @Override
    public Topping getByKey(String toppingKey)
    {
        if (toppingList == null){
            findAll();
        }

        for (Topping topping : toppingList)
        {
            if (topping.getKey().equals(toppingKey))
            {
                return topping;
            }
        }

        return null;
    }
}
