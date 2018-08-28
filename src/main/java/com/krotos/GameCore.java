package com.krotos;

import java.util.Random;

public class GameCore {
    private int ySize;
    private int xSize;
    private boolean notEnded;
    private Random random = new Random();
    private Cell[][] board;

    public GameCore(int ySize, int xSize) {
        this.ySize = ySize;
        this.xSize = xSize;
        notEnded = false;
        board = new Cell[ySize][xSize];
    }

    public void start() {
        notEnded = true;
        createCells();
        setNeighborhood();
        display();
        checkTheEnd();
    }

    public void nextTurn() {
        countNeighborsForEveryCell();
        convertEveryCell();
        display();
        checkTheEnd();
    }

    public boolean isNotEnded() {
        return notEnded;
    }

    private void display() {
        for (int x = 0; x < ySize; x++) {
            for (int y = 0; y < xSize; y++) {
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
        for (int x = 0; x < ySize; x++) {
            for (int y = 0; y < xSize; y++) {
                board[x][y] = new Cell(random.nextBoolean());
            }
        }
    }

    private void setNeighborhood() {
        for (int x = 0; x < ySize; x++) {
            for (int y = 0; y < xSize; y++) {
                if (x > 0) {
                    board[x][y].addNeighbor(board[x - 1][y]);
                }
                if (y > 0) {
                    board[x][y].addNeighbor(board[x][y - 1]);
                }
                if (x < this.ySize - 1) {
                    board[x][y].addNeighbor(board[x + 1][y]);
                }
                if (y < xSize - 1) {
                    board[x][y].addNeighbor(board[x][y + 1]);
                }

            }
        }
    }

    private void countNeighborsForEveryCell() {
        for (int x = 0; x < ySize; x++) {
            for (int y = 0; y < xSize; y++) {
                board[x][y].countLiveNeighbors();
            }
        }
    }

    private void convertEveryCell() {
        for (int x = 0; x < ySize; x++) {
            for (int y = 0; y < xSize; y++) {
                board[x][y].convert();
            }
        }
    }

    private int countAliveCells() {
        int count = 0;
        for (int x = 0; x < ySize; x++) {
            for (int y = 0; y < xSize; y++) {
                if (board[x][y].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    private void checkTheEnd() {
        if (countAliveCells() == 0) {
            notEnded = false;
        }
    }

}
