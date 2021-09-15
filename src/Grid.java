import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Random;
public class Grid {
    private Random random = new Random();
    private String abcs = "ABCDEFGHI";
    private String nums = "123456789";
    private int size;
    public ArrayList<String> missedSquares = new ArrayList<String>();
    public ArrayList<GridSquare> shipSquares = new ArrayList<GridSquare>();
    public Grid(String[] shipNames) throws Exception {
        this.size = shipNames.length;
        for (int i = 0; i < shipNames.length; i++) {
            char letter = abcs.charAt(random.nextInt(shipNames.length));
            char number = nums.charAt(random.nextInt(shipNames.length));
            Battleship ship = new Battleship(shipNames[i], random.nextInt(shipNames.length)+1);
            GridSquare square = new GridSquare(letter, number, ship);
            shipSquares.add(square);
            System.out.print(letter);
            System.out.print(number);

        }
        shipSquares.get(0).setDestroyed(true);
    }
    void displayGrid(){
        String[][] gridLines = new String[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                gridLines[i][j] = "O";
            }
        }
        for (int i = 0; i < missedSquares.size(); i++) {
            int number = Character.getNumericValue(missedSquares.get(i).charAt(1))-1;
            char letter = missedSquares.get(i).charAt(0);
            int letterNumber;
            switch (Character.toString(letter)){
                case "A":
                    letterNumber = 0;
                    break;
                case "B":
                    letterNumber = 1;
                    break;
                case "C":
                    letterNumber = 2;
                    break;
                case "D":
                    letterNumber = 3;
                    break;
                case "E":
                    letterNumber = 4;
                    break;
                case "F":
                    letterNumber = 5;
                    break;
                case "G":
                    letterNumber = 6;
                    break;
                case "H":
                    letterNumber = 7;
                    break;
                case "I":
                    letterNumber = 8;
                    break;
                default: letterNumber = 0;
            }

            gridLines[letterNumber][number] = "M";
        }
        for (int k = 0; k < shipSquares.size(); k++) {
            if(shipSquares.get(k).isHit() == true){

                int letterNumber = 0;
                char letter;
                int number = Character.getNumericValue(shipSquares.get(k).getNumber())-1;
                letter = shipSquares.get(k).getLetter();
                System.out.println(letter);
                switch (Character.toString(letter)){
                    case "A":
                        letterNumber = 0;
                        break;
                    case "B":
                        letterNumber = 1;
                        break;
                    case "C":
                        letterNumber = 2;
                        break;
                    case "D":
                        letterNumber = 3;
                        break;
                    case "E":
                        letterNumber = 4;
                        break;
                    case "F":
                        letterNumber = 5;
                        break;
                    case "G":
                        letterNumber = 6;
                        break;
                    case "H":
                        letterNumber = 7;
                        break;
                    case "I":
                        letterNumber = 8;
                        break;
                    default: letterNumber = 0;
                }
                //System.out.println(letterNumber);
                //System.out.println(number);

                if(shipSquares.get(k).isDestroyed() == true){
                    gridLines[letterNumber][number] = "D";
                }else {
                    gridLines[letterNumber][number] = String.valueOf(shipSquares.get(k).getShip().getHp());
                }
            }else{
                continue;
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

    public int getSize() {
        return size;
    }
}