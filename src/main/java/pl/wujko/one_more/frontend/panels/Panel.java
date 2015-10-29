package pl.wujko.one_more.frontend.panels;

import javax.swing.JPanel;

/**
 * Created by Agata on 2015-10-05.
 */
public abstract class Panel extends JPanel
{
    private boolean refresh = true;

    public Panel getPanel()
    {
        if (refresh)
        {
            initButtonsAndLabels();
            initPanel();
            refresh = false;
        }
        return this;
    }

    public void initButtonsAndLabels() {}

    public abstract void initPanel();
}
