module reproductormp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;
    opens reproductormp to javafx.fxml;
    exports reproductormp;
}
