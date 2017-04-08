package pl.wujko.one_more.frontend.panels.cart;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.datas.WorkshopData;
import pl.wujko.one_more.frontend.panels.Panel;
import pl.wujko.one_more.frontend.utils.FormLayoutUtils;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Agata on 2015-06-30.
 */
public class CartListPanel extends Panel
{
    private DefaultFormBuilder builder;

    private CellConstraints cc;

    private CartPanel currentCartPanel;

    private List<CartPanel> cartPanelList;

    private int currentRow;

    @Override
    public void initPanel()
    {
        cartPanelList = new LinkedList<CartPanel>();

        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:m"));

        cc = new CellConstraints();

        addNewCart();
    }

    private void repaintBuilder()
    {
        currentRow = 1;
        FormLayout layout = FormLayoutUtils.createCartListLayout(cartPanelList.size());
        builder = new DefaultFormBuilder(layout);
        removeAll();
        repaint();
        addToBuilder(cartPanelList);
        revalidate();
    }

    private void addToBuilder(List<CartPanel> cartPanelList)
    {
        if (CollectionUtils.isNotEmpty(cartPanelList))
        {
            for (CartPanel cartPanel : cartPanelList)
            {
                addToBuilder(cartPanel);
            }
        }
        add(builder.getPanel(), cc.xy(1, 1));
    }

    private void addToBuilder(Component component)
    {
        builder.add(component, cc.xy(1, currentRow));
        currentRow += 2;
    }

    public void addNewCart()
    {
        if (currentRow <= (cartPanelList.size() * 2 + 1))
        {
            CartPanel cartPanel = new CartPanel();
            cartPanel.addMouseListener(createMouseListener(cartPanel));

            cartPanelList.add(cartPanel);
            repaintBuilder();
            selectCurrentCartPanel(cartPanel);
        }
    }

    public void removeCart(CartPanel cartPanel)
    {
        ifMustSetNewCurrentCartPanel(cartPanel); // musi być przed **carttttMap . remove (cartPanel);**
        if (cartPanel != null)
        {
            cartPanelList.remove(cartPanel);
        }

        repaintBuilder();
    }

    public void removeAllCarts()
    {
        cartPanelList.clear();
        currentCartPanel = null;
        repaintBuilder();
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
        for (CartPanel cartPanel : cartPanelList)
        {
            if (cartPanel.contains(cartEntryPanel))
            {
                cartPanel.removeEntry(cartEntryPanel);
                List<ChickenCartEntry> chickenList = cartPanel.getChickenList();
                for (ChickenCartEntry chickenCartEntry : chickenList)
                {
                    if (chickenCartEntry.getCartEntryPanel().equals(cartEntryPanel))
                    {
                        chickenList.remove(chickenCartEntry);
                        break;
                    }
                }
                break;
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

    public void updateTimers(DateTime currentTime)
    {
        for (CartPanel cartPanel : cartPanelList)
        {
            cartPanel.updateTimer(currentTime);
        }
    }

    private void ifMustSetNewCurrentCartPanel(CartPanel cartPanelToRemove)
    {
        if (cartPanelToRemove == null || cartPanelList.size() == 1)
        {
            currentCartPanel = null;
            return;
        }
        int indexOfCart = cartPanelList.indexOf(cartPanelToRemove);

        if (indexOfCart == 0)
        {
            selectCurrentCartPanel(cartPanelList.get(1));
        }
        else if (indexOfCart == cartPanelList.size() - 1)
        {
            selectCurrentCartPanel(cartPanelList.get(cartPanelList.size() - 2));
        }
        else if (cartPanelToRemove.equals(currentCartPanel))
        {
            selectCurrentCartPanel(cartPanelList.get(indexOfCart + 1));
        }
    }

    private void selectCurrentCartPanel(CartPanel cartPanel)
    {
        if (currentCartPanel != null && currentCartPanel.equals(cartPanel))
        {
            currentCartPanel.setBorder(GUIConstants.Cart.BORDER_BLACK);
            currentCartPanel.setSelected(false);
            currentCartPanel = null;
        }
        else
        {
            for (CartPanel panel : cartPanelList)
            {
                if (panel.equals(cartPanel))
                {
                    panel.setBorder(GUIConstants.Cart.BORDER);
                    panel.setSelected(true);
                    currentCartPanel = panel;
                }
                else
                {
                    panel.setBorder(GUIConstants.Cart.BORDER_BLACK);
                }
            }
        }
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
