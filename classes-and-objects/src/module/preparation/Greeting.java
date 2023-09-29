package module.preparation;

public class Greeting {
    private String salutation = HELLO;

    public Greeting() {}

    public Greeting(String salutation) {
        this.salutation = salutation;
    }

    public String sayHello(String name) {
        return String.format("%s %s", salutation, name);
    }

    public String sayHello() {
        return sayHello("Nobody");
    }

    protected static final String HELLO = "Hello";
}
