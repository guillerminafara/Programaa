module usuario {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens usuario to javafx.fxml;
    exports usuario;
}
