package com.gameoflife;

import java.util.Scanner;

class Game {
    public static final Scanner scanner = new Scanner(System.in);
    private final int height = 10;
    private final int width = 10;

    void start() {
        System.out.println("Witaj w Game of Life! Co chcesz zrobic? (Wpisz numer operacji)\n "
                + "1. Zagrac!\n 2. Zakonczyc program.");
        int userChoice = Integer.parseInt(scanner.nextLine());
        switch (userChoice) {
            case 1 -> {
                System.out.println("Aby zatrzymać grę wciśnij literę q oraz enter między iteracjami.");
                Simulation simulation = new Simulation(width);
                System.out.println("Ile komorek zywych chcesz wprowadzic? Wymiar tablicy to " + width + " x " + height + ".");
                int numberOfCells = Integer.parseInt(scanner.nextLine());
                int[][] coords = new int[numberOfCells][2];
//                System.out.println("Ile iteracji ma się wykonać?");
//                int iterations = Integer.parseInt(cell.nextLine());
                int x, y;
                for (int i = 0; i < numberOfCells; i++) {
                    int numOfThisCell = i + 1;
                    System.out.println("Komorka numer: " + numOfThisCell);
                    while (true) {
                        System.out.println("Podaj prosze wspolrzeda X komorki.");
                        x = Integer.parseInt(scanner.nextLine());
                        if (x >= 0 && x < width) {
                            break;
                        }
                    }
                    while (true) {
                        System.out.println("Podaj prosze wspolrzeda Y komorki.");
                        y = Integer.parseInt(scanner.nextLine());
                        if (y >= 0 && y < height) {
                            break;
                        }
                    }
                    coords[i][0] = x;
                    coords[i][1] = y;
                }
                simulation.start(coords);
            }
            case 2 -> {
                return;
            }
            default -> throw new IllegalStateException("Unexpected value: " + userChoice);
        }
        scanner.close();
    }
}