import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import static javafx.application.Application.STYLESHEET_CASPIAN;
import static javafx.application.Application.launch;
import static javafx.application.Application.setUserAgentStylesheet;

public class JSouptest extends Application {

    public static final Map<Integer,String> doclist = new HashMap<Integer, String>();
    public static final Map<Integer,String> visitedSite = new HashMap<Integer, String>();
    public static final String[] startwebsites = new String[]{"http://www.handelsblatt.com/unternehmen/handel-konsumgueter/bain-studie-die-neue-lust-auf-luxus/20712004.html","",""};
    public static final List<String> textList = new ArrayList<String>();
    public static final List<News> newsList = new ArrayList<News>();
    static Stage stage;

    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
            Scene scene = new Scene(root, 1200,700);
            //scene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());
            //System.setProperty( "javafx.userAgentStylesheetUrl", "CASPIAN" );
            //setUserAgentStylesheet(STYLESHEET_CASPIAN);
            stage = primaryStage;
            stage.setScene(scene);
            stage.setTitle("Start");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws java.sql.SQLException{
        launch(args);

        //DatabaseConnection con = new DatabaseConnection("localhost","5432","WebCrawler","postgres","147258369");
        //con.setupDBConnection();
        /*Document doc = null;
        Crawler test = new Crawler();
        Thread[] threads = new Thread[startwebsites.length];
        doclist.put(0,startwebsites[0]);

        try{
            test.thewebsite(doc);

        }catch(IOException e){
            e.printStackTrace();
        }
        //con.insertNews(JSouptest.newsList.get(0));

        /*String[] newtext = JSouptest.newsList.get(0).nachricht.split(".");
                //.replace(","," ");
        System.out.println(JSouptest.newsList.get(0).nachricht);*/
        //Classify classy = new Classify();
        //classy.getKnowledge();
        //classy.classyfyText("");
        //String[] text = "Der Mann ist ja super nett und böse oder schlimm".split("\\s");
        //classy.getProbalitiy(text);
    }


}
