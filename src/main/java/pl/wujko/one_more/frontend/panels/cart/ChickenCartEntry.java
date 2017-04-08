package pl.wujko.one_more.frontend.panels.cart;

import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.code.constance.PanSize;
import pl.wujko.one_more.code.constance.PanType;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.code.service.AdditionService;
import pl.wujko.one_more.frontend.datas.WorkshopData;

/**
 * Created by Agata on 2016-05-01.
 */
public class ChickenCartEntry
{
	private CartEntryPanel cartEntryPanel;

	private Addition chicken;

	private Addition souse;

	private Addition souse2;

	private Addition potato;

	public void add(Addition addition)
	{
		if (getAdditionService().isChicken(addition) || getAdditionService().isChickenXXL(addition))
		{
			chicken = addition;
		}
		else if (getAdditionService().isSouse(addition))
		{
			if (souse == null)
			{
				souse = souseClone(addition);
			}
			else
			{
				souse2 = souseClone(addition);
			}
		}
		else if (getAdditionService().isPotato(addition))
		{
			potato = potatoClone(addition);
		}
	}
	
	private Addition souseClone(Addition addition)
	{
		Addition clone = new Addition();
		clone.setKey(addition.getKey());
		if ("Q USA".equals(addition.getKey()))
		{
			clone.setPrice(100);
		}
		else
		{
			clone.setPrice(0);
		}
		return clone;
	}
	
	private Addition potatoClone(Addition addition)
	{
		Addition clone = new Addition();
		clone.setKey(addition.getKey());
		if ("ZIEM".equals(addition.getKey()))
		{
			if (getAdditionService().isChicken(chicken))
			{
				clone.setPrice(100);
			}
			else
			{
				clone.setPrice(150);
			}
		}
		return clone;
	}

	public boolean canAdd(Addition addition)
	{
		if ((getAdditionService().isChicken(addition) || getAdditionService().isChickenXXL(addition)) && chicken == null)
		{
			return true;
		}
		else if (getAdditionService().isSouse(addition))
		{
			if (souse == null)
			{
				return true;
			}
			if (getAdditionService().isChickenXXL(chicken) && souse2 == null)
			{
				return true;
			}
		}
		else if (getAdditionService().isPotato(addition) && potato == null)
		{
			return true;
		}
		return false;
	}

	public void setCartEntryPanel(CartEntryPanel cartEntryPanel)
	{
		this.cartEntryPanel = cartEntryPanel;
	}

	public CartEntryPanel getCartEntryPanel()
	{
		return cartEntryPanel;
	}

	public WorkshopData createWorkshopData()
	{
		WorkshopData workshopData = new WorkshopData();
		workshopData.setPanType(PanType.NO_PANE);
		workshopData.setPanSize(PanSize.NO_PAN);
		workshopData.addToWholeSpace(chicken);
		if (potato != null)
		{
			workshopData.addToWholeSpace(potato);
		}
		if (souse != null)
		{
			workshopData.addToWholeSpace(souse);
		}
		if (souse2 != null)
		{
			workshopData.addToWholeSpace(souse2);
		}
		return workshopData;
	}

	private AdditionService getAdditionService()
	{
		return (AdditionService) BeanHelper.getBean("additionService");
	}
}
