module dinosaurios {
    requires javafx.controls;
    requires javafx.fxml;

    opens dinosaurios to javafx.fxml;
    exports dinosaurios;
}
