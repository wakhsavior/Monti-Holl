package org.example;

import java.util.Random;

public class Player {
    private int playerDoor;
    private int doorNumbers;
    static Random rnd = new Random();

    private Player(int doorNumbers) {
        this.doorNumbers = doorNumbers;
        this.playerDoor = rnd.nextInt(doorNumbers);
    }

    public void chooseDoor(int n) {
        if (n > 0 && n <= doorNumbers) {
            this.playerDoor = n;
        } else {
            throw new RuntimeException("Неправильный выбор двери.");
        }
    }
    public void chooseDoor(){
        int door = rnd.nextInt(1,doorNumbers+1);
        chooseDoor(door);
    }

    static public Player createPlayer(int doorNumbers) {
        return new Player(doorNumbers);
    }

    public int getPlayerDoor() {
        return playerDoor;
    }

    @Override
    public String toString() throws RuntimeException {
        StringBuilder string = new StringBuilder();
        string.append("Игрок выбрал дверь: ");
        string.append(playerDoor);
        return string.toString();
    }
}
