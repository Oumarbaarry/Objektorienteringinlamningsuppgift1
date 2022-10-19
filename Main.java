package Inlämning2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;



public class Main {
    public static void main(String[] args) throws IOException{
      //Här gör jag variablar

        String firstLine = "";
        String secondLine = "";
        String[] list;
        String kundtext = "src/Inlämning2/Kunder.txt";

/*Här skapar jag en Bufferedreader och inut i den sätter jag in en Filereader där jag läser in min kundtext
  Sedan använder jag en While loop så att programmet läser igenom textfilen tills den kmr till null
 */

        try {
            BufferedReader file = new BufferedReader(new FileReader(kundtext));
            while ((firstLine = file.readLine()) != null) {
                secondLine += firstLine + "\n";
            }

 /* Här delar jag strängen med hjälp utav split när det blir en ny rad, gör dessutom så att alla udda tal i listan
 blir datum och det jämna talen blir namn och personnummer.

Skapar en string där användaren får en fråga om att skriva namn elr personnummer
 Sedan kallar jag på min metod hittaMedlem för att kunna hitta platsen i listan som användaren har eller inte.
 Gjort minus 1 om personen inte finns med
  */
            list = secondLine.split("\n");
            String svar = JOptionPane.showInputDialog("Skriv ett namn eller personnummer: ");
            int kundPos = hittaMedlem(svar, list);
            if (kundPos != -1) {



/* Använder mig av LocaleDate för att kunna räkna ut alla som betalt inom ett år tillbaka genom att få ut dagens datum
och göra minus ett år sedan parsar jag in dom, och sedan får jag även ut dom som varit medlemar tidigare
och dom som inte varit medlemmar alls
*/

                LocalDate today = LocalDate.now();
                LocalDate ettÅrTillbaka = today.minusYears(1);
                LocalDate senasteBetalning = LocalDate.parse(list[kundPos + 1]);

                if (senasteBetalning.isBefore(ettÅrTillbaka) || senasteBetalning.equals(ettÅrTillbaka)) {
                    JOptionPane.showMessageDialog(null, list[kundPos] + " har varit medlem tidigare");
                } else {
                    String[] nuvarandeMedlem = list[kundPos].split(", ");
                    loggaIN(nuvarandeMedlem[0], nuvarandeMedlem[1], "pTränare.txt");
                    JOptionPane.showMessageDialog(null, list[kundPos] + " är medlem");
                }
                }else {
                    JOptionPane.showMessageDialog(null, "Har aldrig varit medlem");
                }
            }catch (IOException e){
            System.out.println("Felmeddelande");
        }
    }
     /* Skapar en metod hittaMedlem som ska ränka ut plats i listan,
    Jag gör en for loop där jag lägger alla som är medlemmar inut "i" så när programmet kör igenom listan så går det igenom
    så länge medlemen contains "i"
     */

    private static int hittaMedlem(String member, String[] list) {
        for (int i = 0; i < list.length; i++) {
            if (i % 2 == 0) {
                String[] nuvarandeMedlem = list[i].split(", ");
                if (nuvarandeMedlem[0].equals(member.trim()) || nuvarandeMedlem[1].equalsIgnoreCase(member.trim())) {

                    return i;
                }
            }
        }

        return -1;
    }
    private static void loggaIN(String pNummer,String namn,String text) throws IOException{

        String line;
        String inneBörd = "";
        BufferedReader dt = new BufferedReader(new FileReader(text));

        while ((line=dt.readLine()) != null){
            inneBörd += line + "\n";
        }

        try (PrintWriter ström = new PrintWriter(new BufferedWriter(new FileWriter(text)));){
            File secondFil = new File(text);
            String kundData = pNummer + " " + namn + " " + LocalDate.now();
            inneBörd += kundData+ "\n";
            ström.append(inneBörd);

        }
    }
}

