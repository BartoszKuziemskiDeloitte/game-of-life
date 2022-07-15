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
                System.out.println("Ile komórek zywych chcesz wprowadzic? Wymiar tablicy to 10 x 10.");
                Scanner cell = new Scanner(System.in);
                int numberOfCells = Integer.parseInt(cell.nextLine());
                for (int i=0; i < numberOfCells; i++){
                    int numOfThisCell = i + 1;
                    System.out.println("Komórka numer: "+ numOfThisCell);
                    System.out.println("Podaj prosze wspolrzeda X komorki.");
                    Scanner firstCellX = new Scanner(System.in);
                    int x = Integer.parseInt(firstCellX.nextLine());
                    System.out.println("Podaj prosze wspolrzeda Y komorki.");
                    Scanner firstCellY = new Scanner(System.in);
                    int y = Integer.parseInt(firstCellY.nextLine());
                    Simulation.start(x, y);
                }
                break;
            }
            case 2 -> {
                return;
            }
            default -> throw new IllegalStateException("Unexpected value: " + userChoice);
        }


    }

}