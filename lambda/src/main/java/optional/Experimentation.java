package optional;

import java.util.Optional;

public class Experimentation {

    public static void main(String[] args) {

        Optional<String> unknown = Optional.empty();
        System.out.println(unknown);
        System.out.println(unknown.stream().toList());

        Optional<String> another = Optional.of("Jack");
        System.out.println(another);
        System.out.println(another.stream().toList());

        if (unknown.isPresent()) {
            System.out.println(unknown.get());
        }

        if (another.isPresent()) {
            System.out.println(another.get());
        }

        System.out.println(unknown.orElse("unknown was empty"));
        System.out.println(unknown.orElseThrow(() -> new IllegalArgumentException("unknown was empty")));
    }
}
