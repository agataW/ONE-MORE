package pl.wujko.one_more.code.service;

import pl.wujko.one_more.code.constance.AdditionEnum;
import pl.wujko.one_more.code.constance.TableEnum;
import pl.wujko.one_more.code.constance.ToppingEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agata on 2015-05-14.
 */
public class DatabaseService
{
    private Statement statement;

    public Statement getStatement()
    {
        if (statement == null)
        {
            try
            {
                Class.forName("org.sqlite.JDBC");

                Connection connection = DriverManager.getConnection("jdbc:sqlite:one-more.db");
                statement = connection.createStatement();

                createTablesIfNotExist();
            }
            catch (Exception e)
            {
                return null;
            }
        }
        return statement;
    }

    private void createTablesIfNotExist() throws SQLException
    {
        for (TableEnum table : TableEnum.values())
        {
            try
            {
                statement.executeQuery("SELECT * FROM " + table);
            }
            catch (SQLException e)
            {
                createTable(table);
            }
        }
    }

    private void createTable(TableEnum table) throws SQLException
    {
        switch (table)
        {
            case TOPPING:
                createTableTopping();
                fillTableToppingDefaultValues();
            case ADDITION:
                createTableAddition();
                fillTableAdditionsDefaultValues();
        }
    }

    private void createTableTopping() throws SQLException
    {
        StringBuilder query = new StringBuilder()
            .append("CREATE TABLE ").append(TableEnum.TOPPING).append(" (")
            .append(ToppingEnum.ID)             .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
            .append(ToppingEnum.NAME)           .append(" VARCHAR(20) NOT NULL, ")
            .append(ToppingEnum.KEY)            .append(" VARCHAR(8) NOT NULL, ")
            .append(ToppingEnum.PRICE)          .append(" INTEGER NOT NULL, ")
            .append(ToppingEnum.PRIORITY)       .append(" INTEGER, ")
            .append(ToppingEnum.IS_LIMITED)     .append(" BOOLEAN, ")
            .append(ToppingEnum.IMAGE)          .append(" TEXT,")
            .append(ToppingEnum.FONT_COLOR)     .append(" VARCHAR(6), ")
            .append(ToppingEnum.BACKGROUND_COLOR)   .append(" VARCHAR(6))");
        statement.executeUpdate(query.toString());
    }

    private void fillTableToppingDefaultValues() throws SQLException
    {
        String query = new StringBuilder()
            .append("INSERT INTO ").append(TableEnum.TOPPING).append(" (")
            .append(ToppingEnum.NAME)       .append(", ")
            .append(ToppingEnum.KEY)        .append(", ")
            .append(ToppingEnum.PRICE)      .append(", ")
            .append(ToppingEnum.PRIORITY)   .append(", ")
            .append(ToppingEnum.IS_LIMITED) .append(", ")
            .append(ToppingEnum.IMAGE)      .append(", ")
            .append(ToppingEnum.FONT_COLOR) .append(", ")
            .append(ToppingEnum.BACKGROUND_COLOR).append(")")
            .append(" VALUES ").toString();

        List<String> list = new ArrayList<String>();
        list.add("('PIECZARKI',          '1',  70,   10, 1, 'img/pieczarki.png',         'ffffff', 'ff0000')");
        list.add("('CEBULA',             '2',  30,   20, 1, 'img/cebula.png',            'ffffff', 'ff0000')");
        list.add("('SALAMI_PEPERONI',    '3',  110,  50, 1, 'img/pepperoni.png',         '000000', 'ffff00')");
        list.add("('SALAMI',             '4',  110,  60, 1, 'img/salami.png',            '000000', 'ffff00')");
        list.add("('PAPRYKA',            '5',  80,  120, 1, 'img/papryka.png',           'ffffff', '14c814')");
        list.add("('KUKURYDZA',          '6',  70,  150, 1, 'img/kukurydza.png',         'ffffff', '14c814')");
        list.add("('ANANAS',             '7',  110, 130, 1, 'img/ananas.png',            'ffffff', '14c814')");
        list.add("('SZYNKA',             '8',  120,  30, 1, 'img/szynka.png',            '000000', 'ffff00')");
        list.add("('BOCZEK',             '9',  120,  40, 1, 'img/boczek.png',            '000000', 'ffff00')");
        list.add("('OLIWKI',             '10', 70,  130, 1, 'img/oliwki.png',            'ffffff', '14c814')");
        list.add("('POMIDOR',            '11', 70,  110, 1, 'img/pomidor.png',           'ffffff', '14c814')");
        list.add("('PAPRYCZKI_PEPERONI', '12', 90,  160, 1, 'img/chili.png',             'ffffff', '14c814')");
        list.add("('RUKOLA',             '13', 70,  190, 0, 'img/rukola.png',            'ffffff', '14c814')");
        list.add("('SZPINAK',            '14', 70,  200, 0, 'img/szpinak.png',           'ffffff', '14c814')");
        list.add("('KURCZAK',            '15', 270, 170, 1, 'img/kurczak.png',           '000000', 'ffff00')");
        list.add("('TUNCZYK',            '16', 260, 100, 1, 'img/tunczyk.png',           '000000', 'ffff00')");
        list.add("('BROKULY',            '17', 110,  90, 1, 'img/brokuly.png',           'ffffff', '14c814')");
        list.add("('SUSZONE_POMIDORY',   '18', 150,  70, 1, 'img/suszone_pomidory.png',  'ffffff', '14c814')");
        list.add("('SER_FETA',           '19', 160,  80, 1, 'img/feta.png',              'ffffff', '14c814')");
        list.add("('SZYNKA_PROSCIUTTO',  '20', 380, 170, 1, 'img/szynka_prosciutto.png', 'ffffff', 'ffff00')");
        list.add("('SER',                'SER', 80,   0, 0, 'img/ser.png',               'ffffff', '14c814')");

        for (String topping : list)
        {
            statement.executeUpdate(query + topping);
        }
    }

