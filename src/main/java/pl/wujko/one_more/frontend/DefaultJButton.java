package pl.wujko.one_more.frontend;

import javafx.print.Printer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Paweł on 2017-04-08.
 */
public class DefaultJButton extends JButton {
    private DefaultJButton(String text) {
        super(text);
    }

    public static DefaultJButton create(String text) {
        LookAndFeel previousLF = UIManager.getLookAndFeel();
        DefaultJButton button = null;
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            button = new DefaultJButton(text);
            UIManager.setLookAndFeel(previousLF);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return button;
    }

    public static DefaultJButton createStylized(String text) {
        DefaultJButton defaultJButton = create(text);
        stylizeButton(defaultJButton);
        return defaultJButton;
    }

    private static void stylizeButton(JButton button) {
        Color foreground = GUIConstants.MAIN_PANEL_BACKGROUND;
        Color background = Color.LIGHT_GRAY;

        button.setForeground(foreground);
        button.setBackground(background);
        button.setFocusPainted(false);

        Border margin = BorderFactory.createLineBorder(foreground, 2);
        Border line = new LineBorder(background.darker(), 2);
        button.setBorder(BorderFactory.createCompoundBorder(margin, line));

        button.setMargin(new Insets(10, 10, 10, 10));

        button.setFont(GUIConstants.DEFAULT_FONT);
    }

    public DefaultJButton taller() {
        Dimension size = this.getPreferredSize();
        size.height += 10;
        this.setPreferredSize(size);
        return this;
    }

    public DefaultJButton wider() {
        Dimension size = this.getPreferredSize();
        size.width += 50;
        this.setPreferredSize(size);
        return this;
    }
}

