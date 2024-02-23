package BasicClassesCoding;
//import scanner
import java.util.Scanner;
//make sure you extend your class to test
public class test{
    public static void main(String[] args) {
        //scn is the scanner for input
        Scanner scn = new Scanner(System.in);
        //hard skill object as hd
        hardSkill hd = new hardSkill();
        Person person = new Person();
        Job jb1 = new Job();

        //testing out hard skill 
        System.out.println("Enter title of hard skill and level:");

        //setters
        hd.setTitle(scn.nextLine());
        hd.setLevel(scn.nextLine());

        //displays all the info gathered
        hd.displayDetails();

        //space for easy reading
        System.out.println();

        //set Name and Age
        System.out.println("Enter name and age:");
        person.setName(scn.nextLine());
        person.setAge(scn.nextInt());
        
        //display the Name and Age of the Person
        person.displayDetails();

        //space for easy reading 
        System.out.println();

        
        System.out.println("Enter Job Title and Months of Experience: ");
        jb1.setTitle(scn.nextLine());
        jb1.setExperience(scn.nextInt());
        jb1.displayDetails();

        
    }
}