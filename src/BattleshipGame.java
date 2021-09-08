import java.net.InetAddress;

public class BattleshipGame {
    private Player player;
    private String[] shipNames = {"USS Montana", "HMS Unicorn", "HMS Belfast", "USS Midway", "USS Hornet"};
    private Grid grid = new Grid(shipNames);

    public BattleshipGame(Player player) throws Exception {
        this.player = player;
        System.out.println("Hey there ".concat(player.getPlayerName()).concat("!"));
        System.out.println("Once again welcome to Java Battleship!");
        this.grid.displayGrid();
    }
}
