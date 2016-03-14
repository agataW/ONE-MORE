package pl.wujko.one_more.code.item.entries;

import pl.wujko.one_more.code.constance.EntryTypeEnum;
import pl.wujko.one_more.code.item.Entry;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by Agata on 2015-05-15.
 */
public class Topping extends Entry
{
    private String name;
    private boolean isLimited;
    private BufferedImage image;
    private boolean visible;
    private int price35;

    @Override
    public EntryTypeEnum getType()
    {
        return EntryTypeEnum.TOPPINGS;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isLimited()
    {
        return isLimited;
    }

    public void setLimited(boolean isLimited)
    {
        this.isLimited = isLimited;
    }

    public BufferedImage getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        try
        {
            this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(image));
        }
        catch (Exception e)
        {
            System.out.println("Brak obrazka dla " + getKey());
        }
    }

    public boolean isVisible()
    {
        return visible;
    }

    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }

    public int getPrice35()
    {
        return price35;
    }

    public void setPrice35(int price35)
    {
        this.price35 = price35;
    }
}
