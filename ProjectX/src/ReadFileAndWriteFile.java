import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadFileAndWriteFile {
    private String path;
    private String content;

    public ReadFileAndWriteFile() {
    }


    public void readFile(boolean chooseFile){
        if (chooseFile) {
            setPathFileChooser();
        }
        else {
            path=this.path;
        }

        try {
            this.content = Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    public void appendFile(String content, boolean chooseFile) {
        if (chooseFile){
            setPathFileChooser();
        }
        else {
            this.path=path;

        }

        setContent(content);
        if (this.path == null) {
            System.out.println("Path is null. Cannot write to file.");
            return;
        }
        try {
            Files.write(Paths.get(path), this.content.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }




    public void deleteFile(boolean chooseFile) {
        if (chooseFile) {
            setPathFileChooser();
        }
        else {
            path=this.path;
        }
        if (path == null) {
            System.out.println("Path is null. Cannot delete the file.");
            return;
        }
        try {
            boolean deleted = Files.deleteIfExists(Paths.get(path));
            if (deleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("File does not exist.");
            }
        } catch (IOException e) {
            System.out.println("Error deleting file");
        }
    }



    public void writeFile (String data , boolean chooseFile) {

        if (chooseFile) {
            setPathFileChooser();

        } else {
            Path path = Paths.get(this.path);

        }

        try {

            byte[] bs = data.getBytes();
            Path writtenFilePath = Files.write(Path.of(this.path), bs);

        } catch (Exception e) {
            System.out.println("Path is null. Cannot create/write the file.");
        }

        }

    public void copyFile(boolean  choosePathOpen,boolean choosePathSave){
        readFile(choosePathOpen);
        writeFile(this.content,choosePathSave);


    }


    private void setPathFileChooser() {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setApproveButtonText("Choose");
            fileChooser.setDialogTitle("Choose");
            fileChooser.setCurrentDirectory(new File("."));
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                this.path = selectedFile.getAbsolutePath();
            }

    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}