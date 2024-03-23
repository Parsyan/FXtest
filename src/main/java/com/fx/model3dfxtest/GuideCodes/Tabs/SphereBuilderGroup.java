package com.fx.model3dfxtest.GuideCodes.Tabs;

import com.fx.model3dfxtest.GuideCodes.controls.SmartGroup;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;

public class SphereBuilderGroup extends Group {
    private Sphere sphere = new Sphere(30);
    private final Text text = new Text(" Sphere ");

    public SphereBuilderGroup (Scene scene) {
        this.getChildren().addAll(this.sphere, this.text);



        sphere.translateXProperty().set(scene.getWidth()/16-18);
        sphere.translateYProperty().set(scene.getHeight()/4+4);
        sphere.translateZProperty().set(sphere.translateYProperty().get()/2);

        sphere.setOnMousePressed(mouseEvent -> {
            this.getChildren().add(initSphere(scene));
        });

        text.setX(sphere.translateXProperty().get()/2+18);
        text.setY(sphere.translateYProperty().get()+6);

    }

    private SmartGroup initSphere(Scene groupScene) {
        {
            SmartGroup sphereGroup = new SmartGroup();
            sphereGroup.getChildren().add(new Sphere(50,50));

            Scene scene = groupScene;

            sphereGroup.translateXProperty().set(scene.getWidth()/2);
            sphereGroup.translateYProperty().set(scene.getHeight()/2);
            sphereGroup.translateZProperty().set(0);


            return sphereGroup;
        }
    }
}
