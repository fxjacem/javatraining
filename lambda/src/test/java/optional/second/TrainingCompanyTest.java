package optional.second;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainingCompanyTest {

    TrainingCompany company;

    @BeforeEach
    void init() {
        List<Course> courses = Arrays.asList(
                new Course("Kert?szked?s", Level.ADVANCED, 78000),
                new Course("Fodr?sz", Level.BEGINNER, 153000),
                new Course("Angol nyelvtanfolyam", Level.BEGINNER, 35000),
                new Course("Biztons?gi ?r", Level.ADVANCED, 145000),
                new Course("B?r- ?s TB ?gyint?z?", Level.BEGINNER, 86000)
        );
        company = new TrainingCompany(courses);
    }

    @Test
    void testGetCheaperCourse() {
        Course expected = company.getCheaperCourse(80000);

        assertEquals("Angol nyelvtanfolyam", expected.getName());
        assertEquals(35000, expected.getPrice());
    }

    @Test
    void testGetCheaperCourseNoSuchCourse() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> company.getCheaperCourse(100));
        assertEquals("No such course.", ex.getMessage());
    }

    @Test
    void testGetPriceOfCourseWithGivenNameAndLevel() {
        assertEquals(145000, company.getPriceOfCourseWithGivenNameAndLevel("Biztons?gi ?r", Level.ADVANCED));
    }

    @Test
    void testGetPriceOfCourseWithGivenNameAndLevelNoSuchCourse() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> company.getPriceOfCourseWithGivenNameAndLevel("Titk?rn?", Level.BEGINNER));
        assertEquals("No such course.", ex.getMessage());
    }

    @Test
    void testGetNameOfCourseWithGivenLevel() {
        assertEquals("B?r- ?s TB ?gyint?z?", company.getNameOfCourseWithGivenLevel(Level.BEGINNER));
    }

    @Test
    void testGetNameOfCourseWithGivenLevelNoCourseFound() {
        assertEquals("Sorry, there is no course at this level.", company.getNameOfCourseWithGivenLevel(Level.EXPERT));
    }
}