package pl.wujko.one_more.frontend.panels.cart;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import pl.wujko.map.WujkoMap;
import pl.wujko.one_more.code.item.Cart;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.datas.WorkshopData;
import pl.wujko.one_more.frontend.panels.Panel;
import pl.wujko.one_more.frontend.utils.FormLayoutUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Agata on 2015-06-30.
 */
public class CartListPanel extends Panel
{
    public static final int MAX_ROW_COUNT = 100;

    private FormLayout layout;

    private DefaultFormBuilder builder;

    private CellConstraints cc;

    private CartPanel currentCartPanel;

    private WujkoMap<CartPanel, Cart> cartMap;

    private int currentRow;

    @Override
    public void initPanel()
    {
        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:m"));

        layout = FormLayoutUtils.createCartListLayout(MAX_ROW_COUNT);
        initBuilder();
        cc = new CellConstraints();
        add(builder.getPanel(), cc.xy(1, 1));

        cartMap = new WujkoMap<CartPanel, Cart>();
        addNewCart();
        addNewCart();
        addNewCart();
    }

    public void addNewCart()
    {
        if (currentRow <= MAX_ROW_COUNT)
        {
            CartPanel cartPanel = new CartPanel();
            cartPanel.addMouseListener(createMouseListener(cartPanel));
            addPanel(cartPanel);

            cartMap.put(cartPanel, new Cart());
            selectCurrentCartPanel(cartPanel);
        }
    }

    private void addPanel(CartPanel cartPanel)
    {
        builder.add(cartPanel, cc.xy(1, currentRow));
        currentRow += 2;

        add(builder.getPanel(), cc.xy(1, 1));
        revalidate();
    }

    public void removeCart(CartPanel cartPanel)
    {
        ifMustSetNewCurrentCartPanel(cartPanel); // musi być przed **cartMap.remove (cartPanel);**
        if (cartPanel != null)
        {
            cartMap.remove(cartPanel);
        }

        removeAll();
        initBuilder();

        if (cartMap.isEmpty())
        {
            repaint();
            revalidate();
            return;
        }
        for (CartPanel panel : cartMap.keyList())
        {
            addPanel(panel);
        }
    }

    public void removeAllCarts()
    {
        cartMap.clear();
        removeCart(null);
    }

    public void addToSelectedCart(WorkshopData workshop)
    {
        if (currentCartPanel == null)
        {
            addNewCart();
        }
        currentCartPanel.createCartEntry(workshop);
        revalidate();
    }

    public void removeCartEntry(CartEntryPanel cartEntryPanel)
    {
        for (CartPanel cartPanel : cartMap.keyList())
        {
            if (cartPanel.contains(cartEntryPanel))
            {
                cartPanel.removeEntry(cartEntryPanel);
                return;
            }
        }
    }

    public void addToSelectedCart(Addition addition)
    {
        if (currentCartPanel == null)
        {
            addNewCart();
        }
        currentCartPanel.addAddition(addition);
    }

    private void ifMustSetNewCurrentCartPanel(CartPanel cartPanelToRemove)
    {
        if (cartPanelToRemove == null || cartMap.size() == 1)
        {
            currentCartPanel = null;
            return;
        }

        selectCurrentCartPanel(cartMap.getKey(0));
    }

    private void initBuilder()
    {
        currentRow = 1;
        builder = new DefaultFormBuilder(layout);
    }

    private void selectCurrentCartPanel(CartPanel cartPanel)
    {
        for (CartPanel panel : cartMap.keyList())
        {
            panel.setBorder(GUIConstants.CART_BORDER_BLACK);
        }

        cartPanel.setBorder(GUIConstants.CART_BORDER);
        currentCartPanel = cartPanel;
    }

    private MouseListener createMouseListener(final CartPanel cartPanel)
    {
        return new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                selectCurrentCartPanel(cartPanel);
            }
        };
    }
}
