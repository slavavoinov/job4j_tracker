package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> inName = p -> p.getName().contains(key);
        Predicate<Person> inSurname = p -> p.getSurname().contains(key);
        Predicate<Person> inPhone = p -> p.getPhone().contains(key);
        Predicate<Person> inAdress = p -> p.getAddress().contains(key);
        Predicate<Person> combine = inName.or(inSurname.or(inAdress.or(inPhone)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}