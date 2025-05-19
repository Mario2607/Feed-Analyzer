package TGMSEWFeedAnalyzer;

import java.io.*;
import java.util.*;

public class FeedAnalyzer {
    public static void main(String[] args){
        Map<AnalyzedText, String> messages = new HashMap<>();
        double ergebnis = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("./Resources/potus_tweets_2017_webarchive_publicaccess.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                AnalyzedText nachricht = new AnalyzedText(line);
                Utility u = new Utility();
                ergebnis += u.analyzeText(line);
                messages.put(nachricht, "Potus");
            }
        } catch (IOException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

        System.out.println("Gesamt Score: " + ergebnis);
    }
}
