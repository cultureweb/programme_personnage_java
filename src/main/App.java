package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        //Création d'un objet warrior
        Warrior warrior = new Warrior();

        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Voullez vous créer un magicien ou un guerrier : tapez 1 pour Magicien et 2 pour Guerrier :");
            choice = sc.nextInt();
//            System.out.println(choice);
        }
        while (choice != 1 && choice != 2);


        System.out.println("Vous avez choisi : " + choice);

        System.out.println("Veuillez saisir un nom de guerrier :");
        String str = sc.nextLine();
        System.out.println("Vous avez saisi : " + str);
        warrior.setName(str);

        System.out.println("Veuillez saisir l'adresse Url d'une image pour votre Guerrier " + warrior.getName());
        str = sc.nextLine();
        System.out.println("Vous avez saisi : " + str);
        warrior.setImage(str);
        int nbreSaisi;
        do {
            System.out.println("Veuillez saisir les points de vie de" + warrior.getName() + "entre 0 et 5");
            nbreSaisi = sc.nextInt();

        }
        while (nbreSaisi < 0 || nbreSaisi > 5);

        System.out.println("Vie = " + nbreSaisi);
        warrior.setLife(nbreSaisi);

//        System.out.println("Veuillez saisir les points de vie de"+ warrior.getName() + "entre 0 et 5");
//        int num = sc.nextInt();
//        System.out.println("Vous avez saisi : " + num);
//        warrior.setLife(num);


       /*System.out.println("Afficher les infos du Guerrier :");

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
        System.out.println("Shield :" + merlin.getPotion());*/


    }


}
