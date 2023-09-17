import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainGuiTest {

    ArrayList<String> unit_list = new ArrayList<>();
    ArrayList<Unit> units = new ArrayList<>();
    ArrayList<Unit> units_fight = new ArrayList<>();



    @Test
    void available_units_test10() {
        MainGui test = new MainGui(unit_list,units);

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
        int ergebnis =test.available_units(units,units_fight).size();

        assertEquals(10,ergebnis);
    }
    @Test
    void available_units_test5() {
        MainGui test = new MainGui(unit_list,units);

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
                units_fight.add(unit);
            }
            if(i >10){
                Elvish_Archer unit = new Elvish_Archer("unit "+i);
                unit_list.add(unit.getName());
                units.add(unit);
            }
        }
        int ergebnis =test.available_units(units,units_fight).size();

        assertEquals(5,ergebnis);
    }
    @Test
    void available_units_test0() {
        MainGui test = new MainGui(unit_list,units);

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
                units_fight.add(unit);
            }
            if(i >10){
                Elvish_Archer unit = new Elvish_Archer("unit "+i);
                unit_list.add(unit.getName());
                units.add(unit);
                units_fight.add(unit);
            }
        }
        int ergebnis =test.available_units(units,units_fight).size();

        assertEquals(0,ergebnis);
    }
}