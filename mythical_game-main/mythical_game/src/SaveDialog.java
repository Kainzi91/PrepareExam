import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveDialog extends JFrame{
    private JPanel JPanel_Save;
    private JPanel JPanel_Buttons;
    private JButton JButton_Cancel;
    private JButton JButton_Save;
    private JTextArea JTextArea_Text;
    private JScrollPane JScrollPane_Text;
    private JTextField JTextfield_Pfad;
    private JLabel JLabel_Save;

    public SaveDialog(String statsString, String fileName) {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(400,300);
        setSize(700,400);
        setVisible(true);
        add(JPanel_Save);


        JTextArea_Text.setText(statsString);
        JTextfield_Pfad.setText("C:\\Users\\domin\\Desktop\\POS- Prüfung\\mythical_game\\mythical_game\\files\\"+fileName);



        JButton_Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(JTextfield_Pfad.getText());

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(statsString);
                    dispose();
                } catch (IOException ex) {
                    System.err.println("Fehler beim Speichern des Strings: " + ex.getMessage());
                }
            }

        });


        JButton_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
