import java.io.File;

public class FileSystem {
    private String myPath;
    private File myFiles;

    public FileSystem() {
    }

    public FileSystem(String myPath) {
        this.myPath = myPath;
        this.myFiles = new File(myPath);
    }

    public String getMyPath() {
        return myPath;
    }

    public void setMyPath(String myPath) {
        this.myPath = myPath;
        this.myFiles = new File(myPath);
    }

    public File getMyFiles() {
        return myFiles;
    }

    public void setMyFiles(String filePath) {
        this.myFiles = new File(filePath);
    }

    private File[] listFilesInDirectory() {
        if (this.myFiles.isDirectory()) {
            return this.myFiles.listFiles();
        } else {
            System.out.println("The provided file is not a directory.");
            return null;
        }
    }

    private void printFilesInDirectory() {
        File[] files = listFilesInDirectory();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files or directories found in " + myPath);
        }
    }

    public File[] getFilesInDirectory() {
        return listFilesInDirectory();
    }

    public void printFiles() {
        printFilesInDirectory();
    }
}
