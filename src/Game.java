import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws Exception {
        //String abcs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] shipNames = {"USS Montana", "HMS Unicorn", "HMS Belfast", "USS Midway", "USS Hornet"};
        Weapon[] weapons = new Weapon[3];
        weapons[0] = new Weapon("HE Shells", 3, 4);
        weapons[1] = new Weapon("AP Shells", 1, 9);
        weapons[2] = new Weapon("Nuke Shells", 5, 2);

        //System.out.println("_______________________________");
        //System.out.println("|  O  O  O  O  O  O  O  O  O  |");
        //System.out.println("|  O  O  O  O  O  O  O  O  O  |");
        //System.out.println("|  O  O  O  O  O  O  O  O  O  |");
        //System.out.println("|  O  O  O  O  O  O  O  O  O  |");
        //System.out.println("|  O  O  O  O  O  O  O  O  O  |");
        //System.out.println("|  O  O  H  O  O  X  O  O  O  |");
        //System.out.println("|  O  O  O  O  O  O  O  O  O  |");
        //System.out.println("|  O  O  O  O  O  O  O  O  O  |");
        //System.out.println("|  O  O  O  O  O  O  O  O  O  |");
        //System.out.println("_______________________________");
        //System.out.println(InetAddress.getLocalHost().getHostName());
       Player player = new Player(weapons);

       final BattleshipGame game = new BattleshipGame(player);
    }
}
