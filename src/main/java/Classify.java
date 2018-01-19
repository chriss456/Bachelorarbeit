import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by christianott on 13.01.18.
 */
public class Classify {

    double posCount = 0;
    double negCount = 0;
    double neutralCount = 0;
    Classifier<String, String> bayes = new BayesClassifier<String, String>();

    public void getKnowledge(){
        bayes.setMemoryCapacity(500);

        final String[] positiveText = "lieb nett freundlich toll cool selbstlos ich".split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText));

        final String[] negativeText = "blöd doof unfreundlich kalt".split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText));
    }

    public void classyfyText(String text){

        final String[] unknownText1 = "nett".split("\\s");
        final String[] unknownText2 = "der ist ja doof".split("\\s");
        System.out.println(unknownText1.length);

        System.out.println( // will output "positive"
                bayes.classify(Arrays.asList(unknownText1)).getCategory());
        System.out.println( // will output "negative"
                bayes.classify(Arrays.asList(unknownText2)).getCategory());
        System.out.println(((BayesClassifier<String, String>) bayes).classifyDetailed(
                Arrays.asList(unknownText1)));
    }

    public void getProbalitiy(String[] text){
        List<String> poswords = new ArrayList<String>();poswords.add("nett");
        List<String> negwords = new ArrayList<String>();negwords.add("böse");negwords.add("schlimm");
        List<String> neutralwords = new ArrayList<String>();

        for(int i = 0; i < text.length;i++){
            if(poswords.contains(text[i])){
                posCount++;
            }
            else if(negwords.contains(text[i])){
                negCount++;
            }
            else if(neutralwords.contains(text[i])){
                neutralCount++;
            }
        }

        double probpos = posCount / (posCount + negCount + neutralCount);
        double probneg = negCount /  (posCount + negCount + neutralCount);
        double probneutral = 0;//neutralCount /  (posCount + negCount + neutralCount);

        System.out.println("Wahrscheinlichkeit das der Text positiv ist: " +probpos+ " Negativ ist: "+probneg+" Neutral ist: " +probneutral+".");
    }
}
