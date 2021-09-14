import java.util.ArrayList;
import java.util.Scanner;
public class Player {
    private String playerName;
    public ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private int score = 0;
    void setPlayerName(String newPlayerName){
        this.playerName = newPlayerName;
    }
    void setScore(int newScore){
        this.score = newScore;
    }
    String getPlayerName(){
        return this.playerName;
    }
    int getScore(){
        return this.score;
    }
    void addToScore(int scoreToAdd){
        this.score = this.score + scoreToAdd;
    }
    void subtractFromScore(int numberToSubtract){
        this.score = this.score - numberToSubtract;
    }
    public Player(Weapon[] weapons){
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Battleship!");
        System.out.println("Please enter your name:");

        String s = in.nextLine();
        setPlayerName(s);
        for (int i = 0; i < weapons.length; i++) {
            this.weapons.add(new Weapon(weapons[i].getWeaponName(), weapons[i].getWeaponDamage(), weapons[i].getWeaponStorage()));
        }
    }

}
