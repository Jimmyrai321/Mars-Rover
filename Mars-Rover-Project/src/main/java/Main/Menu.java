package Main;

import InputParser.MenuParser;

public class Menu {


    public static void main(String[] args) {
        boolean exit = false;
        int menuOption;
        MenuParser menuParser = new MenuParser();
        MoveRover moveRover = new MoveRover();



        while (!exit){
            System.out.println(Colour.menu+"    __  ___                   ____                          ______            __             __\n" +
                     "   /  |/  /___ ___________   / __ \\____ _   _____  _____   / ____/___  ____  / /__________  / /\n" +
                    "  / /|_/ / __ `/ ___/ ___/  / /_/ / __ \\ | / / _ \\/ ___/  / /   / __ \\/ __ \\/ __/ ___/ __ \\/ / \n" +
                    " / /  / / /_/ / /  (__  )  / _, _/ /_/ / |/ /  __/ /     / /___/ /_/ / / / / /_/ /  / /_/ / /  \n" +
                    "/_/  /_/\\__,_/_/  /____/  /_/ |_|\\____/|___/\\___/_/      \\____/\\____/_/ /_/\\__/_/   \\____/_/   \n" +
                    "                                                                                               "+Colour.RESET);
            System.out.println(Colour.message+"Welcome to Mars Rover Control."+Colour.RESET);
            System.out.println(Colour.options+"--------------------MENU--------------------");
            System.out.println("Please select one of the following options: ");
            System.out.println("1. Move rover");
            System.out.println("2. Pick up samples");
            System.out.println("3. See inventory");
            System.out.println("4. Exit"+Colour.RESET);

            menuOption = menuParser.validateOption();
            switch (menuOption){
                case (1) -> {
                    moveRover.movingRoverToSpace();
                }
                case(2) -> {

                }
                case (3) ->{

                }
                case (4) -> {
                    exit = true;
                    System.out.println(Colour.message+"Exiting Program ...."+Colour.RESET);
                }

            }
        }
    }


}
