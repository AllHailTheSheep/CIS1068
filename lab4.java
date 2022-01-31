import java.util.Scanner;

// the purpose of this assignment is to create a grade calculator

public class lab4 {
    public static void main(String[] args) {
        System.out.println("All scores (exam and homework average) must be entered as doubles, i.e. 80 -> 80.00.");
        // we create our scanner here and pass it in to our input functions. if we created one inside the input
        // function we would have to close it in that function, which also closes our System.in stream.
        Scanner in = new Scanner(System.in);
        // collect weights
        int hw_weight = utils.get_int_input("Homework weight: ", in);
        int ex1_weight = utils.get_int_input("Exam 1 weight: ", in);
        int ex2_weight = 100 - (hw_weight + ex1_weight);
        System.out.println(String.format("Using weight %d for homework, %d for exam one, and %d for exam two.",
                            hw_weight, ex1_weight, ex2_weight));

        // get homework stats
        int hw_assignments = utils.get_int_input("Number of homework assignments: ", in);
        double hw_avg_score, hw_weighted_score;
        int hw_late_days, hw_labs_attended;
        // if negatgive numbers or zero is enterd in the homework assignmetns variable we give full credit
        if (hw_assignments <= 0) {
            hw_weighted_score = hw_weight;
        } else {
            // if the average score is less then zero, assign it zero, and if it's greater then 10 (max points
            // per assignment) we assign it to 10.
            hw_avg_score = utils.get_double_input("Average homework score: ", in);
            if (hw_avg_score < 0){
                hw_avg_score = 0;
            } else if (hw_avg_score > 10){
                hw_avg_score = 10;
            }
            hw_late_days = utils.get_int_input("Number of late days used: ", in);
            hw_labs_attended = utils.get_int_input("Number of labs attended: ", in);
            // if labs attended is less then zero, assign it to zero, and if it's greater then the max possible,
            // assign it to the max (hw_assignments) 
            if (hw_labs_attended < 0) {
                hw_labs_attended = 0;
            } else if (hw_labs_attended > hw_assignments) {
                hw_labs_attended = hw_assignments;
            }
            // calculate the hw score
            hw_weighted_score = calculate_homework(hw_weight, hw_assignments, hw_avg_score, hw_late_days, hw_labs_attended);
        }
        System.out.println(String.format("Weighted score: %.2f / %d", hw_weighted_score, hw_weight));

        System.out.println("Exam 1:");
        double ex1_score = utils.get_double_input("Score: ", in);
        // if score is less then zero we assign it to zero and if it's greater then 100 we assign it to 100
        if (ex1_score < 0) {
            ex1_score = 0;
        } else if (ex1_score > 100) {
            ex1_score = 100;
        }
        int ex1_curve = utils.get_int_input("Curve: ", in);
        // calculate the exam grade
        double ex1_weighted_score = calculate_exam(ex1_weight, ex1_score, ex1_curve);
        System.out.println(String.format("Weighted score: %.2f / %d", ex1_weighted_score, ex1_weight));

        System.out.println("Exam 2:");
        double ex2_score = utils.get_double_input("Score: ", in);
        // if score is less then zero we assign it to zero and if it's greater then 100 we assign it to 100
        if (ex2_score < 0) {
            ex2_score = 0;
        } else if (ex1_score > 100) {
            ex2_score = 100;
        }
        int ex2_curve = utils.get_int_input("Curve: ", in);
        // calculate the exam grade
        double ex2_weighted_score = calculate_exam(ex2_weight, ex2_score, ex2_curve);
        System.out.println(String.format("Weighted score: %.2f / %d", ex2_weighted_score, ex2_weight));

        // output final grade
        System.out.println(String.format("Course total: %.2f%%", hw_weighted_score + ex1_weighted_score + ex2_weighted_score));
    }


    public static double calculate_homework(int hw_weight, int hw_assignments, double hw_avg_score, int hw_late_days, int hw_labs_attended) {
        double hw_score = hw_assignments * hw_avg_score;
        if (hw_late_days > (hw_assignments / 2)) {
            hw_score -= (hw_avg_score * .10) * hw_late_days;
        } else if (hw_assignments == 0) {
            hw_score += 5;
        }
        double lab_score = 4 * hw_labs_attended;
        double total_possible_points = (hw_assignments * 10) + (hw_assignments * 4);
        double total_points_earned = hw_score + lab_score;
        double weighted_total = (hw_score + lab_score) * hw_weight / total_possible_points;
        if (weighted_total > total_possible_points) {
            weighted_total = total_possible_points;
        }
        System.out.println(String.format("Total points: %.2f / %.2f", total_points_earned, total_possible_points));
        return weighted_total;

        
    }
    
    public static double calculate_exam(int weight, double score, int curve) {
        double curved_score = score + curve;
        if (curved_score > 100) {
            curved_score = 100;
        }
        double weighted_total = (curved_score * weight) / 100;
        System.out.println(String.format("Total points: %.2f / 100", curved_score));
        return weighted_total;
    }
}





