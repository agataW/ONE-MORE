package pl.wujko.one_more.code.item.entries;

import pl.wujko.one_more.code.constance.EntryTypeEnum;
import pl.wujko.one_more.code.item.Entry;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Agata on 2015-06-25.
 */
public class Addition extends Entry {
    private int id;
    private String name;
    private BufferedImage image;

    @Override
    public EntryTypeEnum getType() {
        return EntryTypeEnum.ADDITIONS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
