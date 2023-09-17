public class Weapon {

    private String name;
    private int strikes;
    private int damage;
    private  String melee_range;
    private String type;



    public Weapon() {
    }

    public Weapon(String name, int strikes,int damage, String type, String melee_range) {

        this.damage=damage;
        this.name = name;
        this.strikes = strikes;
        this.melee_range=melee_range;
        setType(type);
    }

    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equals(""))
        {
            System.out.println("wrong Type");
        }
        else {
            this.type = type;
        }
        }


    public String getMelee_range() {
        return melee_range;
    }

    public void setMelee_range(String melee_range) {
        this.melee_range = melee_range;
    }
}
