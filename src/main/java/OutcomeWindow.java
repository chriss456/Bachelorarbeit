import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by christianott on 21.01.18.
 */
public class OutcomeWindow {
    static Stage stage2;

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/OutcomePage.fxml"));
        Scene scene = new Scene(root, 600,400);
        //scene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());
        //System.setProperty( "javafx.userAgentStylesheetUrl", "CASPIAN" );
        //setUserAgentStylesheet(STYLESHEET_CASPIAN);
        stage2 = primaryStage;
        stage2.setScene(scene);
        stage2.setTitle("Start");
        stage2.show();
    }
}
