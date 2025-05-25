package com.panopticode.datastructures;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DisjointSetTest
{
    private DisjointSet ds;

    @BeforeMethod
    public void setUp()
    {
        ds = new DisjointSet(10);
        ds.add(0);
        ds.add(1);
        ds.union(0, 1);
        ds.add(2);
        ds.union(1, 2);
        ds.add(3);
        ds.add(4);
        ds.union(3, 4);
    }

    @Test
    public void testFind()
    {
        assertEquals(ds.find(0), 0);
        assertEquals(ds.find(1), 0);
        assertEquals(ds.find(2), 0);
        assertEquals(ds.find(3), 3);
        assertEquals(ds.find(4), 3);
        assertTrue(ds.find(5) < 0);
    }

    @Test
    public void testUnion()
    {
        ds.add(5);
        ds.add(6);
        ds.add(7);
    }

    @Test
    public void testAdd()
    {
        ds.add(5);
        assertEquals(ds.find(5), 5);
        ds.add(6);
        assertEquals(ds.find(6), 6);
        ds.add(7);
        assertEquals(ds.find(7), 7);
        ds.add(8);
        assertEquals(ds.find(8), 8);
        ds.add(9);
        assertEquals(ds.find(9), 9);
        ds.add(10);
        assertThrows(IllegalArgumentException.class, () -> ds.find(10));
    }

    @Test
    public void testComponents()
    {
        assertEquals(ds.components(), 2);
        var ds1 = new DisjointSet(5);
        ds1.add(0);
        ds1.add(1);
        ds1.add(2);
        ds1.add(3);
        ds1.add(4);
        assertEquals(ds1.components(), 5);
        ds1.union(0, 1);
        assertEquals(ds1.components(), 4);
        ds1.union(1, 2);
        assertEquals(ds1.components(), 3);
        ds1.union(3, 4);
        assertEquals(ds1.components(), 2);
        ds1.union(0, 4);
        assertEquals(ds1.components(), 1);
        ds1.union(1, 3);
        assertEquals(ds1.components(), 1);

    }
}
