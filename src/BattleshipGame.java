import java.util.Scanner;

public class BattleshipGame {
    Scanner in = new Scanner(System.in);

    private Player player;
    private String[] shipNames = {"USS Montana", "HMS Unicorn", "HMS Belfast", "USS Midway", "USS Hornet"};
    private Grid grid = new Grid(shipNames);
    private int getWeapon(){
        System.out.println("------------------------------------------------");
        System.out.println("Please choose which weapon you want to use.");
        for (int i = 0; i < player.weapons.size(); i++) {
            String weapon = String.format("%1$d) %2$s (%3$d left) (Does %4$d damage)", i, player.weapons.get(i).getWeaponName(), player.weapons.get(i).getWeaponStorage(), player.weapons.get(i).getWeaponDamage());
            System.out.println(weapon);
        }
        return in.nextInt();
    }
    private void BattleshipLoop() throws Exception {
        Targeter targeter = new Targeter(this.grid);
        System.out.println("------------------------------------------------");
        for (int i = 0; i < this.player.weapons.size(); i++) {
            System.out.println("You have ".concat(String.valueOf(this.player.weapons.get(i).getWeaponStorage())).concat(" ").concat(this.player.weapons.get(i).getWeaponName()).concat(" left."));
        }
        System.out.println("------------------------------------------------");
        System.out.println("Please choose coordinates:");
        String coords = in.nextLine();
        TargetRes tr = targeter.Target(coords.charAt(0), coords.charAt(1));
        if(tr.res == true){
            if(tr.isHit == true){
                System.out.println("------------------------------------------------");
                System.out.println(String.format("You have already hit the ship, %1$s. It is not destroyed so you can still hit it. It has %2$s HP left.", tr.shipName, tr.hp));
                System.out.println(getWeapon());
            }
        }
    }
    public BattleshipGame(Player player) throws Exception {
        this.player = player;
        System.out.println("Hey there ".concat(player.getPlayerName()).concat("!"));
        System.out.println("Once again welcome to Battleship!");
        System.out.println("In this game, to win you need destroy all the ships. \nThese ships have HP and you will have to use weapons to destroy them. \nFor you to lose you must use all your weapons. \nOn the grid a 'M' means a miss, a value less than or equal to 10 means a ship that has been hit and the value is the hp left \nand an 'O' is square that has not been hit.");
        BattleshipLoop();
    }
}
