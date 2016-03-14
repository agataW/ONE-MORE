package pl.wujko.one_more.code.dao.impl;

import org.apache.log4j.Logger;
import pl.wujko.one_more.code.constance.TableEnum;
import pl.wujko.one_more.code.dao.Dao;
import pl.wujko.one_more.code.item.entries.Composition;
import pl.wujko.one_more.code.item.entries.Topping;
import pl.wujko.one_more.code.service.DatabaseService;
import pl.wujko.one_more.code.service.ToppingService;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agata on 2015-10-06.
 */
public class CompositionDao implements Dao<Composition>
{
    private static Logger LOG = Logger.getLogger(CompositionDao.class);

    @Resource
    private DatabaseService databaseService;

    @Resource
    private ToppingService toppingService;

    @Override
    public List<Composition> findAll()
    {
        try
        {
            ResultSet resultSet = databaseService.executeQuery("SELECT * FROM " + TableEnum.COMPOSITION);
            return convert(resultSet);
        }
        catch (SQLException e)
        {
            LOG.error("Blad przy imporcie", e);
            return null;
        }
    }

    private List<Composition> convert(ResultSet rs) throws SQLException
    {
        List<Composition> additionList = new ArrayList<Composition>();
        while (rs.next())
        {
            Composition composition = new Composition();
            composition.setKey(rs.getString("key"));

            List<Topping> toppingList = new ArrayList<Topping>();
            String[] toppings = rs.getString("toppings").split(",");

            for (String toppingKey : toppings)
            {
                toppingList.add(toppingService.getByKey(toppingKey));
            }

            composition.setToppingList(toppingList);
            additionList.add(composition);
        }
        return additionList;
    }
}
