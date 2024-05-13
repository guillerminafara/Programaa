module gym {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens gym to javafx.fxml;

    exports gym;
}
