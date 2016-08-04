package pl.wujko.one_more.frontend.panels;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.controller.CartListController;
import pl.wujko.one_more.frontend.controller.WorkshopController;
import pl.wujko.one_more.frontend.interfaces.NeedConfirmation;

import javax.annotation.Resource;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Agata on 2015-06-30.
 */
public class MainOptionsPanel extends Panel implements ActionListener, NeedConfirmation
{
    @Resource
    private CartListController cartListController;

    @Resource
    private WorkshopController workshopController;

    private JButton addEntry;

    private JButton newCart;

    private JButton cleanCartList;

    private JLabel price;

    @Override
    public void initPanel()
    {
        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:p"));

        cleanCartList = new JButton("WYCZYŚĆ STRONĘ");
        newCart = new JButton("NOWE ZAMÓWIENIE");
        addEntry = new JButton("DODAJ");
        price = new JLabel("0.00 zł", SwingConstants.CENTER);

        cleanCartList.addActionListener(this);
        newCart.addActionListener(this);
        addEntry.addActionListener(this);

        cleanCartList.setFont(GUIConstants.DEFAULT_FONT);
        newCart.setFont(GUIConstants.DEFAULT_FONT);
        addEntry.setFont(GUIConstants.DEFAULT_FONT);
        price.setFont(GUIConstants.DEFAULT_FONT);

        FormLayout formLayout = new FormLayout("f:100dlu:g, 1dlu, f:120dlu:g, 1dlu, f:50dlu:g, 1dlu, f:50dlu:g",
            "f:p:g");
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
        CellConstraints cc = new CellConstraints();

        builder.add(cleanCartList, cc.rc(1, 1));
        builder.add(newCart, cc.rc(1, 3));
        builder.add(price, cc.rc(1, 5));
        builder.add(addEntry, cc.rc(1, 7));

        add(builder.getPanel(), cc.xy(1, 1));
    }

    public void setPrice(int price)
    {
        int integer = price / 100;
        int afterComa = price % 100;
        if (afterComa > 9)
        {
            this.price.setText(integer + "." + afterComa + " zł");
        }
        else
        {
            this.price.setText(integer + ".0" + afterComa + " zł");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if (source == cleanCartList)
        {
            getConfirmDeletionPanel().showConfirmation(this);
            workshopController.selectWholeSpace();
        }
        else if (source == newCart)
        {
            cartListController.addNewCart();
        }
        else if (source == addEntry)
        {
            cartListController.addItemsToActiveCart();
        }
    }

    @Override
    public void deleteAfterConfirmation()
    {
        cartListController.removeAllCart();
    }

    private ConfirmDeletionPanel getConfirmDeletionPanel()
    {
        return (ConfirmDeletionPanel) BeanHelper.getBean("confirmDeletionPanel");
    }
}
