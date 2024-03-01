package ExtraCredit;

public class test {
    public static void main(String[] args) {
        hippo hp = new hippo();

        hp.identify();
        hp.speak();
        hp.setName();
        hp.walk();
        hp.eat();
        hp.checkFlying(hp.getType());
        hp.swim();
    }
}
