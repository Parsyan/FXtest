package com.fx.model3dfxtest.GuideCodes.Tabs;

import com.fx.model3dfxtest.GuideCodes.Rotate3D;
import com.fx.model3dfxtest.GuideCodes.controls.SmartGroup;
import com.fx.model3dfxtest.mytests.CubeBuilder;
import com.fx.model3dfxtest.mytests.Test3d;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class CubeBuilderGroup extends Group {
    private final Text text = new Text(" Cube ");

    private Box box = new Box(50,50,50);

    public CubeBuilderGroup(Scene scene) {
        this.getChildren().addAll(this.box, this.text);



        box.translateXProperty().set(scene.getWidth()/16);
        box.translateYProperty().set(scene.getHeight()/8);
        box.translateZProperty().set(box.translateYProperty().get()/2);

        box.setOnMousePressed(mouseEvent -> {
            this.getChildren().add(initCube(scene));
        });

        text.setX(box.translateYProperty().get()/2);
        text.setY(box.translateYProperty().get());

    }

    public static SmartGroup initCube(Scene groupScene){
        SmartGroup cubeGroup = new SmartGroup();
        cubeGroup.getChildren().add(new Box(50,50,50));

        Scene scene = groupScene;

        cubeGroup.translateXProperty().set(scene.getWidth()/2);
        cubeGroup.translateYProperty().set(scene.getHeight()/2);
        cubeGroup.translateZProperty().set(0);


        return cubeGroup;
    }
}
