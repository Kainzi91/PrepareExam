import java.util.ArrayList;

public class Dwarvish_Fighter extends Unit{

    public Dwarvish_Fighter(String name) {
        setType_name("Dwarvish Fighter");
        setMoves(4);
        setMax_health(38);
        setName(name);

        Weapon Axe = new Weapon("axe",3,7,"blade",false);
        Weapon Hammer = new Weapon("hammer",2,8,"impact",false);

        addWeapons(Axe);
        addWeapons(Hammer);


    }
}
