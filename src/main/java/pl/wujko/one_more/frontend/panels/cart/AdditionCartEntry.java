package pl.wujko.one_more.frontend.panels.cart;

import pl.wujko.one_more.code.constance.PanSize;
import pl.wujko.one_more.code.constance.PanType;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.frontend.datas.WorkshopData;

import java.util.LinkedList;

/**
 * Created by Agata on 2016-05-01.
 */
public class AdditionCartEntry
{
	private CartEntryPanel cartEntryPanel;

	private LinkedList<Entry> additionList;

	public void add(Addition addition)
	{
		if (additionList == null)
		{
			additionList = new LinkedList<Entry>();
		}
		additionList.add(addition);
	}

	public void setCartEntryPanel(CartEntryPanel cartEntryPanel)
	{
		this.cartEntryPanel = cartEntryPanel;
	}

	public CartEntryPanel getCartEntryPanel()
	{
		return cartEntryPanel;
	}

	public boolean full()
	{
		return additionList.size() == 5;
	}

	public WorkshopData createWorkshopData()
	{
		WorkshopData workshopData = new WorkshopData();
		workshopData.setPanType(PanType.NO_PANE);
		workshopData.setPanSize(PanSize.NO_PAN);
		workshopData.setWholeSpace(additionList);
		return workshopData;
	}
}
