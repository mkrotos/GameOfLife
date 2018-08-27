package com.krotos;

import java.util.Random;

public class GameCore {
    private int xSize;
    private int ySize;
    private boolean run;
    private Random random = new Random();
    private Cell[][] board;

    public GameCore(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        run = false;
        board = new Cell[xSize][ySize];
    }

    public void start() {
        run = true;
        createCells();
        setNeighborhood();
        display();
    }

    public void nextTurn() {
        countNeighborsForEveryCell();
        convertEveryCell();
        display();
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void display() {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                System.out.print(dispAlive(board[x][y]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private char dispAlive(Cell cell) {
        if (cell.isAlive()) {
            return '#';
        } else {
            return '-';
        }
    }

    private void createCells() {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                board[x][y] = new Cell(random.nextBoolean());
            }
        }
    }

    private void setNeighborhood() {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                if (x > 0) {
                    board[x][y].addNeighbor(board[x - 1][y]);
                }
                if (y > 0) {
                    board[x][y].addNeighbor(board[x][y - 1]);
                }
                if (x < xSize - 1) {
                    board[x][y].addNeighbor(board[x + 1][y]);
                }
                if (y < ySize - 1) {
                    board[x][y].addNeighbor(board[x][y + 1]);
                }

            }
        }
    }

    private void countNeighborsForEveryCell() {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                board[x][y].countLiveNeighbors();
            }
        }
    }

    private void convertEveryCell() {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                board[x][y].convert();
            }
        }
    }

}
