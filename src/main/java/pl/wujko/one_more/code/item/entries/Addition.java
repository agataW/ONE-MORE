package pl.wujko.one_more.code.item.entries;

import org.apache.log4j.Logger;
import pl.wujko.one_more.code.constance.EntryTypeEnum;
import pl.wujko.one_more.code.item.Entry;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
/**
 * Created by Agata on 2015-06-25.
 */
public class Addition extends Entry
{
	private static Logger LOG = Logger.getLogger(Addition.class);

	private int id;
	private String name;
	private BufferedImage image;
	private boolean singleInLine;

	@Override
	public EntryTypeEnum getType()
	{
		return EntryTypeEnum.ADDITIONS;
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

	public boolean isSingleInLine()
	{
		return singleInLine;
	}

	public void setSingleInLine(boolean singleInLine)
	{
		this.singleInLine = singleInLine;
	}
}
