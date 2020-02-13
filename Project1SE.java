
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "/Users/mkyong/csv/country.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] member = line.split(cvsSplitBy);

                System.out.println("Country [number1= " + member[1] + " ,number2=" + member[2] + " ,number3=" + member[3] + " ,number4=" + member[4] + " ,number5=" + member[5] +"]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}