package ru.itallium.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanMove {

    private static final int OUT_OF_RANGE = -1;

    public static void move() throws NumberFormatException {
        int y = OUT_OF_RANGE, x = OUT_OF_RANGE;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(x < 0 || x > 2 || y < 0 || y > 2 || Field.field[y][x] != Field.DEFAULT_SYMBOL) {
            try {
                System.out.println("Enter row (1..3):");
                y = Integer.parseInt(reader.readLine()) - 1;
                if (y < 0 || y > 2) {
                    System.out.println("Out of range. Please retry input.");
                    Field.PrintField();
                    continue;
                }
                System.out.println("Enter col (1..3)");
                x = Integer.parseInt(reader.readLine()) - 1;
                if (x < 0 || x > 2) {
                    System.out.println("Out of range. Please retry input.");
                    Field.PrintField();
                    continue;
                }
                if (Field.field[y][x] != Field.DEFAULT_SYMBOL) {
                    System.out.println("This cell is full. Please retry input.");
                    Field.PrintField();
                    continue;
                }
            } catch (Exception NumberFormatException) {
                System.out.println("Incorrected input. Please enter only numbers.");
                y = OUT_OF_RANGE;
                x = OUT_OF_RANGE;
                continue;
            }
        }
        Field.field[y][x] = Field.HUMAN_SYMBOL;
    }

}
