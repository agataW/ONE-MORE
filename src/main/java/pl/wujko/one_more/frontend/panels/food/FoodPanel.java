package pl.wujko.one_more.frontend.panels.food;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.panels.Panel;
import pl.wujko.one_more.frontend.panels.food.workshop.WorkshopPanel;

import javax.annotation.Resource;

/**
 * Created by Agata on 2015-06-30.
 */
public class FoodPanel extends Panel
{
    @Resource
    private ChoosePanelPanel choosePanelPanel;

    @Resource
    private WorkshopPanel workshopPanel;

    @Resource(name="itemsPanel")
    private Panel selectedPanel;

    @Override
    public void initPanel()
    {
        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:p:g"));

        FormLayout formLayout = new FormLayout("f:p:g", "f:m, 5dlu, f:p:g, 10dlu, f:p");
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
        CellConstraints cc = new CellConstraints();

        builder.add(choosePanelPanel.getPanel(), cc.rc(1, 1));
        builder.add(selectedPanel.getPanel(), cc.rc(3, 1));
        builder.add(workshopPanel.getPanel(), cc.rc(5, 1));

        add(builder.getPanel(), cc.xy(1, 1));
    }

    public void setSelectedPanel(Panel selectedPanel)
    {
        this.selectedPanel = selectedPanel;
        removeAll();
        initPanel();
        revalidate();
    }

    public void refresh()
    {
        revalidate();
    }
}
