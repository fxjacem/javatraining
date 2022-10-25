package streamsalgorithms;

public record Employee(String name, int year) {

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
