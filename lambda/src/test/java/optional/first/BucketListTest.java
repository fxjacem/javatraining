package optional.first;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BucketListTest {

    BucketList bucketList;

    @BeforeEach
    void init() {
        bucketList = new BucketList();
        bucketList.addDestination(new Destination("Koppenh�ga", "v�rosn�z�s", 1300));
        bucketList.addDestination(new Destination("Tirol", "s�el�s", 720));
        bucketList.addDestination(new Destination("Lomnici-cs�cs", "hegym�sz�s, lanovk�z�s", 280));
        bucketList.addDestination(new Destination("Izland", "gleccserek, �szaki f�ny", 2900));
        bucketList.addDestination(new Destination("Szeged", "vadaspark", 175));
    }

    @Test
    void getDestinationWithKeyword() {
        assertEquals("Tirol", bucketList.getDestinationWithKeyword("s�").get().getName());
    }

    @Test
    void getDestinationWithKeywordNotFound() {
        assertEquals(Optional.empty(), bucketList.getDestinationWithKeyword("tenger"));
    }

    @Test
    void getDestinationNearerThanGiven() {
        assertEquals("Lomnici-cs�cs", bucketList.getDestinationNearerThanGiven(300).get().getName());
    }

    @Test
    void getDestinationNearerThanGivenNotFound() {
        assertEquals(Optional.empty(), bucketList.getDestinationNearerThanGiven(10));
    }
}