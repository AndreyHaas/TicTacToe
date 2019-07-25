package com.nsk.haas.andy.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Field {
    private static final Logger LOGGER = LoggerFactory.getLogger(Field.class);

    private Field() {
    }

    public static char[][] init() {
        char fieldWidth = 0;
        char fieldHeight = 0;

        BufferedReader width = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader height = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введите цифровое значение высоты игрового поля:");
            fieldWidth = (char) width.read();
            System.out.println("Введите цифровое значение ширины игрового поля:");
            fieldHeight = (char) height.read();
        } catch (IOException e) {
            LOGGER.info("Не удалось считать значение", e);
        }

        return new char[fieldHeight][fieldWidth];
    }
}
