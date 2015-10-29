package pl.wujko.one_more.frontend;

import pl.wujko.one_more.frontend.panels.MainPanel;

import javax.annotation.Resource;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;

/**
 * Created by Agata on 2015-06-30.
 */
public class MainFrame extends JFrame
{
    @Resource
    private MainPanel mainPanel;

    public static final int WIDTH = 1024;

    public static final int HEIGHT = 768;

    public void initFrame()
    {
        setTitle(GUIConstants.FRAME_TITLE);
        setSize(WIDTH, HEIGHT);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        setContentPane(mainPanel.getPanel());
        pack();
    }
}
