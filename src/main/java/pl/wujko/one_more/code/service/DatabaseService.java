package pl.wujko.one_more.code.service;

import org.apache.log4j.Logger;

import java.io.IOError;
import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by Agata on 2015-05-14.
 */
public class DatabaseService
{
	private static Logger LOG = Logger.getLogger(DatabaseService.class);

	private static final String SCRIPT_PATH = "script.sql";

	private static final String DATABASE_NAME = "one-more";

	private Statement statement;

	public DatabaseService()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");

			Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_NAME + ".db");
			statement = connection.createStatement();

			if (checkIfMustImportDefaultDatabase())
			{
				LOG.info("Zaczynam import bazy danych...");
				importSQL(SCRIPT_PATH);
				LOG.info("Dane zaimportowane!");
			}
		}
		catch (SQLException e)
		{
			LOG.error("Błąd importowania do bazy danych! : ", e);
		}
		catch (ClassNotFoundException e)
		{
			LOG.error("Nie znaleziono klasy! : ", e);
		}
	}

	private boolean checkIfMustImportDefaultDatabase() throws SQLException
	{
		return true; //TODO
//		ResultSet resultSet = executeQuery("SELECT * FROM PROPERTY");
//		return !resultSet.next();
	}

	private void importSQL(String filepath) throws SQLException, IOError
	{
		InputStream fis = ClassLoader.getSystemResourceAsStream(filepath);

		Scanner s = new Scanner(fis);
		s.useDelimiter("(;(\r)?\n)|(--\n)");

		while (s.hasNext())
		{
			String line = s.next();
			if (line.startsWith("/*!") && line.endsWith("*/"))
			{
				int i = line.indexOf(' ');
				line = line.substring(i + 1, line.length() - " */".length());
			}

			if (line.trim().length() > 0)
			{
				statement.execute(line);
			}
		}
	}

	public ResultSet executeQuery(String query)
	{
		try
		{
			return statement.executeQuery(query);
		}
		catch (SQLException e)
		{
			LOG.warn("Problem podczas wykonania query: " + query, e);
			return null;
		}
	}
}
