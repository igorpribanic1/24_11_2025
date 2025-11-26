import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PrimjerFileInputStream {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("novaDatoteka.txt");
            FileOutputStream fos = new FileOutputStream("novaDatoteka2.txt")){
            int podatak;
            while ((podatak = fis.read()) != -1){
                fos.write(podatak);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
