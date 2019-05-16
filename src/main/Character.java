package main;

public abstract class Character {
    //Stock le nom de notre perso
    protected String name;
    //Stock l'url de l'image de notre perso
    protected String image;
    //Stock les points de vie de notre perso
    protected int life;
    //Stock la force de l'attaque de notre perso
    protected int attack;

    // constructeur par défault

    public Character(){

    }

    public Character(String name, String image, int life, int attack) {
        this.name = name;
        this.image = image;
        this.life = life;
        this.attack = attack;

    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    //Guetters

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getLife() {
        return life;
    }

    public int getAttack() {
        return attack;
    }
//
//    protected void manger(){
//        System.out.println("Je mange de la viande.");
//    }
//
//    protected void boire(){
//        System.out.println("Je bois de l'eau !");
//    }
//
//    abstract void deplacement();
//
//    abstract void crier();

    public String toString() {
        return "Character Type: " + this.getClass().getSimpleName() +
                "\nName: " + this.name +
                "\nimage: " + this.image +
                "\nLife: " + this.life +
                "\nattack: " + this.attack ;

    }
    public String toStringWithIndex() {
        return "1 - Name: " + this.name +
                "\n2 - Image: " + this.image +
                "\n3 - Life: " + this.life +
                "\n4 - attack: " + this.attack ;

    }
}
