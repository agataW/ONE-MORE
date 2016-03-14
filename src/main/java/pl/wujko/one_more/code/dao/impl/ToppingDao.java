package pl.wujko.one_more.code.dao.impl;

import org.apache.log4j.Logger;
import pl.wujko.one_more.code.constance.TableEnum;
import pl.wujko.one_more.code.constance.ToppingEnum;
import pl.wujko.one_more.code.dao.Dao;
import pl.wujko.one_more.code.item.entries.Topping;
import pl.wujko.one_more.code.service.DatabaseService;
import pl.wujko.one_more.code.service.PropertyService;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Agata on 2015-05-15.
 */
public class ToppingDao implements Dao<Topping>
{
	private static Logger LOG = Logger.getLogger(ToppingDao.class);

	@Resource
	private DatabaseService databaseService;

	@Resource
	private PropertyService propertyService;

	@Override
	public List<Topping> findAll()
	{
		try
		{
			List<String> queueToppingsInOrder = propertyService.getQueueToppingsInOrder();
			List<String> queueToppingsInFoodPanel = propertyService.getQueueToppingsInFoodPanel();
			ResultSet resultSet = databaseService.executeQuery("SELECT * FROM " + TableEnum.TOPPING);
			return convert(resultSet, queueToppingsInOrder, queueToppingsInFoodPanel);
		}
		catch (SQLException e)
		{
			LOG.error("Blad przy imporcie", e);
			return null;
		}
	}

	private List<Topping> convert(ResultSet rs, List<String> queueToppingsInOrder,
								  final List<String> queueToppingsInFoodPanel) throws SQLException
	{
		List<Topping> resultList = new ArrayList<Topping>();

		while (rs.next())
		{
			Topping topping = new Topping();
			topping.setName(rs.getString(ToppingEnum.NAME.toString()));
			topping.setKey(rs.getString(ToppingEnum.KEY.toString()));
			topping.setPrice(rs.getInt(ToppingEnum.PRICE.toString()));
			topping.setPrice35(rs.getInt(ToppingEnum.PRICE35.toString()));
			topping.setLimited(rs.getBoolean(ToppingEnum.IS_LIMITED.toString()));
			topping.setImage(rs.getString(ToppingEnum.IMAGE.toString()));
			topping.setFontColor(rs.getString(ToppingEnum.FONT_COLOR.toString()));
			topping.setBackgroundColor(rs.getString(ToppingEnum.BACKGROUND_COLOR.toString()));
			topping.setVisible(rs.getBoolean(ToppingEnum.VISIBLE.toString()));

			int priority = queueToppingsInOrder.indexOf(topping.getKey());
			if (queueToppingsInOrder.indexOf(topping.getKey()) == -1)
			{
				topping.setPriority(99);
			}
			else
			{
				topping.setPriority(priority);
			}

			resultList.add(topping);
		}

		Collections.sort(resultList, new Comparator<Topping>()
		{
			@Override
			public int compare(Topping topping1, Topping topping2)
			{
				int index1 = queueToppingsInFoodPanel.indexOf(topping1.getKey());
				int index2 = queueToppingsInFoodPanel.indexOf(topping2.getKey());

				if (index1 == -1 && index2 != -1)
				{
					return 1;
				}
				if (index1 != -1 && index2 == -1)
				{
					return -1;
				}

				return index1 - index2;
			}
		});

		return resultList;
	}
}
