public class Weapon {
    private String name;
    private int strikes;
    private int damage;
    private boolean range;
    private WeaponType type;

    public Weapon(String name, int strikes, int damage, boolean range, WeaponType type) {
        this.name = name;
        this.strikes = strikes;
        this.damage = damage;
        this.range = range;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isRange() {
        return range;
    }

    public void setRange(boolean range) {
        this.range = range;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public String getWeaponDamage(){
        String myString = this.strikes + " * " + this.damage;
        return myString;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", strikes=" + strikes +
                ", damage=" + damage +
                ", range=" + range +
                ", type=" + type +
                '}';
    }
}
