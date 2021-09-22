import java.util.Scanner;

public class BattleshipGame {
    Scanner in = new Scanner(System.in);

    private Player player;
    private String[] shipNames = {"USS Montana", "HMS Unicorn", "HMS Belfast", "USS Midway", "USS Hornet"};
    private Grid grid = new Grid(shipNames);
    private int getWeapon(){
        //System.out.println("------------------------------------------------");
        System.out.println("Please choose which weapon you want to use.");
        for (int i = 0; i < player.weapons.size(); i++) {
            String weapon = String.format("%1$d) %2$s (%3$d left) (Does %4$d damage)", i, player.weapons.get(i).getWeaponName(), player.weapons.get(i).getWeaponStorage(), player.weapons.get(i).getWeaponDamage());
            System.out.println(weapon);
        }
        return in.nextInt();
    }
    private void BattleshipLoop() throws Exception {
        int mainShipsLeft = 0;
        for (int i = 0; i < grid.shipSquares.size(); i++) {
            if (grid.shipSquares.get(i).isDestroyed() == false) {
                mainShipsLeft = mainShipsLeft + 1;
            } else {
                continue;
            }
        }
        if (mainShipsLeft == 0) {
            System.out.println("------------------------------------------------");
            System.out.println("You have won! \nDo you want to play again? Y/N");
            String tof = in.nextLine();
            if(tof == "Y"){

            }else{
                System.out.println("Bye!");
            }


        }else if(this.player.weapons.size() == 0){
            System.out.println("------------------------------------------------");
            System.out.println("You have lost! You ran out of weapons. \nDo you want to play again? Y/N");
            String tof = in.nextLine();
            if(tof == "Y"){

            }else{
                System.out.println("Bye!");
            }
        }else{
        Targeter targeter = new Targeter(this.grid);
        System.out.println("------------------------------------------------");
        grid.displayGrid();
        System.out.println("------------------------------------------------");

        for (int i = 0; i < this.player.weapons.size(); i++) {
            System.out.println("You have ".concat(String.valueOf(this.player.weapons.get(i).getWeaponStorage())).concat(" ").concat(this.player.weapons.get(i).getWeaponName()).concat(" left."));
        }
        int shipsLeft = 0;
        for (int i = 0; i < grid.shipSquares.size(); i++) {
            if (grid.shipSquares.get(i).isDestroyed() == false) {
                shipsLeft = shipsLeft + 1;
            } else {
                continue;
            }
        }
        System.out.println(String.format("There are %1$d ships left.", shipsLeft));
        System.out.println("------------------------------------------------");
        System.out.println("Please choose coordinates:");
        String coords = in.nextLine();
        //System.out.println(coords.getClass());
        //System.out.println(coords.getBytes());
        TargetRes tr = new TargetRes();

        try {
            tr = targeter.Target(coords.charAt(0), coords.charAt(1));
        } catch (Exception ex) {
            coords = in.nextLine();
            tr = targeter.Target(coords.charAt(0), coords.charAt(1));

        }
        if (tr.res == true) {
            System.out.println("------------------------------------------------");
            int weaponInt;
            if (tr.isHit == true) {
                System.out.println(String.format("You have already hit the ship, %1$s. It is not destroyed so you can still hit it. It has %2$s HP left.", tr.shipName, tr.hp));
                System.out.println("------------------------------------------------");

            } else {
                System.out.println("You may fire on that square");
                System.out.println("------------------------------------------------");

            }
            weaponInt = getWeapon();
            targeter.Fire(this.player.weapons.get(weaponInt));

            if (this.player.weapons.get(weaponInt).getWeaponStorage() > 0) {
                this.player.weapons.get(weaponInt).removeWeapon();
            }
            if (this.player.weapons.get(weaponInt).getWeaponStorage() == 0) {
                this.player.weapons.remove(weaponInt);
            }
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("Unable to fire on ship because, A: You have already missed this square, B: Ship is destroyed, or C: Selection is out of bounds. ");
        }
        BattleshipLoop();
    }
    }
    public BattleshipGame(Player player) throws Exception {
        this.player = player;
        System.out.println("Hey there ".concat(player.getPlayerName()).concat("!"));
        System.out.println("Once again welcome to Battleship!");
        System.out.println("In this game, to win you need destroy all the ships. \nThese ships have HP and you will have to use weapons to destroy them. \nFor you to lose you must use all your weapons. \nOn the grid a 'M' means a miss, a 'D' means a ship that has been destroyed, a value less than or equal to 10 means a ship that has been hit and the value is the hp left \nand an 'O' is square that has not been hit.");
        BattleshipLoop();
    }
}
