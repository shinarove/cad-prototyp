package ch.zhaw.it.cadprototyp.userinterface;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;

public class cadController {

    @FXML
    private Canvas canvas;

    @FXML
    void drawPoint(ActionEvent event) {
        canvas.setOnMouseClicked(e -> {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.stroke();
        });
    }
}
