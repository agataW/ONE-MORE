package pl.wujko.one_more.code.dao.impl;

import org.apache.log4j.Logger;
import pl.wujko.one_more.code.constance.AdditionEnum;
import pl.wujko.one_more.code.constance.TableEnum;
import pl.wujko.one_more.code.dao.Dao;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.code.service.DatabaseService;
import pl.wujko.one_more.code.service.PropertyService;
import pl.wujko.one_more.frontend.GUIConstants;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Agata on 2015-06-25.
 */
public class AdditionDao implements Dao<Addition>
{
    private static Logger LOG = Logger.getLogger(AdditionDao.class);

    @Resource
    private DatabaseService databaseService;

    @Resource
    private PropertyService propertyService;

    public List<Addition> findAll()
    {
        try
        {
            List<String> additionsPriority = propertyService.getAdditionsPriority();
            ResultSet resultSet = databaseService.executeQuery("SELECT * FROM " + TableEnum.ADDITION);
            return convert(resultSet, additionsPriority);
        }
        catch (SQLException e)
        {
        	LOG.error("Blad przy imporcie", e);
            return null;
        }
    }

    private List<Addition> convert(ResultSet rs, final List<String> additionsPriority) throws SQLException
    {
        List<Addition> additionList = new ArrayList<Addition>();
        while (rs.next())
        {
            Addition addition = new Addition();
            addition.setName(rs.getString(AdditionEnum.NAME.toString()));
            addition.setKey(rs.getString(AdditionEnum.KEY.toString()));
            addition.setPrice(rs.getInt(AdditionEnum.PRICE.toString()));
            addition.setImage(rs.getString(AdditionEnum.IMAGE.toString()));
            addition.setFontColor(GUIConstants.Additions.FONT_COLOUR);
            addition.setBackgroundColor(GUIConstants.Additions.BACKGROUND_COLOR);

            int priority = additionsPriority.indexOf(addition.getKey());
            if (priority == -1)
            {
                addition.setPriority(99);
            }
            else
            {
                addition.setPriority(priority);
            }

            additionList.add(addition);
        }

        Collections.sort(additionList, new Comparator<Addition>()
        {
            @Override
            public int compare(Addition addition1, Addition addition2)
            {
                return addition1.getPriority() - addition2.getPriority();
            }
        });
        return additionList;
    }
}
