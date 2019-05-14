package main;

public class Magician extends Character{

    private Spell spell;
    private String potion;


    //Constructeur par défaut

    public Magician() {

    }

    public Magician(String spellName, int attackLevel, String potion){

        this.spell = new Spell(spellName, attackLevel);
        this.potion = potion;

    }

    // Setters

    public void setSpell(Spell spell) { this.spell = spell; }

    public void setPotion(String potion) {
        this.potion = potion;
    }

    // Getters

    public Spell getSpell() { return spell; }

    public String getPotion() {
        return potion;
    }

    public String toString() {
        return super.toString() +
                "\nSpell: " + this.spell.getSpellName() +
                "\nSpell: " + this.spell.getAttackLevel() +
                "\nPotion: " + this.potion;

    }
}
