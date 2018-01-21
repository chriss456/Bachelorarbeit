import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Date;


public class Crawler {
    private int i = 0;
    private int a = 0;
    String link = "";

    public void catchlinks(Document doc)throws Exception{
        Elements links = doc.select("a[href]");
        Elements otherlinks = doc.getElementsByClass("vhb-share-social-media-button small").tagName("data-share-url");
            for (Element link : links) {
                if(link.attr("href").contains("handelsblatt") && !link.attr("href").contains("digitalpass") && !link.attr("href").contains("mailto")&& !link.attr("href").contains("404")) {
                    if (link.attr("href").startsWith("/")) {
                        this.link = JSouptest.startwebsites[0] + link.attr("href");
                        if (!JSouptest.doclist.containsValue(this.link)) {
                            JSouptest.doclist.put(i++, this.link);
                        }
                    } else if (link.attr("href").startsWith("#") || link.attr("href").startsWith("m")) {

                    } else {
                        this.link = link.attr("href");
                        if (!JSouptest.doclist.containsValue(this.link)) {
                            JSouptest.doclist.put(i++, this.link);
                        }
                    }
                }

            }

        if(otherlinks.size() != 0) {
            for (Element text : otherlinks) {
                //System.out.println(text.toString().split("data-share-url")[2].split("\"")[1]);
                JSouptest.doclistArticle.put(a++, text.toString().split("data-share-url")[2].split("\"")[1]);
            }
        }

        //System.out.println(JSouptest.doclist.size());
    }

    public void catchTexts(Document doc)throws Exception{
        HtmlFormatter formatter = new HtmlFormatter();

        Elements texts = doc.select("p");
        String title = doc.title();
        String finishedtext = "";
        for (Element text : texts) {
            finishedtext += formatter.getPlainText(text);
        }
        //System.out.println("Title: "+title);
        //System.out.println(JSouptest.textList);
        finishedtext.trim();
        Date d = new Date();
        JSouptest.textList.add(finishedtext);
        News news = new News(title,finishedtext,d,"handelsblatt.de");
        JSouptest.newsList.add(news);
        System.out.println("Nachricht: " +news.nachricht);
        if(finishedtext != "") {
            DatabaseConnection.insertNews(news);
        }
    }

    public void thewebsite(Document doc) throws Exception {


        for(int i = 0; i < JSouptest.doclist.size(); i++){
            int j = 0;
            if(JSouptest.doclistArticle.size() > 0){
                for(j = 0; j < JSouptest.doclistArticle.size(); j++){
                    if(!JSouptest.visitedSite.containsValue(JSouptest.doclistArticle.get(j))){
                        JSouptest.visitedSite.put(i + j, JSouptest.doclistArticle.get(j));
                        System.out.println("Derzeitige Website: " + JSouptest.doclistArticle.get(j));
                        doc = Jsoup.connect(JSouptest.doclistArticle.get(j)).get();
                        catchlinks(doc);
                        catchTexts(doc);
                    }
                }
            }

            if(!JSouptest.visitedSite.containsValue(JSouptest.doclist.get(i))){
                JSouptest.visitedSite.put(i + j, JSouptest.doclist.get(i));
                System.out.println("Derzeitige Website: " + JSouptest.doclist.get(i));
                doc = Jsoup.connect(JSouptest.doclist.get(i)).get();
                catchlinks(doc);
            }
        }
    }
}
