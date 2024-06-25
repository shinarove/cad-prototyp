package ch.zhaw.it.cadprototyp.userinterface;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class cadController {

    @FXML
    private Pane cadModel;

    @FXML
    private TextArea textOutput;

    @FXML
    void drawPoint(ActionEvent event) {
        textOutput.appendText("Point Position: (x, y)\n");
        cadModel.setOnMouseClicked(e -> {
            textOutput.appendText("("+e.getX()+", "+e.getY()+")\n");
        });
    }
}
