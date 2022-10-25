package streamsalgorithms;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final List<Employee> employees = Arrays.asList(
            new Employee("First", 1990),
            new Employee("Second", 1980),
            new Employee("Third", 1970),
            new Employee("Fourth", 2000)
    );

    public static void main(String[] args) {

        System.out.println("Adatok: " + employees);

//        1. Összegezd az alkalmazottak születési éveit!
        int yearSum = employees.stream()
                .mapToInt(Employee::year)
                .sum();
        System.out.println("1. Összegezd az alkalmazottak születési éveit! Eredmény: " + yearSum);

//        2. Összegezd az alkalmazottak életkorát!
        int currentYear = LocalDate.now().getYear();
        int ageSum = employees.stream()
                .mapToInt(employee -> currentYear - employee.year())
                .sum();
        System.out.println("2. Összegezd az alkalmazottak életkorát! Eredmény: " + ageSum);

//        3. Add vissza streammel, hány alkalmazott van a listában!
        long countEmployees = employees.stream()
                .count();
        System.out.println("3. Add vissza streammel, hány alkalmazott van a listában! Eredmény: " + countEmployees);

//        4. Add vissza, hány alkalmazott született 1990-nél korábban!
        long before1990 = employees.stream()
                .filter(employee -> employee.year() < 1990)
                .count();
        System.out.println("4. Add vissza, hány alkalmazott született 1990-nél korábban! Eredmény: " + before1990);

//        5. Add vissza a legkorábban született alkalmazott születési évét!
        int earliestYear = employees.stream()
                .mapToInt(Employee::year)
                .sorted()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nincs adat"));
        System.out.println("5. Add vissza a legkorábban született alkalmazott születési évét! Eredmény: "  + earliestYear);

//        6. Add vissza a legkorábban született alkalmazott nevét! (Itt szükség lesz a findFirst() záróműveletre.)
        String earliestName = employees.stream()
                .sorted(Comparator.comparingInt(Employee::year))
                .map(Employee::name)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nincs adat"));
        System.out.println("6. Add vissza a legkorábban született alkalmazott nevét! Eredmény: " + earliestName);

//        7. Add vissza, hogy igaz-e, hogy minden alkalmazott 1980 előtt született-e?
        boolean allBefore = employees.stream()
                .allMatch(employee -> employee.year() < 1980);
        System.out.println("7. Add vissza, hogy igaz-e, hogy minden alkalmazott 1980 előtt született-e? Eredmény: " + allBefore);

//        8. Add vissza egy listában az összes, 1990-nél korábban született alkalmazottat!
        List<Employee> employeesBefore1990 = employees.stream()
                .filter(employee -> employee.year() < 1990)
                .collect(Collectors.toList());
        System.out.println("8. Add vissza egy listában az összes, 1990-nél korábban született alkalmazottat!");
        System.out.println(" Eredmény: " + employeesBefore1990);

//        9. Add vissza egy listában az összes alkalmazott nevét!
        List<String> names = employees.stream()
                .map(Employee::name)
                .collect(Collectors.toList());
        System.out.println("9. Add vissza egy listában az összes alkalmazott nevét! Eredmény: " + names);

//        10. Add vissza egy listában az összes, 1990-nél korábban született alkalmazott nevét!
        List<String> namesBefore1990 = employees.stream()
                .filter(employee -> employee.year() < 1990)
                .map(Employee::name)
                .collect(Collectors.toList());
        System.out.println("10. Add vissza egy listában az összes alkalmazott nevét! Eredmény: " + namesBefore1990);

    }
}
