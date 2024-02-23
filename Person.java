import java.util.Scanner;

public class Person {
    Scanner scn = new Scanner(System.in);

    String name;
    int age;

    public void setName(String input_name){
        this.name = input_name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int input_age) {
        this.age = input_age;
    }

    public int getAge() {
        return age;
    }
        
    public void displayDetails() {
        setName(scn.nextLine());
        String personName = getName();
        System.out.println("Name: " + personName);

        setAge(scn.nextInt());
        int personAge = getAge();
        System.out.println("Age: " + personAge);

    }
    
  
}
