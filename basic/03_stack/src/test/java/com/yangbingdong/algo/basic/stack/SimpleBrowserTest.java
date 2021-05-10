package com.yangbingdong.algo.basic.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author <a href="mailto:yangbingdong1994@gmail.com">yangbingdong</a>
 * @since
 */
class SimpleBrowserTest {

    SimpleBrowser simpleBrowser;

    @BeforeEach
    void init() {
        simpleBrowser = new SimpleBrowser();
    }

    @Test
    void testOpen() {
        simpleBrowser.open("www.baidu.com");
        assertEquals("www.baidu.com", simpleBrowser.getCurUrl());
    }

    @Test
    void testFallback() {
        simpleBrowser.open("a.com");
        simpleBrowser.open("b.com");
        simpleBrowser.open("c.com");
        assertEquals("c.com", simpleBrowser.getCurUrl());
        simpleBrowser.fallback();
        assertEquals("b.com", simpleBrowser.getCurUrl());
        simpleBrowser.fallback();
        assertEquals("a.com", simpleBrowser.getCurUrl());
    }

    @Test
    void testForward() {
        simpleBrowser.open("a.com");
        simpleBrowser.open("b.com");
        simpleBrowser.fallback();
        assertEquals("a.com", simpleBrowser.getCurUrl());
        simpleBrowser.forward();
        assertEquals("b.com", simpleBrowser.getCurUrl());
    }

    @Test
    void shouldThrowIllegalArgumentException_when_couldNotFallbackOrForward() {
        simpleBrowser.open("a.com");
        simpleBrowser.open("b.com");
        assertThrows(IllegalArgumentException.class, () -> simpleBrowser.forward());
        simpleBrowser.fallback();
        assertThrows(IllegalArgumentException.class, () -> simpleBrowser.fallback());
    }

    @Test
    void shouldCannotForward_when_openNewUrl() {
        simpleBrowser.open("a.com");
        simpleBrowser.open("b.com");
        simpleBrowser.fallback();
        simpleBrowser.open("c.com");
        assertFalse(simpleBrowser.canForward());
    }

}
