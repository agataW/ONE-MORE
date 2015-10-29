package pl.wujko.one_more.frontend.datas;

import pl.wujko.map.WujkoMap;
import pl.wujko.one_more.code.constance.EntryTypeEnum;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.frontend.PizzaConstants;

import javax.swing.JPanel;
import java.util.ArrayList;
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

    public void setRightSpace(WujkoMap<JPanel, Entry> rightSpaceData)
    {
        this.rightSpace = sort(rightSpaceData.valueList());
    }

    public PanType getPanType()
    {
        return panType;
    }

    public void setPanType(PanType panType)
    {
        this.panType = panType;
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

    public LinkedList<Entry> getAllEntries()
    {
        LinkedList<Entry> entries = new LinkedList<Entry>();
        if (!leftSpace.isEmpty())
        {
            entries.addAll(leftSpace);
            entries.add(createBracket("("));
        }
        entries.addAll(wholeSpace);
        if (!rightSpace.isEmpty())
        {
            entries.add(createBracket(")"));
            entries.addAll(rightSpace);
        }
        return entries;
    }

    public int getPrice()
    {
        int result = getPanType().getPrice();
        result += price(leftSpace, 2);
        result += price(rightSpace, 2);
        result += price(wholeSpace, 1);
        return result;
    }

    private Entry createBracket(final String brand)
    {
        return new Entry()
        {
            @Override
            public EntryTypeEnum getType()
            {
                return null;
            }

            @Override
            public void setKey(String key)
            {
                super.setKey(brand);
            }
        };
    }

    private int price(LinkedList<Entry> entryList, int v)
    {
        int price = 0;
        for (Entry entry : entryList)
        {
            price += entry.getPrice();
        }
        return price / v;
    }

    public int size()
    {
        return leftSpace.size() + wholeSpace.size() + rightSpace.size();
    }

    public int usedSpaceCount()
    {
        int result = 0;
        if (!leftSpace.isEmpty())
        {
            result++;
        }
        if (!wholeSpace.isEmpty())
        {
            result++;
        }
        if (!rightSpace.isEmpty())
        {
            result++;
        }

        return result;
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

    public enum PanType
    {
        NORMAL(PizzaConstants.NORMAL_PAN),
        AMERICAN(PizzaConstants.AMERICAN_PAN);

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
