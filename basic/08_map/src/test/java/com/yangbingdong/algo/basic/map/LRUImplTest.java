package com.yangbingdong.algo.basic.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class LRUImplTest {

    LRU<String, String> LRU;

    @BeforeEach
    void init() {
        LRU = new LRUImpl<>(4);
    }

    @Test
    void testLUR() {
        LRU.put("1", "1");
        LRU.put("2", "2");
        LRU.put("3", "3");
        LRU.put("4", "4");
        assertEquals(4, LRU.size());
        System.out.println(LRU);

        assertEquals("3", LRU.get("3"));
        System.out.println(LRU);

        LRU.put("5", "5");
        System.out.println(LRU);

        LRU.remove("4");
        assertEquals(3, LRU.size());
        System.out.println(LRU);

        LRU.get("2");
        System.out.println(LRU);
    }

}
