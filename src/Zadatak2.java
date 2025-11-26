import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Zadatak2 {
    public static void main(String[] args) {
        File inFile = new File("novaDatoteka.txt");
        File outFile = new File("novaDatoteka2.txt");

        try(FileInputStream fis = new FileInputStream (inFile);
            FileOutputStream fos = new FileOutputStream (outFile)){
            int podatak;
            while ((podatak = fis.read()) != -1){
                fos.write(podatak);
            }

            if (outFile.exists()){
                System.out.println("Datoteka "+ outFile.getName() + " je uspješno napravljena!");
            }

            fis.close();
            fos.close();

            if (inFile.exists()){
                if(inFile.delete()){
                    System.out.println("Datoteka "+ inFile.getName() + " je uspješno obrisana!");
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
