package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder builder = new StringBuilder();
        int length = evenElements.size();
        for (int i = 0; i < length / 2; i++) {
                builder.append(evenElements.pollFirst());
                evenElements.pollFirst();
        }
        return builder.toString();
    }

    private String getDescendingElements() {
        StringBuilder builder = new StringBuilder();
        int length = descendingElements.size();
        for (int i = 0; i < length; i++) {
            builder.append(descendingElements.pollLast());
        }
        return builder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}