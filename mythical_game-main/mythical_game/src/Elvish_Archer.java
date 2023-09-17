import java.util.ArrayList;

public class Elvish_Archer extends Unit{

    public Elvish_Archer(String name) {
        setType_name("Elvish Archer");
        setMoves(6);
        setMax_health(29);
        setName(name);

        Weapon Sword = new Weapon("sword",2,5,"blade",false);
        Weapon Bow = new Weapon("bow",4,5,"pierce",true);

        addWeapons(Sword);
        addWeapons(Bow);

    }
}
