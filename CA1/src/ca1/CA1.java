//link to GitHub repo
//https://giyhub.com/CCT-SergiuT/JavaCA1.git
package ca1;
//import java library for file reading, writing, excemptions etc.
import java.io.*;
import java.time.LocalDate;


public class CA1 {

    public static void main(String[] args) {
        
        //assign to variable file path
        String filePath = "src\\ca1\\customers.txt";
        //assign to variable output file path
        String outFilePath = "src\\ca1\\cust_discount.txt";
        
        //using try and catch for error handling
        try{
            //reading data from the customer txt
            BufferedReader breader = new BufferedReader(new FileReader(filePath));
            //create variable to write data to the cust_discount txt
            BufferedWriter bwriter = new BufferedWriter(new FileWriter(outFilePath));
            
            //create var line to get data from each line
            String line;
            
            //using while loop to read all the lines in the file until the line is empty/no data
            while((line = breader.readLine()) != null){
                //1st line contain the Name and Surname, create variable and split in 2 variables
                String[] names = line.split(" ");
                
                String name = names[0];
                String surname = names[1];
                
                //Check if the name contains just letters 
                if(!name.matches("[a-zA-Z]+")){
                    System.out.println("Invalid name: " + name);
                }
                
                //Check if the surname contains just letters and numbers
                if(!surname.matches("[a-zA-Z0-9]+")){
                    System.out.println("Invalid surname: " + surname);
                }
                
                //read and assign purcase value to variable and display if it's not double
                line = breader.readLine();
                double purchVal;
                    try{
                        purchVal = Double.parseDouble(line);
                    }catch(NumberFormatException error) {
                        System.out.println("Invalid purchase value: " + line);
                        continue;
                    }
                
                //read and assign customer class to variable and check if class is in between 1 and 3
                line = breader.readLine();
                int custClass;
                    try{
                        custClass = Integer.parseInt(line);
                    }catch(NumberFormatException error) {
                        System.out.println("Customer class wrong format: " + line);
                        continue;
                    }
                    if(custClass < 1 || custClass > 3) {
                        System.out.println("Invalid customer class: " + custClass);
                        
                    }
                
                //read and assign purchase year to variable and check if is a valid year
                line = breader.readLine();
                int purchYear;
                int currentYear = LocalDate.now().getYear();
                    try{
                        purchYear = Integer.parseInt(line);
                    }catch(NumberFormatException error) {
                        System.out.println("Invalid year: " + line);
                        continue;
                    }
                    if (purchYear < 2000 || purchYear > currentYear) {
                    System.out.println("Invalid purchase year: " + purchYear);
                    continue;
                    }
                
                //System.out.println(name + " " + surname + "\n" + purchVal + "\n" + custClass + "\n" + purchYear);
                
            //Create customer object
            Customers customers = new Customers(name, surname, purchVal, custClass, purchYear);
            
            //Create variable for calculated value after discount applied
            double finalValue = calcFinalValue(customers);
            
            System.out.println(customers.getName2() + " " + customers.getSurname2() + "\n" + finalValue + "\n");
            
            //Write data to the file
            bwriter.write(customers.getName2() + " " + customers.getSurname2() + "\n" + finalValue + "\n");
            bwriter.flush();
            }
        }catch(IOException error){
            error.printStackTrace();
        }
    }
    
    //Create class to calculate the discounts
    public static double calcFinalValue(Customers customer){
        //variable of current year
        int currentYear = LocalDate.now().getYear();
        //create variable to keep discount value
        double discount;
        //create variable to get purchase year
        int lastPurchaseYear = customer.getPurchYear2();
        //create variable to get customer class
        int customerClass = customer.getCustClass2();
        //create variable to get purchase value
        double totalPurchase = customer.getPurchVal2();
        
        // *** 2nd option: After monday class
        
        int yearClassKey;

        // Create a unique key for each case based on customerClass and purchaseYear
        if (lastPurchaseYear == currentYear) {
            // Case for purchase in current year
            yearClassKey = customerClass * 100 + 1; 
        }else if (lastPurchaseYear < currentYear && lastPurchaseYear >= (currentYear - 5)) {
            // Case for purchase within past 5 years
            yearClassKey = customerClass * 100 + 2; 
        }else if (lastPurchaseYear < (currentYear - 5)) {
            // Case for purchase more than 5 years ago
            yearClassKey = customerClass * 100 + 3; 
        }else {
            yearClassKey = 0;
        }

        switch (yearClassKey) {
            // customerClass 1, last purchase in current year
            case 101: 
                discount = 0.30;
                break;
            // customerClass 1, last purchase within past 5 years
            case 102: 
                discount = 0.20;
                break;
            // customerClass 1, no purchase in past 5 years
            case 103: 
                discount = 0.10;
                break;
            // customerClass 2, last purchase in current year
            case 201: 
                discount = 0.15;
                break;
            // customerClass 2, last purchase within past 5 years
            case 202: 
                discount = 0.13;
                break;
            // customerClass 2, no purchase in past 5 years
            case 203: 
                discount = 0.05;
                break;
            // customerClass 3, last purchase in current year
            case 301: 
                discount = 0.03;
                break;
            // Any other case (customerClass 3 with old purchase or other)
            default: 
                discount = 0.00;
                break;
            }
        
        
        // *** 1st option
        //using if loop to assign discount value based on conditions
        /*
        //1st criteria - customer calss is 1 and last purchase in 2024 => discount of 30%
        if(lastPurchaseYear == currentYear && customerClass == 1){
            discount = 0.30;
        //2nd criteria - customer calss is 1 and last purchase before 2024 => discount of 20%
        }else if (lastPurchaseYear < currentYear && lastPurchaseYear >= (currentYear - 5) && customerClass == 1){
            discount = 0.20;
        //3rd criteria - customer calss is 1 and last purchase in past 5 years => discount of 10%
        }else if (lastPurchaseYear < (currentYear - 5) && customerClass == 1){
            discount = 0.10;
        //4th criteria - customer calss is 2 and last purchase in 2024 => discount of 15%
        }else if (lastPurchaseYear == currentYear && customerClass == 2){
            discount = 0.15;
        //5th criteria - customer calss is 2 and last purchase before 2024 => discount of 13%
        }else if (lastPurchaseYear < currentYear && lastPurchaseYear >= (currentYear - 5) && customerClass == 2){
            discount = 0.13;
        //6th criteria - customer calss is 2 and no purchase in past 5 years => discount of 5%
        }else if (lastPurchaseYear < (currentYear - 5) && customerClass == 2){
            discount = 0.05;
        //7th criteria - customer calss is 3 and last purchase in 2024 => discount of 3%
        }else if (lastPurchaseYear == currentYear && customerClass == 3){
            discount = 0.03;
        //8th criteria - customer calss is 3 and last purchase before 2024 => no discount
        }else{
            discount = 0.00;
        }*/
        
        //Calculate final value
        //return totalPurchase - (totalPurchase * discount);
        return totalPurchase * (1 - discount);
    }
    
}