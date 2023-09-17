import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

public class GUI_New extends JFrame{
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField2;
    private JButton saveButton;
    private JButton exitButton;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox comboBox1;
    private JPanel MainPanel;
    private JButton imageButton;
    private JLabel imageLabel;

    private List<Raumschiff> raumschiffe;
    private GUI_Raumschiff mainGui;

    private String imageName;



    public GUI_New(List<Raumschiff> raumschiffe,  GUI_Raumschiff mainGui){
        this.raumschiffe = raumschiffe;
        this.mainGui = mainGui;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(800, 200);
        add(MainPanel);
        pack();
        setVisible(true);

        String[] myEnum = {TypeR.Antriebe.toString(), TypeR.Waffen.toString(), TypeR.Sensoren.toString(), TypeR.Verteidigungssysteme.toString()};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(myEnum);
        comboBox1.setModel(model);


        imageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(MainPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath()).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_DEFAULT));
                    imageLabel.setIcon(imageIcon);
                    imageName = selectedFile.getName();
                }
            }
        });


        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = textField1.getText();
                String treibstoff = textField2.getText();
                String schutzschild = textField3.getText();
                String ausstattung_name = textField4.getText();
                String energieverbrauch = textField5.getText();
                String effizienz = textField6.getText();
                String type = comboBox1.getSelectedItem().toString();


                if (name.isEmpty() || treibstoff.isEmpty() || schutzschild.isEmpty() || ausstattung_name.isEmpty()
                        || energieverbrauch.isEmpty() || effizienz.isEmpty() || type.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Alle Felder müssen ausgefüllt sein!");
                } else {
                    // Erstelle ein neues Raumschiff und füge es zur Liste hinzu
                    int treibstoffInt = Integer.parseInt(treibstoff);
                    int schutzschildInt = Integer.parseInt(schutzschild);
                    int energieverbrauchInt = Integer.parseInt(energieverbrauch);
                    int effizienzInt = Integer.parseInt(effizienz);
                    Raumschiff neuesRaumschiff = new Raumschiff(name, treibstoffInt, schutzschildInt, imageName);
                    Ausstattung neueAusstattung = new Ausstattung(ausstattung_name, energieverbrauchInt, effizienzInt, TypeR.valueOf(type));

                    neuesRaumschiff.addAusstattung(neueAusstattung);
                    raumschiffe.add(neuesRaumschiff);

                    JOptionPane.showMessageDialog(null, "Raumschiff wurde erstellt!");


                    for (Raumschiff r : raumschiffe){
                        System.out.println(r.toString());
                    }

                    mainGui.updateRaumschiffList();

                    dispose();
                }
            }
        });
    }
}
