import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileChooser {
    private String suggestedFileName;
    private Unit selectedUnit;

    public SaveFileChooser(Unit selectedUnit) {
        this.suggestedFileName = selectedUnit.getName() + ".md";
        this.selectedUnit = selectedUnit;
    }

    public void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(suggestedFileName));

        int returnValue = fileChooser.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try {
                saveToMarkdownFile(fileToSave);
                JOptionPane.showMessageDialog(null, "Datei erfolgreich gespeichert!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Fehler beim Speichern der Datei: " + e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        }
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
