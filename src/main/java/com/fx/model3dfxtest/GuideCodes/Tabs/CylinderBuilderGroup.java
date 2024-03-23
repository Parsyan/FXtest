package com.fx.model3dfxtest.GuideCodes.Tabs;

import com.fx.model3dfxtest.GuideCodes.controls.SmartGroup;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;

public class CylinderBuilderGroup extends Group {

    private Cylinder cylinder = new Cylinder(35,50);

    private final Text text = new Text(" Cylinder ");


    public CylinderBuilderGroup(Scene scene) {


        this.getChildren().addAll(this.cylinder, this.text);
        cylinder.translateXProperty().set(scene.getWidth()/256 - 35);
        cylinder.translateYProperty().set(scene.getHeight()/2 - 30);
        cylinder.translateZProperty().set(scene.getHeight()/2);

        cylinder.setOnMousePressed(mouseEvent -> {
            this.getChildren().add(initCylinder(scene));
        });

        text.setX(cylinder.translateXProperty().get()/16 + 30);
        text.setY(cylinder.getTranslateY() + cylinder.getHeight()/4);
    }

    private SmartGroup initCylinder(Scene groupScene) {

            SmartGroup cylinderGroup = new SmartGroup();
            cylinderGroup.getChildren().add(new Cylinder(50,50,50));

            Scene scene = groupScene;

            cylinderGroup.translateXProperty().set(scene.getWidth()/2);
            cylinderGroup.translateYProperty().set(scene.getHeight()/2);
            cylinderGroup.translateZProperty().set(0);


            return cylinderGroup;

    }
}
