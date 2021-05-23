package RATES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class COMP3834 extends JPanel{
    private JButton jcomp1;
    private JPanel contentPane;

    public COMP3834(JPanel panel) {
        contentPane = panel;
        setOpaque(true);
        setBackground(Color.BLUE.darker());

        jcomp1 = new JButton("Back");
        jcomp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout)
                        contentPane.getLayout();
                cardLayout.show(contentPane, "Panel 1");
            }
        });
        add(jcomp1);
    }
    public Dimension getPreferredSize() {
        return (new Dimension(500, 500));
    }
}
