public class Targeter {
    private Grid grid;
    public char targetLetter;
    public char targetNumber;
    private boolean canFire = false;
    private boolean hasShip = false;
    private boolean isHit = false;
    private Battleship ship;
    public Targeter(Grid grid){
        this.grid = grid;
    }
    public void Fire(Weapon weapon) throws Exception {
        if(this.hasShip == true){
            for (int i = 0; i < grid.shipSquares.size(); i++) {
                if(grid.shipSquares.get(i).getNumber() == this.targetNumber && grid.shipSquares.get(i).getLetter() == this.targetLetter){
                    grid.shipSquares.get(i).setHit(true);
                    int newHP = grid.shipSquares.get(i).getShip().getHp() - weapon.getWeaponDamage();
                    if(newHP > 0){
                        grid.shipSquares.get(i).getShip().setHp(newHP);
                        break;
                    }else{
                        grid.shipSquares.get(i).setHit(false);
                        grid.shipSquares.get(i).setDestroyed(true);
                    }
                }
            }
        }
    }
    public TargetRes Target(char letter, char number){
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
        if(letterNumber > grid.getSize()){
            return new TargetRes();
        }else if(num > grid.getSize()){
            return new TargetRes();
        }else{
            boolean missed = false;
            for (int i = 0; i < grid.missedSquares.size(); i++) {
                if(grid.missedSquares.get(i).charAt(0) == letter && grid.missedSquares.get(i).charAt(1) == number){
                    missed = true;
                    break;
                }
            }
            if(missed == true){
                return new TargetRes();
            }else{
                boolean hasShip = false;
                boolean isHit = false;
                boolean destroyed = false;
                for (int i = 0; i < grid.shipSquares.size(); i++) {
                    if(grid.shipSquares.get(i).getLetter() == letter && grid.shipSquares.get(i).getNumber() == number){
                        if(grid.shipSquares.get(i).isHit() == true){
                            hasShip = true;
                            isHit = true;
                            this.ship = grid.shipSquares.get(i).getShip();
                            break;
                        }else if(grid.shipSquares.get(i).isDestroyed() == true){
                            return new TargetRes();
                        }
                        else{
                            hasShip = true;
                            break;
                        }
                    }
                }
                if(hasShip == true){
                    if(isHit == true){
                        this.targetLetter = letter;
                        this.targetNumber = number;
                        this.canFire = true;
                        this.hasShip = true;
                        this.isHit = true;
                        return new TargetRes(true, this.ship.getHp(), this.ship.getShipName());
                    }else{
                        this.targetLetter = letter;
                        this.targetNumber = number;
                        this.canFire = true;
                        this.hasShip = true;
                        return new TargetRes(false);
                    }

                }else{
                    this.targetNumber = number;
                    this.targetLetter = letter;
                    this.canFire = true;
                    return new TargetRes(false);
                }
            }
        }
    }
}
