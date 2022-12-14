package com.eliassen;

import java.util.Random;

public class Board
{
    public Cell[][] board = new Cell[6][6];

    public void populateMatrix()
    {

        board = new Cell[6][6];
        String[] images = {"buddy", "santa", "kevin", "frosty"};
        Random randomGenerator = new Random();
        while (!isBoardFull())
        {
            int randomImageIndex = randomGenerator.nextInt(images.length);
            String randomImageSelected = images[randomImageIndex];

            int randomRow1 = randomGenerator.nextInt(6);
            int randomColumn1 = randomGenerator.nextInt(6);
            while (board[randomRow1][randomColumn1] != null)
            {
                randomRow1 = randomGenerator.nextInt(6);
                randomColumn1 = randomGenerator.nextInt(6);
            }

            int randomRow2 = randomGenerator.nextInt(6);
            int randomColumn = randomGenerator.nextInt(6);
            while ((randomRow1 == randomRow2 && randomColumn1 == randomColumn)
                    || board[randomRow2][randomColumn] != null)
            {
                randomRow2 = randomGenerator.nextInt(6);
                randomColumn = randomGenerator.nextInt(6);
            }

            board[randomRow1][randomColumn1] = new Cell(randomImageSelected, randomRow1, randomColumn1);
            board[randomRow2][randomColumn] = new Cell(randomImageSelected, randomRow2, randomColumn);

        }

    }

    private boolean isBoardFull()
    {
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                if (board[i][j] == null)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
