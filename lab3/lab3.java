package lab3;
/* 
* the  goal for this assignment is to print ascii pictures
* this program must include:
*   any character/integer constants must be made static final constants
*   3 nested loop (one doubly nested for loop)
*   a size variable that proportionaly increases the size of the art drawn
* extra credit for producing the linc (go birds!)
*/

/* 
* PROGRAMMERS NOTE:
* there are a lot of functions that could be written to optimize this and make it more readable.
* doing it purely with for loops like this is pretty awful practice both in terms of performance
* and readability (but a decent exercise). if you're trying to read this code, i suggest pulling
* up the original ascii art so you can follow through the loops. i would like to make it known
* that i truly believe this to be the worst code i have ever written in terms of readibility.
* sorry ¯\_(ツ)_/¯
*/

public class lab3 {
    /*
    * im going to define the sizes of the original ascii art here so scale can take effect later
    * the original ascii art as shown on the prompt has a scale of 4, so lengths will be divided by 4.
    */

    //character (and string) constants
    static final char SPACE = ' ';
    static final char UNDERSCORE = '_';
    static final char PIPE = '|';
    static final char PERIOD = '.';
    static final char BACKSLASH = '\\';
    static final char FORWARDSLASH = '/';
    static final char ASTERISK = '*';
    static final String NEWLINE = "\n";
    // parking lot size constants
    static final int PARKING_LOT_SPACER = 2;
    static final int PARKING_LOT_HEADER_LENGTH = 4;
    static final int PARKING_LOT_LINE_LENGTH = 2;
    static final int PARKING_LOT_ROWS = 4;
    // stadium size constants
    static final int STADIUM_HEADER_LENGTH = 8;
    static final int STADIUM_INTERIOR_SPACER_LENGTH = 4;
    static final int STADIUM_FIELD_ROWS = 2;
    static final int STADIUM_FIELD_SIZE = 2;

    // this is the only parameter that should be modified. the range *should* be able to scale any
    // positive integer but if it's longer then your teminal length you're gonna have a bad time
    // 16 is the max i would suggest going to.
    static final int SIZE = 4;
    public static void main(String[] args) {
        linc_driver();
    }

    public static void linc_driver() {
        print_parking_lot();
        print_field();
    }

