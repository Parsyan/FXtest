package com.fx.model3dfxtest.GuideCodes.groups;

import com.fx.model3dfxtest.GuideCodes.controls.SmartGroup;
import com.fx.model3dfxtest.GuideCodes.mo.Pyramid;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;

public class GarniMonument extends SmartGroup {
    public GarniMonument() {
        Box box = new Box(50,50,50);
        box.setMaterial(new PhongMaterial(Color.SILVER));
        SmartGroup ground = new SmartGroup(box);

        ground.setTranslateX(384);
        ground.setTranslateY(323);
        ground.setTranslateZ(0);
        ground.setScaleX(8.6);
        ground.setScaleY(0.784);
        ground.setScaleZ(4.692);
        ground.rotateByX(0);

        Cylinder column1 = new Cylinder(50,50,50);
        column1.setTranslateX(540);
        column1.setTranslateY(230);
        column1.setTranslateZ(-80);
        column1.setScaleX(0.3);
        column1.setScaleY(3.3);
        column1.setScaleZ(0.3);

        Cylinder column3 = new Cylinder(50,50,50);
        {
            column3.setTranslateX(384);
            column3.setTranslateY(230);
            column3.setTranslateZ(-80);
            column3.setScaleX(0.3);
            column3.setScaleY(3.3);
            column3.setScaleZ(0.3);
        }
        Cylinder column5 = new Cylinder(50,50,50);
        {
            column5.setTranslateX(220);
            column5.setTranslateY(230);
            column5.setTranslateZ(-80);
            column5.setScaleX(0.3);
            column5.setScaleY(3.3);
            column5.setScaleZ(0.3);
        }
        Cylinder column4 = new Cylinder(50,50,50);
        {
            column4.setTranslateX(306);
            column4.setTranslateY(230);
            column4.setTranslateZ(-80);
            column4.setScaleX(0.3);
            column4.setScaleY(3.3);
            column4.setScaleZ(0.3);
        }
        Cylinder column2 = new Cylinder(50,50,50);
        {
            column2.setTranslateX(464);
            column2.setTranslateY(230);
            column2.setTranslateZ(-80);
            column2.setScaleX(0.3);
            column2.setScaleY(3.3);
            column2.setScaleZ(0.3);
        }
        Cylinder column9 = new Cylinder(50,50,50);
        {
            column9.setTranslateX(384);
            column9.setTranslateY(230);
            column9.setTranslateZ(80);
            column9.setScaleX(0.3);
            column9.setScaleY(3.3);
            column9.setScaleZ(0.3);
        }
        Cylinder column7 = new Cylinder(50,50,50);
        {
            column7.setTranslateX(220);
            column7.setTranslateY(230);
            column7.setTranslateZ(80);
            column7.setScaleX(0.3);
            column7.setScaleY(3.3);
            column7.setScaleZ(0.3);
        }
        Cylinder column8 = new Cylinder(50,50,50);
        {
            column8.setTranslateX(306);
            column8.setTranslateY(230);
            column8.setTranslateZ(80);
            column8.setScaleX(0.3);
            column8.setScaleY(3.3);
            column8.setScaleZ(0.3);
        }
        Cylinder column10 = new Cylinder(50,50,50);
        {
            column10.setTranslateX(464);
            column10.setTranslateY(230);
            column10.setTranslateZ(80);
            column10.setScaleX(0.3);
            column10.setScaleY(3.3);
            column10.setScaleZ(0.3);
        }
        Cylinder column11 = new Cylinder(50,50,50);
        {
            column11.setTranslateX(540);
            column11.setTranslateY(230);
            column11.setTranslateZ(80);
            column11.setScaleX(0.3);
            column11.setScaleY(3.3);
            column11.setScaleZ(0.3);
        }
        Cylinder column12 = new Cylinder(50,50,50);
        {
            column12.setTranslateX(540);
            column12.setTranslateY(230);
            column12.setTranslateZ(0);
            column12.setScaleX(0.3);
            column12.setScaleY(3.3);
            column12.setScaleZ(0.3);
        }
        Cylinder column6 = new Cylinder(50,50,50);
        {
            column6.setTranslateX(220);
            column6.setTranslateY(230);
            column6.setTranslateZ(0);
            column6.setScaleX(0.3);
            column6.setScaleY(3.3);
            column6.setScaleZ(0.3);
        }
        Pyramid roof = new Pyramid(100, -50, 100, Color.SILVER);
        {
            roof.setTranslateX(332);
            roof.setTranslateY(86);
            roof.setTranslateZ(-64);
            roof.setScaleX(4.4);
            roof.setScaleY(1.6);
            roof.setScaleZ(3);
        }
        Box roofCube = new Box(50,50,50);
        {
            roofCube.setTranslateX(384);
            roofCube.setTranslateY(125);
            roofCube.setTranslateZ(0);
            roofCube.setScaleX(8.6);
            roofCube.setScaleY(0.784);
            roofCube.setScaleZ(4.692);
        }

        Box room = new Box(50,50,50);
        {
            room.setTranslateX(384);
            room.setTranslateY(220);
            room.setTranslateZ(0);
            room.setScaleX(5);
            room.setScaleY(3);
            room.setScaleZ(2);
        }

        Box door = new Box(50,50,50);
        door.setMaterial(new PhongMaterial(Color.BLACK));

        door.setTranslateX(505);
        door.setTranslateY(254);
        door.setTranslateZ(0);
        door.setScaleX(0.9);
        door.setScaleY(1.6);
        door.setScaleZ(1.2);

        this.getChildren().addAll(
                ground,
                column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11, column12,
                roofCube, roof,
                room, door
        );
        this.setTranslateZ(200);
        this.setMouseClicked();

    }
}
