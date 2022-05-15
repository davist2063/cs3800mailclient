module tiptaxtotal {
    requires javafx.controls;
    requires javafx.fxml;

    opens mailClient to javafx.fxml;
    exports mailClient;
}
