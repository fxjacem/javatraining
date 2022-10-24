package optional.second;

public class Course {

    private String name;

    private Level level;

    private int price;

    public Course(String title, Level level, int price) {
        this.name = title;
        this.level = level;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public int getPrice() {
        return price;
    }
}
