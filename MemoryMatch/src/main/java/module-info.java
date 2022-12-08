module com.eliassen.memorymatch {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.eliassen.memorymatch to javafx.fxml;
    exports com.eliassen.memorymatch;
}