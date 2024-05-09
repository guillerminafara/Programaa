module cajeronova {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens cajeronova to javafx.fxml;
    exports cajeronova;
}
