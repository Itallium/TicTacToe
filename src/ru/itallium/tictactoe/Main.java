package ru.itallium.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //Создание игрового поля
    public static char field[][] = {
            { '+', '+', '+' },
            { '+', '+', '+' },
            { '+', '+', '+' }
    };

    public static int difficulty = 1;
	
	public static bool isPlayerMove;

    //Ход человека
    public static void HumanMove() throws IOException {

        int y = -1, x = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(x < 0 || x > 2 || y < 0 || y > 2 || field[y][x] != '+') {
            System.out.println("Введите строку (1..3):");
            y = Integer.parseInt(reader.readLine()) - 1;
            System.out.println("Введите столбец (1..3)");
            x = Integer.parseInt(reader.readLine()) - 1;
            if (x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Вы попали за пределы игрового поля. Повторите ввод.");
                PrintField();
                continue;
            }
            if (field[y][x] != '+') {
                System.out.println("Эта клетка уже занята. Повторите ввод.");
                PrintField();
                continue;
            }
        }
        //Так как первые условия цикла проверяют не вышли ли введённые данные за пределы поля,
        //мы не получаем ошибки программы. Если бы первым условием мы проверяли field[y][x] != '+'
        //то мы получили бы ошибку, так как одна из координат вышла за пределы границ field.
        field[y][x] = 'X';

    }

    //Распечатка текущего состояния игрового поля.
    public static void PrintField() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

    }

    //Проверка на наличие ходов.
    public static boolean CanMove() {

        int canMove = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == '+') canMove = 1;
            }
        }
        if (canMove == 1) return true;
        else return false;

    }

    //Проверка победителя
    public static char CheckGame() {

        char winner = '+';
        //Проверка победителя по строкам
        for(int i = 0; i < 3; i++) {
            if(field[i][0] == field[i][1] && field[i][1] == field[i][2] && field[i][0] != '+') {
                winner = field[i][0];
                break;
            }
        }

        //Проверка победителя по столбцам
        for(int i = 0; i < 3; i++) {
            if(field[0][i] == field[1][i] && field[1][i] == field[2][i] && field[i][0] != '+') {
                winner = field[0][i];
                break;
            }
        }

        //Проверка победителя по главной диагонали
        if(field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
            winner = field[0][0];
        }

        //Проверка победителя по дополнительной диагонали
        if(field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
            winner = field[0][2];
        }
        //Хотелось бы отметить, что я не проверяю перед каждым циклом наличие победителя.
        //Программа проверяет победителя после каждого хода, поэтому неоднознацных ситуаций
        //не возникает.
        return winner;

    }
	
	public static void toggleTurn() {
		isPlayerMove = isPlayerMove ? false : true;
	}
	
	public static void doMove() {
		PrintField();
		if (isPlayerMove) {
			HumanMove();
		} else {
			CompMove.move();
		}
		PrintField();
		toggleTurn();
	}
	
	public static void clearField() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				field[i][j] = '+';
			}
		}
	}

    public static void main(String[] args) throws IOException {

        int gameCount = 0; //Номер партии

        System.out.println("Выберите сложность:\n1. Random-bot\n2. Умный соперник.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        difficulty = Integer.parseInt(reader.readLine());
		while(difficulty < 1 || difficulty > 2) {
			switch (difficulty) {
			case 1:
				System.out.println("Вы выбрали в соперники \"Random-bot\".");
				break;
			case 2:
				System.out.println("\bВы выбрали в соперники \"Умный соперник\".");
				break;
			default:
				System.out.println("Вы ввели некорректные данные. Пожалуйста, повторите ввод.");
				System.out.println("Выберите сложность:\n1. Random-bot\n2. Умный соперник.");
				reader = new BufferedReader(new InputStreamReader(System.in));
				difficulty = Integer.parseInt(reader.readLine());
			}
		}

		reader = new BufferedReader(new InputStreamReader(System.in));
		
		//Основной цикл игры исполняется хотя бы один раз и продолжается
		//если пользователь введёт с клавиатуры символ 'y' и нажмёт Enter
        do {
			gameCount++;
			clearField();
            System.out.println("Игра №" + gameCount + " началась!");
			
            //Случайным образом выбираем игрока.
            float gamer = (float) Math.random();
            //Функция Math.random() выдаёт случайное число от 0 до 1.
            if (gamer <= 0.5) {
				isPlayerMove = false;
                System.out.println("Первым ходит компьютер.");
			} else {
				isPlayerMove = true;
                System.out.println("Первым ходит игрок.");
			}
			
			while(CheckGame() == '+' && CanMove()) {
				doMove();
			}
			
            if (!CanMove()) System.out.println("Ходов больше нет.");
			
            if (CheckGame() == 'X') {
				System.out.println("Поздравляю, ты выиграл!");
			} else {
				System.out.println("Ты проиграл.");
			}
			
            System.out.print("\n~~~~~~~~\nХотите попробовать ещё раз? y - yes\n");
        } while(reader.readline().equals("y"));
		
        System.out.println("Спасибо, что протестировали мою игру. Надеюсь вам понравилось.");
        System.out.print("Created by Itallium. 2013");
    }
}
