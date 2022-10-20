package collections.copy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AuctionTest {

    @Test
    void testCopy() {
        Auction auction = new Auction(5, LocalDate.of(2022, 10, 20),
                new User("Joe"),
                new Product("Computer"));

        Auction another = new Auction(auction);

        assertEquals(5, another.getPrice());
        assertEquals(LocalDate.of(2022, 10, 20), another.getStart());
        assertEquals("Joe", another.getUser().getName());
        assertEquals("Computer", another.getProduct().getName());

        auction.setPrice(10);
        auction.setStart(LocalDate.of(2022, 10, 21));
        auction.getUser().setName("Jack");
        auction.getProduct().setName("Computer2");

        assertEquals(10, auction.getPrice());
        assertEquals(LocalDate.of(2022, 10, 21), auction.getStart());
        assertEquals("Jack", auction.getUser().getName());
        assertEquals("Computer2", auction.getProduct().getName());

        assertEquals(5, another.getPrice());
        assertEquals(LocalDate.of(2022, 10, 20), another.getStart());
        assertEquals("Jack", another.getUser().getName());
        assertEquals("Computer", another.getProduct().getName());



    }

}