    private void createTableAddition() throws SQLException
    {
        StringBuilder query = new StringBuilder()
            .append("CREATE TABLE ").append(TableEnum.ADDITION).append(" (")
            .append(AdditionEnum.ID)             .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
            .append(AdditionEnum.NAME)           .append(" VARCHAR(20) NOT NULL, ")
            .append(AdditionEnum.KEY)            .append(" VARCHAR(8) NOT NULL, ")
            .append(AdditionEnum.PRICE)          .append(" INTEGER NOT NULL, ")
            .append(AdditionEnum.PRIORITY)       .append(" INTEGER, ")
            .append(AdditionEnum.IMAGE)          .append(" TEXT,")
            .append(AdditionEnum.FONT_COLOR)     .append(" VARCHAR(6), ")
            .append(AdditionEnum.BACKGROUND_COLOR)   .append(" VARCHAR(6))");
        statement.executeUpdate(query.toString());
    }

    private void fillTableAdditionsDefaultValues() throws SQLException
    {
        String query = new StringBuilder()
            .append("INSERT INTO ").append(TableEnum.ADDITION).append(" (")
            .append(AdditionEnum.NAME)       .append(", ")
            .append(AdditionEnum.KEY)        .append(", ")
            .append(AdditionEnum.PRICE)      .append(", ")
            .append(AdditionEnum.PRIORITY)   .append(", ")
            .append(AdditionEnum.IMAGE)      .append(", ")
            .append(AdditionEnum.FONT_COLOR) .append(", ")
            .append(AdditionEnum.BACKGROUND_COLOR).append(")")
            .append(" VALUES ").toString();

        List<String> list = new ArrayList<String>();
        list.add("('CZOSNKOWY',    'X',  160, 10, 'img/czosnkowy.png',  'ffffff', '3282ff')");
        list.add("('POMIDOROWY',   'Y',  160, 20, 'img/pomidorowy.png', 'ffffff', '3282ff')");
        list.add("('PIEKIELNY',    'Z',  200, 30, 'img/piekielny.png',  'ffffff', '3282ff')");
        list.add("('BBQ',          'Q',  240, 40, 'img/bbq.png',        'ffffff', '3282ff')");
        list.add("('OIL_1',     'OIL1',  190, 50, 'img/oil.png',        '000000', 'ffffff')");
        list.add("('OIL_2',     'OIL2',  190, 60, 'img/oil2.png',       'ffffff', '000000')");
        list.add("('COLA',       'COL',  400, 70, 'img/cola.png',       'ffffff', '8c3c00')");
        list.add("('PEPSI',      'PEP',  400, 80, 'img/pepsi.png',      'ffffff', '8c3c00')");

        for (String addition : list)
        {
            statement.executeUpdate(query + addition);
        }
    }
}
