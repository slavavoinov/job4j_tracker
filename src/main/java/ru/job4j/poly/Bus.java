package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
    }

    @Override
    public void passengers(int count) {
        count += count;
    }

    @Override
    public int fill(int fuel) {
        return fuel * 52;
    }
}
