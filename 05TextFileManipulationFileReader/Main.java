import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        File myFile = new File("JauxshFile.txt");
        FileReader fr = new FileReader(myFile);
        
        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }

        fr.close();
    }
}
