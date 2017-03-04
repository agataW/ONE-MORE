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

    public static final Font TIMER_FONT = new Font("Tahoma", Font.PLAIN, 18);

    public static class WorkSpace
    {
        public static final Color PANEL_BACKGROUND = new Color(40, 40, 40);

        public static final Color BORDER_COLOR = new Color(153, 204, 255);

        public static final Border BORDER = BorderFactory.createLineBorder(BORDER_COLOR, 2);

        public static final Border BORDER_BLACK = BorderFactory.createLineBorder(new Color(0, 0, 0), 1);
    }

    public static class Cart
    {
        public static final Color BORDER_COLOR = new Color(244, 63, 21);

        public static final Color HEADER_PANEL_BACKGROUND = new Color(140, 140, 140);

        public static final Border BORDER = BorderFactory.createLineBorder(BORDER_COLOR, 2);

        public static final Border BORDER_BLACK = BorderFactory.createLineBorder(new Color(0, 0, 0), 1);
    }

    public static class CartEntry
    {
        public static final Color PANEL_BACKGROUND = new Color(160, 160, 160);
    }

    public static class ConfirmDelete
    {
        public static final Color LABEL_FOREGROUND = new Color(200, 200, 200);

        public static final Color BUTTONS_BACKGROUND = new Color(200, 200, 200);
    }

    public static class PanSizeColour
    {
        public static final Color BACKGROUND_40 = new Color(73, 79, 255);
    }

    public static class Additions {
        public static final Color FONT_COLOUR = new Color(Integer.parseInt("ffffff", 16));
        public static final Color BACKGROUND_COLOR = new Color(Integer.parseInt("3282ff", 16));
    }
}