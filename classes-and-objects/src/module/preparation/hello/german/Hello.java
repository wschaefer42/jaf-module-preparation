package module.preparation.hello.german;

public class Hello {
    private String message;

    public Hello() {
        this("Willkommen");
    }

    public Hello(String message) {
        this.message = message;
    }

    public String sayHello(String name) {
        return message + " " + name;
    }
}
