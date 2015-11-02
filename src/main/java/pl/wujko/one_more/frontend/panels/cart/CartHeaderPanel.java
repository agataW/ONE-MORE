package pl.wujko.one_more.frontend.panels.cart;

import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.controller.CartListController;

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
public class CartHeaderPanel extends JPanel
{
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm");

    private final CartPanel currentCartPanel;

    private static int ID = 0;

    private JLabel price;

    public CartHeaderPanel(CartPanel cartPanel)
    {
        this.currentCartPanel = cartPanel;

        setBackground(GUIConstants.CART_ENTRY_PANEL_BACKGROUND);

        //        JLabel time = new JLabel(getCurrentTime()); //todo
        JLabel time = new JLabel(String.valueOf(++ID));
        price = new JLabel(Double.toString(0.00));
        JButton close = new JButton("X");

        close.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                super.mousePressed(e);
                getCartListController().removeCart(currentCartPanel);
            }
        });

        add(time);
        add(price);
        add(close);
    }

    public CartListController getCartListController()
    {
        return (CartListController) BeanHelper.getBean("cartListController");
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
}
