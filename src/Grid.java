import java.util.ArrayList;
import java.util.Random;
public class Grid {
    private Random random = new Random();
    private String abcs = "ABCDEFGHI";
    private String nums = "123456789";
    private int size;
    ArrayList<String> missedSquares = new ArrayList<String>();
    ArrayList<GridSquare> shipSquares = new ArrayList<GridSquare>();
    public Grid(String[] shipNames) throws Exception {
        this.size = shipNames.length;
        for (int i = 0; i < shipNames.length; i++) {
            char letter = abcs.charAt(random.nextInt(shipNames.length));
            char number = nums.charAt(random.nextInt(shipNames.length));
            Battleship ship = new Battleship(shipNames[i], random.nextInt(shipNames.length)+1);
            GridSquare square = new GridSquare(letter, number, ship);
            shipSquares.add(square);
        }
    }
    void displayGrid(){
        String[][] gridLines = new String[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                gridLines[i][j] = "O";
            }
        }
        for (int i = 0; i < this.size; i++) {
            String row = "";
            for (int j = 0; j < this.size; j++) {
                row = row.concat("  ").concat(gridLines[i][j]);
            }
            System.out.println(row);
        }
    }

}