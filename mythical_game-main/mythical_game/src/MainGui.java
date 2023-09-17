import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MainGui extends JFrame {
    private JPanel panelMain;
    private JList JList_Playerlist;
    private JCheckBox showStatsCheckBox;
    private JTable JTable_Weapons;
    private JScrollPane JScrollPane_Playerlist;
    private JPanel JPanel_Playerlist;
    private JLabel JLabel_typ;
    private JLabel JLabel_Weapons;
    private JLabel JLabel_HP;
    private JLabel JLabel_Moves;
    private JScrollPane JScrollPane_Weapons;
    private JPanel JPanel_Image;
    private JLabel JLabel_Image;
    private JPanel JPanel_Checkbox;


    public MainGui(ArrayList<String> unit_list, ArrayList<Unit> units) {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        add(panelMain);
        setVisible(true);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem about = new JMenuItem("About");
        JMenuItem save_as = new JMenuItem("Save As...");
        JMenuItem quit = new JMenuItem("Quit");

        save_as.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));

        fileMenu.add(save_as);
        fileMenu.add(quit);

        helpMenu.add(about);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        JList_Playerlist.setListData(unit_list.toArray());
        JList_Playerlist.setSelectedIndex(0);

        unitStats(units);
        createTable(units);
        showImage(units);


////////////////////////// ActionListener ///////////////////////////
        showStatsCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showStatsCheckBox.isSelected() == false) {
                    JPanel_Playerlist.setVisible(false);
                } else {
                    JPanel_Playerlist.setVisible(true);
                }
            }
        });
        JList_Playerlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                unitStats(units);
                createTable(units);
                showImage(units);
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PopupGui popupGui = new PopupGui();
            }
        });

        save_as.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String statsString = createStatsString();
                String fileName = JLabel_typ.getText() + ".md";
                fileName = fileName.replace(" ", "_");

                SaveDialog saveDialog = new SaveDialog(statsString, fileName);

            }
        });
    }

    /////////////////////////// Functions //////////////////////////////////////
    public ArrayList<Unit> available_units(ArrayList<Unit> units, ArrayList<Unit> units_fight) {

        ArrayList<Unit> available_units = new ArrayList<>();

        for (Unit unit : units) {
            if (units_fight.contains(unit) == false) {
                available_units.add(unit);
            }
        }
        return available_units;
    }

    public void unitStats(ArrayList<Unit> units) {

        for (Unit unit : units) {
            if (unit.getName() == JList_Playerlist.getSelectedValue()) {
                JLabel_typ.setText(unit.getType_name());
                JLabel_HP.setText("HP: " + unit.getMax_health().toString());
                JLabel_Moves.setText("Moves: " + unit.getMoves().toString());
            }
        }
    }

    public void createTable(ArrayList<Unit> units) {

        String[] titles = new String[]{"Name", "Strikes", "Range", "Type"};
        DefaultTableModel model = new DefaultTableModel(titles, 0);

        for (Unit unit : units) {
            if (unit.getName() == JList_Playerlist.getSelectedValue()) {
                for (Weapon weapon : unit.getWeapons()) {
                    String range = new String();
                    if (weapon.getIs_ranged() == true) {
                        range = "ranged";
                    } else {
                        range = "melee";
                    }
                    model.addRow(new Object[]{weapon.getName(), weapon.getStrikes().toString() + " x " + weapon.getDamage().toString(), range, weapon.getType()});
                }
            }
        }

        JTable_Weapons.setModel(model);
    }

    public void showImage(ArrayList<Unit> units) {

        for (Unit unit : units) {
            if (unit.getName() == JList_Playerlist.getSelectedValue()) {
                if (unit.getType_name() == "Drake Burner") {
                    ImageIcon imageIcon = new ImageIcon("images/drake_burner.png");
                    JLabel_Image.setIcon(imageIcon);
                } else if (unit.getType_name() == "Dwarvish Fighter") {
                    ImageIcon imageIcon = new ImageIcon("images/dwarvish_fighter.png");
                    JLabel_Image.setIcon(imageIcon);
                } else if (unit.getType_name() == "Elvish Archer") {
                    ImageIcon imageIcon = new ImageIcon("images/elvish_archer.png");
                    JLabel_Image.setIcon(imageIcon);
                }
            }
        }


    }

    public String createStatsString() {
        StringBuilder statsString = new StringBuilder();

        statsString.append("# " + JLabel_typ.getText() + "\n");
        statsString.append(JLabel_HP.getText() + "\n");
        statsString.append(JLabel_Moves.getText() + "\n");
        statsString.append("\n");
        statsString.append("## " + JLabel_Weapons.getText() + "\n");
        statsString.append("| ");

        for (int col = 0; col < JTable_Weapons.getColumnCount(); col++) {
            statsString.append(" " + JTable_Weapons.getColumnName(col));
            statsString.append(" |");
        }
        statsString.append("\n");
        statsString.append("|");
        for (int col = 0; col < JTable_Weapons.getColumnCount(); col++) {
            statsString.append("------|");
        }
        statsString.append("\n");
        for (int row = 0; row < JTable_Weapons.getRowCount(); row++) {
            statsString.append("| ");
            for (int col = 0; col < JTable_Weapons.getColumnCount(); col++) {
                statsString.append(JTable_Weapons.getValueAt(row, col));
                statsString.append(" |");
            }
            statsString.append("\n");
        }


        return statsString.toString();

    }


}
