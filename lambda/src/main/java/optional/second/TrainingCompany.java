package optional.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrainingCompany {

    private List<Course> courses;

    public TrainingCompany(List<Course> courses) {
        this.courses = courses;
    }

    public Course getCheaperCourse(int maxPrice) {
        Optional<Course> result = Optional.empty();

        for (Course actual : courses) {
            if (actual.getPrice() <= maxPrice) {
                result = Optional.of(actual);
            }
        }

        return result.orElseThrow(() -> new IllegalArgumentException("No such course."));
    }

    public int getPriceOfCourseWithGivenNameAndLevel(String name, Level level) {
        Optional<Integer> result = Optional.empty();

        for (Course actual : courses) {
            if (actual.getName().equals(name) && actual.getLevel() == level) {
                result = Optional.of(actual.getPrice());
            }
        }

        return result.orElseThrow(() -> new IllegalArgumentException("No such course."));
    }

    public String getNameOfCourseWithGivenLevel(Level level) {
        Optional<String> result = Optional.empty();

        for (Course actual : courses) {
            if (actual.getLevel() == level) {
                result = Optional.of(actual.getName());
            }
        }

        return result.orElse("Sorry, there is no course at this level.");
    }


    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }
}
