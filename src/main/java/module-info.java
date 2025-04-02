module org.example.datastructures1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.datastructures1 to javafx.fxml;
    exports org.example.datastructures1;
}
