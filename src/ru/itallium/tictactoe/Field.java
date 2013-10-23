package ru.itallium.tictactoe;

public class Field {

    public static final int FIELD_SIZE = 3;
    public static final char HUMAN_SYMBOL = 'X';
    public static final char COMPUTER_SYMBOL = '0';
    public static final char DEFAULT_SYMBOL = '+';

    public static char[][] field = new char[FIELD_SIZE][FIELD_SIZE];

    public static void PrintField() {

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

    }

    public static void clearField() {

        for(int i = 0; i < FIELD_SIZE; i++) {
            for(int j = 0; j < FIELD_SIZE; j++) {
                Field.field[i][j] = DEFAULT_SYMBOL;
            }
        }

    }

}
