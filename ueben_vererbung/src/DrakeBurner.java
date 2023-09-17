public class DrakeBurner extends Unit{

    public DrakeBurner(String name, int hitpoints, int moves) {
        super(name, hitpoints, moves);
        this.setType_name(UnitType.DrakeBurner);

        Weapon weapon1 = new Weapon("claws", 7, 2, false, WeaponType.blade);
        Weapon weapon2 = new Weapon("fire breath", 6, 4, true, WeaponType.fire);

        this.addWeaponToUnit(weapon1);
        this.addWeaponToUnit(weapon2);
    }
}
