package classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        String fxmlFile = "/javaFX/sample.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setResizable(false);
        root.setFocusTraversable(true);
        primaryStage.setTitle("My First App");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

