package com.gameoflife;

public class Simulation {

    private static GameOfLife game = new GameOfLife(10);
    public static void start(int [][] coords) {
//        game.initCells();
        for (int[] coord : coords) {
            game.setLiveCell(coord[0], coord[1]);
        }
        simulate();
    }

    private static void simulate() {
        for (int i = 0; i < 10; i++){
            game.printMatrix();
            game.setNeighbours();
            System.out.println();
        }
//        while (true) {
//
//        }
    }

}
