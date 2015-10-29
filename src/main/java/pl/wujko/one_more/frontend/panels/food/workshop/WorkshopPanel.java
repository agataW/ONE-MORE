package pl.wujko.one_more.frontend.panels.food.workshop;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import pl.wujko.map.WujkoMap;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.datas.WorkshopData;
import pl.wujko.one_more.frontend.panels.Panel;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Agata on 2015-10-05.
 */
public class WorkshopPanel extends Panel
{
    private SpacePanel leftSpace;

    private SpacePanel rightSpace;

    private SpacePanel wholeSpace;

    private SpacePanel selectedSpace;

    private JButton americanPan;

    private JButton normalPan;

    @Override
    public void initPanel()
    {
        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:m"));

        FormLayout layout = new FormLayout(
            "f:p:g, f:p:g, 2dlu, f:m, 2dlu",
            "2dlu, f:40dlu:g, 2dlu, f:40dlu:g, 2dlu");
        DefaultFormBuilder builder = new DefaultFormBuilder(layout);
        CellConstraints cc = new CellConstraints();

        builder.add(leftSpace, cc.xywh(1, 1, 1, 3));
        builder.add(rightSpace, cc.xywh(2, 1, 1, 3));
        builder.add(wholeSpace, cc.xywh(1, 4, 2, 2));

        builder.add(americanPan, cc.xy(4, 2));
        builder.add(normalPan, cc.xy(4, 4));

        add(builder.getPanel(), cc.xy(1, 1));
    }

    public void initButtonsAndLabels()
    {
        americanPan = new JButton("AM PAN");
        americanPan.setFont(GUIConstants.DEFAULT_FONT);
        americanPan.addActionListener(createActionListener(americanPan));
        americanPan.setEnabled(false);

        normalPan = new JButton("NORMAL");
        normalPan.setFont(GUIConstants.DEFAULT_FONT);
        normalPan.addActionListener(createActionListener(normalPan));

        leftSpace = new SpacePanel(SpacePanel.Space.HALF);
        leftSpace.setBackground(GUIConstants.WORKSPACE_PANEL_BACKGROUND);
        leftSpace.addMouseListener(createMouseListener(leftSpace));

        rightSpace = new SpacePanel(SpacePanel.Space.HALF);
        rightSpace.setBackground(GUIConstants.WORKSPACE_PANEL_BACKGROUND);
        rightSpace.addMouseListener(createMouseListener(rightSpace));

        wholeSpace = new SpacePanel(SpacePanel.Space.WHOLE);
        wholeSpace.setBackground(GUIConstants.WORKSPACE_PANEL_BACKGROUND);
        wholeSpace.addMouseListener(createMouseListener(wholeSpace));
        selectSpace(wholeSpace);
    }

    public void addEntry(Entry entry)
    {
        selectedSpace.addEntry(entry);
    }

    public WujkoMap<JPanel, Entry> getLeftSpaceData()
    {
        return leftSpace.getEntriesMap();
    }

    public WujkoMap<JPanel, Entry> getWholeSpaceData()
    {
        return wholeSpace.getEntriesMap();
    }


    public WujkoMap<JPanel, Entry> getRightSpaceData()
    {
        return rightSpace.getEntriesMap();
    }

    public WorkshopData.PanType getPan()
    {
        if (americanPan.isEnabled())
        {
            return WorkshopData.PanType.AMERICAN;
        }
        return WorkshopData.PanType.NORMAL;
    }

    private void selectPan(JButton button)
    {
        americanPan.setEnabled(true);
        normalPan.setEnabled(true);
        button.setEnabled(false);
    }

    private void selectSpace(SpacePanel space)
    {
        leftSpace.setBorder(GUIConstants.WORKSPACE_BORDER_BLACK);
        rightSpace.setBorder(GUIConstants.WORKSPACE_BORDER_BLACK);
        wholeSpace.setBorder(GUIConstants.WORKSPACE_BORDER_BLACK);
        space.setBorder(GUIConstants.WORKSPACE_BORDER);

        selectedSpace = space;
    }

    private ActionListener createActionListener(final JButton button)
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectPan(button);
            }
        };
    }

    private MouseListener createMouseListener(final SpacePanel space)
    {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e)
            {
                selectSpace(space);
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
    }
}
