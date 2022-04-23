package lab11;

/**
* Q1: i chose to sort evenly by language prowess and gpa. out of a possible 100 points, 50 can be acheived for a 4.0 gpa,
* and 50 can be acheived for knowing java or 4 other languages.
* Q2: we miss several factors. if a candidate had a bad semester due to external factors, a program has no way of judging that.
* we also fail to account for language proficiency and instead take the candidates word for the lanuages they know. in short,
* there is no way a proram can accurately replace a human actually talking to the applicant.
**/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class lab11 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("lab11/applicant_data.csv"));

        ArrayList<Applicant> applicants = new ArrayList<Applicant>();

        in.nextLine();
        while (in.hasNextLine()) {
            applicants.add(new Applicant(in.nextLine()));
        }

        Collections.sort(applicants, new Comparator<Applicant>(){
            public int compare(Applicant a1, Applicant a2){
                return Double.compare(a2.getScore(), a1.getScore());
            }
        });

        for (int i = 0; i < 10; i++) {
            System.out.println(applicants.get(i).toString());
        }    
    }
}
