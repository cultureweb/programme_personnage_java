package main;

public class Case {

    //Stock un ennemi qu’il faudra vaincre.
    private String name;


    public Case(String name){
        this.name = name;

    }

    public Case(){

    }

    public String toString() {
        return "_ case : " + this.name;

    }

    //getters

    public String getName() {
        return name;
    }

    //setters


    public void setName(String name) {
        this.name = name;
    }
}
