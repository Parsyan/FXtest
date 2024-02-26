package com.fx.model3dfxtest.GuideCodes;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

//import java.io.IOException;


public class HelloApplication extends Application {

    protected static int X = 1400;
    protected static int Y = 800;
    protected static int Z = 1300;
    @Override
    public void start(Stage stage)  {

        Sphere sphere = new Sphere(25);


        Group group = new Group();
        Camera camera = new PerspectiveCamera(true);
        group.getChildren().add(sphere);

        Scene scene = new Scene(group, X, Y);
        scene.setCamera(camera);

        sphere.translateXProperty().set(X/2);
        sphere.translateYProperty().set(Y/2);



        stage.setTitle("3D Model!");
        stage.setScene(scene);

       stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    protected static void basicSteps(KeyEvent key, Shape3D shape3D, int step){
        switch (key.getCode())
        {
            case W:
//                shape3D.translateZProperty().set(shape3D.translateZProperty().get() + step);
                shape3D.translateZProperty().set(checkBorder(step, shape3D.getTranslateZ(), Z));
                break;
            case S:
                shape3D.translateZProperty().set((shape3D.getTranslateZ() - step > -Z)
                        ? shape3D.getTranslateZ() - step
                        : shape3D.getTranslateZ());
                break;
            case A:
                shape3D.translateXProperty().set((shape3D.getTranslateX() - step > 20) ? shape3D.getTranslateX() - step : shape3D.getTranslateX());
                break;
            case D:
                shape3D.translateXProperty().set(checkBorder(shape3D.getTranslateX(), step, X));
                break;
            case Q:
                shape3D.translateYProperty().set(checkBorder(shape3D.getTranslateY(), step, Y));
                break;
            case E:
                shape3D.translateYProperty().set((shape3D.getTranslateY() - step > 20) ? shape3D.getTranslateY() - step : shape3D.getTranslateY());
                break;
        }
    }
    protected static double checkBorder(double step, double currentCoordinate, double border){
        return (step + currentCoordinate < border - 20) ? step + currentCoordinate : currentCoordinate;
    }
}