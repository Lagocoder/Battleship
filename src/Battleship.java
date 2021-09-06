public class Battleship {
    private String shipName;
    private int hp;
    void setShipName(String newShipName){
        this.shipName = newShipName;
    }
    void setHp(int newShipHP) throws Exception {
        if(newShipHP > 10){
            throw new Exception("newShipHP too high!");
        }else{
            this.hp = newShipHP;
        }
    }
    int getHp(){
        return this.hp;
    }
    String getShipName(){
        return  this.shipName;
    }
}
