import java.util.Scanner;

public class BattleshipGame {
    Scanner in = new Scanner(System.in);

    private Player player;
    private String[] shipNames = {"USS Montana", "HMS Unicorn", "HMS Belfast", "USS Midway", "USS Hornet"};
    private Grid grid = new Grid(shipNames);

    public BattleshipGame(Player player) throws Exception {
        this.player = player;
        System.out.println("Hey there ".concat(player.getPlayerName()).concat("!"));
        System.out.println("Once again welcome to Battleship!");
        System.out.println("In this game, to win you need destroy all the ships. \nThese ships have HP and you will have to use weapons to destroy them. \nFor you to lose you must use all your weapons. \nOn the grid a 'M' means a miss, a value less than or equal to 10 means a ship that has been hit and the value is the hp left \nand an 'O' is square that has not been hit.");

    }
}
