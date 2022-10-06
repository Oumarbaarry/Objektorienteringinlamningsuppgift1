public abstract class växter implements VäxterInterface{

    //inkapsling
    
    private double längd;
    private String name;

    String typVäxt;

    String typFöda;


    
    public växter (double längd, String name){
        this.längd=längd;
        this.name=name;

        
    }
    public double getLängd(){
        return längd;
    }
    public String getName(){
        return name;
    }




    }

