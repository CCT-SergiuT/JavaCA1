package ca1;
//import java library for file reading, writing, excemptions etc.
import java.io.*;


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
            //BufferedWriter bwriter = new BufferedWriter(new FileWriter(outFilePath));
            
            //create var line to get data from each line
            String line;
            
            //using while loop to read all the lines in the file until the line is empty/no data
            while((line = breader.readLine()) != null){
                //1st line contain the Name and Surname, create variable and split in 2 variables
                String[] names = line.split(" ");
                String name = names[0];
                String surname = names[1];
                
                //read and assign purcase value to variable
                line = breader.readLine();
                double purchVal = Double.parseDouble(line);
                
                //read and assign customer class to variable
                line = breader.readLine();
                int custClass = Integer.parseInt(line);
                
                //read and assign purchase year to variable
                line = breader.readLine();
                int purchYear = Integer.parseInt(line);
                
                //System.out.println(name + " " + surname + "\n" + purchVal + "\n" + custClass + "\n" + purchYear);
                
                
            }
        }catch(IOException error){
            error.printStackTrace();
        }
    }
    
}
