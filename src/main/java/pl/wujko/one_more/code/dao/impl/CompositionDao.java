package pl.wujko.one_more.code.dao.impl;

import pl.wujko.one_more.code.dao.Dao;
import pl.wujko.one_more.code.item.entries.Composition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agata on 2015-10-06.
 */
public class CompositionDao implements Dao<Composition>
{
    @Override
    public List<Composition> findAll()
    {
        //todo
        List<Composition> list = new ArrayList<Composition>();

        for (int i = 1; i <= 16; ++i)
        {
            Composition composition = new Composition();
            composition.setKey("Gotowiec " + i);
            list.add(composition);
        }

        return list;
    }
}
