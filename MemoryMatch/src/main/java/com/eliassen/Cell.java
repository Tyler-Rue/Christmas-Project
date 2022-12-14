package com.eliassen;

public class Cell
{
    public String value;
    public int row;
    public int column;
    public boolean wasGuessed;

    Cell(String value, int row, int column)
    {
        this.value = value;
        this.row = row;
        this.column = column;
        this.wasGuessed = false;
    }
}
