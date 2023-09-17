import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Unit> allUnits;
    private List<Unit> fightingUnits;

    public Player(String name) {
        this.name = name;
        this.allUnits = new ArrayList<>();
        this.fightingUnits = new ArrayList<>();
    }

    public void addUnitsToAllUnits(Unit unit){
        this.allUnits.add(unit);
    }

    public void addUnitsToFigthingUnits(Unit unit){
        this.fightingUnits.add(unit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Unit> getAllUnits() {
        return allUnits;
    }

    public void setAllUnits(List<Unit> allUnits) {
        this.allUnits = allUnits;
    }

    public List<Unit> getFightingUnits() {
        return fightingUnits;
    }

    public void setFightingUnits(List<Unit> fightingUnits) {
        this.fightingUnits = fightingUnits;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", allUnits=" + allUnits +
                ", fightingUnits=" + fightingUnits +
                '}';
    }
}
