import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        

        växter palm = new Palmer(5,"Laura");
        växter palm2 = new Palmer(1,"Putte");
        växter kaktus = new Kaktusar(0.2,"Igge");
        växter köttätande = new Köttätandeväxter(0.7,"Meatloaf");


        ArrayList<växter>myVäxter=new ArrayList<>();
        myVäxter.add(palm);
        myVäxter.add(palm2);
        myVäxter.add(kaktus);
        myVäxter.add(köttätande);


        String[] växtArray = new String[5];
        for (int i =0; i<4;i++)
            växtArray[i]=myVäxter.get(i).getName();



        växtArray[4]= "Inget av dessa alternativ";



        String valAvVäxt = (String) JOptionPane.showInputDialog(null,
                "Välj vilken växt som ska få föda? ",
                "Näringstabell",
                JOptionPane.QUESTION_MESSAGE,
                null,växtArray,växtArray[0]);



        //Här sker polymorfismen
        for (växter växt:myVäxter)
            if (valAvVäxt.equalsIgnoreCase(växt.getName()))
                JOptionPane.showMessageDialog(null, växt.antalföda());



    }
}
