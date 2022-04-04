package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab7 {
    public static void main(String[] args) throws FileNotFoundException {
        // read file into a single string
        String in_path = "./bin/the_great_gatsby.txt";
        File infile = new File(in_path);
        if (!infile.exists()) {
            System.out.println("File " + in_path + " does not exist.");
            System.exit(1);
        }
        String read_lines = readFile(infile);
        // replace these unicode characters with a regular qoute, as it's more used
        read_lines = read_lines.replaceAll("“", "\"").replaceAll("”", "\"");

        // now only run the southiealyzer on the qoutes
        long i = read_lines.indexOf("\"");
        long j = 0;
        StringBuilder processed_lines = new StringBuilder();
        while (i != -1 && j != -1) {
            // first copy the range out of the qoutes, then re assign j to the next qoute, and run the southiealyzer
            // on the substring between i and j. then reassign i and repeat, quitting when no next qoute is found
            // for some reason the whole thing wont be read when i and j are stored as ints, but it works with long,
            // even though the max value isn't exceeding 2147483647, and it's getting converted back to an int anyways,
            // so it really shouldnt matter
            processed_lines.append(read_lines.substring((int) j, (int) i));
            j = read_lines.indexOf("\"", (int) i + 1);
            processed_lines.append(southiealyze(read_lines.substring((int) i, (int) j)));
            i = read_lines.indexOf("\"", (int) j + 1);
        }
        // append the text after the last endqoute
        processed_lines.append(read_lines.substring((int) j, read_lines.length()));


        // write to file
        String outfile_path = String.format(removeSuffix(infile.getPath(), ".txt") + "_processed.txt");
        File outfile = new File(outfile_path);
        try {
            if (outfile.createNewFile()) {
                FileWriter writer = new FileWriter(outfile.getPath());
                writer.write(processed_lines.toString());
            } else {
                System.out.println("File already exists. Printing result instead.\n");
                System.out.println(processed_lines.toString());
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
        s = _very(s);
        // r after a vowel not in a word boundary is replaced with h
        s = _vowel_r_end(s);
        // eer at the end of a word is replcaed with eeyah
        s = _ee_r(s);
        // ir at the end of a word is replaced with iyah
        s = _i_r(s);
        // oor at the end of a word is replaced with oowah
        s = _oo_r(s);
        // if theres an vowel r pattern left replace it with vowel h
        s = _vowel_r(s);
        // a at the end of a word is replaced with ar
        s = _a_end(s);

        return s;
    }

    public static String _very(String s) {
        Pattern very = Pattern.compile("very", Pattern.CASE_INSENSITIVE);
        Matcher verym = very.matcher(s);
        while (verym.find()) {
            s = verym.replaceAll("wicked");
        }
        return s;

    }

    public static String _vowel_r_end(String s) {
        Pattern _vowel_r_end = Pattern.compile("[a,e,i,o,u]r[a-z]", Pattern.CASE_INSENSITIVE);
        Matcher _vowel_r_endm = _vowel_r_end.matcher(s);
        while (_vowel_r_endm.find()) {
            int beginning = _vowel_r_endm.start();
            char[] array = s.toCharArray();
            array[beginning + 1] = 'h';
            s = new String(array);
        }
        return s;
    }

    public static String _ee_r(String s) {
        Pattern _ee_r = Pattern.compile("e{2}r\\b", Pattern.CASE_INSENSITIVE);
        Matcher _ee_rm = _ee_r.matcher(s);
        while (_ee_rm.find()) {
            int end = _ee_rm.end();
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
        return s;
    }

    public static String _i_r(String s) {
        Pattern _i_r = Pattern.compile("ir\\b", Pattern.CASE_INSENSITIVE);
        Matcher _i_rm = _i_r.matcher(s);
        while (_i_rm.find()) {
            int end = _i_rm.end();
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
        return s;
    }

    public static String _oo_r(String s) {
        Pattern _oo_r = Pattern.compile("o{2}r\\b", Pattern.CASE_INSENSITIVE);
        Matcher _oo_rm = _oo_r.matcher(s);
        while (_oo_rm.find()) {
            int end = _oo_rm.end();
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
        return s;
    }

    public static String _vowel_r(String s) {
        Pattern rAfterVowel = Pattern.compile("[a,e,i,o,u]r", Pattern.CASE_INSENSITIVE);
        Matcher rAfterVowelm = rAfterVowel.matcher(s);
        while (rAfterVowelm.find()) {
            int beginning = rAfterVowelm.start();
            char[] array = s.toCharArray();
            array[beginning + 1] = 'h';
            s = new String(array);
        }
        return s;
    }

    public static String _a_end(String s) {
        Pattern endsInA = Pattern.compile("[a-z]a\\b", Pattern.CASE_INSENSITIVE);
        Matcher endsInAm = endsInA.matcher(s);
        while (endsInAm.find()) {
            int begin = endsInAm.start();
            int end = endsInAm.end();
            s = endsInAm.replaceAll(s.substring(begin, end - 1) + "ar");
        }
        return s;
    }

    public static String removeSuffix(String s, String suf) {
        if (s != null && s.endsWith(suf)) {
            return s.split(suf)[0];
        }
        return s;
    }
}