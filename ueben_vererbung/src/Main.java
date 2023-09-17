import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GUI_Game myGui = new GUI_Game();
    }


    public static List<Unit> availableUnits(List<Unit> allUnits, List<Unit> fightingUnits){
        List<Unit> availableUnits = new ArrayList<>(allUnits);
        availableUnits.removeAll(fightingUnits);

        return availableUnits;
    }
}