    public static void print_parking_lot() {
        // this function prints the lot using solely for loops. stupid, yet oddly cathartic.
        StringBuilder sb = new StringBuilder();
        // add the spacer
        for (int i = 0; i < SIZE; i++) {
            for (int m = 0; m < PARKING_LOT_SPACER; m++) {
                sb.append(SPACE);
            }
        }
        // one space offset
        sb.append(SPACE);

        // add the underscores. note the extra one as the middle pipeline takes up a space
        for (int i = 0; i < SIZE; i++) {
            for (int m = 0; m < PARKING_LOT_HEADER_LENGTH; m++) {
                sb.append(UNDERSCORE);
            }
        }
        sb.append(UNDERSCORE);
        sb.append(NEWLINE);
        
        // now we print the rows
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < PARKING_LOT_ROWS; j++) {
                // add the spacer
                for (int k = 0; k < SIZE; k++) {
                    // oooh baby a triple nested for loop
                    for (int l = 0; l < PARKING_LOT_SPACER; l++) {
                        sb.append(SPACE);
                    }
                }
                // first "column" starts here
                sb.append(PIPE);
                for (int k = 0; k < SIZE; k++) {
                    for (int l = 0; l < PARKING_LOT_SPACER; l++) {
                        sb.append(UNDERSCORE);
                    }
                }
                // second "column" starts here
                sb.append(PIPE);
                for (int k = 0; k < SIZE; k++) {
                    for (int l = 0; l < PARKING_LOT_SPACER; l++) {
                        sb.append(UNDERSCORE);
                    }
                }
                // add a pipe and a newline at the end of each line
                sb.append(PIPE);
                sb.append(NEWLINE);
            }
        }
        // print the result
        System.out.println(sb.toString());
    }

    public static void print_field() {
        // this function prints the field
        StringBuilder sb = new StringBuilder();

        // construct the first line
        sb.append(SPACE);
        for (int i = 0; i < (SIZE * STADIUM_HEADER_LENGTH) + 2; i++) {
            sb.append(UNDERSCORE);
        }
        sb.append(NEWLINE);
        
        // construct the second line
        sb.append(PIPE);
        for (int i = 0; i < SIZE * STADIUM_INTERIOR_SPACER_LENGTH; i++) {
            sb.append(SPACE);
        }
        sb.append(UNDERSCORE);
        sb.append(UNDERSCORE);
        for (int i = 0; i < SIZE * STADIUM_INTERIOR_SPACER_LENGTH; i++) {
            sb.append(SPACE);
        }
        sb.append(PIPE);
        sb.append(NEWLINE);

        // now generate the buffer rows of the stadium (rows that have no field)
        int buffer_rows = SIZE;
        for (int i = 1; i < buffer_rows + 1; i++) {
            sb.append(PIPE);
            for (int j = 0; j < (SIZE * STADIUM_INTERIOR_SPACER_LENGTH) - (i * 2); j++) {
                sb.append(SPACE);
            }
            sb.append(UNDERSCORE);
            sb.append(FORWARDSLASH);
            for (int j = 0; j < (STADIUM_INTERIOR_SPACER_LENGTH * i) - 2; j++){
                sb.append(PERIOD);
            }
            sb.append(BACKSLASH);
            sb.append(UNDERSCORE);
            for (int j = 0; j < (SIZE * STADIUM_INTERIOR_SPACER_LENGTH) - (i * 2); j++) {
                sb.append(SPACE);
            }
            sb.append(PIPE);
            sb.append(NEWLINE);
        }

        // now generate the rows that have field
        for (int i = 1; i < SIZE + 1; i++) {
            sb.append(PIPE);
            for (int j = 0; j < (SIZE * STADIUM_INTERIOR_SPACER_LENGTH) - ((i + SIZE) * 2); j++) {
                sb.append(SPACE);
            }
            sb.append(UNDERSCORE);
            sb.append(FORWARDSLASH);

            for (int j = 0; j < 2 * i + (SIZE - 1); j++) {
                sb.append(PERIOD);
            }
            for (int j = 0; j < (SIZE * STADIUM_FIELD_SIZE); j++) {
                sb.append(ASTERISK);
            }
            for (int j = 0; j < 2 * i + (SIZE - 1); j++) {
                sb.append(PERIOD);
            }
            sb.append(BACKSLASH);
            sb.append(UNDERSCORE);
            for (int j = 0; j < (SIZE * STADIUM_INTERIOR_SPACER_LENGTH) - ((i + SIZE) * 2); j++) {
                sb.append(SPACE);
            }
            sb.append(PIPE);
            sb.append(NEWLINE);
        }

        // now generate the last part of field
        for (int i = 1; i < SIZE + 1; i++) {
            sb.append(PIPE);
            for (int j = 0; j < ((i * 2) - 1); j++) {
                sb.append(SPACE);
            }
            sb.append(BACKSLASH);
            sb.append(UNDERSCORE);
            for (int j = 0; j < Math.negateExact(SIZE) + (SIZE * 4) - (2 * i); j++) {
                sb.append(PERIOD);
            }
            for (int j = 0; j < (SIZE * STADIUM_FIELD_SIZE); j++) {
                sb.append(ASTERISK);
            }
            for (int j = 0; j < Math.negateExact(SIZE) + (SIZE * STADIUM_INTERIOR_SPACER_LENGTH) - (2 * i); j++) {
                sb.append(PERIOD);
            }
            sb.append(UNDERSCORE);
            sb.append(FORWARDSLASH);
            for (int j = 0; j < ((i * 2) - 1); j++) {
                sb.append(SPACE);
            }
            sb.append(PIPE);
            sb.append(NEWLINE);
        }

        // now we generate the last buffer rows
        for (int i = 1; i < buffer_rows + 1; i++) {
            sb.append(PIPE);
            for (int j = 0; j < ((i + SIZE) * 2) - 1; j++) {
                sb.append(SPACE);
            }
            sb.append(BACKSLASH);
            sb.append(UNDERSCORE);
            for (int j = 0; j < SIZE * STADIUM_INTERIOR_SPACER_LENGTH - (i * 4); j++) {
                sb.append(PERIOD);
            }
            sb.append(UNDERSCORE);
            sb.append(FORWARDSLASH);
            for (int j = 0; j < ((i + SIZE) * 2) - 1; j++) {
                sb.append(SPACE);
            }
            sb.append(PIPE);
            sb.append(NEWLINE);
        }

        // now constuct the last stadium line
        sb.append(PIPE);
        for (int i = 0; i < (SIZE * STADIUM_HEADER_LENGTH) + 2; i++) {
            sb.append(UNDERSCORE);
        }
        sb.append(PIPE);
        sb.append(NEWLINE);

        // print the entire stadium
        System.out.println(sb.toString());
    }
}
