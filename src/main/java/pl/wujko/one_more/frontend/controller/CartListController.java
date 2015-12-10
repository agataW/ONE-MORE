package pl.wujko.one_more.frontend.controller;

import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.frontend.datas.WorkshopData;
import pl.wujko.one_more.frontend.panels.cart.CartEntryPanel;
import pl.wujko.one_more.frontend.panels.cart.CartListPanel;
import pl.wujko.one_more.frontend.panels.cart.CartPanel;

import javax.annotation.Resource;

/**
 * Created by Agata on 2015-10-25.
 */

public class CartListController
{
    @Resource
    private CartListPanel cartListPanel;

    @Resource
    private WorkshopController workshopController;

    private WorkshopData lastWorkshopData;

    public void addNewCart()
    {
        cartListPanel.addNewCart();
    }

    public void removeCart(CartPanel cartPanel)
    {
        cartListPanel.removeCart(cartPanel);
    }

    public void removeAllCart()
    {
        cartListPanel.removeAllCarts();
    }

    public void addItemsToActiveCart()
    {
        WorkshopData workshop = workshopController.getWorkshopData();
        workshopController.clearWorkshop();

        if (!workshop.isEmpty())
        {
            cartListPanel.addToSelectedCart(workshop);
            lastWorkshopData = workshop;
        }
        else if (lastWorkshopData != null)
        {
            cartListPanel.addToSelectedCart(lastWorkshopData);
        }
    }

    public void removeCartEntry(CartEntryPanel cartEntryPanel)
    {
        cartListPanel.removeCartEntry(cartEntryPanel);
    }

    public void addToSelectedCart(Addition addition)
    {
        cartListPanel.addToSelectedCart(addition);
    }
}
