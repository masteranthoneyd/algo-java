package com.yangbingdong.algo.basic.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class HashMapTest {

    HashMap<String, String> map;

    @BeforeEach
    void init() {
        map = new HashMap<>(4);
    }

    @Test
    void testPutAndGet() {
        map.put("A", "A");
        map.put("B", "B");
        assertEquals("A", map.get("A"));
        assertEquals("B", map.get("B"));
        assertEquals(2, map.size());
    }

    @Test
    void testRemove() {
        map.put("A", "A");
        map.put("B", "B");
        map.remove("A");
        assertNull(map.get("A"));
        assertEquals("B", map.get("B"));
        assertEquals(1, map.size());
    }

    @Test
    void testResize() {
        map = Mockito.spy(new HashMap<>(4));
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        Mockito.verify(map).resize();
    }
}
