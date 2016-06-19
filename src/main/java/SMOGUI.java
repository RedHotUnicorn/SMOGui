import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aleksandr on 18.03.16.
 */
public class SMOGUI {
    public SMOGUI() {
//        button1.addActionListener(
//                new ActionListener() {

//            public void actionPerformed(ActionEvent e) {
//             textField1.setText (
//                     (new Double(
//                             (new QueueOfSMOs())
//                                     .addOneHandlerSMO(Double.parseDouble(textField2.getText()),Double.parseDouble(textField3.getText()))
//                                     .getMv())).toString()
//             );
//            }
//        });
//        button2.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                answerText2.setText
//                        (
//                        (new Double(
//                                (new QueueOfSMOs())
//                                        .addMultipleHandlerSMO(
//                                                (Integer)spinner1.getValue()
//                                                ,Double.parseDouble(lambdaText2.getText())
//                                                ,Double.parseDouble(muText2.getText())
//                                                                )
//                                        .getMv()
//                                    ).toString()
//                        )
//                        );
//            }
//        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(MainJPanel, "This is the message", "This is the default text",JOptionPane.ERROR_MESSAGE);
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


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
