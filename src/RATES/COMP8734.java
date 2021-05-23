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

//extend JPanel and implement action listener in constructor
public class COMP8734 extends JPanel implements ActionListener {
    private JButton jcomp1, open, saveInf;
    private JPanel contentPane;
    JFileChooser fc;
    private JTextField tf;
    private JLabel comp1, feedback, ques;
    private JTextArea intro, comment;
    private String value;
    //new commit with change
    public COMP8734(JPanel panel) {

        //Set Content and Colour of Panel
        contentPane = panel;
        setOpaque(true);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBackground(Color.BLUE.darker());
        setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));


        //Creates a new slider
        Insets insets = panel.getInsets();
        JSlider rating = new JSlider(JSlider.HORIZONTAL, 1, 10, 10);
        rating.setMajorTickSpacing(10);
        rating.setPaintTicks(true);
        //Creates a new label tabel
        Hashtable hashtable = new Hashtable();
        hashtable.put(new Integer(1), new JLabel("Poor"));
        hashtable.put(new Integer(10), new JLabel("Great"));
        rating.setLabelTable(hashtable);
        rating.setPaintLabels(true);


        //Creates and adds title for subject
        comp1 = new JLabel("COMP8734");
        ques = new JLabel("Overall how did you find this work?");
        comp1.setFont(new Font("Verdana", Font.BOLD, 46));
        comp1.setBounds(25 + insets.left, 25 + insets.top, size().width, size().height);
        add(comp1);

        //creates and adds introduction
        intro = new JTextArea("Welcome to your subject COMP8734" + "\n" + "Below you can submit a review for file you choose!");
        intro.setEditable(false); //sets introduction to be not editable
        add(intro);

        //creates open button for file chooser
        open = new JButton("Choose File");
        add(open);
        open.addActionListener(this); //Uses this to point to the file chooser action listener

        feedback = new JLabel("Leave any further feedback here: ");
        comment = new JTextArea("           ");



        //Create new File chooser and text field to be added
        fc = new JFileChooser();
        tf = new JTextField(20);
        saveInf = new JButton("Save Review");
        //add created objects
        add(tf);
        add(ques);
        add(rating);
        add(feedback);
        add(comment);
        add(saveInf);

        String fileContent = "RATES/random.txt"; //sets location of text file for values to be recorded

        //Add an action listener to save review button to get values and comments
        saveInf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    System.out.println("COMP8734 Feedback");
                    System.out.println("File Name: " + tf.getText());
                    System.out.println("Rating: " + rating.getValue());
                    System.out.println("Comment: " + comment.getText());
                    value = String.valueOf(rating.getValue()); //turns value of slider into string
                    JOptionPane.showMessageDialog(panel, "Your review has been saved!"); //opens dialog box with user feedback message
                    FileWriter fileWriter = new FileWriter(fileContent); //creates file writer
                    tf.write(fileWriter); //writes value of text field to txt file
                    //value.write(fileWriter); //Some difficulties making this work\
                    comment.write(fileWriter);
                    fileWriter.close();
                } catch (Exception exception) {}

            }
        });



        jcomp1 = new JButton("Back");
        jcomp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) //defines card layout
                        contentPane.getLayout();
                cardLayout.show(contentPane, "Panel 1"); //back button action to go to homescreen
            }
        });
        add(jcomp1);
    }

    public void actionPerformed(ActionEvent e) {



        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //System.out.println(file.getName());
            tf.setText(file.getName()); //sets text field to file name


            try {
                FileReader fr = new FileReader(file.getAbsoluteFile());


            } catch (Exception exception) {}

        } else {}

    }



    public Dimension getPreferredSize() {
        return (new Dimension(330, 500));
    }
}
