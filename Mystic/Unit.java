import java.util.ArrayList;

public class Unit {

    private int hitpoints;
    private String name;
    private int moves;
    private String picpath;
    private ArrayList<Weapon> weapons=new ArrayList<Weapon>();



    public Unit(int hitpoints, String name, int moves, Weapon weapon, String picpath) {
        this.hitpoints = hitpoints;
        this.name = name;
        this.moves = moves;
        this.picpath=picpath;
        setWeapons(weapon);
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoves() {
        return moves;
    }
    public String getPicpath() {
        return picpath;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons( Weapon weapon) {
        weapons.add(weapon);
    }

    @Override
    public String toString() {
        return "Unit{" +
                "hitpoints=" + hitpoints +
                ", name='" + name + '\'' +
                ", moves=" + moves +
                ", picpath='" + picpath + '\'' +
                ", weapons=" + weapons +
                '}';
    }


    public String toMarkdown()
    {
        String Unit= new String("# "+ getName()+ "\nHP :" + getHitpoints() +"\nMoves: " +getMoves() +"\n## Weapons\n"
                +"| Name | Strikes | Range | Type |\n" +
                                            "| ---- | ------- | ----- | ---- |");

        for (Weapon weapon:weapons
             )
        {
            Unit+= "\n| " + weapon.getName()+" | "+weapon.getStrikes()+"x"+weapon.getDamage()+" | "+weapon.getMelee_range()+" | "+weapon.getType()+" |";
        }
        return Unit;
    }
}
