import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.jsoup.nodes.Document;


public class JSouptest extends Application {

    public static final Map<Integer,String> doclist = new HashMap<Integer, String>();
    public static final Map<Integer,String> doclistArticle = new HashMap<Integer, String>();
    public static final Map<Integer,String> visitedSite = new HashMap<Integer, String>();
    public static final String[] startwebsites = new String[]{"http://www.handelsblatt.com/finanzen/maerkte/devisen-rohstoffe/opec-und-ihre-partner-vereint-in-oelbruderschaft/20871292.html","",""};
    public static final List<String> textList = new ArrayList<String>();
    public static final List<News> newsList = new ArrayList<News>();
    static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("/Mainpage.fxml"));
            Scene scene = new Scene(root, 600,400);
            //scene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());
            //System.setProperty( "javafx.userAgentStylesheetUrl", "CASPIAN" );
            //setUserAgentStylesheet(STYLESHEET_CASPIAN);
            stage = primaryStage;
            stage.setScene(scene);
            stage.setTitle("Start");
            stage.show();
    }

    public static void main(String[] args)throws Exception {


        DatabaseConnection con = new DatabaseConnection("localhost","5432","WebCrawler","postgres","147258369");
        con.setupDBConnection();
        //launch(args);

        Document doc = null;
        Crawler test = new Crawler();
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
        /*Classify classy = new Classify();
        classy.getKnowledge();
        classy.classyfyText("");
        String[] text = "Der Mann ist ja super nett und böse oder schlimm".split("\\s");
        classy.getProbalitiy(text);*/
    }


}
