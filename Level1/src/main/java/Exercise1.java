class Animal{
    void makeSound(){
        System.out.println("Animal called!!");
    }
}
class Dog extends Animal{
    @Override
    void makeSound() {
        System.out.println("Dog Called!!");
    }
}
public class Exercise1 {
    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.makeSound();
    }
}
