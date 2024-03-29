package com.fx.model3dfxtest.GuideCodes.Tabs;

import com.fx.model3dfxtest.GuideCodes.controls.SmartGroup;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Cylinder;
import javafx.scene.text.Text;

public class CylinderBuilderGroup extends Group implements Place {

    private final Cylinder cylinder = new Cylinder(35,35);

    private final Text text = new Text(" Cylinder ");


    public CylinderBuilderGroup(Scene scene) {

        setCoordinates(scene);
        this.getChildren().addAll(this.cylinder, this.text);


        cylinder.setOnMousePressed(mouseEvent -> this.getChildren().add(initCylinder(scene)));
        text.setOnMousePressed(mouseEvent -> this.getChildren().add(initCylinder(scene)));


    }

    @Override
    public synchronized void setCoordinates(Scene scene) {
        cylinder.translateXProperty().set(scene.getWidth()/16);
        cylinder.translateYProperty().set(scene.getHeight()/8*3);


        text.setX(cylinder.translateXProperty().get() - 10);
        text.setY(cylinder.getTranslateY());
        text.setTranslateZ(cylinder.getTranslateZ() - 40);
    }

    private SmartGroup initCylinder(Scene groupScene) {

            SmartGroup cylinderGroup = new SmartGroup(new Cylinder(50,50,50));

            cylinderGroup.translateXProperty().set(groupScene.getWidth()/2);
            cylinderGroup.translateYProperty().set(groupScene.getHeight()/2);
            cylinderGroup.translateZProperty().set(0);


            return cylinderGroup;

    }
}
