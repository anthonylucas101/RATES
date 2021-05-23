package RATES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {
    private JButton jcomp4, sub1, sub2, sub3, sub4;
    private JPanel contentPane;
    private JLabel heading, question, fav, anser;
    private final int NUM_SUB = 4;
    private Color [] subject = new Color[NUM_SUB];
    private JRadioButton [] subjectButton = new JRadioButton[NUM_SUB];



    public HomePanel(JPanel panel) {
        contentPane = panel;
        setOpaque(true);
        setBackground(Color.RED.darker());





        setLayout(new FlowLayout()); //sets new flow layouut
        heading = new JLabel("WELCOME TO RATES");
        add(heading);

        //Action listeners created below to give buttons an an action when clicked
        //each button uses a string indentifier to link to a file

        sub1 = new JButton("COMP1672");
        sub1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) //defines cardlayout
                        contentPane.getLayout();
                cardLayout.show(contentPane, "COMP1672"); //string indentifer shown here
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

        question = new JLabel("What has been your favourite subject so far");
        add(question);

        fav = new JLabel("My favourite subject is: ");
        anser = new JLabel("");

        subject[0] = Color.white;
        subject[1] = Color.white;
        subject[2] = Color.white;
        subject[3] = Color.white;

        subjectButton[0] = new JRadioButton("COMP1", true);
        subjectButton[1] = new JRadioButton("COMP2", false);
        subjectButton[2] = new JRadioButton("COMP3", false);
        subjectButton[3] = new JRadioButton("COMP4", false);

        ButtonGroup group = new ButtonGroup(); //creates a button group for radio buttons
        for (int i = 0; i < subjectButton.length; i++) {
            group.add(subjectButton[i]);
            add(subjectButton[i]);
            JRadioButton selectedButton = null;

            if (subjectButton[0].isSelected()) {
                selectedButton = subjectButton[0];
            } else if (subjectButton[1].isSelected()) {
                selectedButton = subjectButton[1];
            } else if (subjectButton[2].isSelected()) {
                selectedButton = subjectButton[2];
            } else if (subjectButton[3].isSelected()) {
                selectedButton = subjectButton[3];
            }

            String choice = selectedButton.getText();
            anser.setText(choice);
        }




        add(fav);
        add(anser);


    }



    public Dimension getPreferredSize() {
        return (new Dimension(330, 500));
    }
}
