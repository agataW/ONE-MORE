package pl.wujko.one_more.frontend.panels.cart;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.apache.commons.collections.CollectionUtils;
import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.code.constance.PizzaConstants;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.code.service.AdditionService;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.datas.WorkshopData;
import pl.wujko.one_more.frontend.utils.FormLayoutUtils;

import javax.swing.JPanel;
import java.awt.Component;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Agata on 2015-10-21.
 */
public class CartPanel extends JPanel
{
    private DefaultFormBuilder builder;

    private CellConstraints cc;

    private CartHeaderPanel headerPanel;

    private List<CartEntryPanel> cartEntryPanelList;

    private List<ChickenCartEntry> chickenList;

    private AdditionCartEntry lastAdditionCartEntry;

    private int currentRow = 1;

    private boolean selected;

    public CartPanel()
    {
        headerPanel = new CartHeaderPanel(this);
        cartEntryPanelList = new LinkedList<CartEntryPanel>();
        chickenList = new LinkedList<ChickenCartEntry>();

        setBackground(GUIConstants.CART_HEADER_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:m"));

        initPanel();
    }

    public void createCartEntry(WorkshopData workshop)
    {
        CartEntryPanel cartEntryPanel = new CartEntryPanel(workshop);
        cartEntryPanelList.add(cartEntryPanel);
        initPanel();
        calculatePrice();
    }

    public void removeEntry(CartEntryPanel cartEntryPanel)
    {
        cartEntryPanelList.remove(cartEntryPanel);
        initPanel();
        calculatePrice();
        revalidate();
    }

    public boolean contains(CartEntryPanel cartEntryPanel)
    {
        return cartEntryPanelList.contains(cartEntryPanel);
    }

    public void addAddition(Addition addition)
    {
        if (getAdditionService().isChicken(addition) || getAdditionService().isChickenXXL(addition))
        {
            addNewChicken(addition);
            return;
        }

        ChickenCartEntry chickenCartEntry = findNeededChickenEntry(addition);
        if (chickenCartEntry != null)
        {
            addChickenAddition(addition, chickenCartEntry);
        }
        else
        {
            addMultiAddition(addition);
        }
    }

	private void addNewChicken(Addition addition)
	{
		int index = cartEntryPanelList.size();
		ChickenCartEntry chickenCartEntry = new ChickenCartEntry();
		chickenCartEntry.add(addition);

		CartEntryPanel cartEntryPanel = new CartEntryPanel(chickenCartEntry.createWorkshopData());
		cartEntryPanel.disableEditButton();
		cartEntryPanelList.add(index, cartEntryPanel);
		calculatePrice();
		initPanel();

		chickenCartEntry.setCartEntryPanel(cartEntryPanel);
		chickenList.add(chickenCartEntry);
	}

    private void addChickenAddition(Addition addition, ChickenCartEntry chickenCartEntry)
    {
		int index = cartEntryPanelList.indexOf(chickenCartEntry.getCartEntryPanel());
		removeEntry(chickenCartEntry.getCartEntryPanel());

		chickenCartEntry.add(addition);

		CartEntryPanel cartEntryPanel = new CartEntryPanel(chickenCartEntry.createWorkshopData());
		cartEntryPanel.disableEditButton();
		cartEntryPanelList.add(index, cartEntryPanel);
		calculatePrice();
		initPanel();

		chickenCartEntry.setCartEntryPanel(cartEntryPanel);
    }

	private ChickenCartEntry findNeededChickenEntry(Addition addition)
	{
		for (ChickenCartEntry chickenCartEntry : chickenList)
		{
			if (chickenCartEntry.canAdd(addition))
			{
				return chickenCartEntry;
			}
		}

		return null;
	}

    private void addMultiAddition(Addition addition)
    {
        int index = cartEntryPanelList.size();
        if (lastAdditionCartEntry == null || lastAdditionCartEntry.full() || cartEntryPanelList
                .indexOf(lastAdditionCartEntry.getCartEntryPanel()) == -1)
        {
            lastAdditionCartEntry = new AdditionCartEntry();
        }
        else
        {
            index = cartEntryPanelList.indexOf(lastAdditionCartEntry.getCartEntryPanel());
            removeEntry(lastAdditionCartEntry.getCartEntryPanel());
        }
        lastAdditionCartEntry.add(addition);

        CartEntryPanel cartEntryPanel = new CartEntryPanel(lastAdditionCartEntry.createWorkshopData());
        cartEntryPanel.disableEditButton();
        cartEntryPanelList.add(index, cartEntryPanel);
        calculatePrice();
        initPanel();

        lastAdditionCartEntry.setCartEntryPanel(cartEntryPanel);
    }

    private int pizzaCount()
    {
        int pizzaCount = 0;
        for (CartEntryPanel cartEntryPanel : cartEntryPanelList)
        {
            if (cartEntryPanel.isPizza())
            {
                ++pizzaCount;
            }
        }
        return pizzaCount;
    }

    private void calculatePrice()
    {
        int price = 0;
        for (CartEntryPanel cartEntryPanel : cartEntryPanelList)
        {
            cartEntryPanel.setPizzaDiscount(pizzaCount() >= PizzaConstants.COUNT_OF_PIZZA_TO_DISCOUNT);
        }

        for (CartEntryPanel cartEntryPanel : cartEntryPanelList)
        {
            price += cartEntryPanel.getPrice();
        }
        headerPanel.setPrice(price);
    }

    private void initPanel()
    {
        cc = new CellConstraints();
        initBuilder();
        addToBuilder(headerPanel);
        if (selected)
        {
            addToBuilder(cartEntryPanelList);
        }
    }

    private void addToBuilder(List<CartEntryPanel> cartEntryPanelList)
    {
        if (CollectionUtils.isNotEmpty(cartEntryPanelList))
        {
            for (CartEntryPanel cartEntryPanel : cartEntryPanelList)
            {
                addToBuilder(cartEntryPanel);
            }
        }
    }

    private void addToBuilder(Component component)
    {
        builder.add(component, cc.xy(1, currentRow));
        currentRow += 2;
        add(builder.getPanel(), cc.xy(1, 1));
    }

    private void initBuilder()
    {
        currentRow = 1;
        int size = 0;
        if (selected)
        {
            size = cartEntryPanelList.size();
        }
        FormLayout layout = FormLayoutUtils.createCartListLayout(size);
        builder = new DefaultFormBuilder(layout);
        removeAll();
    }

    public void setSelected(boolean selected)
    {
        if (this.selected != selected)
        {
            this.selected = selected;
            initPanel();
        }
    }

    private AdditionService getAdditionService()
    {
        return (AdditionService) BeanHelper.getBean("additionService");
    }
}
