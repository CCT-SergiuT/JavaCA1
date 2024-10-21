package ca1;

public class Customers {
    private String name;
    private String surname;
    private Double purchVal;
    private int custClass;
    private int purchYear;
    
    public Customers(String name, String surname, Double purchVal, int custClass,int purchYear){
        this.name = name;
        this.surname = surname;
        this.purchVal = purchVal;
        this.custClass = custClass;
        this.purchYear = purchYear;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public double getPurchVal(){
        return purchVal;
    }
    
    public int getCustClass(){
        return custClass;
    }
    
    public int getPurchYear(){
        return purchYear;
    }
}
