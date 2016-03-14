package pl.wujko.one_more.code.service;

import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by Agata on 2015-05-14.
 */
public class DatabaseService
{
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
				System.err.println("Zaczynam import bazy danych...");
				importSQL(SCRIPT_PATH);
				System.err.println("Dane zaimportowane!");
			}
		}
		catch (SQLException e)
		{
			System.err.println("\nBłąd importowania do bazy danych! : " + e.getMessage());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private boolean checkIfMustImportDefaultDatabase() throws SQLException
	{
		return true; //TODO
//		ResultSet resultSet = executeQuery("SELECT * FROM PROPERTY");
//		return !resultSet.next();
	}

	private void importSQL(String filepath) throws SQLException
	{
		InputStream fis;
		try
		{
			fis = ClassLoader.getSystemResourceAsStream(filepath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
		}

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
			e.printStackTrace();
			return null;
		}
	}
}
