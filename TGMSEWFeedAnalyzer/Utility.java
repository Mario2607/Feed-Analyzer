package TGMSEWFeedAnalyzer;

import java.io.*;
import java.util.*;

public class Utility {
    public double analyzeText(String text){
        Set<String> stopWoerter = new HashSet<>();
        Map<String, Double> vader = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("./Resources/SmartStoplist.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stopWoerter.add(line);
            }
        } catch (IOException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("./Resources/vader_lexicon.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length >= 2) {
                    vader.put(parts[0], Double.parseDouble(parts[1]));
                }
            }
        } catch (IOException e) {
            System.err.println("Fehler: " + e.getMessage());
        }

        double ergebnis = 0;
        String[] woerter = text.split(" ");
        for (String wort : woerter) {
            if (!stopWoerter.contains(wort) && vader.containsKey(wort)) {
                ergebnis += vader.get(wort);
            }
        }
        return ergebnis;
    }
}
