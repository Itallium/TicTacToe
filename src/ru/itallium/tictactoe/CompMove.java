package ru.itallium.tictactoe;

public class CompMove {

    private static int x, y;

    public static void move() {

        switch(Main.difficulty) {
            case 1:
                y = (int) Math.floor(Math.random() * 3);
                x = (int) Math.floor(Math.random() * 3);
                while(Main.field[y][x] != '+') {
                    y = (int) Math.floor(Math.random() * 3);
                    x = (int) Math.floor(Math.random() * 3);
                }
                Main.field[y][x] = '0';
                break;
            case 2:
                System.out.println("Умный соперник в разработке.");
                break;
        }

    }

}
