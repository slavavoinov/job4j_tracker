package ru.job4j.poly;

public interface Transport {
    void ride();

    void passengers(int count);

    int fill(int fuel);
}
