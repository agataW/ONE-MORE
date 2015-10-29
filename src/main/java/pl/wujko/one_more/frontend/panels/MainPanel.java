package pl.wujko.one_more.frontend.panels;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.MainFrame;
import pl.wujko.one_more.frontend.panels.cart.CartListPanel;
import pl.wujko.one_more.frontend.panels.food.FoodPanel;

import javax.annotation.Resource;
import javax.swing.JScrollPane;
import java.awt.Dimension;

/**
 * Created by Agata on 2015-06-30.
 */
public class MainPanel extends Panel
{
    @Resource
    private CartListPanel cartListPanel;

    @Resource
    private FoodPanel foodPanel;

    @Resource
    private MainOptionsPanel optionsPanel;

    public void initPanel()
    {
        int height = MainFrame.HEIGHT - 100;

        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        FormLayout layout = new FormLayout(
            "5dlu, f:40dlu:g(0.5), 5dlu, f:40dlu:g(0.5), 5dlu",
            "5dlu, f:"+height+", 5dlu, f:m, 2dlu");
        DefaultFormBuilder builder = new DefaultFormBuilder(layout);
        CellConstraints cc = new CellConstraints();

        JScrollPane scrollPane = new JScrollPane(cartListPanel.getPanel());
        scrollPane.setBorder(null);
        scrollPane.setAutoscrolls(true);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setMaximumSize(new Dimension(10, 45));

//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
// SETTING SCHEME FOR HORIZONTAL BAR
        builder.add(scrollPane, cc.xy(2, 2));
        builder.add(foodPanel.getPanel(), cc.xy(4, 2));
        builder.add(optionsPanel.getPanel(), cc.xyw(2, 4, 3));

        setLayout(new FormLayout("f:p:g", "f:p:g"));
        add(builder.getPanel(), cc.xy(1, 1));
    }
}
