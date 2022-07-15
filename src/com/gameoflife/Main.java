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
                System.out.println("Ile iteracji ma się wykonać?");
                int iterations = Integer.parseInt(cell.nextLine());
                int x, y;
                for (int i=0; i < numberOfCells; i++){
                    int numOfThisCell = i + 1;
                    System.out.println("Komorka numer: " + numOfThisCell);
                    while (true){
                        System.out.println("Podaj prosze wspolrzeda X komorki.");
                        x = Integer.parseInt(cell.nextLine());
                        if(x >=0 && x<100){
                            break;
                        }
                    }
                    while (true){
                        System.out.println("Podaj prosze wspolrzeda Y komorki.");
                        y = Integer.parseInt(cell.nextLine());
                        if(y >=0 && y<100){
                            break;
                        }
                    }
                    coords[i][0] = x;
                    coords[i][1] = y;
                }
                Simulation.start(coords, iterations);
                break;
            }
            case 2 -> {
                return;
            }
            default -> throw new IllegalStateException("Unexpected value: " + userChoice);
        }


    }

}