package com.fx.model3dfxtest.GuideCodes.mo;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class Pyramid extends Group {

    public Pyramid(double width, double height, double depth, Color color) {
        // Create a TriangleMesh for the pyramid
        TriangleMesh mesh = new TriangleMesh();

        // Define the coordinates of the pyramid vertices
        float[] points = {
                0, 0, 0,                            // Base vertex 1
                (float) width, 0, 0,                // Base vertex 2
                (float) width, 0, (float) depth,    // Base vertex 3
                0, 0, (float) depth,                // Base vertex 4
                (float) width / 2, (float) height, (float) depth / 2  // Apex vertex
        };

        // Define the faces of the pyramid
        int[] faces = {
                0, 0, 1, 0, 2, 0,  // Front face
                0, 0, 2, 0, 3, 0,  // Right face
                0, 0, 3, 0, 4, 0,  // Back face
                0, 0, 4, 0, 1, 0,  // Left face
                1, 0, 4, 0, 2, 0,  // Bottom-left face
                2, 0, 4, 0, 3, 0   // Bottom-right face
        };

        mesh.getPoints().addAll(points);
        mesh.getTexCoords().addAll(0, 0);
        mesh.getFaces().addAll(faces);

        // Create a MeshView and set its material
        MeshView pyramid = new javafx.scene.shape.MeshView(mesh);
        PhongMaterial material = new PhongMaterial(color);
        material.setSpecularColor(Color.YELLOW);
        pyramid.setMaterial(material);
        pyramid.setDrawMode(DrawMode.FILL); // Fill the pyramid with color
//        pyramid.se
        // Add the pyramid to the Group
        getChildren().add(pyramid);
    }
}
