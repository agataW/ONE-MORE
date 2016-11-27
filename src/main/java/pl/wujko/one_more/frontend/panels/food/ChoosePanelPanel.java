package pl.wujko.one_more.frontend.panels.food;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.controller.ChoosePanelController;
import pl.wujko.one_more.frontend.panels.Panel;

import javax.annotation.Resource;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Agata on 2015-10-05.
 */
public class ChoosePanelPanel extends Panel implements ActionListener
{
    public static final String CHOOSE_WORKSHOP = "WORKSHOP";

    public static final String CHOOSE_PACKAGE= "PACKAGE";

    @Resource
    private ChoosePanelController choosePanelController;

    private JButton workshopButton;

    private JButton packageButton;

    @Override
    public void initPanel()
    {
        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:p"));

        FormLayout formLayout = new FormLayout("f:p:g, 1dlu, f:p:g", "f:p");
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
        CellConstraints cc = new CellConstraints();

        builder.add(workshopButton, cc.rc(1, 1));
        builder.add(packageButton, cc.rc(1, 3));

        add(builder.getPanel(), cc.xy(1, 1));

        workshopButton.setEnabled(false);
    }

    @Override
    public void initButtonsAndLabels()
    {
        workshopButton = new JButton("SKLADNIKI");
        workshopButton.addActionListener(this);
        workshopButton.setFont(GUIConstants.DEFAULT_FONT);

        packageButton = new JButton("GOTOWCE");
        packageButton.addActionListener(this);
        packageButton.setFont(GUIConstants.DEFAULT_FONT);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if (source == workshopButton)
        {
            choosePanelController.chooseFoodPanel(CHOOSE_WORKSHOP);
            workshopButton.setEnabled(false);
            packageButton.setEnabled(true);
        }
        else if (source == packageButton)
        {
            choosePanelController.chooseFoodPanel(CHOOSE_PACKAGE);
            workshopButton.setEnabled(true);
            packageButton.setEnabled(false);
        }
    }
}
