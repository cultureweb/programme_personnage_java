package main;

public class Warrior extends Character{

    //Stock le nom de l'arme utilisée par notre Class
    private Weapon weapon;
    //Stock le nom du bouclier utilisée par notre guerrier
    private String shield;

    //Constructeur par défaut

    public Warrior() {

    }

    public Warrior(String name, String image ,int life, int attack, String weaponName, int attackLevel, String shield) {
       super(name, image,  life, attack);
        this.weapon = new Weapon(weaponName, attackLevel);
        this.shield = shield;

    }

    public String toString() {
        return  super.toString() +
                "\nWeapon: " + this.weapon.getWeaponName() +
                "\nWeapon: " + this.weapon.getAttackLevel() +
                "\nShield: " + this.shield;

    }
    public String toStringWithIndex() {
        return  super.toStringWithIndex() +
                "\n5 - Weapon's name: " + this.weapon.getWeaponName() +
                "\n6 - Weapon's attack: " + this.weapon.getAttackLevel() +
                "\n7 - Shield: " + this.shield;

    }

    // Setters


    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    // Getters


    public Weapon getWeapon() {
        return weapon;
    }

    public String getShield() {
        return shield;
    }

}
