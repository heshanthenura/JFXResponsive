module com.heshanthenura.jfxresponsive {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.heshanthenura.jfxresponsive to javafx.fxml;
    exports com.heshanthenura.jfxresponsive;
}