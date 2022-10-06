public class Köttätandeväxter extends växter{

    
    double tillskott = 0.2;
    double basnivå = 0.1;

    

    public Köttätandeväxter(double längd, String name) {
        super(längd, name);
        typVäxt ="Köttättandeväxter";
        typFöda = "Protein dryck";
    }
    
    public String antalföda(){
        return "Denna köttätande växt " +typVäxt + " behöver " + (basnivå+(tillskott*this.getLängd()))+ " Liter "+ typFöda+ " per dag";
    }
}
