package pl.wujko.one_more.frontend.datas;

import org.apache.commons.collections.CollectionUtils;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.code.item.entries.Topping;
import pl.wujko.one_more.code.constance.PizzaConstants;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.interfaces.SpaceList;
import pl.wujko.one_more.frontend.panels.food.workshop.SpacePanel;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Agata on 2015-10-25.
 */
public class WorkshopData
{
    private SpaceList<Entry> leftSpace;

    private SpaceList<Entry> wholeSpace;

    private SpaceList<Entry> rightSpace;

    private PanType panType;

    private PanSize panSize;

    public WorkshopData()
    {
        leftSpace = new SpaceList<Entry>(SpacePanel.Space.HALF);
        rightSpace = new SpaceList<Entry>(SpacePanel.Space.HALF);
        wholeSpace = new SpaceList<Entry>(SpacePanel.Space.WHOLE);
        panType = PanType.NORMAL;
        panSize = PanSize.NORMAL;
    }

    public LinkedList<Entry> getAllEntries()
    {
        LinkedList<Entry> entries = new LinkedList<Entry>();
        if (CollectionUtils.isNotEmpty(leftSpace))
        {
            entries.addAll(leftSpace);
            entries.add(createEntry("("));
        }
        entries.addAll(wholeSpace);
        if (CollectionUtils.isNotEmpty(rightSpace))
        {
            entries.add(createEntry(")"));
            entries.addAll(rightSpace);
        }

        if (!entries.isEmpty() && !panType.equals(PanType.NO_PANE))
        {
            Entry panEntry;
            if (panType.equals(PanType.AMERICAN))
            {
                panEntry = createEntry("AM");
            }
            else
            {
                panEntry = createEntry("CL");
            }

            if (panSize.equals(PanSize.SIZE_35))
            {
                panEntry.setBackgroundColor(GUIConstants.PAN_SIZE_35_BACKGROUND);
            }
            entries.add(0, panEntry);
        }

        return entries;
    }

    public int getPrice()
    {
        int result = 0;
        result += price(leftSpace, 2);
        result += price(rightSpace, 2);
        result += price(wholeSpace, 1);

        if (result % 10 == 5)
        {
            result -= 5;
        }
        return result == 0 ? 0 : result + getPanType().getPrice();
    }

    private Entry createEntry(final String brand)
    {
        Entry entry = new Topping();
        entry.setKey(brand);
        entry.setBackgroundColor("FFFFFF");
        entry.setFontColor("000000");
        return entry;
    }

    private int price(LinkedList<Entry> entryList, int v)
    {
        if (CollectionUtils.isEmpty(entryList))
        {
            return 0;
        }
        int price = 0;
        if (panSize.equals(PanSize.SIZE_35))
        {
            for (Entry entry : entryList)
            {
                price += ((Topping) entry).getPrice35();
            }
        }
        else
        {
            for (Entry entry : entryList)
            {
                price += entry.getPrice();
            }
        }
        return price / v;
    }

    public void addToWholeSpace(Entry entry)
    {
        addToSpace(wholeSpace, entry);
    }

    public void addToLeftSpace(Entry entry)
    {
        addToSpace(leftSpace, entry);
    }

    public void addToRightSpace(Entry entry)
    {
        addToSpace(rightSpace, entry);
    }

    public int size()
    {
        return getAllEntries().size();
    }

    private void addToSpace(SpaceList<Entry> space, List<Entry> entries)
    {
        for (Entry entry : entries)
        {
            addToSpace(space, entry);
        }
    }

    private void addToSpace(SpaceList<Entry> space, Entry entry)
    {
        if (entry instanceof Addition)
        {
            space.add(entry);
            return;
        }

        if (space.getSpace().getColumn() == space.size() || ((Topping) entry)
            .isLimited() && space.getSpace().getLimit() == countContainedLimitedTopping(space))
        {
            return;
        }

        for (Entry spaceElement : space)
        {
            if (spaceElement.getPriority() > entry.getPriority())
            {
                space.add(space.indexOf(spaceElement), entry);
                return;
            }
        }
        space.add(entry);
    }

    private int countContainedLimitedTopping(SpaceList<Entry> space)
    {
        int count = 0;

        for (Entry entry : space)
        {
            if (((Topping) entry).isLimited())
            {
                ++count;
            }
        }

        return count;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public boolean isPizza()
    {
        return !panType.equals(PanType.NO_PANE);
    }

    public void setWholeSpace(LinkedList<Entry> list)
    {
        addToSpace(wholeSpace, list);
    }

    public LinkedList<Entry> getLeftSpace()
    {
        return leftSpace;
    }

    public LinkedList<Entry> getWholeSpace()
    {
        return wholeSpace;
    }

    public LinkedList<Entry> getRightSpace()
    {
        return rightSpace;
    }

    public PanType getPanType()
    {
        return panType;
    }

    public void setPanType(PanType panType)
    {
        this.panType = panType;
    }

    public PanSize getPanSize()
    {
        return panSize;
    }

    public void setPanSize(PanSize panSize)
    {
        this.panSize = panSize;
    }

    public void removeFromWholeSpace(Entry entry)
    {
        wholeSpace.remove(entry);
    }

    public void removeFromLeftSpace(Entry entry)
    {
        leftSpace.remove(entry);
    }


    public void removeFromRightSpace(Entry entry)
    {
        rightSpace.remove(entry);
    }

    public enum PanType
    {
        NORMAL(PizzaConstants.NORMAL_PAN),
        AMERICAN(PizzaConstants.AMERICAN_PAN),
        NO_PANE(0);

        private int price;

        PanType(int price)
        {
            this.price = price;
        }

        public int getPrice()
        {
            return price;
        }
    }

    public enum PanSize
    {
        NO_SIZE,
        NORMAL,
        SIZE_35
    }
}
