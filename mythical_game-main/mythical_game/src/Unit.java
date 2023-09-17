import java.util.ArrayList;

public class Unit {

    private String type_name;
    private String name;
    private Integer max_health;
    private Integer moves;
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();

    public Unit() {

    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMax_health() {
        return max_health;
    }

    public void setMax_health(Integer max_health) {
        this.max_health = max_health;
    }

    public Integer getMoves() {
        return moves;
    }

    public void setMoves(Integer moves) {
        this.moves = moves;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void addWeapons(Weapon weapon){
        weapons.add(weapon);
    }
}
