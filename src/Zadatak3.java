import java.io.*;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        String originalFile = "";
        String destinationFile = "";
        String fileForDelete = "";
        boolean validInput = false;

        System.out.println("Ovaj Java program Vam omogućava kopiranje ili brisanje odabrane datoteke na Vašem računalu.\nZa kopiranje datoteke odaberite 1.\nZa brisanje datoteke odaberite 2.\nZa izlaz iz programa odaberite 3.\nUpišite Vaš odabir (1, 2 ili 3): ");
        userInput = br.readLine();
        if(userInput.equals("1") || userInput.equals("2") || userInput.equals("3")) validInput = true;

        while(!validInput){
            System.out.println("Neispravan unos odabira.\nZa kopiranje datoteke odaberite 1.\nZa brisanje datoteke odaberite 2.\nZa izlaz iz programa odaberite 3.\nUpišite Vaš odabir (1, 2 ili 3): ");
            userInput = br.readLine();
            if(userInput.equals("1") || userInput.equals("2") || userInput.equals("3")) validInput = true;
        }

      switch (userInput){
          case "1":
              validInput = false;
              try{
                  while(!validInput) {
                      System.out.println("Upišite apsolutnu putanju originalne datoteke koju želite kopirati: ");
                      originalFile = br.readLine();
                      File f = new File(originalFile);
                      if(!f.exists()){
                          System.err.println("Definirana originalna datoteka ne postoji!");
                          validInput = false;
                      } else{
                          if(!f.canRead()){
                              System.err.println("Definiranu originalnu datoteku nije moguće pročitati!");
                              validInput = true;
                          } else{
                              System.out.println("Upišite apsolutnu putanju destinacijske datoteke: ");
                              destinationFile = br.readLine();
                              File cF = new File(destinationFile);
                              if(cF.exists()){
                                  System.err.println("Definirana destinacijska datoteka već postoji. Kopiranje NIJE napravljeno!");
                                  validInput = true;
                              } else{
                                  if(cF.canWrite()) {
                                      cF.createNewFile();

                                      try (FileInputStream fis = new FileInputStream(f);
                                           FileOutputStream fos = new FileOutputStream(cF);) {
                                          int i;
                                          while ((i = fis.read()) != -1) {
                                              fos.write(i);
                                          }

                                          System.out.println("Kopiranje datoteke uspješno je napravljeno");
                                          validInput = true;
                                      }
                                  } else {
                                      System.err.println("Prava za pisanje ne postoje. Kopiranje NIJE napravljeno!");
                                      validInput = true;
                                  }
                              }

                          }
                      }
                  }
              } catch (Exception e){
                  System.err.println("Došlo je do greške prilikom kopiranja datoteke: " + e.getMessage());
              }
              break;
          case "2":
              validInput = false;
              try{
                  while(!validInput) {
                      System.out.println("Upišite apsolutnu putanju datoteke koju želite obrisati: ");
                      fileForDelete = br.readLine();
                      File f = new File(fileForDelete);
                      if(!f.exists()){
                          System.err.println("Definirana datoteka ne postoji!");
                      } else {
                          if (f.delete()) {
                              System.out.println("Datoteka je uspješno obrisana!");
                          } else {
                              System.err.println("Brisanje datoteke nije bilo uspješno!");
                          }
                      }
                      validInput = true;
                  }
              } catch (Exception e){
                System.err.println("Došlo je do greške prilikom brisanja datoteke: " + e.getMessage());
              }
              break;
          case "3":
              System.out.println("Odabrali ste izlaz iz programa. Pozdrav!");
              break;
          default:
            System.err.println("Došlo je do nepredviđene greške!");
      }
    }
}
