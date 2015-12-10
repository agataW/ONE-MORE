package pl.wujko.one_more.frontend.panels.food.workshop;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import pl.wujko.map.WujkoMap;
import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.code.item.entries.Topping;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.controller.WorkshopController;
import pl.wujko.one_more.frontend.panels.entry.EntryPanel;
import pl.wujko.one_more.frontend.panels.food.ToppingAndAdditionPanel;
import pl.wujko.one_more.frontend.utils.FormLayoutUtils;

import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * Created by Agata on 2015-10-14.
 */
public class SpacePanel extends JPanel
{
    private DefaultFormBuilder builder;

    private CellConstraints cc;

    private int maxColumn;

    private int currentColumn;

    private WujkoMap<JPanel, Entry> entryMap;

    private Space space;

    public SpacePanel(Space space)
    {
        this.space = space;
        entryMap = new WujkoMap<JPanel, Entry>();

        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:m"));

        cc = new CellConstraints();
        initBuilder();

        maxColumn = space.getColumn() * 2 - 1;
    }

    public void addEntry(Entry entry)
    {
        if (currentColumn <= maxColumn)
        {
            EntryPanel panel = new EntryPanel(entry);
            panel.addMouseListener(createMouseListener(panel));
            addPanel(panel);

            entryMap.put(panel, entry);
            getToppingAndAdditionPanel().setButtonDisable(getCountOfLimitedEntries() < space.getLimit());
        }
    }

    public List<Entry> getEntries()
    {
        return entryMap.valueList();
    }

    public void clearSpace()
    {
        entryMap.clear();
        repaintSpace();
    }

    @Override
    public void setBorder(Border border)
    {
        try
        {
            getToppingAndAdditionPanel().setButtonDisable(getCountOfLimitedEntries() < space.getLimit());
        }
        catch (NullPointerException e)
        {
            //
        }
        super.setBorder(border);
    }

    private int getCountOfLimitedEntries()
    {
        int count = 0;

        for (Entry entry : entryMap.valueList())
        {
            if (((Topping)entry).isLimited())
            {
                ++count;
            }
        }
        return count;
    }

    private void repaintSpace()
    {
        removeAll();
        initBuilder();

        if (entryMap.isEmpty())
        {
            repaint();
            revalidate();
            return;
        }
        for (JPanel jPanel : entryMap.keyList())
        {
            addPanel(jPanel);
        }
        getToppingAndAdditionPanel().setButtonDisable(getCountOfLimitedEntries() < space.getLimit());
    }

    private void initBuilder()
    {
        currentColumn = 1;
        FormLayout layout = FormLayoutUtils.createDefaultFoodLayout(space.getColumn(), 1);
        builder = new DefaultFormBuilder(layout);
    }

    private void addPanel(JPanel panel)
    {
        builder.add(panel, cc.xy(currentColumn, 1));
        currentColumn += 2;

        add(builder.getPanel(), cc.xy(1, 1));
        revalidate();
    }

    private void removeEntry(JPanel panel)
    {
        if (panel != null)
        {
            entryMap.remove(panel);
        }
        repaintSpace();
    }

    private MouseListener createMouseListener(final JPanel panel)
    {
        final SpacePanel spacePanel = this;
        return new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                getWorkshopController().removeFromSpace(spacePanel, entryMap.get(panel));
                removeEntry(panel);
                getToppingAndAdditionPanel().setButtonDisable(getCountOfLimitedEntries() < space.getLimit());
            }
        };
    }

    private WorkshopController getWorkshopController()
    {
        return (WorkshopController) BeanHelper.getBean("workshopController");
    }

    private ToppingAndAdditionPanel getToppingAndAdditionPanel()
    {
        return (ToppingAndAdditionPanel) BeanHelper.getBean("toppingAndAdditionPanel");
    }

    public enum Space
    {
        HALF(6, 3),
        WHOLE(8, 5);

        private int column;

        private int limit;

        Space(int column, int limit)
        {
            this.column = column;
            this.limit = limit;
        }

        public int getColumn()
        {
            return column;
        }

        public int getLimit()
        {
            return limit;
        }
    }
}
