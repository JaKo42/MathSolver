package core;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class Start extends Application {

    public void start(Stage startingStage) throws Exception {


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Scene mainScene = new Scene(grid, 300, 200);
//      Coolen namen noch ausdenken
        startingStage.setTitle("Programm");
        startingStage.setScene(mainScene);


        Label hello = new Label("Welches Programm möchten Sie starten?");
        grid.add(hello, 1, 1, 1, 1);


        Button calculation = new Button();
        grid.add(calculation, 1, 2, 1, 1);
        calculation.setText("Zwei Zahlen Rechner");
        calculation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new Calcstage().start(new Stage());
                        }
                            catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });


        startingStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}





