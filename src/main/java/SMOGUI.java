import com.sun.xml.internal.bind.v2.TODO;

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
                if(textField2.getText().isEmpty()||textField3.getText().isEmpty())
                    JOptionPane.showMessageDialog(MainJPanel, "Одно из значений пустое", "Ошибка",JOptionPane.ERROR_MESSAGE);
                else {
                    list1.setModel(listModel);
                    listModel.addElement(textField2.getText() + " " + textField3.getText());
                }
            }
        });
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {

                    if(JOptionPane.showConfirmDialog(MainJPanel, "Вы хотите удалить СМО?" , "Удаление СМО из последовательности",JOptionPane.OK_OPTION)==0)
                    listModel.removeElementAt(list1.getSelectedIndex());
                }
                //System.out.println(list1.getSelectedIndex());

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
