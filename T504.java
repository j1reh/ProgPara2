import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.util.Random;

public class T504 extends Application {

    private int randomNumber;
    
    //attempt counter
    private int attempts = 0; 
    
    private Label resultLabel;
    private TextField guessField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Guess the number");

        //random number genertor
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;

        Label instructionLabel = new Label("Guess a number (between 1 and 100):");

        //guess text field
        guessField = new TextField();
        guessField.setPromptText("Enter your guess");

        //button
        Button submitButton = new Button("Enter");
        submitButton.setOnAction(e -> checkGuess());

        //result
        resultLabel = new Label();

        //layout and display
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(instructionLabel, guessField, submitButton, resultLabel);

        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());

            if (guess < 1 || guess > 100) {
                resultLabel.setText("Please enter a number between 1 and 100.");
                resultLabel.setTextFill(Color.RED);
                return;
            }

            attempts++;

            if (guess == randomNumber) {
                resultLabel.setText("Congratulations, you guessed the number " + randomNumber + "! Attempts: " + attempts);
                resultLabel.setTextFill(Color.GREEN);
            } else if (guess < randomNumber) {
                resultLabel.setText("Try a higher number. Attempt: " + attempts);
                resultLabel.setTextFill(Color.BLACK);
            } else {
                resultLabel.setText("Try a lower number. Attempt: " + attempts);
                resultLabel.setTextFill(Color.BLACK);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input! Please enter a valid number.");
            resultLabel.setTextFill(Color.RED);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
