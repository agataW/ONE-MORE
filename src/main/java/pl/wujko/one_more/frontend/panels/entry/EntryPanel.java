package pl.wujko.one_more.frontend.panels.entry;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import pl.wujko.one_more.code.item.Entry;
import pl.wujko.one_more.frontend.GUIConstants;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Created by Agata on 2015-10-25.
 */
public class EntryPanel extends JPanel
{
    public EntryPanel(Entry entry)
    {
        setLayout(new FormLayout("f:p:g", "f:m"));
        setBackground(entry.getBackgroundColor());

        StringBuilder text = new StringBuilder()
            .append(' ')
            .append(entry.getKey())
            .append(' ');
        JLabel label = new JLabel(text.toString());
        label.setFont(GUIConstants.DEFAULT_FONT);
        label.setForeground(entry.getFontColor());

        CellConstraints cc = new CellConstraints();
        add(label, cc.xy(1, 1));
    }
}
