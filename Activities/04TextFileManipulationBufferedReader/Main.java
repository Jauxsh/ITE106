import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src/main/java/JauxshFile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); //'br' acronym means BufferedReader

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}