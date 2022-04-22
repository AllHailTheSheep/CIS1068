package lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class lab11 {
    public void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("applicant_data.csv"));

        ArrayList<Applicant> applicants = new ArrayList<Applicant>();

        while(in.hasNextLine()) {
            applicants.add(new Applicant(in.nextLine()));
        }
        
        
    
    }
}
