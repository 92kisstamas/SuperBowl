package SuperBowl;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        try {
            List<SuperBowl> superBowls = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("SuperBowl.txt"))){

                String line = null;

                while ((line = reader.readLine()) != null) {
                    SuperBowl superBowl = new SuperBowl(line);
                    superBowls.add(superBowl);
                }
            }

            int counter = 0;
            for (SuperBowl superBowl : superBowls) {
                counter++;
            }
            System.out.println("(4. feladat) " + counter + " db döntő adatai vannak a forrásállományban.");

            double average = 0.0;
            int averageCounter = 0;

            for (SuperBowl superBowl : superBowls){
                String[] temp = superBowl.getResult().split("-");
                average += (Integer.parseInt(temp[0]) - Integer.parseInt(temp[1]));
                averageCounter++;
            }
            double totalAverage = average / averageCounter;
            DecimalFormat df = new DecimalFormat("#.#");
            df.format(55.544545);
            System.out.println("(5.feladat) A döntők során, az átlagos pontkülönbség: "
                    + df.format(totalAverage));


            Map <String, Integer> teamMap = new HashMap<>();

            for (SuperBowl superBowl : superBowls){
                teamMap.put(superBowl.getWinner(), 1);
                teamMap.put(superBowl.getLoser(), 1);
            }

            // Ssz;Dátum;Győztes;Eredmény;Vesztes;Nézőszám
            try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("SuperBowlNew.txt")))) {
                // System.out -> PrintOutputStream
                writer.println("Ssz;Dátum;Győztes;Eredmény;Vesztes;Nézőszám");

                for (SuperBowl superBowl : superBowls) {
                    writer.println(superBowl.getSerialNumber() + ";"
                    + superBowl.getDate() + ";"
                    + superBowl.getWinner() + "(" + teamMap.get(superBowl.getWinner()) + ")" + ";"
                    + superBowl.getResult() + ";"
                    + superBowl.getLoser() + "(" + teamMap.get(superBowl.getLoser()) + ")" + ";"
                    + superBowl.getNumberOfSpecators() + ";");
                    // hashmap.put(key, hashmap.get(key) + 1);
                    teamMap.put(superBowl.getWinner(), teamMap.get(superBowl.getWinner()) + 1);
                    teamMap.put(superBowl.getLoser(), teamMap.get(superBowl.getLoser()) + 1);
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

