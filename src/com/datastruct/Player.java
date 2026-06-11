package com.datastruct;

import java.awt.Rectangle;

public class Player {
    int x = 755;
    int y = 320;
    int size = 25;

    Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    void reset() {
        x = 755;
        y = 320;
    }
}