package pl.wujko.one_more.code.dao.impl;

import org.apache.log4j.Logger;
import pl.wujko.one_more.code.constance.AdditionEnum;
import pl.wujko.one_more.code.constance.TableEnum;
import pl.wujko.one_more.code.dao.Dao;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.code.service.DatabaseService;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agata on 2015-06-25.
 */
public class AdditionDao implements Dao<Addition>
{
    private static Logger LOG = Logger.getLogger(AdditionDao.class);

    @Resource
    private DatabaseService databaseService;

    public List<Addition> findAll()
    {
        try
        {
            ResultSet resultSet = databaseService.executeQuery("SELECT * FROM " + TableEnum.ADDITION);
            return convert(resultSet);
        }
        catch (SQLException e)
        {
        	LOG.error("Blad przy imporcie", e);
            return null;
        }
    }

    private List<Addition> convert(ResultSet rs) throws SQLException
    {
        List<Addition> additionList = new ArrayList<Addition>();
        while (rs.next())
        {
            Addition addition = new Addition();
            addition.setId(rs.getInt(AdditionEnum.ID.toString()));
            addition.setName(rs.getString(AdditionEnum.NAME.toString()));
            addition.setKey(rs.getString(AdditionEnum.KEY.toString()));
            addition.setPrice(rs.getInt(AdditionEnum.PRICE.toString()));
            addition.setPriority(rs.getInt(AdditionEnum.PRIORITY.toString()));
            addition.setImage(rs.getString(AdditionEnum.IMAGE.toString()));
            addition.setFontColor(rs.getString(AdditionEnum.FONT_COLOR.toString()));
            addition.setBackgroundColor(rs.getString(AdditionEnum.BACKGROUND_COLOR.toString()));
            additionList.add(addition);
        }
        return additionList;
    }
}
