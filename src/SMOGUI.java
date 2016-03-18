import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aleksandr on 18.03.16.
 */
public class SMOGUI {
    public SMOGUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             textField1.setText (
                     (new Double(
                             (new Chain())
                                     .createOneHandlerSMO(Double.parseDouble(textField2.getText()),Double.parseDouble(textField3.getText()))
                                     .coutMv())).toString()
             );
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
}
