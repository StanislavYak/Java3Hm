package ru.hm.hm3;

import java.util.List;

public interface ClientUI {
    void showUI();

    void addMessage(String w);

    default void addMessage(List<String> messages) {
        messages.forEach(this::addMessage);
    }
}