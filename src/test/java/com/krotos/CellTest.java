package com.krotos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    Cell cell;

    @BeforeEach
    public void beforeEach(){
        cell=new Cell(true);
    }
    @Test
    public void create(){
        assertTrue(cell.isAlive());
    }
    @Test
    public void countAliveNeighborsWithoutNeighbors(){
        cell.countLiveNeighbors();
        assertEquals(0,cell.getAliveNeighbors());
    }
    @Test
    public void countAliveNeighborsWith4Neighbors(){
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(false));
        cell.countLiveNeighbors();
        assertEquals(3,cell.getAliveNeighbors());
    }
    @Test
    public void countAliveNeighborsWith2Neighbors(){
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(false));
        cell.countLiveNeighbors();
        assertEquals(1,cell.getAliveNeighbors());
    }
    @Test
    public void setMoreThan4Neighbors(){
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(false));
        cell.addNeighbor(new Cell(false));
        cell.addNeighbor(new Cell(false));
        assertThrows(IndexOutOfBoundsException.class,()->cell.addNeighbor(new Cell(false)));
    }
    @Test
    public void dyingWithoutNeighbors(){
        cell.countLiveNeighbors();
        cell.convert();
        assertFalse(cell.isAlive());
    }
    @Test
    public void dyingWith4Neighbors(){
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));

        cell.countLiveNeighbors();
        cell.convert();
        assertFalse(cell.isAlive());
    }
    @Test
    public void livingWith3Neighbors(){
        cell=new Cell(true);
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));

        cell.countLiveNeighbors();
        cell.convert();
        assertTrue(cell.isAlive());
    }
    @Test
    public void stayingDeadWith2Neighbors(){
        cell=new Cell(false);
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));

        cell.countLiveNeighbors();
        cell.convert();
        assertFalse(cell.isAlive());
    }
    @Test
    public void resurectingWith3Neighbors(){
        cell=new Cell(false);
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));
        cell.addNeighbor(new Cell(true));

        cell.countLiveNeighbors();
        cell.convert();
        assertTrue(cell.isAlive());
    }




}