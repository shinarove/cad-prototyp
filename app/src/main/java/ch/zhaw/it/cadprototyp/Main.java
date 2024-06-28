package ch.zhaw.it.cadprototyp;

import ch.zhaw.it.cadprototyp.userinterface.CadController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        launch(args);
        logger.log(Level.FINEST, "Main started");
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(CadController.class.getResource("cadView.fxml"));
        Scene scene = new Scene(loader.load());

        CadController controller = loader.getController();

        primaryStage.setTitle("CAD Prototype");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
