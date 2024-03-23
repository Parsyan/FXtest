package com.fx.model3dfxtest.GuideCodes.Tabs;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;

import static com.fx.model3dfxtest.GuideCodes.Tabs.CubeBuilderGroup.initCube;

public class DeleteBuilderGroup extends Group {

    private Box box;

    private Text text;

    public DeleteBuilderGroup(Scene scene) {
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

}
