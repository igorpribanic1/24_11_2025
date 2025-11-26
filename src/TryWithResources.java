import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TryWithResources {
    public static void main(String[] args) {
        File ulazniFile = new File("dokument.txt");
        File zapis = new File("kopija.txt");

        // Resursi koji su otvoreni u try bloku (try with resources) će se automatski zatvoriti nakon završetka try bloka
        // To je moguće raditi samo s resursima koji imaju implementirano AutoClosable interface
        try (FileReader ulaz = new FileReader(ulazniFile);
             FileWriter izlaz = new FileWriter(zapis);) {

            int c = 0;
            while ((c = ulaz.read()) != -1) {
                izlaz.write(c);
            }
        } catch (Exception e) {
           System.err.println(e);
        }
    }
}
