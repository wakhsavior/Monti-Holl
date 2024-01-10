package org.example;

import java.util.Random;

/**
 *
 */

public class Doors {
    private int doorNumbers;
    private final int winDoor;
    static Random rnd = new Random();

    private Doors(int doorNumbers) {
        this.doorNumbers = doorNumbers;
        this.winDoor = rnd.nextInt(1,doorNumbers+1);
    }
    static public Doors createDoors(int doorNumbers) {
        return new Doors(doorNumbers);
    }
    public int getWinDoor() {
        return winDoor;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Победная дверь: ");
        string.append(winDoor);
        return string.toString();
    }
}
