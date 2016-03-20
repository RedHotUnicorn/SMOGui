import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

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
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerText2.setText
                        (
                        (new Double(
                                (new Chain())
                                        .createMultipleHandlerSMO(
                                                (Integer)spinner1.getValue()
                                                ,Double.parseDouble(lambdaText2.getText())
                                                ,Double.parseDouble(muText2.getText())
                                                                )
                                        .coutMv()
                                    ).toString()
                        )
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
    public void paint(Graphics g){
 g.drawLine(20, 20, 360, 20);
    };
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
