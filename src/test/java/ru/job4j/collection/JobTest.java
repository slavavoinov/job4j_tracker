package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenAscByPriority() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 2));
        list.add(new Job("Fix bug", 1));
        list.sort(new JobAscByPriority());
        int result = list.get(0).getPriority();
        int expected = 1;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenDescByPriority() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 2));
        list.add(new Job("Fix bug", 1));
        list.sort(new JobDescByPriority());
        int result = list.get(0).getPriority();
        int expected = 2;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenAscByName() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 2));
        list.add(new Job("Fix bug", 1));
        list.sort(new JobAscByName());
        String result = list.get(0).getName();
        String expected = "Fix bug";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenDescByName() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 2));
        list.add(new Job("Fix bug", 1));
        list.sort(new JobDescByName());
        String result = list.get(1).getName();
        String expected = "Fix bug";
        assertThat(result).isEqualTo(expected);
    }
}