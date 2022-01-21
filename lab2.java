// the purpose of this program is to print the lyrics to Bought Me a Cat, a popular american folk
// song. I chose to construct the song, then pass it back through the functions up to the main
// songdriver.
import java.util.Arrays;
import java.util.Hashtable;

public class lab2 {
    public static void main(String[] args) {
        // print the song
        songdriver();
        // exit successfully
        System.exit(0);
    }

    public static String capitalize(String str) {
        // this function capitalizes the first character of a string using slicing
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static Hashtable<String, String> init_hashtable() {
        // why use a hashtable here? honestly don't know. I should have just use two lists of strings,
        // one containing the animal names and one containing the phrases, since i could have iterated
        // through the list easier. plus I'm creating a list of keys sperately so theres definitely not
        // much use.
        Hashtable<String, String> a = new Hashtable<String, String>();
        a.put("cat", "fiddle-i-fee");
        a.put("hen", "chimmy-chuck");
        a.put("duck", "quack");
        a.put("goose", "hissy");
        a.put("sheep", "baa");
        a.put("pig", "oink");
        return a;
    }

    public static String[] init_array() {
        // this initializes the array of keys
        String[] array = {"cat", "hen", "duck", "goose", "sheep", "pig"};
        return array;
    }

    public static String construct_verse_part1(String key) {
        // this constructs the first part of the verse, which is dependent on the last value of the keys array
        String result = String.format("Bought me a %s and the %s pleased me,\n" +
                "I fed my %s under yonder tree.\n", key, key, key).toString();
        return result;

    }

    public static String construct_verse_part2(String keys[], Hashtable<String, String> animals) {
        // this constructs the second part of the verse.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            String key = keys[keys.length - 1 - i];
            String value = animals.get(key);
            // note that the phrase for cat takes a different format then the rest
            if (key != "cat") {
                sb.append(String.format("%s goes %s, %s,\n", capitalize(key), value, value));
            } else if (key == "cat") {
                sb.append(String.format("%s goes %s.\n", capitalize(key), value));
            }
        }
        return sb.toString();
    }

    public static String construct_verse(String keys[], Hashtable<String, String> animals) {
        // this constructs the entire verse
        StringBuilder sb = new StringBuilder();
        sb.append(construct_verse_part1(keys[keys.length - 1]));
        sb.append(construct_verse_part2(keys, animals));
        return sb.toString();
    }

    public static void songdriver() {
        Hashtable<String, String> animals = init_hashtable();
        String[] keys = init_array();
        
        // since there are 6 keys, and the verses contain one more key per verse, we can just use a for
        // loop and pass them in as "instructions" of sorts.
        for (int i = 0; i < keys.length; i++) {
            // this is the only line of debugging code i needed. im pretty happy everything else
            // worked first try.
            // System.out.println(Arrays.toString(Arrays.copyOfRange(keys, 0, i + 1)));
            System.out.println(construct_verse(Arrays.copyOfRange(keys, 0, i + 1),  animals));
            // new line at the end of each verse
            System.out.println("");
        }
    }
}
