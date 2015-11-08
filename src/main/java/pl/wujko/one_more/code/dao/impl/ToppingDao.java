package pl.wujko.one_more.code.dao.impl;

import pl.wujko.one_more.code.constance.TableEnum;
import pl.wujko.one_more.code.constance.ToppingEnum;
import pl.wujko.one_more.code.dao.Dao;
import pl.wujko.one_more.code.item.entries.Topping;
import pl.wujko.one_more.code.service.DatabaseService;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agata on 2015-05-15.
 */
public class ToppingDao implements Dao<Topping>
{
    @Resource
    private DatabaseService databaseService;

    public List<Topping> findAll() {
        try
        {
            ResultSet resultSet = databaseService.getStatement()
                .executeQuery("SELECT * FROM " + TableEnum.TOPPING);
            return convert(resultSet);
        }
        catch (SQLException e)
        {
            return null;
        }
    }

    private List<Topping> convert(ResultSet rs) {
        List<Topping> toppingList = new ArrayList<Topping>();
        try
        {
            while (rs.next())
            {
                Topping topping = new Topping();
                topping.setId(rs.getInt(ToppingEnum.ID.toString()));
                topping.setName(rs.getString(ToppingEnum.NAME.toString()));
                topping.setKey(rs.getString(ToppingEnum.KEY.toString()));
                topping.setPrice(rs.getInt(ToppingEnum.PRICE.toString()));
                topping.setPriority(rs.getInt(ToppingEnum.PRIORITY.toString()));
                topping.setLimited(rs.getBoolean(ToppingEnum.IS_LIMITED.toString()));
                topping.setImage(rs.getString(ToppingEnum.IMAGE.toString()));
                topping.setFontColor(rs.getString(ToppingEnum.FONT_COLOR.toString()));
                topping.setBackgroundColor(rs.getString(ToppingEnum.BACKGROUND_COLOR.toString()));
                topping.setVisible(rs.getBoolean(ToppingEnum.VISIBLE.toString()));
                toppingList.add(topping);
            }
        }
        catch (SQLException e)
        {
            return null;
        }
        return toppingList;
    }
}
