package pl.wujko.one_more.frontend.controller;

import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.code.item.entries.Composition;
import pl.wujko.one_more.frontend.datas.WorkshopData;
import pl.wujko.one_more.frontend.panels.food.FoodPanel;
import pl.wujko.one_more.frontend.panels.food.workshop.WorkshopPanel;

import javax.annotation.Resource;

/**
 * Created by Agata on 2015-10-25.
 */
public class WorkshopController
{
    @Resource
    private WorkshopPanel workshopPanel;

    @Resource
    private FoodPanel foodPanel;

    public void addToSelectedWorkSpace(Entry entry)
    {
        workshopPanel.addEntryToSelectedSpace(entry);
    }

    public WorkshopData getWorkshopData()
    {
        WorkshopData workshopData = new WorkshopData();
        workshopData.setLeftSpace(workshopPanel.getLeftSpaceData());
        workshopData.setWholeSpace(workshopPanel.getWholeSpaceData());
        workshopData.setRightSpace(workshopPanel.getRightSpaceData());
        workshopData.setPanType(workshopPanel.getPan());
        foodPanel.refresh();

        return workshopData;
    }

    public void addToWholeSpace(Composition composition)
    {
        workshopPanel.addEntryToWholeSpace(composition);
    }

    public void editEntry(WorkshopData workshopData)
    {
        workshopPanel.getLeftSpaceData(); //bardzo glupie
        workshopPanel.getWholeSpaceData(); //bardzo glupie
        workshopPanel.getRightSpaceData(); //bardzo glupie
        foodPanel.refresh();
        workshopPanel.editEntry(workshopData);
    }
}
