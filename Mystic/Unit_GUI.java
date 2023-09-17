import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Unit_GUI extends JFrame {
    private JList list1;
    private JPanel PanelPic;
    private JPanel PanelMain;
    private JCheckBox showStatsCheckBox;
    private JLabel LabelName;
    private JLabel LabelHP;
    private JLabel LabelMoves;
    private JLabel Weapons;
    private JPanel PanelStats;
    private JTable TableWeapon;
    private boolean visability=true;

    private ArrayList<Unit> Units=new ArrayList<Unit>();

    public Unit_GUI() throws IOException {


        Unit DrakeBurner =new Unit(42,"DrakeBurner",5,new Weapon("claws",7,2,"blade","fire") ,"img\\drake_burner.png");
        DrakeBurner.setWeapons(new Weapon("fire breath",6,4,"fire", "ranged"));
        Units.add(DrakeBurner);

        Unit DwarvishFighter =new Unit(38,"Dwarvish Fighter",4,new Weapon("axe",7,3,"impact","melee"),"img\\dwarvish_fighter.png");
        DwarvishFighter.setWeapons(new Weapon("hammer",8,2,"impact", "melee"));
        Units.add(DwarvishFighter);

        Unit ElvishArcher =new Unit(29,"Elvish Archer",6,new Weapon("sword",5,2,"blade","melee"),"img\\elvish_archer.png");
        ElvishArcher.setWeapons(new Weapon("bow",5,4,"pierce", "ranged"));
        Units.add(ElvishArcher);

        selectUnit(Units.get(0).getName());
        list1.setSelectedIndex(0);
        LabelName.setFont(new Font("Serif", Font.BOLD, 24));

        Weapons.setFont(new Font("Serif", Font.BOLD, 18));




        DefaultListModel listModel = new DefaultListModel();

        for (Unit unit:
             Units) {

            listModel.addElement(unit.getName());
            list1.setModel(listModel);
            };
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting())

                try {
                    selectUnit(list1.getSelectedValue().toString());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }


        });

        setTitle("Mystical Game");
        createMenu();
        add(PanelMain);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(400,200);
        setSize(300,300);
        setVisible(true);
        pack();

        showStatsCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                visability= !visability;
                PanelStats.setVisible(visability);
            }
        });
    }

    private void selectUnit(String name) throws IOException {
        for (Unit unit:
             Units) {
            if (name.equals(unit.getName())){
                LabelName.setText(""+unit.getName());
                LabelHP.setText("HP: "+String.valueOf(unit.getHitpoints()));
                LabelMoves.setText("Moves: "+String.valueOf(unit.getMoves()));
                DisplayImage(PanelPic,unit);
                setWeaponTable(unit);
            }

        }

    }
    private static void DisplayImage(JPanel jp, Unit unit) {
        JLabel jl=new JLabel();

        jl.setIcon(new javax.swing.ImageIcon(unit.getPicpath()));
        jp.removeAll();
        jp.add(jl);
    }
    private void createMenu(){

        JMenuBar menuebar=new JMenuBar();

        this.setJMenuBar(menuebar);

        JMenu menueDatei= new JMenu("File");
        JMenu menueHelp= new JMenu("Help");
        JMenuItem Exit=new JMenuItem("Exit");
        JMenuItem Save=new JMenuItem("Save As");
        JMenuItem Help=new JMenuItem("About");

        menuebar.add(menueDatei);
        menuebar.add(menueHelp);



        menueDatei.add(Save);
        menueDatei.add(Exit);
        menueHelp.add(Help);

        Help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               JOptionPane.showMessageDialog (null, "This is a viewer for creature in a mystical Game", "About Unit GUI", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
       
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FileWriter f =new FileWriter();
                f.chooseFile(Units.get(list1.getSelectedIndex()).getName()+".md",Units.get(list1.getSelectedIndex()).toMarkdown());


            }
        });

  Exit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          System.exit(0);
      }
  });

    }
    private void setWeaponTable(Unit unit) {



        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Name", "Strikes", "Range", "Type" }
        );


        for (Weapon weapon : unit.getWeapons()) {

            Object[] weaponData = new Object[] {
                    weapon.getName(),
                    String.valueOf(weapon.getStrikes())+"x" +String.valueOf(weapon.getDamage()),
                    weapon.getMelee_range(),
                    weapon.getType()
            };

            tableModel.addRow(weaponData);
        }

        TableWeapon.setModel(tableModel);
    }


}




