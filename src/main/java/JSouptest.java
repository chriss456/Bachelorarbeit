import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSouptest {

    public static final Map<Integer,String> doclist = new HashMap<Integer, String>();
    public static final Map<Integer,String> visitedSite = new HashMap<Integer, String>();
    public static final String[] startwebsites = new String[]{"http://www.handelsblatt.com/unternehmen/handel-konsumgueter/bain-studie-die-neue-lust-auf-luxus/20712004.html","",""};
    public static final List<String> textList = new ArrayList<String>();

    public static void main(String[] args) {
        Document doc = null;
        Crawler test = new Crawler();
        Thread[] threads = new Thread[startwebsites.length];
        doclist.put(0,startwebsites[0]);

        try{
            test.thewebsite(doc);

        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
