module com.eliassen.memorymatch {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;


    opens com.eliassen to javafx.fxml;
    exports com.eliassen;
}