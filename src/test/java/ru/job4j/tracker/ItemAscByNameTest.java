package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemAscByNameTest {

    @Test
    public void whenAscending() {
        Item first = new Item("Oleg", 1);
        Item second = new Item("Ivan", 6);
        Item third = new Item("Petr", 3);
        List<Item> items = new ArrayList<>();
        items.add(first);
        items.add(second);
        items.add(third);
        items.sort(new ItemAscByName());
        List<Item> expected = List.of(second, first, third);
        assertEquals(expected, items);
    }

}