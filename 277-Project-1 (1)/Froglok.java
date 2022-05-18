public class Froglok extends Enemy{
  /*
  *sets the froglok initial hp at 3
  */
  public Froglok(){
    super("Froglok", 3);
  }
/* Gives the Entity a random amount of damage
 * @param e The Entity that the enemy is attacking
 * @return It prints out how the Entity got attacked and how much damage it took.
 */
  @Override
  public String attack(Entity e){
    int damage = (int)(Math.random() * 3) + 1;
    e.takeDamage(damage);
    return super.getName() + " attacks " + e.getName() + " for " + damage + " damage.";
  }
}