package com.eliassen;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller
{

    @FXML
    public GridPane gameMatrix;

    Board board = new Board();

    Cell firstCard = null;
    Cell secondCard = null;

    @FXML
    public void initialize() throws FileNotFoundException
    {
        board.populateMatrix();

        for (int row = 0; row < 6; row++)
        {
            for (int column = 0; column < 6; column++)
            {
                FileInputStream input = new FileInputStream("/Github/Christmas-Project/MemoryMatch/src/main/resources/Images/card_back.png");
                Image image = new Image(input);
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(90);
                imageView.setFitHeight(90);
                imageView.setUserData(row + "," + column);
                imageView.setOnMouseClicked(event -> {
                    try
                    {
                        cardListener(event);
                    }
                    catch (FileNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                });
                gameMatrix.add(imageView, row, column);
            }
        }

    }

    public void cardListener(MouseEvent event) throws FileNotFoundException
    {
        Node sourceComponent = (Node) event.getSource();
        String rowAndColumn = (String) sourceComponent.getUserData();

        int rowSelected = Integer.parseInt(rowAndColumn.split(",")[0]);
        int columnSelected = Integer.parseInt(rowAndColumn.split(",")[1]);

        String image = board.board[rowSelected][columnSelected].value;

        FileInputStream imageFile = new FileInputStream("/Github/Christmas-Project/MemoryMatch/src/main/resources/Images/" + image + ".png");

        Image selectedImage = new Image(imageFile);
        ((ImageView) sourceComponent).setImage(selectedImage);
        checkIfMatchingPairWasFound(rowSelected, columnSelected);

    }

    public void checkIfMatchingPairWasFound(int rowSelected, int columnSelected) throws FileNotFoundException
    {

        if (firstCard == null)
        {
            firstCard = board.board[rowSelected][columnSelected];
        }
        else if (secondCard == null)
        {
            secondCard = board.board[rowSelected][columnSelected];
        }
        else
        {
            if (firstCard.value.equals(secondCard.value))
            {
                board.board[firstCard.row][firstCard.column].wasGuessed = true;
                board.board[secondCard.row][secondCard.column].wasGuessed = true;
            }
            else
            {
                int indexFirstCardInList = (firstCard.row * 6) + firstCard.column;

                FileInputStream questionFile = new FileInputStream("/Github/Christmas-Project/MemoryMatch/src/main/resources/Images/card_back.png");
                Image questionImage = new Image(questionFile);
                ((ImageView) gameMatrix.getChildren().get(indexFirstCardInList)).setImage(questionImage);

                int indexSecondCardInList = (secondCard.row * 6) + secondCard.column;
                ((ImageView) gameMatrix.getChildren().get(indexSecondCardInList)).setImage(questionImage);
            }

            firstCard = board.board[rowSelected][columnSelected];
            secondCard = null;
        }
    }
}