package app.tictactoe;

import javafx.scene.control.Button;

public class HighlightWinner {
    // Highlights the winner

    public void highlightWinner(Button B_00, Button B_01, Button B_02,
                                 Button B_10, Button B_11, Button B_12,
                                 Button B_20, Button B_21, Button B_22,
                                 int winner){

        // Determines what is the winning case (horizontal, diagonal, vertical)
        int winnerCase = highlightWinnerCheck(B_00, B_01, B_02,
                B_10, B_11, B_12,
                B_20, B_21, B_22);
        // Stores the winner
        String winnerColor;

        if(winner == 0){
            winnerColor = "red";
            // Highlights the boxes that made a player won
            highlightWinner_aux(B_00, B_01, B_02,
                    B_10, B_11, B_12,
                    B_20, B_21, B_22,
                    winnerColor, winnerCase);
        }
        else if(winner == 1){
            winnerColor = "blue";
            // Highlights the boxes that made a player won
            highlightWinner_aux(B_00, B_01, B_02,
                    B_10, B_11, B_12,
                    B_20, B_21, B_22,
                    winnerColor, winnerCase);
        }
    }

    private int highlightWinnerCheck(Button B_00, Button B_01, Button B_02,
                                     Button B_10, Button B_11, Button B_12,
                                     Button B_20, Button B_21, Button B_22){
        // Checks which case make a player or a computer win
        String line;
        for(int i = 0; i < 8; i++){
            line = switch(i){
                case 0 -> B_00.getText() + B_01.getText()+ B_02.getText();
                case 1 -> B_10.getText() + B_11.getText()+ B_12.getText();
                case 2 -> B_20.getText() + B_21.getText()+ B_22.getText();
                case 3 -> B_00.getText() + B_10.getText()+ B_20.getText();
                case 4 -> B_01.getText() + B_11.getText()+ B_21.getText();
                case 5 -> B_02.getText() + B_12.getText()+ B_22.getText();
                case 6 -> B_00.getText() + B_11.getText()+ B_22.getText();
                case 7 -> B_02.getText() + B_11.getText()+ B_20.getText();
                default -> null;
            };

            if(line.equals("XXX")){
                return i;
            }
            else if(line.equals("OOO")){
                return i;
            }
        }
        return 999;
    }

    private void highlightWinner_aux(Button B_00, Button B_01, Button B_02,
                                     Button B_10, Button B_11, Button B_12,
                                     Button B_20, Button B_21, Button B_22,
                                     String winner, int winnerCase){
        // Will highlight the boxes depending on a case (horizontal, diagonal, vertical)

        if(winnerCase == 0){
            B_00.setStyle("-fx-background-color:" + winner + ";");
            B_01.setStyle("-fx-background-color:" + winner + ";");
            B_02.setStyle("-fx-background-color:"   + winner + ";");
        }
        else if(winnerCase == 1){
            B_10.setStyle("-fx-background-color:"   + winner + ";");
            B_11.setStyle("-fx-background-color:"   + winner + ";");
            B_12.setStyle("-fx-background-color:"   + winner + ";");
        }
        else if(winnerCase == 2){
            B_20.setStyle("-fx-background-color:"   + winner + ";");
            B_21.setStyle("-fx-background-color:"   + winner + ";");
            B_22.setStyle("-fx-background-color:"   + winner + ";");
        }
        else if(winnerCase == 3){
            B_00.setStyle("-fx-background-color:"   + winner + ";");
            B_10.setStyle("-fx-background-color:"   + winner + ";");
            B_20.setStyle("-fx-background-color:"   + winner + ";");
        }
        else if(winnerCase == 4){
            B_01.setStyle("-fx-background-color:"  + winner + ";");
            B_11.setStyle("-fx-background-color:"   + winner + ";");
            B_21.setStyle("-fx-background-color:"   + winner + ";");
        }
        else if(winnerCase == 5){
            B_02.setStyle("-fx-background-color:"   + winner + ";");
            B_12.setStyle("-fx-background-color:"   + winner + ";");
            B_22.setStyle("-fx-background-color:"   + winner + ";");
        }
        else if(winnerCase == 6){
            B_00.setStyle("-fx-background-color:"   + winner + ";");
            B_11.setStyle("-fx-background-color:"   + winner + ";");
            B_22.setStyle("-fx-background-color:"   + winner + ";");
        }
        else if(winnerCase == 7){
            B_02.setStyle("-fx-background-color:"   + winner + ";");
            B_11.setStyle("-fx-background-color:"   + winner + ";");
            B_20.setStyle("-fx-background-color:"   + winner + ";");
        }
    }

}
