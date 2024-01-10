package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PlayGame {
    static Random rnd = new Random();
    private static final int DOORNUMBERS = 3;
    private final Doors doors;
    private final Player player;
    private int showmanDoor;

    private PlayGame() {
        this.player = Player.createPlayer(DOORNUMBERS);
        player.chooseDoor();
//        System.out.println(player);
        this.doors = Doors.createDoors(DOORNUMBERS);
//        System.out.println(doors);
    }

    private void openDoorShowman() {
        Set<Integer> looseDoors = new HashSet<>();
        for (int i = 1; i < DOORNUMBERS + 1; i++) {
            looseDoors.add(i);
        }
        looseDoors.remove(doors.getWinDoor());
        if (looseDoors.contains(player.getPlayerDoor())) {
            looseDoors.remove(player.getPlayerDoor());
        }
        int showmenDoor = (int) looseDoors.toArray()[rnd.nextInt(looseDoors.size())];
        this.showmanDoor = showmenDoor;
//        System.out.println("Ведущий открывает дверь: " + showmenDoor);
    }

    public static PlayGame createGame() {
        return new PlayGame();
    }

    public boolean playWithChangeDoor() {
        openDoorShowman();
        Set<Integer> doors = new HashSet<>();
        for (int i = 1; i < DOORNUMBERS + 1; i++) {
            doors.add(i);
        }
        doors.remove(this.showmanDoor);
        doors.remove(player.getPlayerDoor());
        int changeDoor = (int) doors.toArray()[rnd.nextInt(doors.size())];
//        System.out.println("Игрок меняет выбор на дверь: " + changeDoor);
        player.chooseDoor(changeDoor);
        return this.checkResult();
    }

    public boolean playWithoutChangeDoor() {
        openDoorShowman();
        return this.checkResult();
    }

    public boolean checkResult() {
        if (doors.getWinDoor() == player.getPlayerDoor()) {
            return true;
        }
        return false;
    }
}
