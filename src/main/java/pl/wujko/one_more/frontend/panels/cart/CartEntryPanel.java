package pl.wujko.one_more.frontend.panels.cart;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.code.constance.PanType;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.controller.CartListController;
import pl.wujko.one_more.frontend.controller.WorkshopController;
import pl.wujko.one_more.frontend.datas.WorkshopData;
import pl.wujko.one_more.frontend.interfaces.NeedConfirmation;
import pl.wujko.one_more.frontend.panels.ConfirmDeletionPanel;
import pl.wujko.one_more.frontend.panels.entry.EntryPanel;
import pl.wujko.one_more.frontend.utils.FormLayoutUtils;
import pl.wujko.one_more.frontend.utils.PriceUtils;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

/**
 * Created by Agata on 2015-10-21.
 */

public class CartEntryPanel extends JPanel implements NeedConfirmation
{
    private static final int STATIC_ELEMENTS_COUNT = 4;

    private WorkshopData workshopData;

    private JLabel delete;

    private JLabel edit;

    private JLabel priceLabel;

    private JLabel emptyLabel;

    private DefaultFormBuilder builder;

    private CellConstraints cc;

    private int currentRow = 1;

    private boolean discount = false;

    public CartEntryPanel(final WorkshopData workshopData, final CartPanel cartPanel)
    {
        this.workshopData = workshopData;

        setBackground(GUIConstants.CartEntry.PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:m"));

        final CartEntryPanel that = this;
        delete = new JLabel(GUIConstants.Image.TRASH);
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                getConfirmDeletionPanel().showConfirmation(that);
            }
        });

        edit = new JLabel(GUIConstants.Image.EDIT);
        edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                getWorkshopController().editEntry(workshopData);
                getCartListController().removeCartEntry(that);
                getCartListController().focus(cartPanel);
            }
        });

        priceLabel = new JLabel("0.00", SwingConstants.CENTER);
        priceLabel.setFont(GUIConstants.DEFAULT_FONT);

        emptyLabel = new JLabel();

        initPanel();
    }

    public int getPrice()
    {
        if (discount && !workshopData.getPanType().equals(PanType.NO_PANE))
        {
            return workshopData.getPriceWithDiscount();
        }
        return workshopData.getPrice();
    }

    public int getColaPrice()
    {
        return workshopData.getColaPrice();
    }

    public boolean isPizza()
    {
        return workshopData.isPizza();
    }

    public void setPizzaDiscount(boolean discount)
    {
        this.discount = discount;
        calculatePrice();
    }

    public void disableEditButton()
    {
        edit.setEnabled(false);
    }

    private void initPanel()
    {
        LinkedList<Entry> entriesToPrint = workshopData.getEntriesToPrint();
        int maxSize = entriesToPrint.size() + STATIC_ELEMENTS_COUNT;

        FormLayout layout = FormLayoutUtils.createDefaultCartEntryLayout(maxSize);
        builder = new DefaultFormBuilder(layout);
        cc = new CellConstraints();

        addToBuilder(entriesToPrint);

        calculatePrice();
        addToBuilder(emptyLabel);
        addToBuilder(priceLabel);
        addToBuilder(edit);
        addToBuilder(delete);

        add(builder.getPanel(), cc.xy(1, 1));
    }

    private void calculatePrice()
    {
        this.priceLabel.setText(PriceUtils.convertPrice(getPrice()));
    }

    private void addToBuilder(LinkedList<Entry> space)
    {
        for (Entry entry : space)
        {
            EntryPanel entryPanel = new EntryPanel(entry);
            addToBuilder(entryPanel);
        }
    }

    private void addToBuilder(Component panel)
    {
        builder.add(panel, cc.xy(currentRow, 1));
        currentRow += 2;
    }

    @Override
    public void deleteAfterConfirmation()
    {
        getCartListController().removeCartEntry(this);
    }

    private CartListController getCartListController()
    {
        return (CartListController) BeanHelper.getBean("cartListController");
    }

    private ConfirmDeletionPanel getConfirmDeletionPanel()
    {
        return (ConfirmDeletionPanel) BeanHelper.getBean("confirmDeletionPanel");
    }

    private WorkshopController getWorkshopController()
    {
        return (WorkshopController) BeanHelper.getBean("workshopController");
    }
}
