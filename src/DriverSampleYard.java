import java.io.*;
import java.util.*;

public class DriverSampleYard {
    public static void main(String[] args) throws IOException {
        // read input from greenGrow.txt
        // all properties in input must appear on its own line
        BufferedReader r = new BufferedReader(new FileReader("greenGrow.txt"));

        ArrayList<Yard> yardList = new ArrayList<>(); // yard data of each customer
        int n = Integer.parseInt(r.readLine()); // num of customers
        // iterate through all customers
        while (n-- > 0) {
            // read attributes of the customer
            String lastName = r.readLine();
            String firstName = r.readLine();
            int size = Integer.parseInt(r.readLine());
            int numberTrees = Integer.parseInt(r.readLine());
            int gardenSize = Integer.parseInt(r.readLine());
            String doubleDriveway = r.readLine();

            // instantiate a yard depending on its size
            if (size<=10000) yardList.add(new CustomerLargeYard(lastName, firstName, size, numberTrees, gardenSize, doubleDriveway));
            else if (size<=20000) yardList.add(new CustomerMediumYard(lastName, firstName, size, numberTrees, gardenSize, doubleDriveway));
            else yardList.add(new CustomerLargeYard(lastName, firstName, size, numberTrees, gardenSize, doubleDriveway));
        }
        // sort customers based on last name (behavior defined in the compareTo method of Yard implementations)
        Collections.sort(yardList);

        // initiate the GUI
        new DisplaySampleYard(yardList);
    }
}