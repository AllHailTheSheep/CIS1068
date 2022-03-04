import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class lab7tests extends lab7 {
    @Test
    void testSouthielyzer() {
        assertEquals(southiealyze("I left my car keys by the harbor."), "I left my cah keys by the hahboh.");
        assertEquals(southiealyze("a tuna"), "a tunar");
        assertEquals(southiealyze("Cuba"), "Cubar");
        assertEquals(southiealyze("idea."), "idear.");
        assertEquals(southiealyze("very hard"), "wicked hahd");
        assertEquals(southiealyze("deer"), "deeyah");
        assertEquals(southiealyze("veneers"), "veneehs");
        assertEquals(southiealyze("door"), "doowah");
        assertEquals(southiealyze("doors"), "doohs");
    }
    
}