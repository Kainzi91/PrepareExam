public class Weapon {

    private String name;
    private Integer damage;
    private Integer strikes;
    private String type;
    private Boolean is_ranged;


    public Weapon(String name, Integer damage, Integer strikes, String type, Boolean is_ranged) {
        setName(name);
        setDamage(damage);
        setStrikes(strikes);
        setType(type);
        setIs_ranged(is_ranged);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getStrikes() {
        return strikes;
    }

    public void setStrikes(Integer strikes) {
        this.strikes = strikes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIs_ranged() {
        return is_ranged;
    }

    public void setIs_ranged(Boolean is_ranged) {
        this.is_ranged = is_ranged;
    }
}
