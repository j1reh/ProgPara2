import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class T505 extends Application {

    private TextField num1Field, num2Field;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        //input numbers
        num1Field = new TextField();
        num2Field = new TextField();
        num1Field.setPromptText("Number 1:");
        num2Field.setPromptText("Number 2");

        //operation buttons
        Button addButton = new Button("+");
        addButton.setOnAction(e -> calculateResult(Operation.add));

        Button subtractButton = new Button("-");
        subtractButton.setOnAction(e -> calculateResult(Operation.sub));

        Button multiplyButton = new Button("*");
        multiplyButton.setOnAction(e -> calculateResult(Operation.mul));

        Button divideButton = new Button("/");
        divideButton.setOnAction(e -> calculateResult(Operation.div));

        //result
        resultLabel = new Label();

        //layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        gridPane.add(num1Field, 0, 0);
        gridPane.add(num2Field, 1, 0);
        gridPane.add(addButton, 0, 1);
        gridPane.add(subtractButton, 1, 1);
        gridPane.add(multiplyButton, 0, 2);
        gridPane.add(divideButton, 1, 2);
        gridPane.add(resultLabel, 0, 3, 2, 1);

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateResult(Operation operation) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operation) {
                case add:
                    result = num1 + num2;
                    break;
                case sub:
                    result = num1 - num2;
                    break;
                case mul:
                    result = num1 * num2;
                    break;
                case div:
                    if (num2 != 0)
                        result = num1 / num2;
                    else
                        resultLabel.setText("Math Error!");
                    break;
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input! Please enter valid numbers.");
        }
    }
    public static void main(String[] args) {
launch(args);
    }

    enum Operation {
        add, sub, mul, div
    }
}