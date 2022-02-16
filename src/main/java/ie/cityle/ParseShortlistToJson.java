package ie.cityle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.*;

public class ParseShortlistToJson {

    public static void main(String[] args) throws Exception
    {
        CSVReader reader = new CSVReader(new FileReader("data.csv"));

        String output = "data.json";

        //Read CSV line by line and use the string array as you want
        List<Map<String,String>> dataList = new ArrayList<>();
        String[] nextLine;
        String[] fieldNames = reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            //Verifying the read data here
            System.out.println(Arrays.toString(nextLine));
            Map<String, String> values = new HashMap<>();
            for (int i = 0; i < fieldNames.length; i++) {
                values.put(fieldNames[i], nextLine[i]);
            }
            dataList.add(values);
        }
        try {
            ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(Paths.get(output).toFile(), dataList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
