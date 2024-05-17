import Main.*;
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
           assertEquals(8,p.getPlateau().length);
           assertEquals(2,p.getPlateau()[0][0]);
           assertEquals(2,p.getPlateau()[6][0]);
           assertEquals(0,p.getPlateau()[5][5]);

            Plateau p2 = new Plateau(7,2);
            System.out.println(Arrays.deepToString(p2.getPlateau()));
            assertEquals(10,p2.getPlateau().length);
            assertEquals(2,p2.getPlateau()[0][0]);
            assertEquals(2,p2.getPlateau()[6][0]);
            assertEquals(0,p2.getPlateau()[5][1]);
        });
    }

    @Test
    void checkBoundary() {
        // MAKE SURE VALIDATE ROVER DROP is commented out BEFORE STARTING THIS UNIT TEST
        Plateau p = new Plateau(5,5);
        Rover rover = new Rover();
        assertAll(()->{
            rover.setXY(0,0);
            rover.setFacing(CompassDirection.N);
            rover.rotate(Instruction.R);
            rover.rotate(Instruction.M);
            assertTrue(p.checkBoundary(rover));

            rover.setXY(1,2);
            rover.setFacing(CompassDirection.S);
            rover.rotate(Instruction.R);
            rover.rotate(Instruction.M);
            assertTrue(p.checkBoundary(rover));

            rover.setXY(5,5);
            rover.setFacing(CompassDirection.W);
            rover.rotate(Instruction.M);
            assertTrue(p.checkBoundary(rover));

            rover.setXY(3,3);
            rover.setFacing(CompassDirection.S);
            rover.rotate(Instruction.R);
            rover.rotate(Instruction.M);
            rover.rotate(Instruction.M);
            assertTrue(p.checkBoundary(rover));
            //false - hitting boundary
            rover.setXY(0,0);
            rover.setFacing(CompassDirection.N);
            rover.rotate(Instruction.L);
            rover.rotate(Instruction.M);
            assertFalse(p.checkBoundary(rover));

            rover.setXY(5,0);
            rover.setFacing(CompassDirection.N);
            rover.rotate(Instruction.M);
            assertFalse(p.checkBoundary(rover));

            rover.setXY(5,3);
            rover.setFacing(CompassDirection.S);
            rover.rotate(Instruction.L);
            rover.rotate(Instruction.M);
            assertFalse(p.checkBoundary(rover));

        });
    }
}