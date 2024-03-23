package com.fx.model3dfxtest.GuideCodes;

import com.fx.model3dfxtest.GuideCodes.Tabs.CubeBuilderGroup;
import com.fx.model3dfxtest.GuideCodes.Tabs.CylinderBuilderGroup;
import com.fx.model3dfxtest.GuideCodes.Tabs.SphereBuilderGroup;
import com.fx.model3dfxtest.GuideCodes.controls.MouseControl;
import com.fx.model3dfxtest.GuideCodes.controls.SmartGroup;
import com.fx.model3dfxtest.mytests.CubeBuilderWithButton;
import com.fx.model3dfxtest.mytests.StretchableObjects;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

public class TTT extends Application {




    @Override
    public void start(Stage stage) throws Exception {

//        Text text = new Text(" Cube ");
//        text.setFill(Color.RED);
//        text.setFont(new Font("Arial", 17));
//
//        Box box = new Box(50, 50, 50);
//
//
//        Rotate3D.SmartGroup group = new Rotate3D.SmartGroup();
//        group.getChildren().addAll(box, text);
//
//        Camera camera = new PerspectiveCamera();
//
//
//
//        Scene scene = new Scene(group,Screen.getPrimary().getBounds().getMaxX()/2.0, Screen.getPrimary().getBounds().getMaxY()/2.0);
//
//        System.out.println(Screen.getPrimary().getBounds().getMaxX()/2.0 + " " + Screen.getPrimary().getBounds().getMaxY()/2.0);
//
//        System.out.println(scene.getHeight() + " " + scene.getWidth());
//
//        box.translateXProperty().set(scene.getWidth()/16);
//        box.translateYProperty().set(scene.getHeight()/8);
//        box.translateZProperty().set(box.translateYProperty().get()/2);
//
//        System.out.println(box.translateXProperty().get() + " " + box.translateYProperty().get() + " " + box.translateZProperty().get());
//        text.setX(box.translateYProperty().get()/2);
//        text.setY(box.translateYProperty().get());
        Group group = new Group();
        Scene scene = new Scene(group, Screen.getPrimary().getBounds().getMaxX()/2, Screen.getPrimary().getBounds().getMaxY()/2, Color.HOTPINK);
        group.getChildren().add(new CubeBuilderGroup(scene));
        group.getChildren().add(new SphereBuilderGroup(scene));
        group.getChildren().add(new CylinderBuilderGroup(scene));

        System.out.println(group.getChildren());
        Camera camera = new PerspectiveCamera();



//      mouseControl(scene);


        scene.setCamera(camera);
        scene.setFill(Color.BLUEVIOLET);


        stage.setTitle("T 3d");
        stage.setScene(scene);
        stage.show();
    }

//    public void mouseControl(Scene scene) {
//
//        scene.setOnMouseClicked(MouseControl::handleMouseClicked);
//        scene.setOnMouseDragged(MouseControl::handleMouseDragged);
//        scene.setOnMousePressed(MouseControl::handleMousePressed);
//    }




}


