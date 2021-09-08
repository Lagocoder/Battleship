public class GridSquare {
    private char letter;
    private char number;
    private boolean hit = false;
    private Battleship ship;
    public GridSquare(char letter, char number, Battleship ship){
        this.letter = letter;
        this.number = number;
        this.ship = ship;
    }
    char getLetter(){
        return this.letter;
    }

    void setHit(boolean hit) {
        this.hit = hit;
    }
    boolean isHit(){
        return this.hit;
    }

    char getNumber(){
        return this.number;
    }
    Battleship getShip(){
        return this.ship;
    }
    void log(){
        System.out.print(this.letter);
        System.out.print(this.number);
        System.out.print(this.ship.getShipName());
        System.out.println(this.ship.getHp());

    }
}
