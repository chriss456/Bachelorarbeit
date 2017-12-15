import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class Crawler {
    private int i = 0;
    String link = "";

    public void catchlinks(Document doc){
        Elements links = doc.select("a[href]");

            for (Element link : links) {
                if(link.attr("href").contains("handelsblatt") && !link.attr("href").contains("digitalpass") && !link.attr("href").contains("mailto")) {
                    if (link.attr("href").startsWith("/")) {
                        this.link = JSouptest.startwebsite + link.attr("href");
                        if (!JSouptest.doclist.containsValue(this.link)) {
                            JSouptest.doclist.put(i++, this.link);
                        }
                    } else if (link.attr("href").startsWith("#") || link.attr("href").startsWith("m") || link.attr("href").contains("404")) {

                    } else {
                        this.link = link.attr("href");
                        if (!JSouptest.doclist.containsValue(this.link)) {
                            JSouptest.doclist.put(i++, this.link);
                        }
                    }
                    //System.out.println(this.link);
                    //System.out.println("Text : " + link.text());
                }
            }

        System.out.println(JSouptest.doclist.size());
    }

    public void thewebsite(Document doc) throws IOException {

        for(int i = 0; i < JSouptest.doclist.size(); i++){
            if(!JSouptest.visitedSite.containsValue(JSouptest.doclist.get(i))){
                JSouptest.visitedSite.put(i, JSouptest.doclist.get(i));System.out.println("Derzeitige Website: " + JSouptest.doclist.get(i));
                doc = Jsoup.connect(JSouptest.doclist.get(i)).get();
                catchlinks(doc);

            }
        }
    }
}
