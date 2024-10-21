package ca1;
//Create customer class
public class Customers {
    //Create private variables 
    private String name;
    private String surname;
    private Double purchVal;
    private int custClass;
    private int purchYear;
    
    //create customers method
    public Customers(String name2, String surname2, Double purchVal2, int custClass2, int purchYear2){
        this.name = name2;
        this.surname = surname2;
        this.purchVal = purchVal2;
        this.custClass = custClass2;
        this.purchYear = purchYear2;
    }
    //Retrieve private variable name value to public variable name2
    public String getName2(){
        return name;
    }
    //Retrieve private variable surname value to public variable Surname2
    public String getSurname2(){
        return surname;
    }
    //Retrieve private variable customer purchase value to public variable getPurchVal2
    public double getPurchVal2(){
        return purchVal;
    }
    //Retrieve private variable customer class value to public variable CustClass2
    public int getCustClass2(){
        return custClass;
    }
    //Retrieve private variable puchase year value to public variable PurchYear2
    public int getPurchYear2(){
        return purchYear;
    }
}
