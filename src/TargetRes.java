public class TargetRes {
    public boolean isHit;
    public boolean res;
    public int hp;
    public String shipName;
    public TargetRes(){
        this.res = false;
    }
    public TargetRes(boolean res, int hp, String shipName){
        this.res = true;
        this.isHit = res;
        this.hp = hp;
        this.shipName = shipName;
    }
    public TargetRes(boolean res){
        this.res = true;
        this.isHit = res;
    }
}
