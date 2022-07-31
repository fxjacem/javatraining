package distjar;

public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        if (args.length == 0) {
            System.out.println("No parameter!");
        } else {
            for (String arg: args) {
                System.out.println(arg);
            }
        }

    }
}
