import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IPConfigInfo {

    public String getIPConfigInfo() {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec("ipconfig /all");
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = inputReader.readLine()) != null) {
                output.append(line).append("\n");
            }

            inputReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public List<String> filterIPConfigInfo(String[] keys) {
        List<String> filteredInfo = new ArrayList<>();
        String fullInfo = getIPConfigInfo();
        String[] lines = fullInfo.split("\n");

        for (String key : keys) {
            for (String line : lines) {
                if (line.trim().startsWith(key)) {
                    filteredInfo.add(line);
                }
            }
        }
        return filteredInfo;
    }
}