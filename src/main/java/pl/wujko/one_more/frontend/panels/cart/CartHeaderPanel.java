package pl.wujko.one_more.frontend.panels.cart;

import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.controller.CartListController;
import pl.wujko.one_more.frontend.interfaces.NeedConfirmation;
import pl.wujko.one_more.frontend.panels.ConfirmDeletionPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Agata on 2015-10-14.
 */
public class CartHeaderPanel extends JPanel implements NeedConfirmation
{
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm");

    private final CartPanel currentCartPanel;

    private JLabel price;

    public CartHeaderPanel(CartPanel cartPanel)
    {
        this.currentCartPanel = cartPanel;

        setBackground(GUIConstants.CART_ENTRY_PANEL_BACKGROUND);

        JLabel time = new JLabel(getCurrentTime());
        time.setFont(GUIConstants.DEFAULT_FONT);
        price = new JLabel(Double.toString(0.00));
        price.setFont(GUIConstants.DEFAULT_FONT);
        JButton close = new JButton("X");
        close.setFont(GUIConstants.DEFAULT_FONT);

        final CartHeaderPanel that = this;
        close.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                getConfirmDeletionPanel().showConfirmation(that);
            }
        });

        add(time);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(price);
        add(new JLabel());
        add(close);
    }

    @Override
    public void deleteAfterConfirmation()
    {
        getCartListController().removeCart(currentCartPanel);
    }

    public void setPrice(int price)
    {
        int integer = price / 100;
        int afterComa = price % 100;
        this.price.setText(integer + "." + afterComa + " zł");
    }

    private static String getCurrentTime()
    {
        return DATE_FORMAT.format(new Date());
    }

    private CartListController getCartListController()
    {
        return (CartListController) BeanHelper.getBean("cartListController");
    }

    private ConfirmDeletionPanel getConfirmDeletionPanel()
    {
        return (ConfirmDeletionPanel) BeanHelper.getBean("confirmDeletionPanel");
    }
}
