import java.util.List;

public class Main {
    public static void main(String[] args) {
        IPConfigInfo ipConfigInfo = new IPConfigInfo();

        /**
         * Filtern
         */
        String[] keys = {"IPv4-Adresse", "Subnetzmaske", "Standardgateway"};
        List<String> filteredInfo = ipConfigInfo.filterIPConfigInfo(keys);

        for (String info : filteredInfo) {
            System.out.println(info);
        }

        /**
         * all
         */
        String result = ipConfigInfo.getIPConfigInfo();
        System.out.println(result);
    }
}