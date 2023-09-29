package module.preparation;

public class GreetingMain {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        System.out.println(greeting.sayHello());
        String hello = new Greeting("Servus").sayHello("Franz");
        System.out.println(hello);
    }
}
