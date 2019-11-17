package sample.database.entities;

public class Address {

    private String first;

    public Address(){
    }

    public Address(String first){
        this.first = first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getFirst() {
        return first;
    }

}
