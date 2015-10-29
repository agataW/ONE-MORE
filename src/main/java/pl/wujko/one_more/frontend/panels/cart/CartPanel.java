package pl.wujko.one_more.frontend.panels.cart;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
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
    public static final int MAX_ROW_COUNT = 15;

    private FormLayout layout;

    private DefaultFormBuilder builder;

    private CellConstraints cc;

    private CartHeaderPanel headerPanel;

    private List<CartEntryPanel> cartEntryPanelList;

    private int currentRow = 1;

    public CartPanel()
    {
        headerPanel = new CartHeaderPanel(this);
        cartEntryPanelList = new LinkedList<CartEntryPanel>();
        initPanel();
    }

    public void createCartEntry(WorkshopData workshop)
    {
        CartEntryPanel cartEntryPanel = new CartEntryPanel(workshop);
        cartEntryPanelList.add(cartEntryPanel);
        addToBuilder(cartEntryPanel);

        calculatePrice();
    }

    public void removeEntry(CartEntryPanel cartEntryPanel)
    {
        cartEntryPanelList.remove(cartEntryPanel);
        initPanel();
        for (CartEntryPanel entryPanel : cartEntryPanelList)
        {
            addToBuilder(entryPanel);
        }
        calculatePrice();
        revalidate();
    }

    public boolean contains(CartEntryPanel cartEntryPanel)
    {
        return cartEntryPanelList.contains(cartEntryPanel);
    }

    private void calculatePrice()
    {
        double price = 0; //todo
        for (CartEntryPanel cartEntryPanel : cartEntryPanelList)
        {
            price += cartEntryPanel.getPrice();
        }
        headerPanel.setPrice(price);
    }

    private void initPanel()
    {
        setBackground(GUIConstants.CART_LIST_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:m"));

        layout = FormLayoutUtils.createCartListLayout(MAX_ROW_COUNT);
        cc = new CellConstraints();
        initBuilder();
        addToBuilder(headerPanel);
    }

    private void addToBuilder(Component component)
    {
        builder.add(component, cc.xy(1 ,currentRow));
        currentRow += 2;
        removeAll();
        add(builder.getPanel(), cc.xy(1, 1));
    }

    private void initBuilder()
    {
        currentRow = 1;
        builder = new DefaultFormBuilder(layout);
    }
}
