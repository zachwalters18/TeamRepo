package ExtraCredit;

public class hippo extends animal {
    String animalType = "hippo";

    public String getType() {
        return animalType;
    }

    public void swim() {
        System.out.println("Hippo is swimming!");
    }

    public void identify() {
        System.out.println("This animal is a hippo!");
    }

    public void speak() {
        System.out.println("Hippo is roaring!");
    }
}
