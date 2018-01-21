import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by christianott on 21.01.18.
 */
public class OutcomeController implements Initializable {

    @FXML ListView listView;

    //@Override
    public void initialize(URL location, ResourceBundle resources){
        ObservableList<String> newsTitle = FXCollections.observableArrayList();

        for(News news : MainWindowController.items){
            newsTitle.add(news.title);
        }
        listView.setItems(newsTitle);
    }
}
