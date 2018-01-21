import java.util.Date;

/**
 * Created by christianott on 03.01.18.
 */
public class News {

    String title;
    String nachricht;
    Date datum;
    String quelle;
    String classification;

    public News(String title, String nachricht, Date datum, String quelle){
        this.title = title;
        this.nachricht = nachricht;
        this.datum = datum;
        this.quelle = quelle;
    }

    public void setClassification(String classification){
        this.classification = classification;
    }

    public String getClassification(){
        return classification;
    }

}
