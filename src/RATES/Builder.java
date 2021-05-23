package RATES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Builder {
    private JPanel contentPane;
    private HomePanel panel1;
    private COMP1672 panel2;
    private COMP2874 panel3;
    private COMP3834 panel4;
    private COMP8734 panel5;

    private void frameDisplay() {
        JFrame frame = new JFrame("RATES");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        contentPane.setLayout(new CardLayout());
        panel1 = new HomePanel(contentPane);
        panel2 = new COMP1672(contentPane);
        panel3 = new COMP2874(contentPane);
        panel4 = new COMP3834(contentPane);
        panel5 = new COMP8734(contentPane);
        contentPane.add(panel1, "Panel 1");
        contentPane.add(panel2, "COMP1672");
        contentPane.add(panel3, "COMP2874");
        contentPane.add(panel4, "COMP3834");
        contentPane.add(panel5, "COMP8734");
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Builder().frameDisplay();
            }
        });
    }

    public Dimension getPreferredSize() {
        return (new Dimension(330, 500));
    }

}
