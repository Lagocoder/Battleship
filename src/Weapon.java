public class Weapon {
    private String weaponName;
    private int weaponDamage;
    private int weaponStorage;
    public Weapon(String name, int damage, int storage){
        this.weaponDamage = damage;
        this.weaponStorage = storage;
        this.weaponName = name;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public int getWeaponStorage() {
        return weaponStorage;
    }

    public String getWeaponName() {
        return weaponName;
    }
}
