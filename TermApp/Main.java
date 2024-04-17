package TermApp;

import java.util.Scanner;
import java.util.ArrayList;

public class Main extends TEMPARRAYS{
    static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) {
        TEMPARRAYS temp = new TEMPARRAYS();
        //users
        temp.createFakeUsers();

        boolean closeProgram = false;
        String index = "";
        while(!closeProgram) {          //testing code (we should mostly develop the app to work in the console first)
            System.out.println("Select an option by inputting its index: ");
            System.out.println("1.Log in\n2.Create a new User\n3.Edit User\n4.Delete User\n5.Display Users\n6.Log out\n7.Close Program");
            index = scnr.nextLine();

            if (index.equals("1")) {
                System.out.println("Yay!");
            } else if (index.equals("2")) {
                System.out.println("Yay!");
            } else if (index.equals("3")) {
                System.out.println("Yay!");
            } else if (index.equals("4")) {
                System.out.println("Yay!");
            } else if (index.equals("5")) {
                System.out.println("Yay!");
            } else if (index.equals("6")) {
                System.out.println("Yay!");
            } else if (index.equals("7")) {
                System.out.println("Terminating Program...");
                closeProgram = true;
            } else {
                System.out.println("INCORRECT INPUT ");
            }
        }
    }
}