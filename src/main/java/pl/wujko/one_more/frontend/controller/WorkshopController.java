package pl.wujko.one_more.frontend.controller;

import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.code.item.entries.Composition;
import pl.wujko.one_more.code.item.entries.Topping;
import pl.wujko.one_more.frontend.datas.WorkshopData;
import pl.wujko.one_more.frontend.panels.MainOptionsPanel;
import pl.wujko.one_more.frontend.panels.food.workshop.SpacePanel;
import pl.wujko.one_more.frontend.panels.food.workshop.WorkshopPanel;

import javax.annotation.Resource;

/**
 * Created by Agata on 2015-10-25.
 */
public class WorkshopController
{
    @Resource
    private WorkshopPanel workshopPanel;

    public void addToSelectedWorkSpace(Topping topping)
    {
        workshopPanel.addEntryToSelectedSpace(topping);
        updatePriceInMainOptionPanel();
    }

    public WorkshopData getWorkshopData()
    {
        return workshopPanel.getWorkshopData();
    }

    public void clearWorkshop()
    {
        workshopPanel.clearWorkshop();
        updatePriceInMainOptionPanel();
    }

    public void addToWholeSpace(Composition composition)
    {
        workshopPanel.addEntryToWholeSpace(composition);
        updatePriceInMainOptionPanel();
    }

    public void editEntry(WorkshopData workshopData)
    {
        workshopPanel.clearWorkshop();
        workshopPanel.editWorkshop(workshopData);
        updatePriceInMainOptionPanel();
    }

    public void removeFromSpace(SpacePanel spacePanel, Entry entry)
    {
        workshopPanel.removeFromSpace(spacePanel, entry);
        updatePriceInMainOptionPanel();
    }

    public void updatePriceInMainOptionPanel()
    {
        getMainOptionsPanel().setPrice(getWorkshopData().getPrice());
    }

    private MainOptionsPanel getMainOptionsPanel()
    {
        return (MainOptionsPanel) BeanHelper.getBean("optionsPanel");
    }

    public void selectWholeSpace()
    {
        workshopPanel.selectWholeSpace();
    }
}
