public class Target {
    private Grid grid;
    public char targetLetter;
    public char targetNumber;
    public Target(Grid grid){
        this.grid = grid;
    }
    public boolean Target(char letter, char number){
        Grid grid = this.grid;
        int letterNumber;
        int num = Character.getNumericValue(number) - 1;
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
        if(letterNumber < grid.getSize()){
            return false;
        }else if(num < grid.getSize()){
            return false;
        }else{
            boolean missed = false;
            for (int i = 0; i < grid.missedSquares.size(); i++) {
                if(grid.missedSquares.get(i).charAt(0) == letter && grid.missedSquares.get(i).charAt(1) == number){
                    missed = true;
                    break;
                }
            }
            if(missed == true){
                return false;
            }else{
                boolean hasShip = false;
                for (int i = 0; i < grid.shipSquares.size(); i++) {
                    if(grid.shipSquares.get(i).getLetter() == letter && grid.shipSquares.get(i).getNumber() == number){
                        hasShip = true;
                        break;
                    }
                }
                if(hasShip == true){
                    this.targetLetter = letter;
                    this.targetNumber = number;
                    return true;
                }else{
                    this.targetNumber = number;
                    this.targetLetter = letter;
                    return true;
                }
            }
        }
    }
}
