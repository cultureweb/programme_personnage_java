package main;

public class Warrior extends Character{

    //Stock le nom de l'arme utilisée par notre Class
    private Weapon weapon;
    //Stock le nom du bouclier utilisée par notre guerrier
    private String shield;

    //Constructeur par défaut

    public Warrior() {

    }

    public Warrior(String weaponName, int attackLevel, String shield) {
        this.weapon = new Weapon(weaponName, attackLevel);
        this.shield = shield;

    }
    public String toString() {
        return  super.toString() +
                "\nWeapon: " + this.weapon.getWeaponName() +
                "\nWeapon: " + this.weapon.getAttackLevel() +
                "\nShield: " + this.shield;

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
