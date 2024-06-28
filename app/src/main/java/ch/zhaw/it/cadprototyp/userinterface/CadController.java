package ch.zhaw.it.cadprototyp.userinterface;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class CadController {

    @FXML
    private Pane cadModel;

    @FXML
    private TextArea textOutput;

    @FXML
    private Label xValue;

    @FXML
    private Label yValue;

    private CenterPoint centerPoint;

    private double currentX;
    private double currentY;

    private boolean executeCommand = false;

    @FXML
    void initialize() {
        cadModel.setOnMouseMoved(e -> {
            //initialize (0, 0) coordinate, the coordinate should first be in the middle of the cadModel Pane.
            if (centerPoint == null) {
                centerPoint = new CenterPoint(cadModel.getWidth()/2, cadModel.getHeight()/2);
                textOutput.appendText(String.format("Center Point: (%.3f, %.3f)\n", cadModel.getWidth()/2, cadModel.getHeight()/2));
            }


            currentX = TransformCoordinate.transformX(e.getX(), centerPoint.getX());
            currentY = TransformCoordinate.transformY(e.getY(), centerPoint.getY());
            xValue.setText(String.format("%.3f, altX: %.3f", currentX, e.getX()));
            yValue.setText(String.format("%.3f, altY: %.3f", currentY, e.getY()));
        });
        cadModel.setOnMouseClicked(e -> {
            if (executeCommand) {
                textOutput.appendText("(" + currentX + ", " + currentY + ")\n");
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
