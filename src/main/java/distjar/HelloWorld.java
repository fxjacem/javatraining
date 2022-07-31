package distjar;

import java.util.Arrays;

public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        System.out.println(args.length);

        if (args.length > 0) {
            System.out.println(Arrays.asList(args));
        }

    }
}
