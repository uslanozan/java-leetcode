/*
2️⃣ Word Frequency in Large Text File (File Processing)
You have a .txt file and it has a large amount of text.
For example:

This is a simple text file.
It contains words and phrases.
Some words repeat, repeat and repeat.
✅ Task:

Read the file line by line.
Calculate how many times each word occurs. (Map<String, Integer>)
Find the 5 most frequent words and print them.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String filepath = "src/resources/paragraph.txt";
        readFromFile(filepath);
    }

    public static void readFromFile(String filePath){

        Map<String, Integer> countWords = new HashMap<>();

        try {
            File file = new File(filePath);
            Scanner myScanner = new Scanner(file);
            while(myScanner.hasNextLine()){
                String data = myScanner.next();

                if(countWords.containsKey(data)){
                    countWords.put(data, countWords.get(data) + 1);
                }else{
                    countWords.put(data, 1);
                }

                //System.out.println(data);
            }
            myScanner.close();

            // HashMap sıralama yapamaz
            // countWords.entrySet() → HashMap içindeki tüm (anahtar, değer) çiftlerini alır.
            List<Map.Entry<String, Integer>> list = new ArrayList<>(countWords.entrySet());

            /*
             ❓ Bu satır ne yapıyor?
                list.sort(...) → Listenin içindeki elemanları sıralar.
                (a, b) -> b.getValue().compareTo(a.getValue()) →
                Lambda fonksiyonudur.
                b.getValue() (önce ikinci elemanı alıyor) ile a.getValue() (ilk elemanı alıyor) karşılaştırılır.
                compareTo() fonksiyonu kullanılarak büyükten küçüğe sıralama yapılır.
             */
            list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Burada eğer list.size 5'den küçükse onu alacak. yani hangisi küçükse onu kullanacak
            for (int i = 0; i < Math.min(5, list.size()); i++) {
                System.out.println(list.get(i).getKey() + " = " + list.get(i).getValue());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
