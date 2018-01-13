import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

/**
 * Created by christianott on 13.01.18.
 */
public class Classify {

    Classifier<String, String> bayes = new BayesClassifier<String, String>();
}
