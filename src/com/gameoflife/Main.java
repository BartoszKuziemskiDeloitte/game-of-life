package com.gameoflife;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Witaj w Game of Life! Co chcesz zrobic? (Wpisz numer operacji)\n "
                + "1. Zagrac!\n 2. Zakonczyc program.");
        Scanner in = new Scanner(System.in);
        int userChoice = Integer.parseInt(in.nextLine());
        switch (userChoice) {
            case 1 -> {
                System.out.println("Ile komorek zywych chcesz wprowadzic? Wymiar tablicy to 10 x 10.");
                Scanner cell = new Scanner(System.in);
                int numberOfCells = Integer.parseInt(cell.nextLine());
                int [][] coords = new int[numberOfCells][2];
                Scanner scanner = new Scanner(System.in);
                int x, y;
                for (int i=0; i < numberOfCells; i++){
                    int numOfThisCell = i + 1;
                    System.out.println("Komorka numer: "+ numOfThisCell);
                    System.out.println("Podaj prosze wspolrzeda X komorki.");
                    x = Integer.parseInt(scanner.nextLine());
                    System.out.println("Podaj prosze wspolrzeda Y komorki.");
                    y = Integer.parseInt(scanner.nextLine());
                    coords[i][0] = x;
                    coords[i][1] = y;
                }
                Simulation.start(coords);
                break;
            }
            case 2 -> {
                return;
            }
            default -> throw new IllegalStateException("Unexpected value: " + userChoice);
        }


    }

}