package org.example.currencyconverterfinalprojectsdev200carsonbeckmann;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.Arrays;
import java.util.List;

public class MainApp extends Application {
    private ComboBox<AbstractCurrency> sourceCurrencyBox = new ComboBox<>();
    private ComboBox<AbstractCurrency> targetCurrencyBox = new ComboBox<>();
    private TextField amountTextField = new TextField();
    private Label resultLabel = new Label();
    private Button convertButton = new Button("Convert");
    private List<AbstractCurrency> currencies = Arrays.asList(
            new USDollar(),
            new EuroCurrency(),
            new MexicanPeso(),
            new JapaneseYen(),
            new IndianRupee()
    );

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        // Setup currency boxes
        sourceCurrencyBox.getItems().addAll(currencies);
        targetCurrencyBox.getItems().addAll(currencies);
        setupCurrencyBox(sourceCurrencyBox);
        setupCurrencyBox(targetCurrencyBox);
        sourceCurrencyBox.getSelectionModel().selectFirst();
        targetCurrencyBox.getSelectionModel().selectFirst();

        // UI Elements
        amountTextField.setPromptText("Enter amount");
        convertButton.setOnAction(e -> convertCurrency());

        // Layout
        root.getChildren().addAll(
                new Label("Amount:"), amountTextField,
                new Label("Source Currency:"), sourceCurrencyBox,
                new Label("Target Currency:"), targetCurrencyBox,
                convertButton,
                new Label("Result:"), resultLabel
        );

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupCurrencyBox(ComboBox<AbstractCurrency> comboBox) {
        comboBox.setCellFactory(new Callback<>() {
            @Override
            public ListCell<AbstractCurrency> call(ListView<AbstractCurrency> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(AbstractCurrency item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? null : item.getCode());
                    }
                };
            }
        });

        comboBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(AbstractCurrency item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.getCode());
            }
        });
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountTextField.getText());
            AbstractCurrency source = sourceCurrencyBox.getValue();
            AbstractCurrency target = targetCurrencyBox.getValue();

            double result = CurrencyConverter.convert(amount, source, target);
            resultLabel.setText(String.format("%.2f %s = %.2f %s",
                    amount, source.getCode(), result, target.getCode()));
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Please enter a valid number");
        } catch (Exception e) {
            resultLabel.setText("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}