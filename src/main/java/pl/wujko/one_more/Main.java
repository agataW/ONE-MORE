package pl.wujko.one_more;

import javax.swing.UIManager;

import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.frontend.MainFrame;
import pl.wujko.one_more.thread.TimerThread;

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
        TimerThread timerThread = new TimerThread();
        timerThread.start();
    }
}
