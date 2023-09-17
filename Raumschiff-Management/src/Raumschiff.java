import java.util.ArrayList;
import java.util.List;

public class Raumschiff {

    private String name;
    private int treibstoff;
    private int schutzschild;
    private String image;
    private List<Ausstattung> ausstattung;

    public Raumschiff(String name, int treibstoff, int schutzschild, String image) {
        this.name = name;
        this.treibstoff = treibstoff;
        this.schutzschild = schutzschild;
        this.image = image;
        this.ausstattung = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTreibstoff() {
        return treibstoff;
    }

    public void setTreibstoff(int treibstoff) {
        this.treibstoff = treibstoff;
    }

    public int getSchutzschild() {
        return schutzschild;
    }

    public void setSchutzschild(int schutzschild) {
        this.schutzschild = schutzschild;
    }

    public List<Ausstattung> getAusstattung() {
        return ausstattung;
    }

    public void setAusstattung(List<Ausstattung> ausstattung) {
        this.ausstattung = ausstattung;
    }

    public void addAusstattung(Ausstattung ausstattung){
        this.ausstattung.add(ausstattung);
    }

    public String getImage(){
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Raumschiff{" +
                "name='" + name + '\'' +
                ", treibstoff=" + treibstoff +
                ", schutzschild=" + schutzschild +
                ", image=" + image +
                ", ausstattung=" + ausstattung +
                '}';
    }
}
