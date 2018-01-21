import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static javafx.application.Application.STYLESHEET_CASPIAN;
import static javafx.application.Application.setUserAgentStylesheet;

/**
 * Created by christianott on 18.01.18.
 */
public class MainWindowController{

@FXML Button searchButton;
@FXML TextField searchName;
@FXML DatePicker datePicker;
Stage primaryStage = new Stage();


    public void search() throws Exception{
        JSouptest.stage.close();
        OutcomeWindow outcomeWindow = new OutcomeWindow();
        outcomeWindow.start(primaryStage);
    }

}
