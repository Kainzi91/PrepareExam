import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GUI_Raumschiff extends JFrame{
    private JPanel panel1;
    private JList list1;
    private JButton Details;
    private JButton Neues_raum;
    private JButton Exit;
    private JButton saveButton;


    private List<Raumschiff> raumschiffe;

    /////
    private JMenuBar menuBar;
    private JMenu myMenu;
    private JMenuItem Reload, Quit;



    public GUI_Raumschiff(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(300, 200);
        add(panel1);
        pack();
        setVisible(true);


        /**
         * Menu
         */
        menuBar = new JMenuBar();
        myMenu = new JMenu("File");
        Reload = new JMenuItem("Reload..");
        Quit = new JMenuItem("Quit");

        menuBar.add(myMenu);

        myMenu.add(Reload);
        myMenu.add(Quit);

        setJMenuBar(menuBar);
        /**
         * Raumschiffe inizialisieren
         */
        raumschiffe = new ArrayList<>();

        Raumschiff myRaumschiff1 = new Raumschiff("Enterprise", 100, 1000, "r1.jpg");
        myRaumschiff1.addAusstattung(new Ausstattung("Laser", 100, 90, TypeR.Antriebe));
        myRaumschiff1.addAusstattung(new Ausstattung("Rakete", 100, 90, TypeR.Waffen));
        myRaumschiff1.addAusstattung(new Ausstattung("Gas", 100, 90, TypeR.Waffen));
        myRaumschiff1.addAusstattung(new Ausstattung("Turbo", 10000, 9077, TypeR.Antriebe));

        Raumschiff myRaumschiff2 = new Raumschiff("Voyager", 200, 10000, "r2.jpg");
        myRaumschiff2.addAusstattung(new Ausstattung("Photonentorpedos", 1000, 900, TypeR.Waffen));

        raumschiffe.add(myRaumschiff1);
        raumschiffe.add(myRaumschiff2);
        /**
         * GUI List befüllen
         */
        String[] myNames = {myRaumschiff2.getName(), myRaumschiff1.getName()};
        list1.setListData(myNames);

        list1.setSelectedIndex(0);


        Exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        Details.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String mySel = (String) list1.getSelectedValue();
                Raumschiff selectedRaumschiff = null;

                for (Raumschiff r : raumschiffe){
                    if(r.getName().equals(mySel)){
                        selectedRaumschiff = r;
                    }
                }

                GUI_Details detailsGUI = new GUI_Details(selectedRaumschiff);
            }
        });
        Neues_raum.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GUI_New newGUI = new GUI_New(raumschiffe, GUI_Raumschiff.this);
            }
        });
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String projectDir = System.getProperty("user.dir");
                File selectedFile = new File(projectDir + "/save_file.md");
                System.out.println("Saving to file: " + selectedFile.getAbsolutePath());
                try {
                    saveToMarkdownFile(selectedFile);
                } catch (Exception ex) {
                    System.out.println("An error occurred: " + ex.getMessage());
                    ex.printStackTrace();
                }
                System.out.println("File saved");
            }
        });
        Reload.addActionListener(e -> {
            String projectDir = System.getProperty("user.dir");
            File selectedFile = new File(projectDir + "/save_file.md");
            loadFromMarkdownFile(selectedFile);
            updateRaumschiffList();
            System.out.println("Game Reloaded");
        });

    }

    public void updateRaumschiffList() {
        String[] updatedNames = raumschiffe.stream().map(Raumschiff::getName).toArray(String[]::new);
        list1.setListData(updatedNames);
    }


    private void saveToMarkdownFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (Raumschiff raumschiff : raumschiffe) {
                writer.write("# " + raumschiff.getName() + "\n");
                writer.write("Treibstoff: " + raumschiff.getTreibstoff() + "\n");
                writer.write("Schutzschild: " + raumschiff.getSchutzschild() + "\n");
                writer.write("Bild: " + raumschiff.getImage() + "\n");
                writer.write("## Ausstattung\n");
                writer.write("| Name | Energieverbrauch | Effizienz | Typ |\n");
                writer.write("| ---- | ---------------- | ---------- | --- |\n");
                for (Ausstattung ausstattung : raumschiff.getAusstattung()) {
                    writer.write("| " + ausstattung.getName() + " | " + ausstattung.getEnergieverbrauch() +
                            " | " + ausstattung.getEffizienz() + " | " + ausstattung.getType().toString() + " |\n");
                }
                writer.write("\n"); // Leerzeile zwischen Raumschiffen
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void loadFromMarkdownFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            Raumschiff currentRaumschiff = null;

            List<String> namesToSkip = Arrays.asList("Enterprise", "Voyager");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("# ")) {
                    String name = line.substring(2);

                    if (namesToSkip.contains(name)) {
                        currentRaumschiff = null;
                        continue;
                    }

                    currentRaumschiff = new Raumschiff(name, 0, 0, "");
                    raumschiffe.add(currentRaumschiff);
                } else if (currentRaumschiff != null) {
                    if (line.startsWith("Treibstoff: ")) {
                        int treibstoff = Integer.parseInt(line.substring(12));
                        currentRaumschiff.setTreibstoff(treibstoff);
                    } else if (line.startsWith("Schutzschild: ")) {
                        int schutzschild = Integer.parseInt(line.substring(14));
                        currentRaumschiff.setSchutzschild(schutzschild);
                    } else if (line.startsWith("Bild: ")) {
                        String bild = line.substring(6);
                        currentRaumschiff.setImage(bild);
                    } else if (line.startsWith("|")) {
                        if (line.contains("Energieverbrauch") || line.contains("---")) { // Überspringen der Kopfzeile der Tabelle und der Trennlinie
                            continue;
                        }
                        String[] parts = line.split("\\|");
                        if (parts.length >= 5) {
                            String name = parts[1].trim();
                            int energieverbrauch = Integer.parseInt(parts[2].trim());
                            int effizienz = Integer.parseInt(parts[3].trim());
                            String type = parts[4].trim();

                            Ausstattung ausstattung = new Ausstattung(name, energieverbrauch, effizienz, TypeR.valueOf(type));
                            currentRaumschiff.addAusstattung(ausstattung);
                        }
                    }
                }
            }

            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
