package com.nsk.haas.andy;

import com.nsk.haas.andy.base.Field;
import com.nsk.haas.andy.base.MainMenu;

public class Application {
    public static void main(String[] args) {
        new MainMenu().gameMenuSelection();
        new Field().drawInitField();
    }
}
