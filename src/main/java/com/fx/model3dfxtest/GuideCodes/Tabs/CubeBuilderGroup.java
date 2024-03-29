package com.fx.model3dfxtest.GuideCodes.Tabs;

import com.fx.model3dfxtest.GuideCodes.controls.SmartGroup;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;

public class CubeBuilderGroup extends Group implements Place{
    private final Text text = new Text(" Cube ");

    private final Box box = new Box(50,50,50);

    public CubeBuilderGroup(Scene scene) {
        this.getChildren().addAll(this.box, this.text);

        setCoordinates(scene);


        box.setOnMousePressed(mouseEvent -> this.getChildren().add(initCube(scene)));
        text.setOnMousePressed(mouseEvent -> this.getChildren().add(initCube(scene)));
    }

    public synchronized void setCoordinates(Scene scene) {
        box.translateXProperty().set(scene.getWidth()/16);
        box.translateYProperty().set(scene.getHeight()/8);

        text.setX(box.translateXProperty().get() - 10);
        text.setY(box.translateYProperty().get() + 5);
        text.setTranslateZ(box.getTranslateZ() - 40);
    }

    public static SmartGroup initCube(Scene groupScene){
        SmartGroup cubeGroup = new SmartGroup(new Box(50,50,50));


        cubeGroup.translateXProperty().set(groupScene.getWidth()/2);
        cubeGroup.translateYProperty().set(groupScene.getHeight()/2);
        cubeGroup.translateZProperty().set(0);


        return cubeGroup;
    }
}
