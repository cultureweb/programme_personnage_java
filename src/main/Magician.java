package main;

public class Magician {

    private String name;
    private String image;
    private int life;
    private int attack;
    private Spell spell;
    private String potion;


    //Constructeur par défaut

    public Magician() {

    }
    public Magician(String name, String image, int life, int attack, String spellName, int attackLevel, String potion){
        this.name = name;
        this.image = image;
        this.life = life;
        this.attack = attack;
        this.spell = new Spell(spellName, attackLevel);
        this.potion = potion;

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

    public void setSpell(Spell spell) { this.spell = spell; }

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

    public Spell getSpell() { return spell; }

    public String getPotion() {
        return potion;
    }
}
