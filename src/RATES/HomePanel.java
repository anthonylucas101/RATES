package RATES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {
    private JButton jcomp4, sub1, sub2, sub3, sub4;
    private JPanel contentPane;
    private JLabel heading;


    public HomePanel(JPanel panel) {
        contentPane = panel;
        setOpaque(true);
        setBackground(Color.RED.darker());


        setLayout(new FlowLayout());
        heading = new JLabel("WELCOME TO RATES");

        sub1 = new JButton("COMP1672");
        sub1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout)
                        contentPane.getLayout();
                cardLayout.show(contentPane, "COMP1672");
            }
        });
        add(sub1);

        sub2 = new JButton("COMP2874");
        sub2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout)
                        contentPane.getLayout();
                cardLayout.show(contentPane, "COMP2874");
            }
        });
        add(sub2);

        sub3 = new JButton("COMP3834");
        sub3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout)
                        contentPane.getLayout();
                cardLayout.show(contentPane, "COMP3834");
            }
        });
        add(sub3);

        sub4 = new JButton("COMP8734");
        sub4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout)
                        contentPane.getLayout();
                cardLayout.show(contentPane, "COMP8734");
            }
        });
        add(sub4);

        add(heading);

    }



    public Dimension getPreferredSize() {
        return (new Dimension(500, 500));
    }
}
