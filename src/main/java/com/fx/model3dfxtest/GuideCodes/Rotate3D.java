package com.fx.model3dfxtest.GuideCodes;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

import static com.fx.model3dfxtest.GuideCodes.HelloApplication.X;
import static com.fx.model3dfxtest.GuideCodes.HelloApplication.Y;

public class Rotate3D extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Box box = new Box(25,25,25);


        SmartGroup group = new SmartGroup();
        group.getChildren().add(box);

        Camera camera = new PerspectiveCamera(true);
        Scene scene = new Scene(group, X, Y);
        scene.setFill(Color.BLUEVIOLET);
        scene.setCamera(camera);

        camera.translateXProperty().set(0);
        camera.translateYProperty().set(0);
        camera.translateZProperty().set(-500);


        camera.setNearClip(1);
        camera.setFarClip(1000);


//        System.out.println(" Width " + Screen.getPrimary().getVisualBounds().);
//        Transform transform = new Rotate(65, new Point3D(1,0,0));
//        box.getTransforms().add(transform);

        stage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            int step = 12;
            switch (keyEvent.getCode())
            {
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
                case RIGHT:
                    group.rotateByY(-15);
                    break;
                case LEFT:
                    group.rotateByY(15);
                    break;
            }
        });

        stage.setTitle("Camera 3d");
        stage.setScene(scene);
        stage.show();
    }


    static class SmartGroup extends Group {
        Rotate r;
        Transform t = new Rotate();

        void rotateByX(int ang) {
            r = new Rotate(ang, Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
        void rotateByY(int ang) {
            r = new Rotate(ang, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
    }

}