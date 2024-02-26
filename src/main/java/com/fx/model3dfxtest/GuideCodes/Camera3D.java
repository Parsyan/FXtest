package com.fx.model3dfxtest.GuideCodes;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

import static com.fx.model3dfxtest.GuideCodes.HelloApplication.*;

public class Camera3D extends Application {
    @Override
    public void start(Stage stage) {
        Sphere sphere = new Sphere(25);

        Group group = new Group();
        group.getChildren().add(sphere);

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
//        Rotate3D.basicMoveOperations(stage, camera.translateZProperty(), camera.getTranslateZ(), camera.translateXProperty(), camera.getTranslateX(), camera.translateYProperty(), camera.getTranslateY(), sphere);
        stage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            int step = 12;
            switch (keyEvent.getCode())
            {
                case W:
                    camera.translateYProperty().set((camera.getTranslateY() + step));
                    break;
                case S:
                    camera.translateYProperty().set(camera.getTranslateY() - step);
                    break;
                case A:
                    camera.translateXProperty().set(camera.translateXProperty().get() + step);
                    break;
                case D:
                    camera.translateXProperty().set(camera.translateXProperty().get() - step);
                    break;
                case Q:
                    camera.translateZProperty().set(camera.translateZProperty().get() - step);
                    break;
                case E:
                    camera.translateZProperty().set(camera.translateZProperty().get() + step);
                    break;
            }
        });

        stage.setTitle("Camera 3d");
        stage.setScene(scene);
        stage.show();
    }
}
