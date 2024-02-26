package com.fx.model3dfxtest.GuideCodes;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class Test3d extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Box box = new Box(300, 500, 300);

        Group group = new Group();

        group.getChildren().add(box);
//        box.translateXProperty().set(500);
//        box.translateYProperty().set(500);
//        box.translateZProperty().set(-1500);


        Scene scene = new Scene(group, 1400, 600);

        Camera camera = new PerspectiveCamera();

        box.translateXProperty().set(700);
        box.translateYProperty().set(300);
        scene.setCamera(camera);
        stage.setScene(scene);
        stage.setTitle("3D Model!");
        stage.show();
    }
}
