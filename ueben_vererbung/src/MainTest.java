import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainTest {
    @Test
    void testAvailableUnits() {
        Player Mario = new Player("Mario");

        DrakeBurner myUnit01 = new DrakeBurner("Drake Burner", 12,12);
        ElvishArcher myUnit02 = new ElvishArcher("Elvish Archer", 22, 22);
        DwarvishFighter myUnit03 = new DwarvishFighter("Dwarvish Fighter", 33,33);

        System.out.println(myUnit01.toString());
        System.out.println(myUnit02.toString());
        System.out.println(myUnit03.toString());

        Mario.addUnitsToAllUnits(myUnit01);
        Mario.addUnitsToAllUnits(myUnit02);
        Mario.addUnitsToAllUnits(myUnit03);

        Mario.addUnitsToFigthingUnits(myUnit01);

        List<Unit> availableUnits = Main.availableUnits(Mario.getAllUnits(), Mario.getFightingUnits());
        int expectedNumber = 2;
        Assertions.assertEquals(2, availableUnits.size());

        //Assertions.assertEquals(availableUnits.contains(myUnit02), true);
    }
}
