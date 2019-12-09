package com.example.canyourunalap;


import java.util.HashMap;
import java.util.Map;

public final class Storage {
    public static Map<Integer, String> players = new HashMap<>();
    public static void add(String name, Integer laps) {
        players.put(laps, name);
    }
    public static void remove(Integer laps) { players.remove(laps); }
    Storage() {
    }
}
