package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    static int comparechar(String left, String right) {
        int res = 0;
        int length = Math.min(left.length(), right.length());
        for (int index = 0; index < length; index++) {
            res = Character.compare(left.charAt(index), right.charAt(index));
            if (res != 0) {
                break;
            }
        }
        return res;
    }

    @Override
    public int compare(String left, String right) {
        int rsl = comparechar(left, right);
        return rsl != 0 ? rsl : Integer.compare(left.length(), right.length());
    }
}
