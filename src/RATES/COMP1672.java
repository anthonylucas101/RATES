package RATES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class COMP1672 extends JPanel implements ActionListener {
    private JButton jcomp1, open, saveInf;
    private JPanel contentPane;
    JFileChooser fc;
    private JTextField tf;
    private JLabel comp1;
    private JTextArea intro;

    public COMP1672(JPanel panel) {

        Insets insets = panel.getInsets();

        JSlider rating = new JSlider(JSlider.HORIZONTAL, 1, 10, 10);
        rating.setMajorTickSpacing(10);
        rating.setPaintTicks(true);

        Hashtable hashtable = new Hashtable();
        hashtable.put(new Integer(1), new JLabel("Poor"));
        hashtable.put(new Integer(10), new JLabel("Great"));
        rating.setLabelTable(hashtable);
        rating.setPaintLabels(true);



        comp1 = new JLabel("COMP1672");
        comp1.setFont(new Font("Verdana", Font.BOLD, 46));
        comp1.setBounds(25 + insets.left, 25 + insets.top, size().width, size().height);
        add(comp1);

        intro = new JTextArea("Welcome to your subject COMP1672" + "\n" + "Below you can submit a review for file you choose!");
        intro.setEditable(false);
        add(intro);






        //Set Content and Colour of Panel
        contentPane = panel;
        setOpaque(true);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBackground(Color.BLUE.darker());
        setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

        //Create new File chooser and text field to be added
        fc = new JFileChooser();
        tf = new JTextField(20);
        saveInf = new JButton("saveReview");
        add(tf);
        add(saveInf);
        add(rating);

        String fileContent = "RATES/random.txt";

        saveInf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    System.out.println(tf.getText());
                    System.out.println(rating.getValue());
                    JOptionPane.showMessageDialog(panel, "Your review has been saved!");
                    FileWriter fileWriter = new FileWriter(fileContent);
                    tf.write(fileWriter);
                    fileWriter.close();
                } catch (Exception exception) {}

            }
        });





        open = new JButton("open");
        add(open);
        open.addActionListener(this);


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

    public void actionPerformed(ActionEvent e) {



        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            System.out.println(file.getName());
            tf.setText(file.getName());
            //logTA.append("Opening " + file.getName() + ".\n");

            try {
                FileReader fr = new FileReader(file.getAbsoluteFile());
                //workTA.read(fr, null);

            } catch (Exception exception) {}

        } else {}

    }

    public Dimension getPreferredSize() {
        return (new Dimension(500, 500));
    }
}
