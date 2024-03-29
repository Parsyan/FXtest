package com.fx.model3dfxtest.GuideCodes.Tabs;

import com.fx.model3dfxtest.GuideCodes.controls.SmartGroup;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;

public class SphereBuilderGroup extends Group implements Place {
    private final Sphere sphere = new Sphere(30);
    private final Text text = new Text(" Sphere ");

    public SphereBuilderGroup (Scene scene) {
        this.getChildren().addAll(this.sphere, this.text);


        setCoordinates(scene);


        sphere.setOnMousePressed(mouseEvent -> this.getChildren().add(initSphere(scene)));
        text.setOnMousePressed(mouseEvent -> this.getChildren().add(initSphere(scene)));

    }

    @Override
    public void setCoordinates(Scene scene) {
        sphere.translateXProperty().set(scene.getWidth()/16);
        sphere.translateYProperty().set(scene.getHeight()/8*2);
//        sphere.translateZProperty().set(sphere.translateYProperty().get()/2);

        text.setX(sphere.translateXProperty().get()/2 + 15);
        text.setY(sphere.translateYProperty().get());
        text.setTranslateZ(sphere.getTranslateZ() - 30);
    }

    private SmartGroup initSphere(Scene groupScene) {
        {
            SmartGroup sphereGroup = new SmartGroup(new Sphere(50,50));

            sphereGroup.translateXProperty().set(groupScene.getWidth()/2);
            sphereGroup.translateYProperty().set(groupScene.getHeight()/2);
            sphereGroup.translateZProperty().set(0);


            return sphereGroup;
        }
    }
}
