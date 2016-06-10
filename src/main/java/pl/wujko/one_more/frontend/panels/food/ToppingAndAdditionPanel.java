package pl.wujko.one_more.frontend.panels.food;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.springframework.beans.factory.annotation.Required;
import pl.wujko.one_more.code.item.entries.Addition;
import pl.wujko.one_more.code.item.entries.Topping;
import pl.wujko.one_more.code.service.AdditionService;
import pl.wujko.one_more.code.service.ToppingService;
import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.controller.CartListController;
import pl.wujko.one_more.frontend.controller.WorkshopController;
import pl.wujko.one_more.frontend.panels.Panel;
import pl.wujko.one_more.frontend.utils.FormLayoutUtils;

import javax.annotation.Resource;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Agata on 2015-10-11.
 */
public class ToppingAndAdditionPanel extends Panel
{
    @Resource
    private ToppingService toppingService;

    @Resource
    private AdditionService additionService;

    @Resource
    private WorkshopController workshopController;

    @Resource
    private CartListController cartListController;

    private Map<Topping, JButton> toppingToButtonMap;

    private int TOPPING_COLUMN_COUNT;

    @Override
    public void initPanel()
    {
        setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setLayout(new FormLayout("f:p:g", "f:p:g"));

        toppingToButtonMap = new HashMap<Topping, JButton>();
        List<Topping> toppingList = toppingService.findAllVisible();
        List<Addition> additionList = additionService.findAll();

        int maxRowsCount = toppingList.size() / TOPPING_COLUMN_COUNT;
        if (toppingList.size() % TOPPING_COLUMN_COUNT != 0)
        {
            maxRowsCount += 1;
        }

        FormLayout formLayout = FormLayoutUtils
            .createDefaultFoodLayout(TOPPING_COLUMN_COUNT + 2, maxRowsCount);//Math.max(maxRowsCount, additionList.size()));
        DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);
        CellConstraints cc = new CellConstraints();

        int column = 1;
        int row = 1;
        int maxRow = maxRowsCount * 2 - 1;
        for (Topping topping : toppingList)
        {
            JButton button = createButtonFor(topping);
            builder.add(button, cc.rc(row, column));
            toppingToButtonMap.put(topping, button);

            row += 2;
            if (row > maxRow)
            {
                row = 1;
                column += 2;
            }
        }

        if (row <= maxRow)
        {
            column += 2;
        }
        row = 1;
        maxRow = Math.min(maxRow, additionList.size());

        for (Addition addition : additionList)
        {
            JButton button = createButtonFor(addition);
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


    public void setButtonDisable(boolean disable)
    {
        for (Topping topping : toppingToButtonMap.keySet())
        {
            if (topping.isLimited())
            {
                toppingToButtonMap.get(topping).setEnabled(disable);
            }
        }
    }

    private JButton createButtonFor(final Topping topping)
    {
        JButton button = new JButton(topping.getKey());
        setDefaultOptions(button, topping.getImage());
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                workshopController.addToSelectedWorkSpace(topping);
            }
        });
        return button;
    }

    private JButton createButtonFor(final Addition addition)
    {
        JButton button = new JButton(addition.getKey());
        setDefaultOptions(button, addition.getImage());
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cartListController.addToSelectedCart(addition);
            }
        });
        return button;
    }

    private void setDefaultOptions(JButton button, BufferedImage image)
    {
        button.setHorizontalTextPosition(SwingConstants.LEADING);
        button.setBackground(Color.WHITE);
        button.setFont(GUIConstants.DEFAULT_FONT);
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setMargin(new Insets(0, 0, 0, 0));
        if (image != null)
        {
            button.setIcon(new ImageIcon(image.getScaledInstance(35, -1, Image.SCALE_SMOOTH)));
        }
    }

    @Required
    public void setToppingColumnCount(int toppingColumnCount)
    {
        TOPPING_COLUMN_COUNT = toppingColumnCount;
    }
}
