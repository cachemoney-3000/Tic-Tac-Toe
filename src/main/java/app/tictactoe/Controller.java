package app.tictactoe;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button B_00;

    @FXML
    private Button B_01;

    @FXML
    private Button B_02;

    @FXML
    private Button B_10;

    @FXML
    private Button B_11;

    @FXML
    private Button B_12;

    @FXML
    private Button B_20;

    @FXML
    private Button B_21;

    @FXML
    private Button B_22;

    @FXML
    private Text winnerText;

    @FXML
    private Text computerScore;

    @FXML
    private Text gamesPlayed;

    @FXML
    private Text playerScore;

    private int computerMoves = 0;

    private int haveWinner = 0;

    private ArrayList<Button> buttons;

    private int totalGame = 0;

    private int playerWinScore = 0;

    private int computerWinScore = 0;

    private int player = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(B_00, B_01, B_02, B_10, B_11, B_12, B_20, B_21, B_22));

        // Everytime a box has been clicked by the user, it will be marked as "x"
        buttons.forEach(button ->{
            button.setOnMouseClicked(mouseEvent ->
                    playerAttack(button));
            button.setFocusTraversable(false);
        });
    }

    @FXML
    void restart(MouseEvent event) {
        buttons.forEach((this::resetButton));
        winnerText.setText("Tic-Tac-Toe");

        // Counts the total number of games played
        totalGame++;
        gamesPlayed.setText(String.valueOf(totalGame));
    }

    private void resetButton(Button button) {
        // Resets the game
        button.setDisable(false);
        button.setText(" ");
        button.setFont(Font.font("Arial Black", 40));

        button.setStyle(null);
        computerMoves = 0;
        haveWinner = 0;
        player = 0;
    }

    private void playerAttack(Button button){
        // User turn
        if(player == 0){
            // Marks the box as X
            button.setText("X");
            button.setFont(Font.font("Arial Black", 40));

            // Disable that particular box
            button.setDisable(true);
            // Check if there are any winners
            String winner = checkGame();
            gameOver(winner, buttons);

            // If there is still no winner, then next player turn
            if(haveWinner == 0){
                player = 1;
            }
        }

        // Computer turn
        if(player == 1){
            // Computer will decide which box to mark
            ComputerTurn();
            // Check if there are any winners
            String winner = checkGame();
            gameOver(winner, buttons);

            // If there is still no winner, then next player turn
            if(haveWinner == 0){
                player = 0;
            }
        }
    }

    private void gameOver(String winner, ArrayList<Button> buttons){
        HighlightWinner highlight = new HighlightWinner();

        if(winner.equals("X")){
            // Will disable all the buttons since X already won
            buttons.forEach(button -> {
                button.setDisable(true);
            });

            winnerText.setText("X won");
            haveWinner = 1;

            playerWinScore++;
            playerScore.setText(String.valueOf(playerWinScore));
            // 0 means that the user won and the color to be highlighted is RED
            highlight.highlightWinner(B_00, B_01, B_02,
                    B_10, B_11, B_12,
                    B_20, B_21, B_22,
                    0);
        }

        else if(winner.equals("O")){
            // Will disable all the buttons since O already won
            buttons.forEach(button -> {
                button.setDisable(true);
            });
            winnerText.setText("O won");
            haveWinner = 1;

            computerWinScore++;
            computerScore.setText(String.valueOf(computerWinScore));
            // 1 means that Computer won and the color to be highlighted is BLUE
            highlight.highlightWinner(B_00, B_01, B_02,
                    B_10, B_11, B_12,
                    B_20, B_21, B_22,
                    1);
        }
    }

    public void ComputerTurn(){
        int defenseMove;
        int offenseMove;

        PickMove choose = new PickMove();
        Defense defend = new Defense();
        Offense offense = new Offense();

        // If it is the first move of the computer, it will randomly select a box
        if(computerMoves == 0){
            choose.randomChoice(B_00, B_01, B_02,
                                B_10, B_11, B_12,
                                B_20, B_21, B_22);
        }

        // On next consecutive move, it will check if it needs to be defensive or offensive
        else if(computerMoves > 0){
            // Will find its possible move by blocking possible scenario that the user will win
            defenseMove = defend.findPossibleMove(B_00, B_01, B_02,
                                        B_10, B_11, B_12,
                                        B_20, B_21, B_22);

            // Will find its possible move by choosing which box will make the computer win
            offenseMove = offense.findPossibleMove(B_00, B_01, B_02,
                                                B_10, B_11, B_12,
                                                B_20, B_21, B_22);

            // If the computer saw a winning move
            if(offenseMove != -999){
                // It will mark a position that will make computer win
                offense.offensive(B_00, B_01, B_02,
                        B_10, B_11, B_12,
                        B_20, B_21, B_22,
                        offenseMove);
            }

            // If the computer did not see a winning move, it will try to be defensive
            else {
                // If the computer see that the user is almost winning, it will block the user, so they will not win
                if(defenseMove != 999){
                    defend.defense(B_00, B_01, B_02,
                            B_10, B_11, B_12,
                            B_20, B_21, B_22,
                            defenseMove);
                }
                // If the computer did not find a move that can help to defend or offence, it will make a random choice
                else{
                    choose.randomChoice(B_00, B_01, B_02,
                            B_10, B_11, B_12,
                            B_20, B_21, B_22);
                }
            }

        }
        // Counts how many moves the computer made
        computerMoves++;
    }

    private String checkGame(){
        // Checks all the possible combination that a player can win
        String winner = "none";
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

            // This means that the player have won
            if(line.equals("XXX")){
                winner = "X";
                System.out.println(winner);
                return winner;
            }

            // The computer have won
            if(line.equals("OOO")) {
                winner = "O";
                System.out.println(winner);
                return winner;
            }
        }
        return winner;
    }


}
