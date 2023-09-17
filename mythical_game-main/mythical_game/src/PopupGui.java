import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupGui extends JFrame{
    private JButton JButton_ok;
    private JPanel panelMain;
    private JLabel JLabel_about;

    public PopupGui() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(400,300);
        add(panelMain);
        setVisible(true);
        pack();
        setTitle("About Unit GUI");


        JButton_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
