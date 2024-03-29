package com.fx.model3dfxtest.GuideCodes;

import com.fx.model3dfxtest.GuideCodes.Tabs.*;
import com.fx.model3dfxtest.GuideCodes.controls.SmartGroup;
import com.fx.model3dfxtest.GuideCodes.groups.GarniMonument;
import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TTT extends Application {


    @Override
    public void start(Stage stage) {


        Group group = new Group();
        Scene scene = new Scene(group, Screen.getPrimary().getBounds().getMaxX() / 2, Screen.getPrimary().getBounds().getMaxY() / 2, true);
        group.getChildren().add(new CubeBuilderGroup(scene));
        group.getChildren().add(new SphereBuilderGroup(scene));
        group.getChildren().add(new CylinderBuilderGroup(scene));
        group.getChildren().add(new DeleteGroup(scene));
//        group.getChildren().add(new MergeGroup(scene));



        Camera camera = new PerspectiveCamera();
        camera.setTranslateZ(-100);
        camera.setNearClip(1);
        camera.setFarClip(10000);
        SmartGroup monumentGroup = new GarniMonument();


        group.getChildren().add(monumentGroup);


        scene.setCamera(camera);
        scene.setFill(Color.BLUEVIOLET);

        stage.setTitle("T 3d");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}


