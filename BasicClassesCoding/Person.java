package BasicClassesCoding;


public class Person {

    //variables
    private String name;
    private int age;

    //instantiate the name
    public void setName(String input_name){
        this.name = input_name;
    }
    //obtain the name
    public String getName() {
        return name;
    }
    //instantiate the age
    public void setAge(int input_age) {
        this.age = input_age;
    }
    //obtain the age
    public int getAge() {
        return age;
    }
    //display the name and age
    public void displayDetails() {
        System.out.println("Name: " + getName() + " Age: " + getAge());

    
        

    }
    
  
}
