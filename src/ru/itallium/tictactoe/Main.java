package ru.itallium.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int difficulty = 0;
	
	public static boolean isPlayerMove;

    public static void main(String[] args) throws IOException {

        int gameCount = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		do {
            System.out.println("Select difficulty:\n1. Random-bot\n2. Genius.");
            try {
                difficulty = Integer.parseInt(reader.readLine());
            } catch (Exception NumberFormatException) {
                System.out.println("Incorrected input. Please enter only numbers.");
                continue;
            }
			switch (difficulty) {
			case 1:
				System.out.println("Your select is: \"Random-bot\".");
				break;
			case 2:
				System.out.println("\bYour select is: \"Умный соперник\".");
				break;
            default:
                System.out.println("Input is not correct. Please retry input.");
            }
		} while(difficulty < 1 || difficulty > 2);

        do {
			gameCount++;
			Field.clearField();
            System.out.println("Game №" + gameCount + " is started!");
			
            float gamer = (float) Math.random();
            if (gamer <= 0.5) {
				isPlayerMove = false;
                System.out.println("Computer is first.");
			} else {
				isPlayerMove = true;
                System.out.println("Gamer is first.");
			}
			
			while(CheckGame.check() == Field.DEFAULT_SYMBOL && CheckGame.CanMove()) {
				doMove();
			}
			
            Field.PrintField();
            if (!CheckGame.CanMove()) {
                System.out.println("Field is full.");
            }
			
            if (CheckGame.check() == Field.HUMAN_SYMBOL) {
				System.out.println("Congratulation, you win!");
			}

            if (CheckGame.check() == Field.COMPUTER_SYMBOL) {
				System.out.println("You lose.");
			}
			
            System.out.print("\n~~~~~~~~\nDo you retry? y - yes\n");
        } while(reader.readLine().equals("y"));
		
        System.out.println("Thank you for testing my game. May you like.");
        System.out.print("Created by Itallium. 2013");

    }

    public static void doMove(){
        if (isPlayerMove) {
            Field.PrintField();
            HumanMove.move();
        } else {
            CompMove.move();
        }
        toggleTurn();
    }

    public static void toggleTurn() {
        isPlayerMove = isPlayerMove ? false : true;
    }

}
