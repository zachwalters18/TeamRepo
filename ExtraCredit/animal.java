package ExtraCredit;

import java.util.Scanner;

public abstract class animal {
    Scanner scn = new Scanner(System.in);
    private String name;

    public void setName() {
        System.out.print("Input animal's new pet name:");
        name = scn.nextLine();
    }

    public void eat() {
        System.out.println(name + "is eating food!");
    }

    public void walk() {
        System.out.println(name + "is walking away!");
    }

    public void checkFlying(String animalType) {
        if (!name.equals("bird")) {
            System.out.println(name + "cannot fly!");
        }
        else {
            System.out.println(name + "can fly!");
        }
    }
}