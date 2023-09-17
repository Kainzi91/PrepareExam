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

    private void chooseFilePathCopy() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setApproveButtonText("Speichern");
        fileChooser.setDialogTitle("Speichern");
        fileChooser.setCurrentDirectory(new File("."));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            this.path = selectedFile.getAbsolutePath();
            writeFileCopy();
        }
    }

    private void chooseFilePath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            this.path = selectedFile.getAbsolutePath();
            readFile(path);
        }
    }
    private void chooseFilePathWrite() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            this.path = selectedFile.getAbsolutePath();
            writeFile(path);
        }
    }

    private void readFile(String path) {
        try {
            this.content = Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    private void writeFile(String path) {
        try {
            Files.write(Paths.get(path), this.content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error writing file");
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

    public void writeFileEasy(){
        if (this.path == null) {
            System.out.println("Path is null. Cannot write to file.");
            return;
        }
        try {
            Files.write(Paths.get(path), this.content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public void writeFileCopy() {
        if (this.path == null) {
            System.out.println("Path is null. Cannot write to file.");
            return;
        }
        try {
            Files.deleteIfExists(Paths.get(path)); // Löschen, falls die Datei existiert
            Files.write(Paths.get(path), this.content.getBytes(), StandardOpenOption.CREATE_NEW); // Erstellen einer neuen Datei
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }


    public void readFileEasy(){
        try {
            this.content = Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    public void appendFile(String path, String content) {
        setPath(path);
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

    public void copyChoosenFile(){
        chooseFilePath();
        chooseFilePathCopy();
    }

    public void deleteFile(String path) {
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

    public void deleteChoosenFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setApproveButtonText("Delete");
        fileChooser.setDialogTitle("Delete");
        fileChooser.setCurrentDirectory(new File("."));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            this.path = selectedFile.getAbsolutePath();
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

    public void setChoosenPath(){
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



}