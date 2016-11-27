package pl.wujko.one_more.frontend.panels.cart;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.controller.CartListController;
import pl.wujko.one_more.frontend.interfaces.NeedConfirmation;
import pl.wujko.one_more.frontend.panels.ConfirmDeletionPanel;
import pl.wujko.one_more.frontend.utils.PriceUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Agata on 2015-10-14.
 */
public class CartHeaderPanel extends JPanel implements NeedConfirmation
{
    private static int COUNT_OF_CART = 0;

    private static DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("H:mm");

    private final CartPanel currentCartPanel;

    private JLabel price;

    private JLabel colaPrice;

    private JLabel timer;

    private JLabel bigEmptySpace;

    private DateTime startTime = new DateTime();

    public CartHeaderPanel(CartPanel cartPanel)
    {
        this.currentCartPanel = cartPanel;

        setBackground(GUIConstants.CART_HEADER_PANEL_BACKGROUND);

        JLabel countLabel = new JLabel((++COUNT_OF_CART) + ".");
        countLabel.setFont(GUIConstants.DEFAULT_FONT);
        JLabel time = new JLabel(getCurrentTime());
        time.setFont(GUIConstants.DEFAULT_FONT);
        timer = new JLabel("(0:00)");
        timer.setFont(GUIConstants.TIMER_FONT);
        price = new JLabel(PriceUtils.convertPrice(0));
        price.setFont(GUIConstants.DEFAULT_FONT);
        colaPrice = new JLabel();
        colaPrice.setFont(GUIConstants.TIMER_FONT);
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

        JLabel smallEmptySpace = new JLabel();
        smallEmptySpace.setPreferredSize(new Dimension(15, 1));
        bigEmptySpace = new JLabel();
        bigEmptySpace.setPreferredSize(new Dimension(150, 1));

        add(countLabel);
        add(smallEmptySpace);
        add(time);
        add(smallEmptySpace);
        add(timer);
        add(bigEmptySpace);
        add(price);
        add(smallEmptySpace);
        add(colaPrice);
        add(smallEmptySpace);
        add(close);
    }

    @Override
    public void deleteAfterConfirmation()
    {
        getCartListController().removeCart(currentCartPanel);
    }

    public void setPrice(int price)
    {
        this.price.setText(PriceUtils.convertPrice(price));
    }

    public void setColaPrice(int price)
    {
        if (price == 0)
        {
            bigEmptySpace.setPreferredSize(new Dimension(150, 1));
            this.colaPrice.setText("");
        }
        else
        {
            bigEmptySpace.setPreferredSize(new Dimension(72, 1));
            this.colaPrice.setText("(" + PriceUtils.convertPrice(price) + ")");
        }
    }

    public void updateTimer(DateTime currentTime)
    {
        Period diff = new Period(startTime, currentTime);
        int hours = diff.getHours();
        int minutes = diff.getMinutes();
        String zero = "";
        if (minutes < 10)
        {
            zero = "0";
        }

        timer.setText("(" + hours + ":" + zero + minutes + ")");
    }

    private String getCurrentTime()
    {
        return DATE_FORMAT.print(startTime);
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
