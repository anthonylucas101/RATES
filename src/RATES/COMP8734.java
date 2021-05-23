package RATES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class COMP8734 extends JPanel{
    private JButton butt;
    private JPanel contentPane;

    public COMP8734(JPanel panel) {
        contentPane = panel;
        setOpaque(true);
        setBackground(Color.BLUE.darker());

        butt = new JButton("Back");
        butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout)
                        contentPane.getLayout();
                cardLayout.show(contentPane, "Panel 1");
            }
        });
        add(butt);
    }
    public Dimension getPreferredSize() {
        return (new Dimension(330, 500));
    }
}
