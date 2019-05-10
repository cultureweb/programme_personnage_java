package main;

public class Warrior {
        //Stock le nom de notre guerrier
        private String name;
        //Stock l'url de l'image de notre guerrier
        private  String image;
        //Stock les points de vie de notre guerrier
        private int life;
        //Stock la force de l'attaque de notre guerrier
        private int attack;
        //Stock le nom de l'arme utilisée par notre guerrier
        private String weapon;
        //Stock le nom du bouclier utilisée par notre guerrier
        private String shield;

        //Constructeur par défaut

        public Warrior(){
                name = "";
                image = "";
                life = 0;
                attack = 0;
                weapon = "";
                shield = "";

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

        public void setWeapon(String weapon) {
                this.weapon = weapon;
        }

        public void setShield(String shield) {
                this.shield = shield;
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

        public String getWeapon() {
                return weapon;
        }

        public String getShield() {
                return shield;
        }
}
