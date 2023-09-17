public class DwarvishFighter extends Unit{

    public DwarvishFighter(String name, int hitpoints, int moves) {
        super(name, hitpoints, moves);
        this.setType_name(UnitType.DwarvishFighter);


        Weapon weapon3 = new Weapon("axe", 7, 3, false, WeaponType.blade);
        Weapon weapon4 = new Weapon("hammer", 8, 2, false, WeaponType.impact);

        this.addWeaponToUnit(weapon3);
        this.addWeaponToUnit(weapon4);
    }
}
