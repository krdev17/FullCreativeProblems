package p1;
public class Character {
    private CharacterType type;
    private int health;
    private int damage;
    public CharacterType getType() {
        return type;
    }
    public void setType(CharacterType type) {
        this.type = type;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    Character(CharacterType type, int health){
        this.type = type;
        this.health = health;
    }
    public void attacks(Character character, Integer damage) {
        character.setHealth(character.getHealth() - damage);
    }
    public boolean isDead() {
        return this.health <= 0;
    }
}