module app.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.tictactoe to javafx.fxml;
    exports app.tictactoe;
}