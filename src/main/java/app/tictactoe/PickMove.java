package app.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class PickMove {
    public void randomChoice(Button B_00, Button B_01, Button B_02,
                            Button B_10, Button B_11, Button B_12,
                            Button B_20, Button B_21, Button B_22){

        int ComputerSpotChoice = (int) (Math.random() * 8 ) + 1 ;

        if(ComputerSpotChoice == 1){
            if(B_00.getText().equals(" ")){
                B_00.setText("O");
                B_00.setFont(Font.font("Arial Black", 40));
                B_00.setDisable(true);
            }
            else{
                computerTurn(B_00, B_01, B_02,
                            B_10, B_11, B_12,
                            B_20, B_21, B_22,
                            ComputerSpotChoice);
            }
        }
        else if(ComputerSpotChoice == 2){
            if(B_01.getText().equals(" ")){
                B_01.setText("O");
                B_01.setFont(Font.font("Arial Black", 40));
                B_01.setDisable(true);
            }
            else{
                computerTurn(B_00, B_01, B_02,
                        B_10, B_11, B_12,
                        B_20, B_21, B_22,
                        ComputerSpotChoice);
            }
        }
        else if(ComputerSpotChoice == 3){
            if(B_02.getText().equals(" ")){
                B_02.setText("O");
                B_02.setFont(Font.font("Arial Black", 40));
                B_02.setDisable(true);
            }
            else{
                computerTurn(B_00, B_01, B_02,
                        B_10, B_11, B_12,
                        B_20, B_21, B_22,
                        ComputerSpotChoice);
            }
        }
        else if(ComputerSpotChoice == 4){
            if(B_10.getText().equals(" ")){
                B_10.setText("O");
                B_10.setFont(Font.font("Arial Black", 40));
                B_10.setDisable(true);
            }
            else{
                computerTurn(B_00, B_01, B_02,
                        B_10, B_11, B_12,
                        B_20, B_21, B_22,
                        ComputerSpotChoice);
            }

        }
        else if(ComputerSpotChoice == 5){
            if(B_11.getText().equals(" ")){
                B_11.setText("O");
                B_11.setFont(Font.font("Arial Black", 40));
                B_11.setDisable(true);
            }
            else{
                computerTurn(B_00, B_01, B_02,
                        B_10, B_11, B_12,
                        B_20, B_21, B_22,
                        ComputerSpotChoice);
            }
        }
        else if(ComputerSpotChoice == 6){
            if(B_12.getText().equals(" ")){
                B_12.setText("O");
                B_12.setFont(Font.font("Arial Black", 40));
                B_12.setDisable(true);
            }
            else{
                computerTurn(B_00, B_01, B_02,
                        B_10, B_11, B_12,
                        B_20, B_21, B_22,
                        ComputerSpotChoice);
            }
        }
        else if(ComputerSpotChoice == 7){
            if(B_20.getText().equals(" ")){
                B_20.setText("O");
                B_20.setFont(Font.font("Arial Black", 40));
                B_20.setDisable(true);
            }
            else{
                computerTurn(B_00, B_01, B_02,
                        B_10, B_11, B_12,
                        B_20, B_21, B_22,
                        ComputerSpotChoice);
            }
        }
        else if(ComputerSpotChoice == 8){
            if(B_21.getText().equals(" ")){
                B_21.setText("O");
                B_21.setFont(Font.font("Arial Black", 40));
                B_21.setDisable(true);
            }
            else{
                computerTurn(B_00, B_01, B_02,
                        B_10, B_11, B_12,
                        B_20, B_21, B_22,
                        ComputerSpotChoice);
            }
        }
        else if(ComputerSpotChoice == 9){
            if(B_22.getText().equals(" ")){
                B_22.setText("O");
                B_22.setFont(Font.font("Arial Black", 40));
                B_22.setDisable(true);
            }
            else{
                computerTurn(B_00, B_01, B_02,
                        B_10, B_11, B_12,
                        B_20, B_21, B_22,
                        ComputerSpotChoice);
            }
        }
    }

    private void computerTurn(Button B_00, Button B_01, Button B_02,
                             Button B_10, Button B_11, Button B_12,
                             Button B_20, Button B_21, Button B_22,
                             int choice){

        if(B_00.getText().equals(" ") && choice != 1){
            B_00.setText("O");
            B_00.setFont(Font.font("Arial Black", 40));
            B_00.setDisable(true);
        }
        else if(B_01.getText().equals(" ") && choice != 2){
            B_01.setText("O");
            B_01.setFont(Font.font("Arial Black", 40));
            B_01.setDisable(true);
        }
        else if(B_02.getText().equals(" ") && choice != 3){
            B_02.setText("O");
            B_02.setFont(Font.font("Arial Black", 40));
            B_02.setDisable(true);
        }
        else if(B_10.getText().equals(" ") && choice != 4){
            B_10.setText("O");
            B_10.setFont(Font.font("Arial Black", 40));
            B_10.setDisable(true);
        }
        else if(B_11.getText().equals(" ") && choice != 5){
            B_11.setText("O");
            B_11.setFont(Font.font("Arial Black", 40));
            B_11.setDisable(true);
        }
        else if(B_12.getText().equals(" ") && choice != 6){
            B_12.setText("O");
            B_12.setFont(Font.font("Arial Black", 40));
            B_12.setDisable(true);
        }
        else if(B_20.getText().equals(" ") && choice != 7){
            B_20.setText("O");
            B_20.setFont(Font.font("Arial Black", 40));
            B_20.setDisable(true);
        }
        else if(B_21.getText().equals(" ") && choice != 8){
            B_21.setText("O");
            B_21.setFont(Font.font("Arial Black", 40));
            B_21.setDisable(true);
        }
        else if(B_22.getText().equals(" ") && choice != 9){
            B_22.setText("O");
            B_22.setFont(Font.font("Arial Black", 40));
            B_22.setDisable(true);
        }
    }
}
