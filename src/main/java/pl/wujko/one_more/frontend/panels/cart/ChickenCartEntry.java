package pl.wujko.one_more.frontend.panels.cart;

import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.code.constance.PanSize;
import pl.wujko.one_more.code.constance.PanType;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.code.service.AdditionService;
import pl.wujko.one_more.frontend.datas.WorkshopData;

/**
 * Created by Agata on 2016-05-01.
 */
public class ChickenCartEntry
{
	private CartEntryPanel cartEntryPanel;

	private Entry chicken;

	private Entry souse;

	private Entry potato;

	public void add(Addition addition)
	{
		if (getAdditionService().isChicken(addition))
		{
			chicken = addition;
		}
		else if (getAdditionService().isSouse(addition))
		{
			souse = simpleClone(addition);
		}
		else if (getAdditionService().isPotato(addition))
		{
			potato = simpleClone(addition);
		}
	}

	private Entry simpleClone(Addition addition)
	{
		Addition clone = new Addition();
		clone.setKey(addition.getKey());
		clone.setPrice(0);
		return clone;
	}

	public boolean canAdd(Addition addition)
	{
		if (getAdditionService().isChicken(addition) && chicken == null)
		{
			return true;
		}
		else if (getAdditionService().isSouse(addition) && souse == null)
		{
			return true;
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
		return workshopData;
	}

	private AdditionService getAdditionService()
	{
		return (AdditionService) BeanHelper.getBean("additionService");
	}
}
