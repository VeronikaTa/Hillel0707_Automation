package Homework.lesson26.PageObject;

import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkWithHashMap {

    public static HashMap<String,String> makeAHashMap(List<WebElement> titles, List<WebElement> prices){
        if(titles.size() == 0 || prices.size() == 0){
            throw new IllegalArgumentException();
        }
        if(titles.size() != prices.size()){
            throw new IllegalArgumentException();
        }

        int length = titles.size();
        HashMap<String, String> titlesAndPrices = new HashMap<>();
        for(int i = 0 ; i < length; i++){
            titlesAndPrices.put(titles.get(i).getAttribute("innerText").replace("\u00A0"," ").trim(),prices.get(i).getAttribute("innerHTML").replace("&nbsp;"," ").trim());
        }

        return titlesAndPrices;
    }

    public static void writeToFile(HashMap<String,String> titlesAndPrices){
        try {
            FileWriter writer = new FileWriter("titlesAndPricesTwo.txt");
            int i = 1;
            for(Map.Entry<String,String> entry : titlesAndPrices.entrySet()){
                writer.write(i+".");
                writer.write(entry.getKey()+"-" + entry.getValue());
                writer.write("\n");
                i++;
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
