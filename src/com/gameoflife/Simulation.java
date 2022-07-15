package com.gameoflife;

public class Simulation {

    private static GameOfLife game = new GameOfLife(10);
    public static void start() {
        game.initCells();
        game.setLiveCell(0, 0);
        game.setLiveCell(1, 0);
        game.setLiveCell(1,1);
        game.setLiveCell(2,1);
        game.printMatrix();
        simulate();
    }

    private static void simulate() {
        game.setNeighbors();
//        while (true) {
//
//        }
    }

}
