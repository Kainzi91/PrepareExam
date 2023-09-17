import java.util.ArrayList;
import java.util.List;

public abstract class Unit {
    private UnitType type_name;
    private String name;
    private int hitpoints;
    private int moves;
    private List<Weapon> weapons;

    private String path;

    public Unit(String name, int hitpoints, int moves) {
        this.type_name = null;
        this.name = name;
        this.hitpoints = hitpoints;
        this.moves = moves;
        this.weapons = new ArrayList<>();
        this.path = "";
    }

    public void addWeaponToUnit(Weapon weapon){
        this.weapons.add(weapon);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public UnitType getType_name() {
        return type_name;
    }

    public void setType_name(UnitType type_name) {
        this.type_name = type_name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "type_name=" + type_name +
                ", name='" + name + '\'' +
                ", hitpoints=" + hitpoints +
                ", moves=" + moves +
                ", weapons=" + weapons +
                '}';
    }
}
