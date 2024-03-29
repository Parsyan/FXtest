package com.fx.model3dfxtest.GuideCodes.controls;

import com.fx.model3dfxtest.GuideCodes.Tabs.DeleteGroup;
import com.fx.model3dfxtest.GuideCodes.Tabs.MergeGroup;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import lombok.Getter;


public class SmartGroup extends Group {

// Object Mouse Stretch values
    private double initialX;
    private double initialY;
    private double initialScaleX;
    private double initialScaleY;
    private double initialScaleZ;
// rotating
        @Getter
        private Rotate r;
        private Transform t = new Rotate();
// mouse rotating
    private double previousMouseX;
    private double previousMouseY;
    private Rotate rotateX;
    private Rotate rotateY;

//
    private Box box;
    private Cylinder cylinder;
    private Sphere sphere;
    private double currentX;
    private double currentY;
    private double currentZ;
    private boolean X_AXIS_MODE = false;
    private boolean Y_AXIS_MODE = false;
    private boolean Z_AXIS_MODE = false;
//

        public SmartGroup(Box box) {
            this.box = box;
            this.getChildren().add(box);
            setMouseClicked();
        }
        public SmartGroup(Sphere sphere) {
            this.sphere = sphere;
            this.getChildren().add(sphere);

            setMouseClicked();
        }

        public SmartGroup(Cylinder cylinder) {
            this.cylinder = cylinder;
            this.getChildren().add(cylinder);

            setMouseClicked();
        }
        public SmartGroup() {
            setMouseClicked();
        }

        public SmartGroup(Group root3D) {
            this.getChildren().add(root3D);
            setMouseClicked();
        }

        protected void setMouseClicked() {
                logging();
                this.setOnMouseClicked(mouseEvent -> {

                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                        initMoveMouseControl();

                        if(DeleteGroup.isActivated){
                            DeleteGroup.delete((Group) this.getParent(), this);
                        }
                        if (MergeGroup.isActivated){
                            MergeGroup.createMergeGroup(this.toGroup());
                        }

                        if (mouseEvent.getClickCount() == 3) {
                            initStretchMouseControl();
                        }
                        if (mouseEvent.getClickCount() == 2) {
                            initRotateMouseControl();
                        }
                    }
                });
            }

        private void logging(){
            System.out.print("X: " + currentX + ", Y: " + currentY + ", Z: " + currentZ + ", Scale X : " + this.getScaleX() + ", Scale Y : " + this.getScaleY() + ", Scale Z : " + this.getScaleZ() + ", Rotate : " + this.getRotate());
            if(box != null){
                System.out.print(" Box Width : " + box.getWidth() + ", Height : " + box.getHeight() + ", Depth : " + box.getDepth());
            }
            if(sphere != null){
                System.out.print(" Sphere Radius : " + sphere.getRadius() + ", Divisions : " + sphere.getDivisions());
            }
            if(cylinder != null){
                System.out.print(" Cylinder Radius : " + cylinder.getRadius() + ", Divisions : " + cylinder.getDivisions() + ", Height : " + cylinder.getHeight());
            }
            System.out.println();
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


        public void initRotateMouseControl() {
            this.getTransforms().addAll(
                    rotateX = new Rotate(5, Rotate.X_AXIS),
                    rotateY = new Rotate(5, Rotate.Y_AXIS)
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
        public Group toGroup(){
            Group group = new Group();
            for (Node gr : this.getChildren()) {
                    group.getChildren().add(gr);
            }
            group.getChildren().addAll(this.getChildren());
            return group;
        }
}
