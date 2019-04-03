package sample.entity;

import javafx.beans.property.SimpleStringProperty;

public class Exam {

    private final SimpleStringProperty numematerie;
    private final SimpleStringProperty numestudent;
    private final SimpleStringProperty nota;
    private final SimpleStringProperty dataexamen;

    public Exam(String numematerie, String numestudent, String nota, String dataexamen) {
        this.numematerie = new SimpleStringProperty(numematerie);
        this.numestudent = new SimpleStringProperty(numestudent);
        this.nota = new SimpleStringProperty(nota);
        this.dataexamen = new SimpleStringProperty(dataexamen);
    }

    public String getNumematerie() {
        return numematerie.get();
    }

    public SimpleStringProperty numematerieProperty() {
        return numematerie;
    }

    public void setNumematerie(String numematerie) {
        this.numematerie.set(numematerie);
    }

    public String getNumestudent() {
        return numestudent.get();
    }

    public SimpleStringProperty numestudentProperty() {
        return numestudent;
    }

    public void setNumestudent(String numestudent) {
        this.numestudent.set(numestudent);
    }

    public String getNota() {
        return nota.get();
    }

    public SimpleStringProperty notaProperty() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota.set(nota);
    }

    public String getDataexamen() {
        return dataexamen.get();
    }

    public SimpleStringProperty dataexamenProperty() {
        return dataexamen;
    }

    public void setDataexamen(String dataexamen) {
        this.dataexamen.set(dataexamen);
    }
}
