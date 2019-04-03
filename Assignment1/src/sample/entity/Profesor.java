package sample.entity;

public class Profesor {

    int id;
    String nume;
    int cnp;

    public Profesor(int id, String nume, int cnp) {
        this.id = id;
        this.nume = nume;
        this.cnp = cnp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }
}
