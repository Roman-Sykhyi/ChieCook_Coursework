module chiefcook.chiecook_coursework {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    //requires org.junit.jupiter.api;
    requires log4j;
    requires java.sql;

    opens chiefcook.chiecook_coursework to javafx.fxml;
    exports chiefcook.chiecook_coursework;
    exports chiefcook.chiecook_coursework.controllers;
    opens chiefcook.chiecook_coursework.controllers to javafx.fxml;
    exports chiefcook.chiecook_coursework.gui.controllers;
    opens chiefcook.chiecook_coursework.gui.controllers to javafx.fxml;
}