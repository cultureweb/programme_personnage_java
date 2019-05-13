package main;

public class Spell {

        //Stock le nom du sort
        private String spellName;
        //Stock le niveau d'attaque de notre sortilege
        private int spellAttackLevel;
        //Stock le nom de l'arme utilisée par notre Class


        //Constructeur par défaut
        public Spell() {

        }
        public Spell(String spellName, int spellAttackLevel){

            this.spellName = spellName;
            this.spellAttackLevel = spellAttackLevel;

        }

        // Setters
        public void setSpellName(String spellName) {
            this.spellName = spellName;
        }

        public void setAttackLevel(int spellAttackLevel) {
            this.spellAttackLevel = spellAttackLevel;
        }

        // Getters

        public String getSpellName() {
            return spellName;
        }

        public int getAttackLevel() {
            return spellAttackLevel;
        }
    }


