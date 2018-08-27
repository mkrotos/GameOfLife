package com.krotos;

public class Main {
    public static void main(String[] args) {
        GameCore gameCore=new GameCore(10,10);
        gameCore.start();
        gameCore.nextTurn();
    }
}
