package com.nsk.haas.andy.base;

public class Field {
    private static final int SIDE_SIZE = 3;
    private static final String DRAW_PLAYING_FIELD_LINE = "    |    |    ";
    private static final String SEPARATOR_UNDERLINE = "--------------";

    private String[][] gameField = new String[SIDE_SIZE][SIDE_SIZE];

    public void drawInitField() {
        System.out.println(DRAW_PLAYING_FIELD_LINE);
        System.out.println(SEPARATOR_UNDERLINE);
        System.out.println(DRAW_PLAYING_FIELD_LINE);
        System.out.println(SEPARATOR_UNDERLINE);
        System.out.println(DRAW_PLAYING_FIELD_LINE);
    }
}
