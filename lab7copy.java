import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab7copy {
    public static void main(String[] args) throws FileNotFoundException {
        // read file into line array sentence by sentence
        String in_path = "./bin/the_great_gatsby.txt";
        File infile = new File(in_path);
        if (!infile.exists()) {
            System.out.println("File " + in_path + " does not exist.");
            System.exit(1);
        }
        String read_lines = readFile(infile);
        // TODO: create function to return qoutes

        // southiealyze by entry in array
        String processed_lines = southiealyze(read_lines);

        // write to file
        String outfile_path = String.format(removeSuffix(infile.getPath(), ".txt") + "_processed.txt");
        File outfile = new File(outfile_path);
        try {
            if (outfile.createNewFile()) {
                FileWriter writer = new FileWriter(outfile.getPath());
                writer.write(processed_lines);
            } else {
                System.out.println("File already exists. Printing result instead.\n");
                System.out.println(processed_lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(File path) throws FileNotFoundException {
        Scanner reader = new Scanner(path);
        StringBuilder sb = new StringBuilder();
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            sb.append(line + "\n");
        }
        reader.close();
        return sb.toString();
    }

    public static String southiealyze(String s) {
        // very is replaced with wicked
        Pattern very = Pattern.compile("very", Pattern.CASE_INSENSITIVE);
        Matcher verym = very.matcher(s);
        while (verym.find()) {
            s = verym.replaceAll("wicked");
        }

        // r after a vowel not in a word boundary is replaced with h
        Pattern rAfterVowelAtEnd = Pattern.compile("[a,e,i,o,u]r[a-z]", Pattern.CASE_INSENSITIVE);
        Matcher rAfterVowelAtEndm = rAfterVowelAtEnd.matcher(s);
        while (rAfterVowelAtEndm.find()) {
            int beginning = rAfterVowelAtEndm.start();
            char[] array = s.toCharArray();
            array[beginning + 1] = 'h';
            s = new String(array);
        }

        // eer at the end of a word is replcaed with eeyah
        Pattern rAfterEE = Pattern.compile("e{2}r\\b", Pattern.CASE_INSENSITIVE);
        Matcher rAfterEEm = rAfterEE.matcher(s);
        while (rAfterEEm.find()) {
            int end = rAfterEEm.end();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i == end - 1) {
                    sb.append("yah");
                }
                else {
                    sb.append(s.charAt(i));
                }
            }
            s = sb.toString();
        }

        // ir at the end of a word is replaced with iyah
        Pattern rAfterI = Pattern.compile("ir\\b", Pattern.CASE_INSENSITIVE);
        Matcher rAfterIm = rAfterI.matcher(s);
        while (rAfterIm.find()) {
            int end = rAfterIm.end();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i == end - 1) {
                    sb.append("yah");
                }
                else {
                    sb.append(s.charAt(i));
                }
            }
            s = sb.toString();
        }

        // oor at the end of a word is replaced with oowah
        Pattern rAfterOO = Pattern.compile("o{2}r\\b", Pattern.CASE_INSENSITIVE);
        Matcher rAfterOOm = rAfterOO.matcher(s);
        while (rAfterOOm.find()) {
            int end = rAfterOOm.end();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i == end - 1) {
                    sb.append("wah");
                }
                else {
                    sb.append(s.charAt(i));
                }
            }
            s = sb.toString();
        }

        // if theres an vowel r pattern left replace it with vowel h
        Pattern rAfterVowel = Pattern.compile("[a,e,i,o,u]r", Pattern.CASE_INSENSITIVE);
        Matcher rAfterVowelm = rAfterVowel.matcher(s);
        while (rAfterVowelm.find()) {
            int beginning = rAfterVowelm.start();
            char[] array = s.toCharArray();
            array[beginning + 1] = 'h';
            s = new String(array);
        }

        // a at the end of a word is replaced with ar
        Pattern endsInA = Pattern.compile("[a-z]a\\b", Pattern.CASE_INSENSITIVE);
        Matcher endsInAm = endsInA.matcher(s);
        while (endsInAm.find()) {
            int begin = endsInAm.start();
            int end = endsInAm.end();
            s = endsInAm.replaceAll(s.substring(begin, end - 1) + "ar");
        }

        return s;
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {return true;}
        else {return false;}
    }

    public static boolean isPunct(char c) {
        if (c == '\'' || c == ',' || c == '.' || c == ';' || c == ':' || c == '!' || c == '?') {return true;}
        else {return false;}
    }

    public static String removeSuffix(String s, String suf) {
        if (s != null && s.endsWith(suf)) {
            return s.split(suf)[0];
        }
        return s;
    }
}

