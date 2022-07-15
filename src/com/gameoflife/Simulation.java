package com.gameoflife;

public class Simulation {

    private static GameOfLife game = new GameOfLife(10);
    public static void start(int x, int y) {
        game.initCells();
        game.setLiveCell(x, y);
        simulate();
        game.printMatrix();
    }

    private static void simulate() {
        game.setNeighbors();
//        while (true) {
//
//        }
    }

}
