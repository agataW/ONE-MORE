package pl.wujko.one_more;

import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.frontend.MainFrame;

import javax.swing.UIManager;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        try
        {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (Exception e)
        {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        MainFrame mainFrame = (MainFrame) BeanHelper.getBean("mainFrame");
        mainFrame.initFrame();

//        Statement statement = databaseService.getStatement();
//
//        try
//        {
//            statement.executeUpdate("CREATE TABLE topping (id INTEGER, name string)");
//            statement.executeUpdate("INSERT INTO topping VALUES(1, 'leo')");
//            statement.executeUpdate("INSERT INTO topping VALUES(2, 'yui')");
//            ResultSet rs = statement.executeQuery("SELECT * FROM topping");
//            while (rs.next())
//            {
//                System.out.println(rs.getObject("id") + ", " + rs.getObject("name") + ", " + rs.getObject("price"));
//            }
//        }
//        catch (SQLException e)
//        {
//            // if the error message is "out of memory",
//            // it probably means no database file is found
//            System.err.println(e.getMessage());
//        }
    }
}
