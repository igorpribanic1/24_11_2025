import java.io.*;

public class Zadatak1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Writer novaDat = new FileWriter("novaDatoteka.txt");
        PrintWriter zapis = new PrintWriter(novaDat);
        String korisnickiUnos = "";

        File ulazniFile = new File("novaDatoteka.txt");
        File izlazniFile = new File("kopijaDatoteke.txt");
        FileReader ulaz = new FileReader(ulazniFile);
        FileWriter izlaz = new FileWriter(izlazniFile);

        try{
            while(!korisnickiUnos.toUpperCase().equals("KRAJ")){
                System.out.println("Unesite željenu informaciju (za kraj unosa upišite KRAJ): ");
                korisnickiUnos = br.readLine();
                if(!korisnickiUnos.toUpperCase().equals("KRAJ")) zapis.println(korisnickiUnos);
            }

            novaDat.close();

            int c = 0;
            while ((c = ulaz.read()) != -1){
                izlaz.write(Character.toUpperCase(c));
            }

            ulaz.close();
            izlaz.close();

        }
        catch (Exception e){
            System.err.println("Greška: " + e.getMessage());
        } finally{
            novaDat.close();
            ulaz.close();
            izlaz.close();
        }
    }
}
