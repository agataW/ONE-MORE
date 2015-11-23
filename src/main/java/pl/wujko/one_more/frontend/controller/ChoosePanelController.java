package pl.wujko.one_more.frontend.controller;

import pl.wujko.one_more.frontend.panels.food.FoodPanel;
import pl.wujko.one_more.frontend.panels.food.ChoosePanelPanel;
import pl.wujko.one_more.frontend.panels.food.CompositionPanel;
import pl.wujko.one_more.frontend.panels.food.ToppingAndAdditionPanel;

import javax.annotation.Resource;

/**
 * Created by Agata on 2015-10-14.
 */
public class ChoosePanelController
{
    @Resource
    private FoodPanel foodPanel;

    @Resource
    private ToppingAndAdditionPanel toppingAndAdditionPanel;

    @Resource
    private CompositionPanel compositionPanel;

    public void chooseFoodPanel(String chooseWorkshop)
    {
        if (ChoosePanelPanel.CHOOSE_PACKAGE.equals(chooseWorkshop))
        {
            foodPanel.setSelectedPanel(compositionPanel);
        }
        else if (ChoosePanelPanel.CHOOSE_WORKSHOP.equals(chooseWorkshop))
        {
            foodPanel.setSelectedPanel(toppingAndAdditionPanel);
        }
    }
}
