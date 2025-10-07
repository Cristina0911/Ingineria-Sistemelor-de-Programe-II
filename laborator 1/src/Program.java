public class Program {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.makeSound();

        Dog d = new Dog();
        d.makeSound();

        a = new Cat();
        a.makeSound();

        a = new Pig();
        a.makeSound();
    }
}