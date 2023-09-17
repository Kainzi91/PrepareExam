import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> unit_list = new ArrayList<>();
        ArrayList<Unit> units = new ArrayList<>();
        ArrayList<Unit> units_fight = new ArrayList<>();

        for (int i= 1; i <= 15; i++){

            if(i <= 5 ){
                Drake_Burner unit = new Drake_Burner("unit "+i);
                unit_list.add(unit.getName());
                units.add(unit);
                units_fight.add(unit);

            }
            if(i >5 && i <= 10){
                Dwarvish_Fighter unit = new Dwarvish_Fighter("unit "+i);
                unit_list.add(unit.getName());
                units.add(unit);
            }
            if(i >10){
                Elvish_Archer unit = new Elvish_Archer("unit "+i);
                unit_list.add(unit.getName());
                units.add(unit);
            }
        }

        MainGui gui = new MainGui(unit_list,units);


    }

}
