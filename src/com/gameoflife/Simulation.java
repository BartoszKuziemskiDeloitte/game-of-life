package com.gameoflife;

public class Simulation {

    private static GameOfLife game = new GameOfLife(100);
    public static void start(int [][] coords, int iterations) {
//        game.initCells();
        for (int i=0; i < coords.length; i++){
            game.setLiveCell(coords[i][0], coords[i][1]);
        }
        simulate(iterations);
    }

    private static void simulate(int iterations) {
        for (int i = 0; i < iterations; i++){
//            game.printMatrix();
            game.setNeighbours();
//            System.out.println();
        }
    }

}
