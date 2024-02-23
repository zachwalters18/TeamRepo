package BasicClassesCoding;
//import scanner
import java.util.Scanner;
//make sure you extend your class to test
public class test extends hardSkill{
    public static void main(String[] args) {
        //scn is the scanner for input
        Scanner scn = new Scanner(System.in);
        //hard skill object as hd
        hardSkill hd = new hardSkill();

        //testing out hard skill 
        System.out.println("Enter title and level:");
        //setters
        hd.setTitle(scn.nextLine());
        hd.setLevel(scn.nextLine());
        //getters
        System.out.println(hd.getLevel());
        System.out.println(hd.getTitle());
        //displays all the info gathered
        hd.displayDetails();

        Job jb1 = new Job();
        System.out.println("Enter Job title and years of experience");
        jb1.setTitle(scn.nextLine());
        jb1.setExperience(scn.nextInt());
        jb1.displayDetails();
    }
}