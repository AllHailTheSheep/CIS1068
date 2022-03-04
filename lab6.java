import java.util.List;
import java.util.Random;
import java.util.Scanner;

import bin.utils;

public class lab6 {
    static class LoopControl {

        private int rounds, player_wins, cpu_wins;
        private char instruction;

        public LoopControl() {
            this.rounds = 0;
            this.player_wins = 0;
            this.cpu_wins = 0;
            this.instruction = 'h';
        }

        public LoopControl(int r, int pw, int cw, char c) {
            this.rounds = r;
            this.player_wins = pw;
            this.cpu_wins = cw;
            this.instruction = c;

        }

        public int getRounds() {
            return this.rounds;
        }

        public int getPlayerWins() {
            return this.player_wins;
        }

        public int getCPUWins() {
            return this.cpu_wins;
        }

        public char getInstruction() {
            return this.instruction;
        }

        public void addRound() {
            this.rounds++;
        }

        public void addPlayerWin() {
            this.player_wins++;
        }

        public void addCPUWin() {
            this.cpu_wins++;
        }

        public void getNewInstruction(Scanner in) {
            StringBuilder sb = new StringBuilder();
            sb.append("Would you like to play another round?\n");
            sb.append("Enter y for yes, n for no, h for help, r to reset the scoreboard, or s to display the score: ");
            String loop_control_string =  utils.get_input(sb.toString(), in);
            char instruction_char = loop_control_string.charAt(0);
            if (instruction_char == 'y' || instruction_char == 'n' || instruction_char == 'h'
                || instruction_char == 's' || instruction_char == 'r') {
                this.instruction = instruction_char;            
            } else {
                System.out.println("Invalid instruction, please try again.");
                getNewInstruction(in);
            }
        }

        public void printSummary() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Rounds played: %d\n", this.rounds));
            sb.append(String.format("Player Wins: %d\n", this.player_wins));
            sb.append(String.format("CPU Wins: %d\n", this.cpu_wins));
            sb.append(String.format("Your win percentage: %d%%\n",
                                    (int)(100 * ((double)this.player_wins / (double)this.rounds))));
            System.out.println(sb.toString());
        }

        public void reset() {
            this.rounds = 0;
            this.player_wins = 0;
            this.cpu_wins = 0;
        }
    }

    public static void main(String[] args) {

        LoopControl l = new LoopControl();
        while (true) {
            l = runLoop(l);
        }

    }

    public static LoopControl runLoop(LoopControl lc) {
        Scanner in = new Scanner(System.in);
        if (lc.getInstruction() == 'n') { 
            lc.printSummary();
            System.out.println("Thanks for playing!");
            in.close();
            System.exit(0);
        }

        if (lc.getInstruction() == 'h') {printRules();}
        if (lc.getInstruction() == 's') {lc.printSummary();}
        if (lc.getInstruction() == 'r') {lc.reset();}

        char user_move = getMoveFromUser(in);

        char cpu_move = pickCPUMove();
        System.out.format("You picked %s and the computer picked %s.\n",
                                utils.capitalize(getStringFromChar(user_move)),
                                utils.capitalize(getStringFromChar(cpu_move)));

            
        if (compareMoves(user_move, cpu_move)) {
            System.out.format("You won, as you picked %s, which beats the computer's %s.\n",
                                utils.capitalize(getStringFromChar(user_move)),
                                utils.capitalize(getStringFromChar(cpu_move)));
            lc.addPlayerWin();
        } else {
            System.out.format("You lost, as the computer picked %s, which beats your %s.\n",
                                utils.capitalize(getStringFromChar(cpu_move)),
                                utils.capitalize(getStringFromChar(user_move)));
            lc.addCPUWin();
        }
        lc.addRound();
        System.out.println("");
        lc.getNewInstruction(in);
        System.out.println("");
        return lc;
    }


    public static char getMoveFromUser(Scanner in) {
        String raw_user_input = utils.get_input("Pick your move: ", in);
        char user_move = raw_user_input.toLowerCase().charAt(0);
        if (validateMove(user_move)) {
            return user_move;
        } else {
            System.out.println("Invalid move, please try again.");
            getMoveFromUser(in);
        }
        // unreachable code but makes the linter happy
        return 's';
    }

    public static boolean compareMoves(char user_move , char cpu_move) {
        // returns true if player wins and false if cpu wins
        if (user_move == cpu_move) {return false;}
        switch (user_move) {
            case 's':
                return (cpu_move == 'h' || cpu_move == 'k' ? true : false);
            case 't':
                return (cpu_move == 'p' || cpu_move == 's' ? true : false);
            case 'k':
                return (cpu_move == 't' || cpu_move == 'h' ? true : false); 
            case 'h':
                return (cpu_move == 'p' || cpu_move == 't' ? true : false);
            case 'p': 
                return (cpu_move == 'k' || cpu_move == 's' ? true : false);
        }
        // unreachable code but makes the linter happy
        return false;
    }

    public static char pickCPUMove() {
        List<Character> char_inputs = List.of('s', 't', 'k', 'h', 'p');
        Random rand = new Random();
        int index = rand.nextInt(char_inputs.size());
        return char_inputs.get(index);
        
    }

    public static String getStringFromChar(char c) {
        List<Character> char_inputs = List.of('s', 't', 'k', 'h', 'p');
        List<String> acceptable_inputs = List.of("skadis", "tjusig", "klyket", "hovolm", "pershult");
        int index = char_inputs.indexOf(c);
        return acceptable_inputs.get(index);
    }

    public static boolean validateMove(char c) {
        if (c == 's' || c == 't' || c == 'k' || c == 'h' || c == 'p') {
            return true;
        } else {
            return false;
        }
    }

    public static void printRules() {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to Uppf\u00F6ra, an ancient Norweigian game.\n\n");
        sb.append("You will pick your move from the following list: ");
        sb.append("Skadis, Tjusig, Klyket, Hovolm, or Pershult,\nby entering the ");
        sb.append("first letter of the move when prompted.\n");
        sb.append("\tPershult beats Klyket and Skadis,\n");
        sb.append("\tKlyket beats Tjusig and Hovolm,\n");
        sb.append("\tTjusig beats Pershult and Skadis,\n");
        sb.append("\tSkadis beats Hovolm and Klyket,\n");
        sb.append("\tHovolm beats Pershult and Tjusig.\n\n");
        sb.append("The computer will pick its move randomly and wins in the even of a tie.\n");
        sb.append("Note that you only have to enter the first letter of your move.\n");
        System.out.println(sb.toString());
    }
}