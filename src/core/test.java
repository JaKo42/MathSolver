package core;
import java.text.DecimalFormat;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class test extends Application{
    Scanner digitReader = new Scanner(System.in);


    @Override
    public void start(Stage stage) throws Exception{
//      Erstellung der Labels
        GridPane grid = new GridPane();       //Grundlegende Struktur
        grid.setHgap(5);
        grid.setVgap(5);
//        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setGridLinesVisible(false);
        Scene scene = new Scene(grid, 600, 400); //Erstellung der Scene
        stage.setTitle("Math Program");
        stage.setScene(scene);

        Label titel1 = new Label("Mathe Program"); //Erstes Label mit Titel
            grid.add(titel1,3,0,2,1 );

        Label description1= new Label("Geben Sie zwei Zahlen ein"); //Zweites Label mit Anweisung/Beschreibung
            grid.add(description1,3,3,2,1);


            //TODO: Schrift verschwindet beim auswählen des Feldes
        TextField digitField = new TextField("Erste Zahl");//Erstes Textfeld mit Zahlenfeld
            grid.add(digitField,1,8,3,1);
            digitField.setPromptText("Erste Zahl eingeben");
            digitField.setPrefColumnCount(10);
            digitField.getText();

        TextField digitField2 = new TextField("Zweite Zahl");//Zweites Textfeld mit Zahlenfeld
            grid.add(digitField2,5,8,3,1);
            digitField2.setPromptText("Zweite Zahl eingeben");
            digitField2.setPrefColumnCount(10);
            digitField2.getText();


        TextField solutionField = new TextField("Ergebnis");//Textfeld mit der Lösung
            grid.add(solutionField,6,14,1,1);
            solutionField.setPromptText("Ergebnis");
            solutionField.setPrefColumnCount(10);
            //TODO:double soll gekürzt werden

        grid.add(new Separator(),0,12,7,1);


        //Nachkommastellen reduzieren
        DecimalFormat df = new DecimalFormat("#.##");

        //Erstellung der Buttons
        Button add = new Button();
            add.setText("Addieren");
            add.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) throws NumberFormatException {
                try {


                    if ((digitField.getText() != null && digitField.getText() != null && !digitField.getText().isEmpty() && !digitField2.getText().isEmpty() ))
                        solutionField.setText(""+(Calculation.add(Double.parseDouble(digitField.getText()),Double.parseDouble(digitField2.getText()))));
                }
                catch (NumberFormatException invalidEntry){
                    Alert warning = new Alert(Alert.AlertType.ERROR, "Bitte Felder mit Zahlen füllen",ButtonType.OK);
                    warning.showAndWait();
                }

                }
            });
        Button sub = new Button();
        sub.setText("Subtrahieren");
        sub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) throws NumberFormatException {
                try {


                    if ((digitField.getText() != null && digitField.getText() != null && !digitField.getText().isEmpty() && !digitField2.getText().isEmpty() ))
                      solutionField.setText(""+(Calculation.subtract(Double.parseDouble(digitField.getText()),Double.parseDouble(digitField2.getText()))));
                }
                catch (NumberFormatException invalidEntry){
                    Alert warning = new Alert(Alert.AlertType.ERROR, "Bitte Felder mit Zahlen füllen",ButtonType.OK);
                    warning.showAndWait();
                }
                catch (ArithmeticException divideZero) {
                    Alert warning = new Alert(Alert.AlertType.ERROR, "Nicht mit Null teilen", ButtonType.OK);
                    warning.showAndWait();
                }
            }
        });
        Button div = new Button();
        div.setText("Dividieren");
        div.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) throws NumberFormatException {
                try {
                //TODO:Dividieren durch 0 abfangen

                    if ((digitField.getText() != null && digitField.getText() != null && !digitField.getText().isEmpty() && !digitField2.getText().isEmpty() ))
                        solutionField.setText(""+(Calculation.divide(Double.parseDouble(digitField.getText()),Double.parseDouble(digitField2.getText()))));
                }
                catch (NumberFormatException invalidEntry){
                    Alert warning = new Alert(Alert.AlertType.ERROR, "Bitte Felder mit Zahlen füllen",ButtonType.OK);
                    warning.showAndWait();
                }

            }
        });
        Button mult = new Button();
        mult.setText("Multiplizieren");
        mult.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) throws NumberFormatException {
                try {


                    if ((digitField.getText() != null && digitField.getText() != null && !digitField.getText().isEmpty() && !digitField2.getText().isEmpty() ))
                        solutionField.setText(""+(Calculation.multiply(Double.parseDouble(digitField.getText()),Double.parseDouble(digitField2.getText()))));
                }
                catch (NumberFormatException invalidEntry){
                    Alert warning = new Alert(Alert.AlertType.ERROR, "Bitte Felder mit Zahlen füllen",ButtonType.OK);
                    warning.showAndWait();
                }

            }
        });

        grid.add(add,2,14,1,1);
        grid.add(sub,3,14,1,1);
        grid.add(div,4,14,1,1);
        grid.add(mult,5,14,1,1);
        //TODO:Buttons richtig anordnen


        stage.show();

    }

    @Override
    public void stop() throws Exception {
            }

    public static void main(String[] args) {
        launch(args);


    }
}

    class NumberTextField extends TextField{

    }
