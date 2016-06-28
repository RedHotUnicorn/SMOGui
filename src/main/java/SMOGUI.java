import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by aleksandr on 18.03.16.
 */
public class SMOGUI {
    public SMOGUI() {
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(MainJPanel, "This is the message", "This is the default text",JOptionPane.ERROR_MESSAGE);
            }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                list1.setModel(listModel);
                listModel.addElement(textField2.getText()+" "+textField3.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SMOGUI");
        frame.setContentPane(new SMOGUI().MainJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }


    private JPanel MainJPanel;
    private JButton button1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTabbedPane tabbedPane1;
    private JSpinner spinner1;
    private JButton button2;
    private JTextField answerText2;
    private JTextField lambdaText2;
    private JTextField muText2;
    private JTabbedPane tabbedPane2;
    DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> list1;


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
