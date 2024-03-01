module com.example.control {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.logging;

    opens com.example.control to javafx.fxml,javafx.graphics;
    opens com.example.logica to javafx.base;
}