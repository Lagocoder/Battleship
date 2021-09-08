public class Game {
    public static void main(String[] args) throws Exception {
        //String abcs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] shipNames = {"USS Montana", "HMS Unicorn", "HMS Belfast", "USS Midway", "USS Hornet"};

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
        Grid test = new Grid(shipNames);
        test.displayGrid();
        //Player player = new Player();
        //final BattleshipGame game = new BattleshipGame(player);
    }
}
