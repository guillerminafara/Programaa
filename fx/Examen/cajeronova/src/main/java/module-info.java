module cajeronova {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;

    opens cajeronova to javafx.fxml;
    exports cajeronova;
}
