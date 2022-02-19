import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class lab6tests extends lab6 {
    @Test
    void testGetStringFromChar() {
        assertEquals(lab6.getStringFromChar('s'), "skadis");
        assertEquals(lab6.getStringFromChar('t'), "tjusig");
        assertEquals(lab6.getStringFromChar('k'), "klyket");
        assertEquals(lab6.getStringFromChar('h'), "hovolm");
        assertEquals(lab6.getStringFromChar('p'), "pershult");
    }

    @Test
    void testValidateMove(){
        assertEquals(lab6.validateMove('s'), true);
        assertEquals(lab6.validateMove('t'), true);
        assertEquals(lab6.validateMove('k'), true);
        assertEquals(lab6.validateMove('h'), true);
        assertEquals(lab6.validateMove('p'), true);
        assertEquals(lab6.validateMove('a'), false);
        assertEquals(lab6.validateMove('l'), false);
        assertEquals(lab6.validateMove('r'), false);
        assertEquals(lab6.validateMove('y'), false);
        assertEquals(lab6.validateMove('n'), false);
    }

    @Test
    void testCompareMoves() {
        assertEquals(lab6.compareMoves('s', 's'), false);
        assertEquals(lab6.compareMoves('s', 't'), false);
        assertEquals(lab6.compareMoves('s', 'k'), true);
        assertEquals(lab6.compareMoves('s', 'h'), true);
        assertEquals(lab6.compareMoves('s', 'p'), false);

        assertEquals(lab6.compareMoves('t', 's'), true);
        assertEquals(lab6.compareMoves('t', 't'), false);
        assertEquals(lab6.compareMoves('t', 'k'), false);
        assertEquals(lab6.compareMoves('t', 'h'), false);
        assertEquals(lab6.compareMoves('t', 'p'), true);

        assertEquals(lab6.compareMoves('k', 's'), false);
        assertEquals(lab6.compareMoves('k', 't'), true);
        assertEquals(lab6.compareMoves('k', 'k'), false);
        assertEquals(lab6.compareMoves('k', 'h'), true);
        assertEquals(lab6.compareMoves('k', 'p'), false);

        assertEquals(lab6.compareMoves('h', 's'), false);
        assertEquals(lab6.compareMoves('h', 't'), true);
        assertEquals(lab6.compareMoves('h', 'k'), false);
        assertEquals(lab6.compareMoves('h', 'h'), false);
        assertEquals(lab6.compareMoves('h', 'p'), true);

        assertEquals(lab6.compareMoves('p', 's'), true);
        assertEquals(lab6.compareMoves('p', 't'), false);
        assertEquals(lab6.compareMoves('p', 'k'), true);
        assertEquals(lab6.compareMoves('p', 'h'), false);
        assertEquals(lab6.compareMoves('p', 'p'), false);
    }

    @Test
    void testCapitalize() {
        assertEquals(utils.capitalize("s"), "S");
        assertEquals(utils.capitalize("sausage"), "Sausage");
        assertEquals(utils.capitalize("13 and a half"), "13 and a half");
        assertEquals(utils.capitalize("i'M nOt ShOuTiNg!1!1!"), "I'M nOt ShOuTiNg!1!1!");
        assertEquals(utils.capitalize("No change needed."), "No change needed.");
    }

    @Test
    void testPickCPUMove() {
        int iterations = 10000000;
        @SuppressWarnings("unused")
        int s = 0, t = 0, k = 0, h = 0, p = 0;
        for (int i = 0; i < iterations; i++) {
            char c = lab6.pickCPUMove();
            switch (c) {
                case 's':
                    s++;
                    break;
                case 't':
                    t++;
                    break;
                case 'k':
                    k++;
                    break;
                case 'h':
                    h++;
                    break;
                case 'p':
                    p++;
                    break;
            }
        }
        int percentage = (int)(100 * ((double) s / (double)iterations));
        if (percentage > 22) {
            fail(String.format("percentage of s picked shouold be around 20%, instead it's %d%%\n", percentage));
        }
    }
    
}