package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/main_menu.fxml"));
        primaryStage.setTitle("Main menu");
        primaryStage.setScene(new Scene(root, 573, 293));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
