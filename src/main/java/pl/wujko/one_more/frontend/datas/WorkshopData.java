package pl.wujko.one_more.frontend.datas;

import org.apache.commons.collections.CollectionUtils;
import pl.wujko.map.WujkoMap;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.code.item.entries.Topping;
import pl.wujko.one_more.code.constance.PizzaConstants;

import javax.swing.JPanel;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Agata on 2015-10-25.
 */
public class WorkshopData
{
    private LinkedList<Entry> leftSpace;

    private LinkedList<Entry> wholeSpace;

    private LinkedList<Entry> rightSpace;

    private PanType panType;

    public void setLeftSpace(WujkoMap<JPanel, Entry> leftSpaceData)
    {
        this.leftSpace = sort(leftSpaceData.valueList());
    }

    public void setWholeSpace(WujkoMap<JPanel, Entry> wholeSpaceData)
    {
        this.wholeSpace = sort(wholeSpaceData.valueList());
    }

    public void setWholeSpace(LinkedList<Entry> list)
    {
        this.wholeSpace = list;
    }

    public void setRightSpace(WujkoMap<JPanel, Entry> rightSpaceData)
    {
        this.rightSpace = sort(rightSpaceData.valueList());
    }

    public PanType getPanType()
    {
        return panType;
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

    public void setPanType(PanType panType)
    {
        this.panType = panType;
    }

    public LinkedList<Entry> getAllEntries()
    {
        LinkedList<Entry> entries = new LinkedList<Entry>();
        if (panType.equals(PanType.AMERICAN))
        {
            entries.add(createEntry("AM"));
        }
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
        return entries;

//        LinkedList<Entry> entries = new LinkedList<Entry>();
//        if (panType.equals(PanType.AMERICAN))
//        {
//            entries.add(createEntry("AM"));
//        }
//        if (CollectionUtils.isNotEmpty(leftSpace) || CollectionUtils.isNotEmpty(rightSpace))
//        {
//            entries.addAll(leftSpace);
//            entries.add(createEntry("|"));
//            entries.addAll(rightSpace);
//        }
//        else
//        {
//            entries.addAll(wholeSpace);
//        }
//        return entries;
    }

    public int getPrice()
    {
        int result = getPanType().getPrice();
        result += price(leftSpace, 2);
        result += price(rightSpace, 2);
        result += price(wholeSpace, 1);
        return result;
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
        for (Entry entry : entryList)
        {
            price += entry.getPrice();
        }
        return price / v;
    }

    public int size()
    {
        return getAllEntries().size();
    }

    private LinkedList<Entry> sort(List<Entry> entryList)
    {
        LinkedList<Entry> resultEntries = new LinkedList<Entry>();

        int index;
        for (Entry entry : entryList)
        {
            for (index = 0; index < resultEntries.size(); ++index)
            {
                if (entry.getPriority() > resultEntries.get(index).getPriority())
                {
                    break;
                }
            }
            resultEntries.add(entry);
        }

        return resultEntries;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public boolean isPizza()
    {
        return !panType.equals(PanType.NO_PANE);
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
}
