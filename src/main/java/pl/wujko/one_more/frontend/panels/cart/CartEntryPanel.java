package pl.wujko.one_more.frontend.panels.cart;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.controller.CartListController;
import pl.wujko.one_more.frontend.datas.WorkshopData;
import pl.wujko.one_more.frontend.panels.entry.EntryPanel;
import pl.wujko.one_more.frontend.utils.FormLayoutUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by Agata on 2015-10-21.
 */

public class CartEntryPanel extends JPanel implements ActionListener
{
    private static final int BUTTONS_COUNT = 2;

    private WorkshopData workshopData;

    private JButton delete;

    private JButton edit;

    private JLabel priceLabel = new JLabel("0.00", SwingConstants.CENTER);

    private DefaultFormBuilder builder;

    private CellConstraints cc;

    private int currentRow = 1;

    private int price;

    public CartEntryPanel(WorkshopData workshopData)
    {
        this.workshopData = workshopData;

        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:m"));

        delete = new JButton("X");
        delete.addActionListener(this);

        edit = new JButton(">");
        edit.addActionListener(this);

        initPanel();
    }

    public double getPrice()
    {
        return workshopData.getPrice() / 100d;
    }

    private void initPanel()
    {
        int maxSize = (workshopData.size() + workshopData.usedSpaceCount() + BUTTONS_COUNT) * 2 - 1;

        FormLayout layout = FormLayoutUtils.createDefaultEntryLayout(maxSize);
        builder = new DefaultFormBuilder(layout);
        cc = new CellConstraints();

        addToBuilder(workshopData.getLeftSpace());
        addToBuilder(workshopData.getWholeSpace());
        addToBuilder(workshopData.getRightSpace());

        calculatePrice();
        addToBuilder(priceLabel);
        addToBuilder(delete);
        addToBuilder(edit);

        add(builder.getPanel(), cc.xy(1, 1));
    }

    private void calculatePrice()
    {
        double price = workshopData.getPrice() / 100d;
        String sPrice = Double.toString(price);
        this.priceLabel.setText(sPrice);
    }

    private void addToBuilder(LinkedList<Entry> space)
    {
        for (Entry entry : space)
        {
            EntryPanel panel = new EntryPanel(entry);
            addToBuilder(panel);
        }
    }

    private void addToBuilder(Component panel)
    {
        builder.add(panel, cc.xy(currentRow, 1));
        currentRow += 2;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if (source.equals(edit))
        {

        }
        else if (source.equals(delete))
        {
            getCartListController().removeCartEntry(this);
        }
    }

    private CartListController getCartListController()
    {
        return (CartListController) BeanHelper.getBean("cartListController");
    }
}
