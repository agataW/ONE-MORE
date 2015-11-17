package pl.wujko.one_more.frontend.panels;

import pl.wujko.one_more.frontend.GUIConstants;
import pl.wujko.one_more.frontend.interfaces.NeedConfirmation;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Agata on 2015-11-17.
 */
public class ConfirmDeletionPanel extends JFrame implements ActionListener
{
    private JButton yesButton;

    private NeedConfirmation needConfirmation;

    public void showConfirmation(NeedConfirmation needConfirmation)
    {
        this.needConfirmation = needConfirmation;
        Point point = MouseInfo.getPointerInfo().getLocation();
        point.setLocation(point.getX(), point.getY() - 150);
        setLocation(point);
        setVisible(true);
    }

    public ConfirmDeletionPanel()
    {
        initPanel();
    }

    public void initPanel()
    {
        setUndecorated(true);
        ((JPanel) getContentPane()).setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setTitle("Uwaga!");
        setSize(250, 150);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(GUIConstants.MAIN_PANEL_BACKGROUND);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JLabel label = new JLabel("<html>Czy na pewno<br>chcesz usunac?</html>");
        label.setBounds(10, 10, getWidth() - 20, 50);
        label.setForeground(GUIConstants.CONFIRM_DELETE_LABEL_FOREGROUND);
        label.setFont(GUIConstants.DEFAULT_FONT);
        add(label);

        yesButton = new JButton("TAK");
        yesButton.setBounds(10, 80, 110, 50);
        yesButton.setFont(GUIConstants.DEFAULT_FONT);
        yesButton.setBackground(GUIConstants.CONFIRM_DELETE_BUTTONS_BACKGROUND);
        yesButton.setOpaque(true);
        yesButton.addActionListener(this);
        add(yesButton);

        JButton noButton = new JButton("NIE");
        noButton.setFont(GUIConstants.DEFAULT_FONT);
        noButton.setBackground(GUIConstants.CONFIRM_DELETE_BUTTONS_BACKGROUND);
        noButton.setOpaque(true);
        noButton.setBounds(130, 80, 110, 50);
        noButton.addActionListener(this);
        add(noButton);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == yesButton)
        {
            needConfirmation.deleteAfterConfirmation();
        }
        setVisible(false);
    }
}
