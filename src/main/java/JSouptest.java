/**
 * Created by christianott on 19.10.17.
 */

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSouptest {

    public static void main(String[] args) {
        Document doc = null;
        List<String> doclist = new ArrayList<String>();
        Array[] array = new Array[100];

        try{
            doc = Jsoup.connect("http://www.handelsblatt.com/unternehmen/industrie/kraftwerkssparte-siemens-zahl-zum-stellenabbau-ist-noch-nicht-fix/20695274.html").get();
            String title = doc.title();
            System.out.println("Title: " + title);

            Elements links = doc.select("p");

            for(Element link : links){
                System.out.println("\nLink : " + link.attr("href"));
                System.out.println("Text : " + link.text());
                doclist.add(link.attr("href"));
                //doc = Jsoup.connect(link.attr("href")).get();
                //array[0] = ;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
