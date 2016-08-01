package pl.wujko.one_more.code.item.entries;

import org.apache.log4j.Logger;
import pl.wujko.one_more.code.constance.EntryTypeEnum;
import pl.wujko.one_more.code.item.Entry;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by Agata on 2015-05-15.
 */
public class Topping extends Entry
{
    private static Logger LOG = Logger.getLogger(Topping.class);

    private String name;
    private boolean isLimited;
    private BufferedImage image;
    private boolean visible;
    private int price40;

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
            LOG.info("Brak obrazka dla " + getKey());
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

    public int getPrice40()
    {
        return price40;
    }

    public void setPrice40(int price40)
    {
        this.price40 = price40;
    }
}
