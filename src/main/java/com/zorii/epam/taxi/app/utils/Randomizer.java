package com.zorii.epam.taxi.app.utils;

import java.util.Random;

public class Randomizer {
    public static int generateDistance() {
        Random rand = new Random();
        return rand.nextInt(20) + 1; // генеруємо число від 1 до 100
    }
}
