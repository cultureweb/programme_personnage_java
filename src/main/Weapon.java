package main;

public class Weapon {
    //Stock le nom de L'arme du guerrier
    private String weaponName;
    //Stock le niveau d'attaque de notre arme
    private int weaponAttackLevel;
    //Stock le nom de l'arme utilisée par notre Class


    //Constructeur par défaut
    public Weapon() {

    }
    public Weapon(String weaponName, int weaponAttackLevel){

        this.weaponName = weaponName;
        this.weaponAttackLevel = weaponAttackLevel;

    }

    // Setters
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public void setAttackLevel(int weaponAttackLevel) {
        this.weaponAttackLevel = weaponAttackLevel;
    }
    // Getters

    public String getWeaponName() {
        return weaponName;
    }

    public int getAttackLevel() {
        return weaponAttackLevel;
    }
}
