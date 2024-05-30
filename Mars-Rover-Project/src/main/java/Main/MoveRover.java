package Main;

import InputParser.InstructionParser;

import java.util.List;
import java.util.Scanner;

public class MoveRover {
private Rover r1;
private InstructionParser IP;
public static Plateau plateau;
private List<Instruction> instructionSeq;


    public List<Instruction> getInstructionSeq() {
        return instructionSeq;
    }

    public Rover getR1() {
        return r1;
    }

    public MoveRover() {
        validatePlateauSize();
        r1 = new Rover();
        IP = new InstructionParser();


    }

    public void movingRoverToSpace(){
        System.out.println();
        System.out.println(Colour.message+"initial R1 position: X,Y=("+r1.getX()+", "+r1.getY()+") "+r1.getFacing() +Colour.RESET);
        System.out.println(Colour.options+"Please choose either to ROTATE or MOVE the rover R1 using the options below:");
        System.out.println("L: Rotate Left");
        System.out.println("R: Rotate Right");
        System.out.println("M: move ROVER one space"+Colour.RESET);
        instructionSeq = IP.validateOption();
        for (Instruction i : instructionSeq) {
            if (i == Instruction.R) {
                System.out.println(Colour.message+"**Rotating right...**"+Colour.RESET);
                r1.rotate(Instruction.R);
            } else if (i == Instruction.L) {
                System.out.println(Colour.message+"**Rotating left...**"+Colour.RESET);
                r1.rotate(Instruction.L);
            } else if (i == Instruction.M) {
                if (plateau.checkBoundary(r1)){
                    System.out.println(Colour.message+"**Moving ...**"+Colour.RESET);
                    r1.move(r1.getFacing());
                }else {
                    System.out.println(Colour.error+"[!] ERROR! Rover detected boundary cannot perform move."+Colour.RESET);
                }


            }
        }
        System.out.print("\n");
        System.out.println(Colour.success+"R1 position NOW: X,Y=("+r1.getX()+", "+r1.getY()+") "+r1.getFacing()+Colour.RESET);
    }

    public void validatePlateauSize(){

        Scanner scanner = new Scanner(System .in);
        String input;
        do{
            System.out.print(Colour.message+"Size of plateau [xSize] [ySize]: "+Colour.RESET);
            input= scanner.nextLine();
            if (input.matches("[1-9] [1-9]") && input.length() == 3){
                plateau = new Plateau(Integer.parseInt(String.valueOf(input.charAt(0))),Integer.parseInt(String.valueOf(input.charAt(2))));
                break;
            }else{
                System.out.println(Colour.error+"[!] Invalid input! Format should be in ([x size] [y size]) e.g. 5 5");
                System.out.println("[xSize] = 1-9 [ySize] = 1-9"+Colour.RESET);
               // System.out.print(Colour.message+"Size of plateau [xSize] [ySize]: "+Colo);
            }
        }while(true);

    }
}
