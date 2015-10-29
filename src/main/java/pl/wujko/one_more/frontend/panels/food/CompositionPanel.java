package pl.wujko.one_more.frontend.panels.food;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.springframework.beans.factory.annotation.Required;
import pl.wujko.one_more.code.item.entries.Composition;
import pl.wujko.one_more.code.service.impl.CompositionService;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.panels.Panel;
import pl.wujko.one_more.frontend.utils.FormLayoutUtils;

import javax.annotation.Resource;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Agata on 2015-10-05.
 */
public class CompositionPanel extends Panel
{
    @Resource
    private CompositionService compositionService;

    private int COLUMN_COUNT;

    @Override
    public void initPanel()
    {
        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:p:g"));

        List<Composition> compositionList = compositionService.findAll();

        int maxRowsCount = compositionList.size() / COLUMN_COUNT;
        if (compositionList.size() % COLUMN_COUNT != 0)
        {
            maxRowsCount += 1;
        }

        FormLayout formLayout = FormLayoutUtils.createDefaultFoodLayout(COLUMN_COUNT, maxRowsCount);
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
        CellConstraints cc = new CellConstraints();

        int column = 1;
        int row = 1;
        int maxRow = maxRowsCount * 2 - 1;
        for (Composition composition : compositionList)
        {
            JButton button = createButtonFor(composition);
            builder.add(button, cc.rc(row, column));

            row += 2;
            if (row > maxRow)
            {
                row = 1;
                column += 2;
            }
        }

        add(builder.getPanel(), cc.xy(1, 1));
    }

    private JButton createButtonFor(Composition composition)
    {
        JButton button = new JButton(composition.getKey());
        button.setFont(GUIConstants.DEFAULT_FONT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //todo
            }
        });
        return button;
    }

    @Required
    public void setColumnCount(int columnCount)
    {
        COLUMN_COUNT = columnCount;
    }
}
