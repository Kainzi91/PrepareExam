import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;


public class FileSystemGUI extends JFrame{
    private JPanel JPanelMain;
    private JLabel LabelVerzeichnis;
    private JTextField textFieldPfad;
    private JList<File> JListResult;
    private JButton beendenButton;

    FileSystem fileSystem = new FileSystem(".\\");

    InhaltGUI inhaltGUI = new InhaltGUI();

    public FileSystemGUI() {
        setTitle("1. Test Sommersemester Mario Pilz");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,200,300,400);
        add(JPanelMain);
        setVisible(true);


        //textFieldPfad
        textFieldPfad.setText(".\\");
        //File[] files = fileSystem.getFilesInDirectory();
        displayFiles();

        JListResult.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        beendenButton.setBorder(BorderFactory.createLineBorder(Color.white, 1));

        JListResult.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                File selectedFile = JListResult.getSelectedValue();
                if (selectedFile != null) {
                    if (evt.getClickCount() == 2 && selectedFile.isFile()) {
                        if (selectedFile.getName().endsWith(".java")) {
                           // DateiLesen dateiLesen = new DateiLesen(selectedFile.getPath());
                           // String fileContent = dateiLesen.getInhalt();
                           // inhaltGUI.setTextArea1(fileContent);
                            inhaltGUI.setVis();
                            inhaltGUI.setMyTitle(selectedFile.getName());
                            inhaltGUI.setPos(getX() + getWidth() + 30, getY(), getWidth(), getHeight());
                        } else {
                            System.out.println("Selected item is a file of type: " + getFileExtension(selectedFile));
                            System.out.println("Absolute path: " + selectedFile.getAbsolutePath());
                        }
                    } else if (selectedFile.isDirectory()) {
                        fileSystem.setMyPath(selectedFile.getPath());
                        displayFiles();
                    }
                }
            }
        });


        textFieldPfad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileSystem.setMyPath(textFieldPfad.getText());
                displayFiles();
            }
        });
        beendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void displayFiles() {
        File[] files = fileSystem.getFilesInDirectory();
        if (files != null) {
            JListResult.setListData(files);
        } else {
            JListResult.setListData(new File[0]);
        }
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

}
