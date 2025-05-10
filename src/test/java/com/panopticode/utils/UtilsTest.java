package com.panopticode.utils;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class UtilsTest {
    @Test
    public void min() {
        assertEquals(Utils.min(1, 2, 3, 4, 5, 6, 7, 8), 1);
    }

    @Test
    public void min_negatives() {
        assertEquals(Utils.min(1, 2, 3, -4, 5, 6, 7, 8), -4);
    }

    @Test
    public void min_empty() {
        assertThrows(IllegalArgumentException.class, Utils::min);
    }

    @Test
    public void min_singleELement() {
        assertEquals(Utils.min(54), 54);
    }
}