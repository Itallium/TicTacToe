package ru.itallium.tictactoe;

public class CompMove {

    private static int x, y;
    private static boolean moveComplete = false;

    public static void move() {

        switch(Main.difficulty) {
            case 1:
                y = (int) Math.floor(Math.random() * Field.FIELD_SIZE);
                x = (int) Math.floor(Math.random() * Field.FIELD_SIZE);
                while(Field.field[y][x] != Field.DEFAULT_SYMBOL) {
                    y = (int) Math.floor(Math.random() * Field.FIELD_SIZE);
                    x = (int) Math.floor(Math.random() * Field.FIELD_SIZE);
                }
                Field.field[y][x] = Field.COMPUTER_SYMBOL;
                break;
            case 2:
                //Отработка и закрытие незаконченных комбинаций компьютера.
                //По строкам.
                if(!moveComplete) {
                    for (int i = 0; i < Field.FIELD_SIZE; i++) {
                        if(Field.field[i][0] == Field.COMPUTER_SYMBOL && Field.field[i][1] == Field.COMPUTER_SYMBOL && Field.field[i][2] == Field.DEFAULT_SYMBOL) {
                            Field.field[i][2] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[i][1] == Field.COMPUTER_SYMBOL && Field.field[i][2] == Field.COMPUTER_SYMBOL && Field.field[i][0] == Field.DEFAULT_SYMBOL) {
                            Field.field[i][0] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[i][0] == Field.COMPUTER_SYMBOL && Field.field[i][2] == Field.COMPUTER_SYMBOL && Field.field[i][1] == Field.DEFAULT_SYMBOL) {
                            Field.field[i][1] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                    }
                }
                //По столбцам.
                if(!moveComplete) {
                    for (int i = 0; i < Field.FIELD_SIZE; i++) {
                        if(Field.field[0][i] == Field.COMPUTER_SYMBOL && Field.field[1][i] == Field.COMPUTER_SYMBOL && Field.field[2][i] == Field.DEFAULT_SYMBOL) {
                            Field.field[2][i] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[1][i] == Field.COMPUTER_SYMBOL && Field.field[2][i] == Field.COMPUTER_SYMBOL && Field.field[0][i] == Field.DEFAULT_SYMBOL) {
                            Field.field[0][i] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][i] == Field.COMPUTER_SYMBOL && Field.field[2][i] == Field.COMPUTER_SYMBOL && Field.field[1][i] == Field.DEFAULT_SYMBOL) {
                            Field.field[1][i] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                    }
                }
                //По главной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Field.field[0][0] == Field.COMPUTER_SYMBOL && Field.field[1][1] == Field.COMPUTER_SYMBOL && Field.field[2][2] == Field.DEFAULT_SYMBOL) {
                            Field.field[2][2] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][0] == Field.COMPUTER_SYMBOL && Field.field[1][1] == Field.DEFAULT_SYMBOL && Field.field[2][2] == Field.COMPUTER_SYMBOL) {
                            Field.field[1][1] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][0] == Field.DEFAULT_SYMBOL && Field.field[1][1] == Field.COMPUTER_SYMBOL && Field.field[2][2] == Field.COMPUTER_SYMBOL) {
                            Field.field[0][0] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        break;
                    }
                }
                //По дополнительной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Field.field[0][2] == Field.COMPUTER_SYMBOL && Field.field[1][1] == Field.COMPUTER_SYMBOL && Field.field[2][0] == Field.DEFAULT_SYMBOL) {
                            Field.field[2][0] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][2] == Field.COMPUTER_SYMBOL && Field.field[1][1] == Field.DEFAULT_SYMBOL && Field.field[2][0] == Field.COMPUTER_SYMBOL) {
                            Field.field[1][1] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][2] == Field.DEFAULT_SYMBOL && Field.field[1][1] == Field.COMPUTER_SYMBOL && Field.field[2][0] == Field.COMPUTER_SYMBOL) {
                            Field.field[0][2] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        break;
                    }
                }
                //Отработка и закрытие незаконченных комбинаций человека.
                //По строкам.
                if(!moveComplete) {
                    for (int i = 0; i < Field.FIELD_SIZE; i++) {
                        if(Field.field[i][0] == Field.HUMAN_SYMBOL && Field.field[i][1] == Field.HUMAN_SYMBOL && Field.field[i][2] == Field.DEFAULT_SYMBOL) {
                            Field.field[i][2] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[i][1] == Field.HUMAN_SYMBOL && Field.field[i][2] == Field.HUMAN_SYMBOL && Field.field[i][0] == Field.DEFAULT_SYMBOL) {
                            Field.field[i][0] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[i][0] == Field.HUMAN_SYMBOL && Field.field[i][2] == Field.HUMAN_SYMBOL && Field.field[i][1] == Field.DEFAULT_SYMBOL) {
                            Field.field[i][1] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                    }
                }
                //По столбцам.
                if(!moveComplete) {
                    for (int i = 0; i < Field.FIELD_SIZE; i++) {
                        if(Field.field[0][i] == Field.HUMAN_SYMBOL && Field.field[1][i] == Field.HUMAN_SYMBOL && Field.field[2][i] == Field.DEFAULT_SYMBOL) {
                            Field.field[2][i] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[1][i] == Field.HUMAN_SYMBOL && Field.field[2][i] == Field.HUMAN_SYMBOL && Field.field[0][i] == Field.DEFAULT_SYMBOL) {
                            Field.field[0][i] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][i] == Field.HUMAN_SYMBOL && Field.field[2][i] == Field.HUMAN_SYMBOL && Field.field[1][i] == Field.DEFAULT_SYMBOL) {
                            Field.field[1][i] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                    }
                }
                //По главной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Field.field[0][0] == Field.HUMAN_SYMBOL && Field.field[1][1] == Field.HUMAN_SYMBOL && Field.field[2][2] == Field.DEFAULT_SYMBOL) {
                            Field.field[2][2] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][0] == Field.HUMAN_SYMBOL && Field.field[1][1] == Field.DEFAULT_SYMBOL && Field.field[2][2] == Field.HUMAN_SYMBOL) {
                            Field.field[1][1] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][0] == Field.DEFAULT_SYMBOL && Field.field[1][1] == Field.HUMAN_SYMBOL && Field.field[2][2] == Field.HUMAN_SYMBOL) {
                            Field.field[0][0] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        break;
                    }
                }
                //По дополнительной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Field.field[0][2] == Field.HUMAN_SYMBOL && Field.field[1][1] == Field.HUMAN_SYMBOL && Field.field[2][0] == Field.DEFAULT_SYMBOL) {
                            Field.field[2][0] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][2] == Field.HUMAN_SYMBOL && Field.field[1][1] == Field.DEFAULT_SYMBOL && Field.field[2][0] == Field.HUMAN_SYMBOL) {
                            Field.field[1][1] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][2] == Field.DEFAULT_SYMBOL && Field.field[1][1] == Field.HUMAN_SYMBOL && Field.field[2][0] == Field.HUMAN_SYMBOL) {
                            Field.field[0][2] = Field.COMPUTER_SYMBOL;
                            moveComplete = true;
                            break;
                        }
                        break;
                    }
                }
                if(!moveComplete) {
                    y = (int) Math.floor(Math.random() * Field.FIELD_SIZE);
                    x = (int) Math.floor(Math.random() * Field.FIELD_SIZE);
                    while(Field.field[y][x] != Field.DEFAULT_SYMBOL) {
                        y = (int) Math.floor(Math.random() * Field.FIELD_SIZE);
                        x = (int) Math.floor(Math.random() * Field.FIELD_SIZE);
                    }
                    Field.field[y][x] = Field.COMPUTER_SYMBOL;
                }
                break;
        }
        moveComplete = false;

    }

}
