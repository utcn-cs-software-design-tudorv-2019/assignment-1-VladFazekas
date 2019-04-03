package sample.entity;

import javafx.beans.property.SimpleStringProperty;

public class Student {

    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty cnp;
    private final SimpleStringProperty icn;
    private final SimpleStringProperty address;
    private final SimpleStringProperty materii;
    private final SimpleStringProperty grupa;

    public Student(String id, String name, String cnp, String icn, String address, String materii, String grupa) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.cnp = new SimpleStringProperty(cnp);
        this.icn = new SimpleStringProperty(icn);
        this.address = new SimpleStringProperty(address);
        this.materii = new SimpleStringProperty(materii);
        this.grupa = new SimpleStringProperty(grupa);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCnp() {
        return cnp.get();
    }

    public SimpleStringProperty cnpProperty() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp.set(cnp);
    }

    public String getIcn() {
        return icn.get();
    }

    public SimpleStringProperty icnProperty() {
        return icn;
    }

    public void setIcn(String icn) {
        this.icn.set(icn);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getMaterii() {
        return materii.get();
    }

    public SimpleStringProperty materiiProperty() {
        return materii;
    }

    public void setMaterii(String materii) {
        this.materii.set(materii);
    }

    public String getGrupa() {
        return grupa.get();
    }

    public SimpleStringProperty grupaProperty() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa.set(grupa);
    }
}
