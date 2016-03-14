package pl.wujko.one_more.code.dao;

import pl.wujko.one_more.code.service.DatabaseService;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Agata on 2016-03-09.
 */
public class PropertyDao
{
	public static final String VALUE = "value";

	@Resource
	private DatabaseService databaseService;

	public List<String> getProperty(String key, String splitter)
	{
		try
		{
			ResultSet resultSet = databaseService.executeQuery("SELECT * FROM PROPERTY WHERE KEY LIKE '" + key + "'");

			resultSet.next();
			String value = resultSet.getString(VALUE);
			String[] split = value.split(splitter);
			return Arrays.asList(split);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
