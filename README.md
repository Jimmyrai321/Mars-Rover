<img width="820" height="312" alt="1" src="https://github.com/user-attachments/assets/dc01b787-8094-46f7-a140-9cb05e526c6e" />

## Project Brief
A Mars rover has been dropped on to Mars on a square/rectanglar plateau which is split into a grid with a (x,y) coordinate system. A terminal program helps to navigate the rover on this plateau which can be any size between 1-9 by 1-9. Commands and instructions are printed to the console. The rover position is represented by an (x,y) coordinate and a directional heading (N, E, S, W). For example a position of (0, 0, N) suggest the rover is in the top left corner of the plateau facing North. 

## Movement
Pressing `1` on the menu allows you to move the rover. The rover accepts a string of instructions with 3 characters:
- M - move rover 1 grid point in the direction it's facing
- L - rotate rover 90° anti-clockwise
- R - rotate rover 90° clockwise

### Example Input
A plateau is created with input `5 5`. 
Rover's starting position is inputted `0 0 N`.

Rover's starting position is `(0 0 N)`.
The string RMM will move the rover's position to `(2 0 E)`.

Rover's position is `(2 0 E)`.
The string LLM will move the rover's position to `(1 0 W)`

## Installation
1. Install [Java](https://www.java.com/en/download/manual.jsp) (recommended version 21.0).
2. Install a [Java IDE](https://www.jetbrains.com/idea/download) (e.g IntelliJ Community Edition).
3. Clone this repository and open project.
4. Naviagte to  `src/main/java/main/Menu`.
5. Press `run`

Application runs in IDE terminal.

## Future considerations
- [x] Add movement to the rover.
- [x] Handle collisions of rover against plateau.
- [ ] Allow sample collection from plateau position.
- [ ] Inventory display.
- [ ] Add obstacles.

