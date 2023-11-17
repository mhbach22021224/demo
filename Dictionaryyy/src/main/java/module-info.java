module com.example.dictionaryyy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jlayer;


    opens com.example.dictionaryyy to javafx.fxml;
    exports com.example.dictionaryyy;
}