package pl.wujko.one_more.code.item.entries;

import pl.wujko.one_more.code.constance.EntryTypeEnum;
import pl.wujko.one_more.code.item.Entry;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Agata on 2015-05-15.
 */
public class Topping extends Entry
{
    private int id;
    private String name;
    private boolean isLimited;
    private BufferedImage image;
    private boolean visible;

    @Override
    public EntryTypeEnum getType()
    {
        return EntryTypeEnum.TOPPINGS;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
        catch (IOException e)
        {
            e.printStackTrace();
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
}
