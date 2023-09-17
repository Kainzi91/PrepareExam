public class ElvishArcher extends Unit{
    public ElvishArcher(String name, int hitpoints, int moves) {
        super(name, hitpoints, moves);
        this.setType_name(UnitType.ElvishArcher);

        Weapon weapon5 = new Weapon("sword", 5, 2, false, WeaponType.blade);
        Weapon weapon6 = new Weapon("bow", 5, 4, true, WeaponType.pierce);

        this.addWeaponToUnit(weapon5);
        this.addWeaponToUnit(weapon6);
    }
}
