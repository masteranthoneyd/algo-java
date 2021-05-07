package com.yangbingdong.algo.basic.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ConcurrentModificationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class ArrayTest {

    Array<String> array;

    @BeforeEach
    void init() {
        array = new ArrayImpl<>();
    }

    @Test
    void testGet_givenNormalString() {
        array.add("ybd0");
        array.add(1, "ybd1");
        assertEquals(array.get(0), "ybd0");
        assertEquals(array.get(1), "ybd1");
        System.out.println(array.toString());
    }

    @Test
    void testRemove() {
        array.add("0");
        array.add("1");
        array.add("2");
        array.add("3");
        assertEquals(array.get(1), "1");
        String remove = array.remove(2);
        assertEquals(remove, "2");
        System.out.println(array.toString());
    }

    @Test
    void testSet() {
        array.add("0");
        array.add("1");
        array.set(1, "A");
        assertEquals(array.get(1), "A");
    }

    @Test
    void testSize() {
        array.add("a");
        array.add("a");
        array.add("a");
        array.add("a");
        array.add("a");
        array.add("a");
        assertEquals(array.size(), 6);
    }

    @Test
    void contains() {
        array.add("666");
        array.add("777");
        array.add("888");
        assertTrue(array.contains("666"));
        assertFalse(array.contains("555"));
    }

    @Test
    void testResize() {
        ArrayImpl<String> array = spy(new ArrayImpl<>(1));
        array.add("1");
        array.add("2");
        verify(array, Mockito.times(1)).resize(eq(2));
    }

    @Test
    void testIterator() {
        array.add("1");
        array.add("2");
        array.add("3");
        Iterator<String> iterator = array.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    void testRemoveByIterator() {
        array.add("A");
        array.add("B");
        array.add("C");
        Iterator<String> iterator = array.iterator();
        iterator.next();
        iterator.remove();
        assertEquals(array.size(), 2);
        iterator = array.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void shouldThrowConcurrentModificationException_when_modifyConcurrency() {
        array.add("1");
        array.add("2");
        array.add("3");
        Iterator<String> iterator = array.iterator();
        array.remove(2);
        Assertions.assertThrows(ConcurrentModificationException.class, iterator::next);
    }
}
