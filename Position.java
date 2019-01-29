package com.mygdx.space.utils;

public class Position {
    private int xPos;
    private int yPos;
    public Position(int x,int y){
        xPos = x;
        yPos = y;
    }
    public Position(float x, float y){
        xPos = getGridSquare(x);
        yPos = getGridSquare(y);
    }
    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }
    private int getGridSquare(float num){
        return (int) num / Constants.gridSquareSize;

    }
    public float getBottomLeftX(){
        return xPos * Constants.gridSquareSize;
    }
    public float getBottomLeftY(){
        return yPos * Constants.gridSquareSize;
    }
}
