module com.eliassen.memorymatch {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.eliassen to javafx.fxml;
    exports com.eliassen;
}