import Main.CompassDirection;
import Main.Instruction;
import Main.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    Rover rover = new Rover();

    @Test
    void getInitialRoverPosition() {
        assertAll(()->{
            assertEquals(1,rover.getX());
            assertEquals(1,rover.getY());
            assertEquals(CompassDirection.N,rover.getFacing());
        });
    }


    @Test
    void setRoverPosition() {
        assertAll(()->{
            rover.setXY(2,1);
            rover.setFacing(CompassDirection.E);
            assertEquals(2,rover.getX());
            assertEquals(1,rover.getY());
            assertEquals(CompassDirection.E,rover.getFacing());

            rover.setXY(5,5);
            rover.setFacing(CompassDirection.S);
            assertEquals(5,rover.getX());
            assertEquals(5,rover.getY());
            assertEquals(CompassDirection.S,rover.getFacing());

            rover.setXY(2,3);
            rover.setFacing(CompassDirection.W);
            assertEquals(2,rover.getX());
            assertEquals(3,rover.getY());
            assertEquals(CompassDirection.W,rover.getFacing());
        });


    }


    @Test
    void rotate() {
        assertAll(()-> {
            rover.rotate(Instruction.L);
            assertEquals(CompassDirection.E, rover.getFacing());// starting at N rotate once left

            rover.rotate(Instruction.L);
            assertEquals(CompassDirection.S, rover.getFacing());// starting at E rotate once left

            rover.rotate(Instruction.R);
            assertEquals(CompassDirection.E, rover.getFacing());// starting at S rotate once right

            rover.rotate(Instruction.L);
            assertEquals(CompassDirection.S, rover.getFacing());// starting at E rotate once left

            rover.rotate(Instruction.M);
            assertEquals(CompassDirection.S, rover.getFacing());// should remain unchanged


        });


    }

    @Test
    void move(){

        assertAll(()-> {
            rover.move(CompassDirection.N);
            assertEquals(1, rover.getX());
            assertEquals(2, rover.getY());

            rover.move(CompassDirection.E);
            assertEquals(2, rover.getX());
            assertEquals(2, rover.getY());

            rover.move(CompassDirection.N);
            assertEquals(2, rover.getX());
            assertEquals(3, rover.getY());

            rover.move(CompassDirection.S);
            assertEquals(2, rover.getX());
            assertEquals(2, rover.getY());

            rover.move(CompassDirection.W);
            assertEquals(1, rover.getX());
            assertEquals(2, rover.getY());

        });

    }

}