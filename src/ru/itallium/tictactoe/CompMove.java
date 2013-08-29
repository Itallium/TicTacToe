package ru.itallium.tictactoe;

public class CompMove {

    private static int x, y;
    private static boolean moveComplete = false;

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
                //Отработка и закрытие незаконченных комбинаций компьютера.
                //По строкам.
                if(!moveComplete) {
                    for (int i = 0; i < 3; i++) {
                        if(Main.field[i][0] == '0' && Main.field[i][1] == '0' && Main.field[i][2] == '+') {
                            Main.field[i][2] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[i][1] == '0' && Main.field[i][2] == '0' && Main.field[i][0] == '+') {
                            Main.field[i][0] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[i][0] == '0' && Main.field[i][2] == '0' && Main.field[i][1] == '+') {
                            Main.field[i][1] = '0';
                            moveComplete = true;
                            break;
                        }
                    }
                }
                //По столбцам.
                if(!moveComplete) {
                    for (int i = 0; i < 3; i++) {
                        if(Main.field[0][i] == '0' && Main.field[1][i] == '0' && Main.field[2][i] == '+') {
                            Main.field[2][i] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[1][i] == '0' && Main.field[2][i] == '0' && Main.field[0][i] == '+') {
                            Main.field[0][i] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[0][i] == '0' && Main.field[2][i] == '0' && Main.field[1][i] == '+') {
                            Main.field[1][i] = '0';
                            moveComplete = true;
                            break;
                        }
                    }
                }
                //По главной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Main.field[0][0] == '0' && Main.field[1][1] == '0' && Main.field[2][2] == '+') {
                            Main.field[2][2] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[0][0] == '0' && Main.field[1][1] == '+' && Main.field[2][2] == '0') {
                            Main.field[1][1] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[0][0] == '+' && Main.field[1][1] == '0' && Main.field[2][2] == '0') {
                            Main.field[0][0] = '0';
                            moveComplete = true;
                            break;
                        }
                        break;
                    }
                }
                //По дополнительной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Main.field[0][2] == '0' && Main.field[1][1] == '0' && Main.field[2][0] == '+') {
                            Main.field[2][0] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[0][2] == '0' && Main.field[1][1] == '+' && Main.field[2][0] == '0') {
                            Main.field[1][1] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[0][2] == '+' && Main.field[1][1] == '0' && Main.field[2][0] == '0') {
                            Main.field[0][2] = '0';
                            moveComplete = true;
                            break;
                        }
                        break;
                    }
                }
                //Отработка и закрытие незаконченных комбинаций человека.
                //По строкам.
                for (int i = 0; i < 3; i++) {
                    if(Main.field[i][0] == 'X' && Main.field[i][1] == 'X' && Main.field[i][2] == '+') {
                        Main.field[i][2] = '0';
                        moveComplete = true;
                        break;
                    }
                    if(Main.field[i][1] == 'X' && Main.field[i][2] == 'X' && Main.field[i][0] == '+') {
                        Main.field[i][0] = '0';
                        moveComplete = true;
                        break;
                    }
                    if(Main.field[i][0] == 'X' && Main.field[i][2] == 'X' && Main.field[i][1] == '+') {
                        Main.field[i][1] = '0';
                        moveComplete = true;
                        break;
                    }
                }
                //По столбцам.
                if(!moveComplete) {
                    for (int i = 0; i < 3; i++) {
                        if(Main.field[0][i] == 'X' && Main.field[1][i] == 'X' && Main.field[2][i] == '+') {
                            Main.field[2][i] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[1][i] == 'X' && Main.field[2][i] == 'X' && Main.field[0][i] == '+') {
                            Main.field[0][i] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[0][i] == 'X' && Main.field[2][i] == 'X' && Main.field[1][i] == '+') {
                            Main.field[1][i] = '0';
                            moveComplete = true;
                            break;
                        }
                    }
                }
                //По главной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Main.field[0][0] == 'X' && Main.field[1][1] == 'X' && Main.field[2][2] == '+') {
                            Main.field[2][2] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[0][0] == 'X' && Main.field[1][1] == '+' && Main.field[2][2] == 'X') {
                            Main.field[1][1] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[0][0] == '+' && Main.field[1][1] == 'X' && Main.field[2][2] == 'X') {
                            Main.field[0][0] = '0';
                            moveComplete = true;
                            break;
                        }
                        break;
                    }
                }
                //По дополнительной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Main.field[0][2] == 'X' && Main.field[1][1] == 'X' && Main.field[2][0] == '+') {
                            Main.field[2][0] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[0][2] == 'X' && Main.field[1][1] == '+' && Main.field[2][0] == 'X') {
                            Main.field[1][1] = '0';
                            moveComplete = true;
                            break;
                        }
                        if(Main.field[0][2] == '+' && Main.field[1][1] == 'X' && Main.field[2][0] == 'X') {
                            Main.field[0][2] = '0';
                            moveComplete = true;
                            break;
                        }
                        break;
                    }
                }
                if(!moveComplete) {
                    y = (int) Math.floor(Math.random() * 3);
                    x = (int) Math.floor(Math.random() * 3);
                    while(Main.field[y][x] != '+') {
                        y = (int) Math.floor(Math.random() * 3);
                        x = (int) Math.floor(Math.random() * 3);
                    }
                    Main.field[y][x] = '0';
                }
                break;
        }
        moveComplete = false;

    }

}
