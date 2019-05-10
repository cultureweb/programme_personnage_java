package main;

public class App {
    public static void main(String[] args) {


        System.out.println("Afficher les infos du Guerrier :");

         Warrior duncan = new Warrior();
         duncan.setName("Duncan");
         duncan.setImage("https://www.google.com/search?q=duncan+warrior&tbm=isch&source=lnt&tbs=itp:clipart&sa=X&ved=0ahUKEwie95Hv9pDiAhXJURUIHaMaDQ8QpwUIIA&biw=958&bih=959&dpr=1");
         duncan.setLife(5);
         duncan.setAttack(3);
         duncan.setWeapon("sword");
         duncan.setShield("silver shied");

        System.out.println("Name : " + duncan.getName());
        System.out.println("Image : " + duncan.getImage());
        System.out.println("Life :" + duncan.getLife());
        System.out.println("Attack :" + duncan.getAttack());
        System.out.println("Weapon :" + duncan.getWeapon());
        System.out.println("Shield :" + duncan.getShield());


        System.out.println("Afficher les infos du Magicien :");

        Magician merlin = new Magician();
        merlin.setName("Merlin");
        merlin.setImage("http://ekladata.com/n4WZlH3YmOw5NW9gkUA8nSfWL_Y.png");
        merlin.setLife(5);
        merlin.setAttack(3);
        merlin.setSort("fireBall");
        merlin.setPotion("health");

        System.out.println("Name : " + merlin.getName());
        System.out.println("Image : " + merlin.getImage());
        System.out.println("Life :" + merlin.getLife());
        System.out.println("Attack :" + merlin.getAttack());
        System.out.println("Weapon :" + merlin.getSort());
        System.out.println("Shield :" + merlin.getPotion());






    }


}
