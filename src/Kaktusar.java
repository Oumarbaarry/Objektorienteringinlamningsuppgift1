public class Kaktusar extends växter{




    public Kaktusar(double längd, String name) {
        super(längd, name);
        typVäxt="Kaktus";
        typFöda="Mineralvatten";
    }

    public String antalföda(){
        return "Denna kaktus " +this.getName()+ " behöver 0.2 liter "+ typFöda+ " per dag";
    }
}
