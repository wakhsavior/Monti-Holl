package org.example;

public class Main {
    private static final int NUMBEROFTESTS = 1000;
    public static void main(String[] args) {
        int withChange = 0;
        int withoutChange = 0;
        for (int i = 0; i < NUMBEROFTESTS; i++) {
            PlayGame game = PlayGame.createGame();
            if(game.playWithoutChangeDoor()) withoutChange++;
//            System.out.println("Игра закончилась победой: " + game.playWithoutChangeDoor());
//            System.out.println("------------------------");
        }
//        System.out.println("********************\n\n");

        for (int i = 0; i < NUMBEROFTESTS; i++) {
            PlayGame game = PlayGame.createGame();
            if(game.playWithChangeDoor()) withChange++;
//            System.out.println("Игра закончилась победой: " + game.playWithChangeDoor());
//            System.out.println("------------------------");
        }
        System.out.println("Общее количество испытаний: " + NUMBEROFTESTS);
        System.out.println("Количество попед при смене решения: "+ withChange);
        System.out.println("Количество попед при сохранении решения: "+ withoutChange);

    }
}