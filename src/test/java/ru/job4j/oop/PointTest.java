package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when000to020then2() {
        double expected = 2;
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 2, 0);
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when000to555then8dot66() {
        double expected = 8.66;
        Point a = new Point(0, 0, 0);
        Point b = new Point(5, 5, 5);
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}
