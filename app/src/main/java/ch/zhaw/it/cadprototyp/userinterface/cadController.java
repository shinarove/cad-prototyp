package ch.zhaw.it.cadprototyp.userinterface;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class cadController {

    @FXML
    private Pane cadModel;

    @FXML
    private TextArea textOutput;

    @FXML
    private Label xValue;

    @FXML
    private Label yValue;

    private double currentX;
    private double currentY;

    private boolean executeCommand = false;

    @FXML
    void initialize() {
        cadModel.setOnMouseMoved(e -> {
            currentX = e.getX();
            currentY = e.getY();
            xValue.setText(String.format("%.3f", currentX));
            yValue.setText(String.format("%.3f", currentY));
        });
        cadModel.setOnMouseClicked(e -> {
            if (executeCommand) {
                textOutput.appendText("("+e.getX()+", "+e.getY()+")\n");
            }
            executeCommand = false;
        });
    }

    @FXML
    void drawPoint(ActionEvent event) {
        textOutput.appendText("Point Position: (x, y)\n");
        executeCommand = true;
    }
}
