public class Palmer extends växter{


    
    final double föda = 0.5;

    
    public Palmer(double längd, String name) {
        super(längd, name);
        typVäxt ="Palm";
        typFöda = "Kranvatten";
    }
    
    public String antalföda(){
        return "Denna palm "+ this.getName() + " behöver " +(this.getLängd()*föda)+ " liter "+ typFöda + " per dag";
    }

}


