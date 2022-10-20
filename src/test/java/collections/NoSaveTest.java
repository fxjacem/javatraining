package collections;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NoSaveTest {

    @Test
    void testSortArray() {
        int[] i = {3, 1, 6, 9, 5, 3};
        Arrays.sort(i);
        assertArrayEquals(new int[]{1, 3, 3, 5, 6, 9}, i);
    }

    @Test
    void testSortList() {
        List<Integer> i = Arrays.asList(1, 3, 3, 5, 6, 9);
        Collections.sort(i);
        assertEquals(Arrays.asList(1, 3, 3, 5, 6, 9), i);

        i = Arrays.asList(1, 3, 3, 5, 6, 9);
        i.sort(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        assertEquals(Arrays.asList(1, 3, 3, 5, 6, 9), i);
    }

    @Test
    void testSet() {
        Set<String> s = new TreeSet<>();
        s.add("Jack");
        s.add("Joe");
        s.add("Jane");
        assertEquals(Arrays.asList("Jack", "Jane", "Joe").toString(), s.toString());
        assertArrayEquals(Arrays.asList("Jack", "Jane", "Joe").toArray(), s.toArray());
    }

    @Test
    void testTrainerSet() {
        Set<Trainer> trainers = new TreeSet<>();
        trainers.add(new Trainer("Joe", 3));
        trainers.add(new Trainer("Jack", 2));
        trainers.add(new Trainer("Jane", 1));
        System.out.println(trainers);
    }

    @Test
    void testReverseList() {
        List<Integer> i = Arrays.asList(3, 1, 6, 9, 5, 3);
        Collections.reverse(i);
        assertEquals(Arrays.asList(3, 5, 9, 6, 1, 3), i);
    }

    @Test
    void testShuffleList() {
        List<Integer> i = Arrays.asList(3, 1, 6, 9, 5, 3);
        Collections.shuffle(i, new Random(5));
        assertEquals(Arrays.asList(1, 9, 5, 3, 6, 3), i);
    }

    @Test
    void testUnmodifiableList() {
        List<Integer> i = new ArrayList<>(Arrays.asList(3, 1, 6, 9, 5, 3));
        List<Integer> unmodifiable = Collections.unmodifiableList(i);

        Exception e = assertThrows(UnsupportedOperationException.class,
                () -> unmodifiable.add(11));
        e = assertThrows(UnsupportedOperationException.class, () -> unmodifiable.set(0, 11));

        assertEquals(6, unmodifiable.size());
        i.add(11);
        assertEquals(7, unmodifiable.size());
    }

    @Test
    void testEmptyList() {
        List<Integer> empty = Collections.emptyList();
        assertTrue(empty.isEmpty());

        Exception e = assertThrows(UnsupportedOperationException.class,
                () -> empty.add(13));
    }

    @Test
    void testSingleton() {
        Map<Integer, String> singletonMap = Collections.singletonMap(1, "first");
        assertEquals("first", singletonMap.get(1));
        assertEquals("{1=first}", singletonMap.toString());

        Exception e = assertThrows(UnsupportedOperationException.class,
                () -> singletonMap.put(2, "second"));
    }

    @Test
    void testSynchronized() {
        Set<Integer> original = new TreeSet<>(Arrays.asList(4, 3, 2, 0));
        assertEquals(Arrays.asList(0, 2, 3, 4), original.stream().toList());
        Set<Integer> sync = Collections.synchronizedSet(original);
        original.add(1);
        assertEquals(Arrays.asList(0, 1, 2, 3, 4), sync.stream().toList());
        sync.add(-1);
        assertEquals(Arrays.asList(-1, 0, 1, 2, 3, 4), original.stream().toList());
    }
}