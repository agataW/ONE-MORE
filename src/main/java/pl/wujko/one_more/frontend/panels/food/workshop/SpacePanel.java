package pl.wujko.one_more.frontend.panels.food.workshop;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import pl.wujko.map.WujkoMap;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.panels.entry.EntryPanel;
import pl.wujko.one_more.frontend.utils.FormLayoutUtils;

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Agata on 2015-10-14.
 */
public class SpacePanel extends JPanel
{
    private DefaultFormBuilder builder;

    private FormLayout layout;

    private CellConstraints cc;

    private int maxColumn;

    private int currentColumn;

    private WujkoMap<JPanel, Entry> entryMap;

    public SpacePanel(Space space)
    {
        entryMap = new WujkoMap<JPanel, Entry>();

        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:m"));

        layout = FormLayoutUtils.createDefaultFoodLayout(space.getColumn(), 1);
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
        }
    }

    public WujkoMap<JPanel, Entry> getEntriesMap()
    {
        WujkoMap<JPanel, Entry> wujkoMap = new WujkoMap<JPanel, Entry>(entryMap);
        entryMap.clear();
        removeEntry(null);
        return wujkoMap;
    }

    private void initBuilder()
    {
        currentColumn = 1;
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
    }

    private MouseListener createMouseListener(final JPanel panel)
    {
        return new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e)
            {
                removeEntry(panel);
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
    }

    public enum Space
    {
        HALF(4),
        WHOLE(8);

        private int column;

        Space(int column)
        {
            this.column = column;
        }

        public int getColumn()
        {
            return column;
        }
    }
}
