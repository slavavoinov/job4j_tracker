package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Мы едем, едем, едем в далекие края...");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров" + count);
    }

    @Override
    public int fill(int fuel) {
        return fuel * 52;
    }
}
