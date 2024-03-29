package com.fx.model3dfxtest.GuideCodes.Tabs;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;

public class DeleteGroup extends Group implements Place {

    private final Box box = new Box(50,50,50);

    private final Text text = new Text("Delete");

    public static boolean isActivated = false;

    public DeleteGroup(Scene scene) {
        setCoordinates(scene);
        this.getChildren().addAll(this.box, this.text);
        box.setMaterial(new PhongMaterial(Color.GREEN));




        box.setOnMousePressed(mouseEvent -> {
            isActivated = !isActivated;
            if(isActivated) {
                box.setMaterial(new PhongMaterial(Color.RED));
            } else {
                box.setMaterial(new PhongMaterial(Color.GREEN));
            }
        });



    }

    @Override
    public synchronized void setCoordinates(Scene scene) {
        box.setTranslateX(scene.getWidth()/16);
        box.setTranslateY(scene.getHeight()/8*5);


        text.setX(box.translateXProperty().get() - 6);
        text.setY(box.translateYProperty().get());
        text.setTranslateZ(box.getTranslateZ() - 40);
    }

    public static void delete(Group group, Node node){
        group.getChildren().removeAll(node);
    }

}
