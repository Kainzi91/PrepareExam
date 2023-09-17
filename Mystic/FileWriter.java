import javax.swing.*;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter {


    public void chooseFile(String defaultName, String data) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Path");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setApproveButtonText("Open");
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setSelectedFile(new File(defaultName));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            createFile(fileToSave.getAbsolutePath());
            writeFile(data,fileToSave.getAbsolutePath());
        }
    }
    private void createFile(String s_path){
        try {

            File f = new File(s_path);
            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
    private void writeFile (String data,String s_path){

        Path path = Paths.get(s_path);
        try {

            byte[] bs = data.getBytes();
            Path writtenFilePath = Files.write(path, bs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String readFile(String path) {
        try {
            Path filePath = Paths.get(path);
            byte[] bytes = Files.readAllBytes(filePath);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}




