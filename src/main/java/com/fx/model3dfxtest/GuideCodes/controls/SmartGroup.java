package com.fx.model3dfxtest.GuideCodes.controls;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public class SmartGroup extends Group {

// Object Mouse Stretch values
    private double initialX;
    private double initialY;
    private double initialScaleX;
    private double initialScaleY;
    private double initialScaleZ;
// rotating
        private Rotate r;
        private Transform t = new Rotate();
// mouse rotating
    private double previousMouseX;
    private double previousMouseY;
    private Rotate rotateX;
    private Rotate rotateY;

//

    private double currentX;
    private double currentY;
    private double currentZ;
    private boolean X_AXIS_MODE = false;
    private boolean Y_AXIS_MODE = false;
    private boolean Z_AXIS_MODE = false;


        public SmartGroup() {

            this.setOnMouseClicked(mouseEvent -> {

                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    initMoveMouseControl();


                    if (mouseEvent.getClickCount() == 3) {
                        initStretchMouseControl();
                    }
                    if (mouseEvent.getClickCount() == 2) {
                        initRotateMouseControl();
                    }

                }

            });
        }






        public void rotateByX(int ang) {
            r = new Rotate(ang, Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
        public void rotateByY(int ang) {
            r = new Rotate(ang, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        public void initDelete(){
            this.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                switch (event.getCode()) {
                    case DELETE:
                        this.getChildren().clear();

                }
            });
        }

        public void initRotateMouseControl() {
//            this.getTransforms().clear();
            this.getTransforms().addAll(
                    rotateX = new Rotate(0, Rotate.X_AXIS),
                    rotateY = new Rotate(0, Rotate.Y_AXIS)
            );

            this.setOnMousePressed(mouseEvent -> {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    previousMouseX = mouseEvent.getSceneX();
                    previousMouseY = mouseEvent.getSceneY();
                    mouseEvent.consume();
                }

            });

            this.setOnMouseDragged(mouseEvent -> {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    double deltaX = mouseEvent.getSceneX() - previousMouseX;
                    double deltaY = mouseEvent.getSceneY() - previousMouseY;

                    rotateX.setAngle(rotateX.getAngle() - deltaY);
                    rotateY.setAngle(rotateY.getAngle() + deltaX);

                    previousMouseX = mouseEvent.getSceneX();
                    previousMouseY = mouseEvent.getSceneY();
                    mouseEvent.consume();
                }

            });


        }
        public void initStretchMouseControl() {
            this.setOnMousePressed(mouseEvent -> {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    initialX = mouseEvent.getSceneX();
                    initialY = mouseEvent.getSceneY();
                    initialScaleX = this.getScaleX();
                    initialScaleY = this.getScaleY();
                    initialScaleZ = this.getScaleZ();
                    mouseEvent.consume();
                }
            });

            this.setOnMouseDragged(mouseEvent -> {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    double dx = mouseEvent.getSceneX() - initialX;
                    double dy = mouseEvent.getSceneY() - initialY;

                    this.setScaleX(initialScaleX + dx / 100);
                    this.setScaleY(initialScaleY + dy / 100);
                    this.setScaleZ(initialScaleZ + (dx + dy) / 200);

                    mouseEvent.consume();
                }
            });
        }
        public void initMoveMouseControl() {

//            this.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
//                switch (keyEvent.getCode()) {
//                    case X:
//                        X_AXIS_MODE = true;
//                        Y_AXIS_MODE = false;
//                        Z_AXIS_MODE = false;
//                        break;
//                    case Y:
//                        Y_AXIS_MODE = true;
//                        X_AXIS_MODE = false;
//                        Z_AXIS_MODE = false;
//                        break;
//                    case Z:
//                        Z_AXIS_MODE = true;
//                        X_AXIS_MODE = false;
//                        Y_AXIS_MODE = false;
//                        break;
//                }
//            });
            this.setOnScroll(mouseEvent -> {
                this.translateZProperty().set(this.getTranslateZ() + mouseEvent.getDeltaY());
            });

            this.setOnMousePressed(mouseEvent -> {
                if(mouseEvent.getButton().equals(MouseButton.SECONDARY)){

                    if (mouseEvent.getClickCount() == 2) {
                        X_AXIS_MODE = false;
                        Y_AXIS_MODE = true;
                        Z_AXIS_MODE = false;
                    } else if (mouseEvent.getClickCount() == 1){
                        X_AXIS_MODE = true;
                        Y_AXIS_MODE = false;
                        Z_AXIS_MODE = false;
                    }

                }

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    currentX = this.getTranslateX();
                    currentY = this.getTranslateY();
                    currentZ = this.getTranslateZ();
                    previousMouseX = mouseEvent.getSceneX();
                    previousMouseY = mouseEvent.getSceneY();

                }
                mouseEvent.consume();
            });

            this.setOnMouseDragged(mouseEvent -> {
                double deltaX = mouseEvent.getSceneX() - previousMouseX;
                double deltaY = mouseEvent.getSceneY() - previousMouseY;

                if (X_AXIS_MODE && !Y_AXIS_MODE && !Z_AXIS_MODE){
                    this.translateXProperty().set(currentX + deltaX);
                } else if (Y_AXIS_MODE && !X_AXIS_MODE && !Z_AXIS_MODE){
                    this.translateYProperty().set(currentY + deltaY);
                } else if (Z_AXIS_MODE && !X_AXIS_MODE && !Y_AXIS_MODE){
                    this.translateZProperty().set(currentZ + deltaY);
                    System.out.println("Z is working");
                }
                mouseEvent.consume();

            });
        }

    public Rotate getR() {
            return r;
        }
}
