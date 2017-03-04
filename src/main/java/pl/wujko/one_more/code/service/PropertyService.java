package pl.wujko.one_more.code.service;

import pl.wujko.one_more.code.dao.PropertyDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Agata on 2016-03-09.
 */
public class PropertyService
{
	@Resource
	private PropertyDao propertyDao;

	public List<String> getQueueToppingsInOrder()
	{
		return propertyDao.getProperty("QUEUE_TOPPING_IN_ORDER", ",");
	}

	public List<String> getQueueToppingsInFoodPanel()
	{
		return propertyDao.getProperty("QUEUE_TOPPING_IN_FOOD_PANEL", ",");
	}

	public List<String> getAdditionsPriority()
	{
		return propertyDao.getProperty("ADDITION_PRIORITY", ",");
	}
}
