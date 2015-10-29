package pl.wujko.one_more.code.item;

import pl.wujko.one_more.code.constance.EntryTypeEnum;

import java.awt.Color;

/**
 * Created by Agata on 2015-06-25.
 */
public abstract class Entry
{
    private String key;

    private int price;

    private int priority;

    private Color fontColor;

    private Color backgroundColor;

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public Color getFontColor()
    {
        return fontColor;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public void setFontColor(Color fontColor)
    {
        this.fontColor = fontColor;
    }

    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }

    public void setFontColor(String fontColor)
    {
        setFontColor(new Color(Integer.parseInt(fontColor, 16)));
    }

    public void setBackgroundColor(String backgroundColor)
    {
        setBackgroundColor(new Color(Integer.parseInt(backgroundColor, 16)));
    }

    @Deprecated
    public abstract EntryTypeEnum getType();
}
