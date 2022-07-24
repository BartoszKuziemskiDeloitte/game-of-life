package com.gameoflife;

public class GameOfLife {

    private final int size;
    private final boolean[][] matrix;


    public GameOfLife(int size) {
        this.size = size;
        this.matrix = new boolean[size][size];
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void setLiveCell(int x, int y) {
        matrix[y][x] = true;
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j]) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" O ");
                }
            }
            System.out.println();
        }
    }

    public int countAliveNeighbours(boolean[][] matrix, int x, int y) {
        int counter = 0;
        for (int i = (Math.max(0, x - 1)); i <= (Math.min(x + 1, size - 1)); i++) {
            for (int j = (Math.max(0, y - 1)); j <= (Math.min(y + 1, size - 1)); j++) {
                if (matrix[i][j]) {
                    counter++;
                }
            }
        }
        if (matrix[x][y]) {
            return counter - 1;
        } else {
            return counter;
        }
    }

    public void setNeighbours() {
        boolean[][] oldMatrix = new boolean[size][size];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, oldMatrix[i], 0, matrix[i].length);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean isAlive = matrix[i][j];
                int numOfAliveCells = countAliveNeighbours(oldMatrix, i, j);
                if (!isAlive) {
                    if (numOfAliveCells == 3) {
                        matrix[i][j] = true;
                    }
                } else {
                    if (numOfAliveCells < 2 || numOfAliveCells > 3) {
                        matrix[i][j] = false;
                    }
                }
            }
        }
    }
}
