package Main;

public class Rover extends Position{


    public void rotate(Instruction instruction){
        if (instruction == Instruction.L){
            switch(getFacing()){
                case CompassDirection.N ->{
                    setFacing(CompassDirection.W);
                }
                case CompassDirection.E ->{
                    setFacing(CompassDirection.N);
                }
                case CompassDirection.S ->{
                    setFacing(CompassDirection.E);
                }
                case CompassDirection.W->{
                    setFacing(CompassDirection.S);
                }
            }
            System.out.println(Colour.success+"**Rotating left successful**"+Colour.RESET);
        }else if (instruction == Instruction.R){
            switch(getFacing()) {
                case CompassDirection.N -> {
                    setFacing(CompassDirection.E);
                }
                case CompassDirection.E -> {
                    setFacing(CompassDirection.S);
                }
                case CompassDirection.S -> {
                    setFacing(CompassDirection.W);
                }
                case CompassDirection.W -> {
                    setFacing(CompassDirection.N);
                }
            }
            System.out.println(Colour.success+"**Rotating right successful**"+Colour.RESET);

        }
    }

    public void move(CompassDirection compassDirection){
        switch(compassDirection) {
            case CompassDirection.N -> {
                setXY(getX(),getY()-1);
            }
            case CompassDirection.E -> {
                setXY(getX()+1,getY());
            }
            case CompassDirection.S -> {
                setXY(getX(),getY()+1);
            }
            case CompassDirection.W -> {
                setXY(getX()-1,getY());
            }
        }
        System.out.println(Colour.success+"**Successfully moved one space "+ compassDirection+"**"+Colour.RESET);
    }

}
