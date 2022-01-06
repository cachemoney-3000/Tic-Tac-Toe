package app.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.util.Objects;

public class Offense {
    public int findPossibleMove(Button B_00, Button B_01, Button B_02,
                                Button B_10, Button B_11, Button B_12,
                                Button B_20, Button B_21, Button B_22){
        String line;
        int i;
        for(i = 0; i < 8; i++){
            line = switch (i) {
                case 0 -> B_00.getText() + B_01.getText() + B_02.getText();
                case 1 -> B_10.getText() + B_11.getText() + B_12.getText();
                case 2 -> B_20.getText() + B_21.getText() + B_22.getText();
                case 3 -> B_00.getText() + B_10.getText() + B_20.getText();
                case 4 -> B_01.getText() + B_11.getText() + B_21.getText();
                case 5 -> B_02.getText() + B_12.getText() + B_22.getText();
                case 6 -> B_00.getText() + B_11.getText() + B_22.getText();
                case 7 -> B_02.getText() + B_11.getText() + B_20.getText();
                default -> null;
            };

            switch (Objects.requireNonNull(line)) {
                case "OO ": return i + 30;
                case "O O": return i + 20;
                case " OO": return i + 10;
            }

        }
        return -999;
    }

    public void offensive(Button B_00, Button B_01, Button B_02,
                        Button B_10, Button B_11, Button B_12,
                        Button B_20, Button B_21, Button B_22,
                        int caseNum){

        int priority = 0;
        int caseNum_subtracted;

        if(caseNum == 16 || caseNum == 26 || caseNum == 36){
            if(caseNum == 16){
                priority = 1;
            }
            else if(caseNum == 26){
                priority = 5;
            }
            else {
                priority = 9;
            }

            caseNum_subtracted = caseNum - 10;
            offensive_aux(caseNum_subtracted, priority,
                    B_00, B_01, B_02,
                    B_10, B_11, B_12,
                    B_20, B_21, B_22);
        }

        else if(caseNum == 17 || caseNum == 27 || caseNum == 37){
            if(caseNum == 17){
                priority = 3;
            }
            else if(caseNum == 27){
                priority = 5;
            }
            else {
                priority = 7;
            }

            caseNum_subtracted = caseNum - 10;
            offensive_aux(caseNum_subtracted, priority,
                    B_00, B_01, B_02,
                    B_10, B_11, B_12,
                    B_20, B_21, B_22);
        }

        else if(caseNum >= 10 && caseNum < 20){
            caseNum_subtracted = caseNum - 10;
            offensive_aux(caseNum_subtracted, priority,
                    B_00, B_01, B_02,
                    B_10, B_11, B_12,
                    B_20, B_21, B_22);
        }
        else if(caseNum >= 20 && caseNum < 30){
            caseNum_subtracted = caseNum - 20;
            offensive_aux(caseNum_subtracted, priority,
                    B_00, B_01, B_02,
                    B_10, B_11, B_12,
                    B_20, B_21, B_22);
        }
        else if(caseNum >= 30){
            caseNum_subtracted = caseNum - 30;
            offensive_aux(caseNum_subtracted, priority,
                    B_00, B_01, B_02,
                    B_10, B_11, B_12,
                    B_20, B_21, B_22);
        }
    }

    public void offensive_aux(int caseNum, int block,
                            Button B_00, Button B_01, Button B_02,
                            Button B_10, Button B_11, Button B_12,
                            Button B_20, Button B_21, Button B_22){
        int nextTurn = 0;

        // Takes care of the diagonal case
        if(block == 1 && B_00.getText().equals(" ")){
            B_00.setText("O");
            B_00.setFont(Font.font("Arial Black", 40));
            B_00.setDisable(true);
            nextTurn = 1;
        }

        else if(block == 3 && B_02.getText().equals(" ")){
            B_02.setText("O");
            B_00.setFont(Font.font("Arial Black", 40));
            B_02.setDisable(true);
            nextTurn = 1;
        }

        else if(block == 5 && B_11.getText().equals(" ")){
            B_11.setText("O");
            B_00.setFont(Font.font("Arial Black", 40));
            B_11.setDisable(true);
            nextTurn = 1;
        }

        else if(block == 7 && B_20.getText().equals(" ")){
            B_20.setText("O");
            B_00.setFont(Font.font("Arial Black", 40));
            B_20.setDisable(true);
            nextTurn = 1;
        }

        else if(block == 9 && B_22.getText().equals(" ")){
            B_22.setText("O");
            B_00.setFont(Font.font("Arial Black", 40));
            B_22.setDisable(true);
            nextTurn = 1;
        }

        // Takes care of the horizontal or vertical blocks
        if(nextTurn == 0){
            if(B_00.getText().equals(" ")
                    && (caseNum == 0 || caseNum == 3 || caseNum == 7)){
                B_00.setText("O");
                B_00.setFont(Font.font("Arial Black", 40));
                B_00.setDisable(true);
            }
            else if(B_01.getText().equals(" ")
                    && (caseNum == 0 || caseNum == 4)){
                B_01.setText("O");
                B_01.setFont(Font.font("Arial Black", 40));
                B_01.setDisable(true);
            }
            else if(B_02.getText().equals(" ")
                    && (caseNum == 0 || caseNum == 5)){
                B_02.setText("O");
                B_02.setFont(Font.font("Arial Black", 40));
                B_02.setDisable(true);
            }
            else if(B_10.getText().equals(" ")
                    && (caseNum == 1 || caseNum == 3)){
                B_10.setText("O");
                B_10.setFont(Font.font("Arial Black", 40));
                B_10.setDisable(true);
            }
            else if(B_11.getText().equals(" ")
                    && (caseNum == 1 || caseNum == 4 || caseNum == 6 || caseNum == 7)){
                B_11.setText("O");
                B_11.setFont(Font.font("Arial Black", 40));
                B_11.setDisable(true);
            }
            else if(B_12.getText().equals(" ")
                    && (caseNum == 1 || caseNum == 5)){
                B_12.setText("O");
                B_12.setFont(Font.font("Arial Black", 40));
                B_12.setDisable(true);
            }
            else if(B_20.getText().equals(" ")
                    && (caseNum == 2 || caseNum == 3 || caseNum == 7)){
                B_20.setText("O");
                B_20.setFont(Font.font("Arial Black", 40));
                B_20.setDisable(true);
            }
            else if(B_21.getText().equals(" ")
                    && (caseNum == 2 || caseNum == 4)){
                B_21.setText("O");
                B_21.setFont(Font.font("Arial Black", 40));
                B_21.setDisable(true);
            }
            else if(B_22.getText().equals(" ")
                    && (caseNum == 2 || caseNum == 5 || caseNum == 6)){
                B_22.setText("O");
                B_22.setFont(Font.font("Arial Black", 40));
                B_22.setDisable(true);
            }
        }
    }
}
