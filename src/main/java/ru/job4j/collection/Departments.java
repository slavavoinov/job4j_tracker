package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            int len = value.split("/").length;
            for (String str : value.split("/")) {
                start += "".equals(start) ? str : "/" + str;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
        }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}