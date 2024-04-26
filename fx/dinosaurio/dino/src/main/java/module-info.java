module dinosaurios {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens dinosaurios to javafx.fxml;
    exports dinosaurios;
}
