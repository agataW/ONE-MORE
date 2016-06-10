package pl.wujko.one_more.frontend.panels.entry;

import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.frontend.GUIConstants;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Created by Agata on 2015-10-25.
 */
public class EntryPanel extends JPanel
{
    public EntryPanel(Entry entry)
    {
        setBackground(entry.getBackgroundColor());

        JLabel label = new JLabel(entry.getKey(), SwingConstants.CENTER);
        label.setFont(GUIConstants.DEFAULT_FONT);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(entry.getFontColor());

        add(label);
    }
}
