module com.fx.model3dfxtest {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.fx.model3dfxtest to javafx.fxml;
    exports com.fx.model3dfxtest;
    exports com.fx.model3dfxtest.GuideCodes;
    opens com.fx.model3dfxtest.GuideCodes to javafx.fxml;
}