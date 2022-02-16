package ie.cityle;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;


public class ParseCSVLineByLine
{
   @SuppressWarnings("resource")
   public static void main(String[] args) throws Exception
   {
      CSVReader reader = new CSVReader(new FileReader("worldcities.csv"));

      String csv = "data.csv";
      CSVWriter writer = new CSVWriter(new FileWriter(csv));
      //Read CSV line by line and use the string array as you want
      String[] nextLine;
      int count = 0;
      while ((nextLine = reader.readNext()) != null) {
         if (count == 0 || nextLine.length > 12 && nextLine[12] != null && !nextLine[12].isEmpty()) {
            System.out.println(Arrays.toString(nextLine));
            writer.writeNext(nextLine);
         }
         count++;
      }

      //close the writer
      writer.close();
   }
}
