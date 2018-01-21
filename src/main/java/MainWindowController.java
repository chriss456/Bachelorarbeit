import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
static ObservableList<News> items = FXCollections.observableArrayList();



    public void search() throws Exception{

        String search = searchName.getText();

        items = DatabaseConnection.getNews();

        Stage primaryStage = new Stage();
        OutcomeWindow outcomeWindow = new OutcomeWindow();
        outcomeWindow.start(primaryStage);
        JSouptest.stage.close();
    }

}
