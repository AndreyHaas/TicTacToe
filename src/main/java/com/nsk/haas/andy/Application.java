package com.nsk.haas.andy;

import com.nsk.haas.andy.base.Field;

public class Application {
    public static void main(String[] args) {
        new Application().game();
    }

    private void game() {
        Field.init();
    }
}
