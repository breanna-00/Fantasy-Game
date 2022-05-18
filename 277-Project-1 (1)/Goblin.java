public class Goblin extends Enemy{
  /*
  *Sets goblin initial hp at 2
  */
  public Goblin(){
    super("Goblin", 2);
  }
/* Gives the Entity a random amount of damage between
 * @param e The Entity that the magical enemy is attacking
 * @return It prints out how the Entity got attacked and how much damage it took.
 */
  @Override
  public String attack(Entity e){
    int damage = (int)(Math.random() * 2) + 1;
    e.takeDamage(damage);
    return super.getName() + " attacks " + e.getName() + " for " + damage + " damage.";
  }
}