import Main.Plateau;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {


    @DisplayName("Testing initial Main.Plateau")
    @Test
    void initialisePlateauTest() {
        // Testing boundaries when initialising plateau
        Plateau p = new Plateau(5,5);
        System.out.println(Arrays.deepToString(p.getPlateau()));
        assertAll(()->{
           assertEquals(7,p.getPlateau().length);
           assertEquals(2,p.getPlateau()[0][0]);
           assertEquals(2,p.getPlateau()[6][0]);
           assertEquals(0,p.getPlateau()[5][5]);

            Plateau p2 = new Plateau(7,2);
            System.out.println(Arrays.deepToString(p2.getPlateau()));
            assertEquals(9,p2.getPlateau().length);
            assertEquals(2,p2.getPlateau()[0][0]);
            assertEquals(2,p2.getPlateau()[6][0]);
            assertEquals(0,p2.getPlateau()[5][1]);
        });
    }

    @Test
    void checkBoundary() {
        assertAll(()->{

        });
    }
}