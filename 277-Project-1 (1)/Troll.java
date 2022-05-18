public class Troll extends Enemy{
  //Sets the initial Hp of the troll
  public Troll(){
    super("Troll", 5);
  }

  /* Gives the Entity a random amount of damage
  * @param e The Entity that the enemy is attacking.
  * @return String that it prints out how the Entity got attacked and how much damage it took.
  */
  @Override
  public String attack(Entity e){
    int damage = (int)(Math.random() * 5);
    e.takeDamage(damage);
    return super.getName() + " attacks " + e.getName() + " for " + damage + " damage.";
  }
}