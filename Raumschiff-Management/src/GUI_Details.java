import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_Details extends JFrame{
    private JPanel panel1;
    private JButton exitButton;
    private JCheckBox checkBox1;
    private JTable table1;
    private JPanel JPanelImage;
    private JLabel myImage;



    public GUI_Details(Raumschiff selectedRaumschiff){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(600, 200);
        add(panel1);
        pack();
        setVisible(true);
        //myImage = new JLabel(); immer mir der hand reinziehen!!!

        checkBox1.setSelected(true);


        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Energieverbrauch");
        model.addColumn("Effizienz");
        model.addColumn("Type");
        table1.setModel(model);
        model.setRowCount(0);

        String imagePath = selectedRaumschiff.getImage();

        System.out.println(imagePath);

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + imagePath));
        myImage.setIcon(icon);

        for(Ausstattung ausstattung : selectedRaumschiff.getAusstattung()){
            model.addRow(new Object[]{ausstattung.getName(), ausstattung.getEffizienz(), ausstattung.getEnergieverbrauch(), ausstattung.getType()});
        }

        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        JPanelImage.add(myImage);
        checkBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!checkBox1.isSelected()){
                    JPanelImage.setVisible(false);
                }else {
                    JPanelImage.setVisible(true);
                }
            }
        });
    }
}
