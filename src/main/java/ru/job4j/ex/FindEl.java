package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        if (key == null) {
            throw new ElementNotFoundException("Element could not be null");
        }
        int rsl = -1;
        for (int i = 0; i < value.length - 1; i++) {
            if (key.equals(value[i])) {
                rsl = i;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[] {"Petr", "Semen", "Igor"}, "Slava");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}