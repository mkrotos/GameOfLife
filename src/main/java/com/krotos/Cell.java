package com.krotos;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private boolean alive;
    private List<Cell> neighbors=new ArrayList<>();
    private int aliveNeighbors;


    public Cell(boolean alive) {
        this.alive = alive;
    }

    public int getAliveNeighbors() {
        return aliveNeighbors;
    }

    public boolean isAlive() {
        return alive;
    }

    public void addNeighbor(Cell cell){
        if(neighbors.size()>=4){
            throw new IndexOutOfBoundsException();
        }
        if(cell==null){
            throw new NullPointerException();
        }
        neighbors.add(cell);
    }

    void countLiveNeighbors(){
        int count=0;
        for(Cell cell:neighbors){
            if(cell.isAlive()){
                count++;
            }
        }
        aliveNeighbors=count;
    }
    public void convert(){
        if(alive&&aliveNeighbors<2){
            alive=false;
        }
        if(alive&&aliveNeighbors>3){
            alive=false;
        }
        if(!alive &&aliveNeighbors==3){
            alive=true;
        }
    }

}
