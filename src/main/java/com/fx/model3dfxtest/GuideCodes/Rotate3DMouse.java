package com.fx.model3dfxtest.GuideCodes;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import static com.fx.model3dfxtest.GuideCodes.HelloApplication.X;
import static com.fx.model3dfxtest.GuideCodes.HelloApplication.Y;

public class Rotate3DMouse extends Application {

    private double anchorX, anchorY;
    private double currentAngleX = 0,
            currentAngleY = 0;

    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);

    @Override
    public void start(Stage stage) throws Exception {
        Box box = new Box(25, 23, 25);


        Rotate3D.SmartGroup group = new Rotate3D.SmartGroup();
        Group group2 = new Group();
        group.getChildren().addAll(box, new Box(15,25,30));
//        group2.getChildren().a

        Camera camera = new PerspectiveCamera(true);
        Scene scene = new Scene(group, X, Y);
        scene.setFill(Color.BLUEVIOLET);
        scene.setCamera(camera);

        camera.translateXProperty().set(0);
        camera.translateYProperty().set(0);
        camera.translateZProperty().set(-500);

        camera.setNearClip(1);
        camera.setFarClip(1000);

        initMouseControl(group, scene);


        stage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            int step = 12;
            switch (keyEvent.getCode()) {
                case S:
                    box.translateYProperty().set((box.getTranslateY() + step));
                    break;
                case W:
                    box.translateYProperty().set(box.getTranslateY() - step);
                    break;
                case D:
                    box.translateXProperty().set(box.translateXProperty().get() + step);
                    break;
                case A:
                    box.translateXProperty().set(box.translateXProperty().get() - step);
                    break;
                case Q:
                    box.translateZProperty().set(box.translateZProperty().get() - step);
                    break;
                case E:
                    box.translateZProperty().set(box.translateZProperty().get() + step);
                    break;
                case UP:
                    group.rotateByX(-15);
                    break;
                case DOWN:
                    group.rotateByX(15);
                    break;
                case LEFT:
                    group.rotateByY(-15);
                    break;
                case RIGHT:
                    group.rotateByY(15);
                    break;
            }
        });

        stage.addEventHandler(ScrollEvent.SCROLL, scrollEvent -> {
            double delta = scrollEvent.getDeltaY();
            group.translateZProperty().set(group.getTranslateZ() + delta);
        });

        stage.setTitle("Rotate 3D Mouse Control 3d");
        stage.setScene(scene);
        stage.show();
    }

    private void initMouseControl(Rotate3D.SmartGroup group, Scene scene) {
        Rotate xRotate;
        Rotate yRotate;
        group.getTransforms().addAll(
                xRotate = new Rotate(0, Rotate.X_AXIS),
                yRotate = new Rotate(0, Rotate.Y_AXIS)
        );
//        This code is most important for work this method
//        It's synchronize mouse x and y with angleX and angleY
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);
//
        scene.setOnMousePressed(mouseEvent -> {
            anchorX = mouseEvent.getSceneX();
            anchorY = mouseEvent.getSceneY();
            currentAngleX = angleX.get();
            currentAngleY = angleY.get();
        });

        scene.setOnMouseDragged(mouseEvent -> {
            angleX.set(currentAngleX - (anchorY - mouseEvent.getSceneY()));
            angleY.set(currentAngleY + anchorX - mouseEvent.getSceneX());
        });


    }
}
