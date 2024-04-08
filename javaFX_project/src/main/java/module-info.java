module hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens dtu.timeregistering.ui to javafx.fxml; // Gives access to fxml files
    exports dtu.timeregistering.ui;
    exports dtu.timeregistering.app;
    opens dtu.timeregistering.app to javafx.fxml; // Exports the class inheriting from javafx.application.Application
}