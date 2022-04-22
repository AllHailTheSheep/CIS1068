package lab11;

public class Applicant {
    // 0: last_name, 1: first_name, 2: phone, 3: email, 4: address, 5: postalZip, 6: region, 7: languages,
    // 8: GPA, 9: major, 10: university
    private String firstName, lastName, phone, email, address, zip, region, major, university;
    private double gpa;
    private String[] languages;

    public Applicant(String A) {
        String[] columns = A.split("\\b,\\b");
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

}