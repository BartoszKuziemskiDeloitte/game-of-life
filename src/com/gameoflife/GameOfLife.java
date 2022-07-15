package com.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

    private int size = 10;
    private final boolean[][] matrix = new boolean[size][size];

    private List<Cell> cells = new ArrayList<>();

    public GameOfLife(int size) {
        this.size = size;
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void setLiveCell(int x, int y) {
        matrix[y][x] = true;
        cells.get(x*size + y).setLive(true);
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j]) {
                    System.out.print(" x ");
                } else {
                    System.out.print(" o ");
                }
            }
            System.out.println();
        }
    }

    public void initCells() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells.add(new Cell(i, j));
            }
        }
    }

    public void setNeighbors() {
        for (int i = 0; i < cells.size(); i++) {
            for (int j = i + 1; j < cells.size(); j++) {
                cells.get(i).checkNeighbor(cells.get(j));
            }
        }
    }

}
