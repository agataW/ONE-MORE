package pl.wujko.one_more.frontend;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;

/**
 * Created by Agata on 2015-06-30.
 */
public class GUIConstants
{
    public static final String FRAME_TITLE = "One-More Kalkulator";

    public static final Color MAIN_PANEL_BACKGROUND = new Color(30, 30, 30);

    public static final Font DEFAULT_FONT = new Font("Tahoma", Font.BOLD, 18);

    // WORKSPACE
    public static final Color WORKSPACE_PANEL_BACKGROUND = new Color(40, 40, 40);

    public static final Color WORKSPACE_BORDER_COLOR = new Color(153, 204, 255);

    public static final Border WORKSPACE_BORDER = BorderFactory.createLineBorder(WORKSPACE_BORDER_COLOR, 2);

    public static final Border WORKSPACE_BORDER_BLACK = BorderFactory.createLineBorder(new Color(0, 0, 0), 1);

    // CART
    public static final Color CART_BORDER_COLOR = new Color(244, 63, 21);

    public static final Color CART_HEADER_PANEL_BACKGROUND = new Color(100, 100, 100);

    public static final Border CART_BORDER = BorderFactory.createLineBorder(CART_BORDER_COLOR, 2);

    public static final Border CART_BORDER_BLACK = BorderFactory.createLineBorder(new Color(0, 0, 0), 1);

    // CART ENTRY
    public static final Color CART_ENTRY_PANEL_BACKGROUND = new Color(140, 140, 140);

    //CONFIRM DELETE
    public static final Color CONFIRM_DELETE_LABEL_FOREGROUND = new Color(200, 200, 200);

    public static final Color CONFIRM_DELETE_BUTTONS_BACKGROUND = new Color(200, 200, 200);
}