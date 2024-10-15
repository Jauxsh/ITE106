import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File myFile = new File("JauxshFile.txt");
        FileReader fr = new FileReader(myFile); // 'fr' acronym means FileReader

        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }

        fr.close();
    }
}
