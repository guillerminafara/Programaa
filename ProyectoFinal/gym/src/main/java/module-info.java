module gym {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;

    opens gym to javafx.fxml;
    opens modelo to javafx.base;
    exports gym;
}
