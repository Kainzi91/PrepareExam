import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GUI_Save extends JFrame{
    private JPanel MainPanel;
    private JTextField textFieldPath;
    private JButton saveButton;
    private JButton exitButton;

    private Unit selectedUnit;

    public GUI_Save(Unit selectedUnit){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(600, 200);
        add(MainPanel);
        pack();
        setVisible(true);

        this.selectedUnit = selectedUnit;

        textFieldPath.setText("Markdown/" + selectedUnit.getName() + ".md");

        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                File file = new File(textFieldPath.getText());
                saveToMarkdownFile(file);
                System.out.println("Saved to Markdown");
                dispose();
            }
        });


        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
    }

    private void saveToMarkdownFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("# " + selectedUnit.getName() + "\n");
            writer.write("HP: " + selectedUnit.getHitpoints() + "\n");
            writer.write("Moves: " + selectedUnit.getMoves() + "\n\n\n");
            writer.write("## Weapons\n");
            writer.write("| Name | Strikes | Range | Type |\n");
            writer.write("| ---- | ---------------- | ---------- | --- |\n");
            for (Weapon weapon : selectedUnit.getWeapons()) {
                writer.write("| " + weapon.getName() +
                        " | " + weapon.getWeaponDamage() +
                        " | " + (weapon.isRange() ? "melee" : "range") + " | " + weapon.getType().toString() + " |\n");
            }
            writer.write("\n"); // Leerzeile zwischen Raumschiffen

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
