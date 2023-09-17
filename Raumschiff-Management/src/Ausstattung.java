public class Ausstattung {
    private String name;
    private int energieverbrauch;
    private int effizienz;
    private TypeR type;


    public Ausstattung(String name, int energieverbrauch, int effizienz, TypeR type) {
        this.name = name;
        this.energieverbrauch = energieverbrauch;
        this.effizienz = effizienz;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergieverbrauch() {
        return energieverbrauch;
    }

    public void setEnergieverbrauch(int energieverbrauch) {
        this.energieverbrauch = energieverbrauch;
    }

    public int getEffizienz() {
        return effizienz;
    }

    public void setEffizienz(int effizienz) {
        this.effizienz = effizienz;
    }

    public TypeR getType() {
        return type;
    }

    public void setType(TypeR type) {
        this.type = type;
    }

    public int getEffizienzMalEnergieverbrauch() {
        return effizienz * energieverbrauch;
    }

    @Override
    public String toString() {
        return "Ausstattung{" +
                "name='" + name + '\'' +
                ", energieverbrauch=" + energieverbrauch +
                ", effizienz=" + effizienz +
                ", type=" + type +
                '}';
    }
}
