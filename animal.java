
import java.util.Scanner;
public abstract class animal {

String name;
Scanner scn = new Scanner(System.in);

public String getName() {
    return name;
}

public void setName() {
    System.out.println("What is the name of your animal:");
    name = scn.nextLine();
}

public void walk() {
    System.out.println("Your " + getName() +  " has taken five steps forward!");
}

public void sleep() {
    System.out.println("Your " + getName() + " has gone to sleep for eight hours!");
}













    
    
}
