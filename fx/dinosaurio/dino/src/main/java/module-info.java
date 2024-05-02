module dinosaurios {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens dinosaurios to javafx.fxml;
    exports dinosaurios;
}
