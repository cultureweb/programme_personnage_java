package main;

public class Magician {

    String name;
    String image;
    int life;
    int attack;
    String sort;
    String potion;


    public Magician(){
        name = "";
        image = "";
        life = 0;
        attack = 0;
        sort = "";
        potion = "";

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

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }

    // Getters

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

    public String getSort() {
        return sort;
    }

    public String getPotion() {
        return potion;
    }
}
