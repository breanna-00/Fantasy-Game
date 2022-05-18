public class Orc extends Enemy{
  //Sets the initial HP for the Orc
  public Orc(){
    super("Orc", 4);
  }
  /* Gives the Entity a random amount of damage
  * @param e The Entity that the enemy is attacking.
  * @return It prints out how the Entity got attacked and how much damage it took.
  */
  @Override
  public String attack(Entity e){
    int damage = (int)(Math.random() * 4);
    e.takeDamage(damage);
    return super.getName() + " attacks " + e.getName() + " for " + damage + " damage.";
  }
}