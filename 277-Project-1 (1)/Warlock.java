public class Warlock extends EnemyDecorator implements Magical{
  //Gets the name and max HP for the warlock enemy
  public Warlock(Enemy e){
    super(e, e.getName(), (e.getMaxHP() + 1));
  }

 /*Selects which attack is inflicted
  *@param e attacked character
  *@return magicMissile, fireball,thunderclap
 */
  @Override
  public String attack(Entity e){
    int randAttack = (int)((Math.random() * 4) + 1);
    if(randAttack == 1){
      int physdamage = (int)((Math.random() *2) + 1);
      e.takeDamage(physdamage);
      return getName() + " attacks " + e.getName() + " with a spell for " + physdamage + " damage.";
    }else if(randAttack == 2){
      return magicMissile(e);
    }else if(randAttack == 3){
      return fireball(e);
    }else if(randAttack == 4){
      return thunderclap(e);
    }
    return "not working";
  }

  /*Adds Warlock to the name
  *@return It prints out the name
  */
  @Override
  public String getName(){
    return "WarLock " + super.getName();
  }

  /* Gives the Entity a random amount of damage between 2 - 0
   * @param e The Entity that the magical enemy is attacking
   * @return It prints out how the Entity got attacked and how much damage it took.
   */
  @Override
  public String magicMissile(Entity e){
    int damage = (int)(Math.random() * 2);
    e.takeDamage(damage);
    return getName() + " shoots " + e.getName() + " with Magic Missel for " + damage + " damage.";
  }

  /* Gives the Entity a random amount of damage between 3 - 1
   * @param e The Entity that the magical enemy is attacking
   * @return It prints out how the Entity got attacked and how much damage it took.
   */
  @Override
  public String fireball(Entity e){
    int damage = (int)((Math.random() * 3) + 1);
    e.takeDamage(damage);
    return getName() + " hits " + e.getName() + " with Fireball for " + damage + " damage.";
  }

  /* Gives the Entity a random amount of damage between 3 - 0
   * @param e The Entity that the magical enemy is attacking
   * @return It prints out how the Entity got attacked and how much damage it took.
   */
  @Override
  public String thunderclap(Entity e){
    int damage = (int)(Math.random() * 3);
    e.takeDamage(damage);
    return getName() + " zaps " + e.getName() + " with Thunderclap for " + damage + " damage.";
  }
}