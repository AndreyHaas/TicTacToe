package com.nsk.haas.andy.base;

public class Field {
    private static final int SIDE_SIZE = 3;
    private static final String DRAW_PLAYING_FIELD_LINE = "    |    |    ";
    private static final String SEPARATOR_UNDERLINE = "--------------";

    private String[][] gameField = new String[SIDE_SIZE][SIDE_SIZE];

    public void drawInitField() {
        for (int i = -1; i <= SIDE_SIZE; i++) {
            if (i % 2 != 0) {
                System.out.println(DRAW_PLAYING_FIELD_LINE);
            } else {
                System.out.println(SEPARATOR_UNDERLINE);
            }
        }
    }
}
