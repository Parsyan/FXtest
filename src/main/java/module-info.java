module com.fx.model3dfxtest {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires org.lwjgl.glfw;
    requires org.lwjgl.opengl;
    requires javafx.graphics;
    requires javafx.swing;
    requires jdk.jfr;
    requires static lombok;

    opens com.fx.model3dfxtest to javafx.fxml;
    exports com.fx.model3dfxtest.GuideCodes;
    opens com.fx.model3dfxtest.GuideCodes to javafx.fxml;

}