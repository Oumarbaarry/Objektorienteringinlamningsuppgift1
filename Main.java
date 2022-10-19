package Inlämning2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;



public class Main {
    public static void main(String[] args) throws IOException{
      

        String firstLine = "";
        String secondLine = "";
        String[] list;
        String kundtext = "src/Inlämning2/Kunder.txt";


        try {
            BufferedReader file = new BufferedReader(new FileReader(kundtext));
            while ((firstLine = file.readLine()) != null) {
                secondLine += firstLine + "\n";
            }

 
            list = secondLine.split("\n");
            String svar = JOptionPane.showInputDialog("Skriv ett namn eller personnummer: ");
            int kundPos = hittaMedlem(svar, list);
            if (kundPos != -1) {




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

