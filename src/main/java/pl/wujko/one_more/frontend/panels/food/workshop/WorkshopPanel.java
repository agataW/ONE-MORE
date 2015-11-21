package pl.wujko.one_more.frontend.panels.food.workshop;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.apache.commons.collections.CollectionUtils;
import pl.wujko.map.WujkoMap;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.code.item.entries.Composition;
import pl.wujko.one_more.code.item.entries.Topping;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.datas.WorkshopData;
import pl.wujko.one_more.frontend.panels.Panel;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * Created by Agata on 2015-10-05.
 */
public class WorkshopPanel extends Panel
{
    private SpacePanel leftSpace;

    private SpacePanel rightSpace;

    private SpacePanel wholeSpace;

    private SpacePanel selectedSpace;

    private JButton americanPanButton;

    private WorkshopData.PanType panType;

    //    private JButton normalPan;

    @Override
    public void initPanel()
    {
        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:m"));

        FormLayout layout = new FormLayout("f:p:g, f:p:g, 2dlu, f:m, 2dlu", "2dlu, f:40dlu:g, 2dlu, f:40dlu:g, 2dlu");
        DefaultFormBuilder builder = new DefaultFormBuilder(layout);
        CellConstraints cc = new CellConstraints();

        builder.add(leftSpace, cc.xywh(1, 1, 1, 3));
        builder.add(rightSpace, cc.xywh(2, 1, 1, 3));
        builder.add(wholeSpace, cc.xywh(1, 4, 2, 2));

        builder.add(americanPanButton, cc.xy(4, 2));
        //        builder.add(normalPan, cc.xy(4, 4));

        add(builder.getPanel(), cc.xy(1, 1));
    }

    public void initButtonsAndLabels()
    {
        americanPanButton = new JButton("AM PAN");
        americanPanButton.setFont(GUIConstants.DEFAULT_FONT);
        americanPanButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (panType.equals(WorkshopData.PanType.AMERICAN))
                {
                    setPanType(WorkshopData.PanType.NORMAL);
                }
                else
                {
                    setPanType(WorkshopData.PanType.AMERICAN);
                }
            }
        });

        panType = WorkshopData.PanType.NORMAL;
        setPanType(panType); // musi być po inicjalizacji americanPanButton

        //        normalPan = new JButton("NORMAL");
        //        normalPan.setFont(GUIConstants.DEFAULT_FONT);
        //        normalPan.addActionListener(createActionListener(normalPan));
        //        normalPan.setEnabled(false);

        leftSpace = new SpacePanel(SpacePanel.Space.HALF);
        leftSpace.setBackground(GUIConstants.WORKSPACE_PANEL_BACKGROUND);
        leftSpace.addMouseListener(createMouseAdapterForSpace(leftSpace));

        rightSpace = new SpacePanel(SpacePanel.Space.HALF);
        rightSpace.setBackground(GUIConstants.WORKSPACE_PANEL_BACKGROUND);
        rightSpace.addMouseListener(createMouseAdapterForSpace(rightSpace));

        wholeSpace = new SpacePanel(SpacePanel.Space.WHOLE);
        wholeSpace.setBackground(GUIConstants.WORKSPACE_PANEL_BACKGROUND);
        wholeSpace.addMouseListener(createMouseAdapterForSpace(wholeSpace));
        selectSpace(wholeSpace);
    }

    public void addEntryToWholeSpace(Composition composition)
    {
        List<Topping> toppingList = composition.getToppingList();
        if (CollectionUtils.isEmpty(toppingList))
        {
            return;
        }
        for (Topping topping : toppingList)
        {
            wholeSpace.addEntry(topping);
        }
    }


    public void editWorkshop(WorkshopData workshopData)
    {
        setPanType(workshopData.getPanType());

        if (CollectionUtils.isNotEmpty(workshopData.getWholeSpace()))
        {
            for (Entry entry : workshopData.getWholeSpace())
            {
                wholeSpace.addEntry(entry);
            }
        }

        if (CollectionUtils.isNotEmpty(workshopData.getLeftSpace()))
        {
            for (Entry entry : workshopData.getLeftSpace())
            {
                leftSpace.addEntry(entry);
            }
        }

        if (CollectionUtils.isNotEmpty(workshopData.getRightSpace()))
        {
            for (Entry entry : workshopData.getRightSpace())
            {
                rightSpace.addEntry(entry);
            }
        }
    }

    private void setPanType(WorkshopData.PanType panType)
    {
        this.panType = panType;
        changePanTypeButton(panType);
    }

    private void changePanTypeButton(WorkshopData.PanType panType)
    {
        if (panType.equals(WorkshopData.PanType.AMERICAN))
        {
            americanPanButton.setBackground(Color.GREEN);
        }
        else
        {
            americanPanButton.setBackground(Color.GRAY);
        }
    }

    public void addEntryToSelectedSpace(Entry entry)
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

    public WorkshopData.PanType getPanType()
    {
        return panType;
    }

    public void clearWorkshop()
    {
        wholeSpace.clearSpace();
        leftSpace.clearSpace();
        rightSpace.clearSpace();
        selectSpace(wholeSpace);
        setPanType(WorkshopData.PanType.NORMAL);
    }

    public void selectWholeSpace()
    {
        selectSpace(wholeSpace);
    }


    private void selectSpace(SpacePanel space)
    {
        if (space.equals(selectedSpace))
        {
            space = wholeSpace;
        }

        leftSpace.setBorder(GUIConstants.WORKSPACE_BORDER_BLACK);
        rightSpace.setBorder(GUIConstants.WORKSPACE_BORDER_BLACK);
        wholeSpace.setBorder(GUIConstants.WORKSPACE_BORDER_BLACK);
        space.setBorder(GUIConstants.WORKSPACE_BORDER);

        selectedSpace = space;
    }

    private MouseListener createMouseAdapterForSpace(final SpacePanel space)
    {
        return new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                selectSpace(space);
            }
        };
    }
}
