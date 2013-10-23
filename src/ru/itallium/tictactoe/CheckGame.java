package ru.itallium.tictactoe;

public class CheckGame {

    public static char check() {
        char winner = Field.DEFAULT_SYMBOL;

        //Проверка победителя по строкам
        for(int i = 0; i < Field.FIELD_SIZE; i++) {
            if(Field.field[i][0] == Field.field[i][1] && Field.field[i][1] == Field.field[i][2] && Field.field[i][0] != Field.DEFAULT_SYMBOL) {
                winner = Field.field[i][0];
                break;
            }
        }

        //Проверка победителя по столбцам
        for(int i = 0; i < Field.FIELD_SIZE; i++) {
            if(Field.field[0][i] == Field.field[1][i] && Field.field[1][i] == Field.field[2][i] && Field.field[i][0] != Field.DEFAULT_SYMBOL) {
                winner = Field.field[0][i];
                break;
            }
        }

        //Проверка победителя по главной диагонали
        if(Field.field[0][0] == Field.field[1][1] && Field.field[1][1] == Field.field[2][2]) {
            winner = Field.field[0][0];
        }

        //Проверка победителя по дополнительной диагонали
        if(Field.field[0][2] == Field.field[1][1] && Field.field[1][1] == Field.field[2][0]) {
            winner = Field.field[0][2];
        }
        return winner;
    }

    public static boolean CanMove() {
        boolean canMove = false;
        for (int i = 0; i < Field.FIELD_SIZE; i++) {
            for (int j = 0; j < Field.FIELD_SIZE; j++) {
                if (Field.field[i][j] == Field.DEFAULT_SYMBOL) canMove = true;
            }
        }
        return canMove;
    }

}
