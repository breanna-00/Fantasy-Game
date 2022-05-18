public class Warrior extends EnemyDecorator{
  //Gets the name and max HP for the warrior enemy
  public Warrior(Enemy e){
    super(e, e.getName(), (e.getMaxHP() + 2));
  }

/*Generates a random physical damage to be dealt by the warrior
 *@param e: Entity atacked by the warrior
 *@return It prints out how the Entity got attacked and how much damage it took.
 */
  @Override
  public String attack(Entity e){
    int physdamage = (int)(Math.random() * 3) + 1;
    e.takeDamage(physdamage);
    return getName() + " attacks " + e.getName() + " with long sword for " + physdamage + " damage.";
  }
  
/*Adds Warrior to the name
 *@return Name
 */
  @Override
  public String getName(){
    return "Warrior " + super.getName();
  }

}