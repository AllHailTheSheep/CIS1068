package lab11;

import java.util.Arrays;

public class Applicant {
    // 0: last_name, 1: first_name, 2: phone, 3: email, 4: address, 5: postalZip, 6: region, 7: languages,
    // 8: GPA, 9: major, 10: university
    private String firstName, lastName, phone, email, address, zip, region, major, university;
    private double gpa;
    private String[] languages;

    public Applicant(String A) {
        // this will match commas not in quotes
        String[] columns = A.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        this.lastName = columns[0];
        this.firstName = columns[1];
        this.phone = columns[2];
        this.email = columns[3];
        this.address = columns[4];
        this.zip = columns[5];
        this.region = columns[6];
        this.languages = columns[7].split(" ");
        this.gpa = Double.parseDouble(columns[8]);
        this.major = columns[9];
        this.university = columns[10];
    }

    public double getScore() {
        double part1 = getGPA() * 25/2;
        double part2 = 0;
        for (String lang : getLanguages()) {
            if (lang.equals("Java") && part2 != 50.0) {
                part2 = 50.0;
            } else if (part2 != 50.0) {
                part2 += 25/4;
            }
        }
        return part1 + part2;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public String getRegion() {
        return region;
    }

    public String[] getLanguages() {
        return languages;
    }

    public double getGPA() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    public String getUniversity() {
        return university;
    }

    public String toString() {
        return String.format("%s, %s: score = %f\n\tGPA: %f\n\tLanguages: %s\n\tPhone: %s\n\tEmail: %s", getLastName(), getFirstName(),
                            getScore(), getGPA(), Arrays.toString(getLanguages()), getPhone(), getEmail());
    }
}