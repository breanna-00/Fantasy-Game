public class Hero extends Entity implements Magical {
  /* hero level
  *   hero start location
  *   Map
  *   x coordinate
  *   y coordinate
  */
  private  Point loc;
  private int level;
  private int gold;
  private int key;
  /*
  * Constructs a Hero with a name,location,hp,level, and map 
  */
  public Hero(String n){
    super(n, 25);
    loc = new Point(0, 2);
    level = 1; 
    gold = 25;
    key = 0;
  }

  /*
  *   Heros method to increase level and load new *map
  */
  public void levelUp(){
    level += 1;
    for (int i = 1; i < 112; i += 3){
      if (level == i || level == 1){
        Map.getInstance().loadMap(1);
      }
    
    }

    for (int i = 2; i < 112; i +=3){
      if (level == i || level == 2){
        Map.getInstance().loadMap(2);
      }
    }

    for (int i = 3; i < 112; i += 3 ){
      if (level == i || level == 3){
        Map.getInstance().loadMap(3);
      }
      
    }
    
  }

  /* Gets the player's level
   * @return player's level
   */
  public int getLevel(){
    return level;
  }

  /* Heros method to move up and makes sure they stay on the map 
  *  @returns char from the map or 'x' if they attempt to get off the map
  */  
  public char goNorth(){
    loc.y -= 1;
    if (loc.y < 0) {
      loc.y = 0;
      return 'x';
    }
    loc = new Point(loc.x, loc.y);
    return Map.getInstance().getCharAtLoc(loc);
  }
 
 /* Heros method to move down and makes sure they stay on the map 
  *  @returns char from the map or 'x' if they attempt to get off the map
  */
  public char goSouth(){
    loc.y += 1;
    if (loc.y > 4){
      loc.y = 4;
      return 'x';
    }
    loc = new Point(loc.x, loc.y);
    return Map.getInstance().getCharAtLoc(loc);
  }

  /* Heros method to move right and makes sure they stay on the map 
  *  @returns char from the map or 'x' if they attempt to get off the map
  */
  public char goEast(){
    loc.x += 1;
    if (loc.x > 4){
      loc.x = 4;
      return 'x';
    }
    loc = new Point(loc.x, loc.y);
    return Map.getInstance().getCharAtLoc(loc);
  }

  /* Heros method to move left and makes sure they stay on the map 
  *  @returns char from the map or 'x' if they attempt to get off the map
  */
  public char goWest(){
    loc.x -= 1;
    if (loc.x < 0){
      loc.x = 0;
      return 'x';
    }
    loc = new Point(loc.x, loc.y);
    return Map.getInstance().getCharAtLoc(loc);
  }

  /* Gets player's location
   * @returns loc which is the player's coordinates
  */
  public Point getLoc(){
    return loc;
  }

  /* Gets player's gold
   * @return the gold
   */
  public int getGold() {
    return gold;
  }
  
  /* Adds to player's gold
   * @param int g is the amount of gold being added
   * @return the total gold
  */
  public void collectGold(int g){
    gold += g;
  }

  /* Subtracts to player's gold
   * @param int g is the amount of gold being subtracted
   * @return the total gold
  */
  public void spendGold(int g){
    gold -= g;
  }

  /* Checks if player has key
   * @return true if player has key or false if player doesn't have key
  */
  public boolean hasKey(){
    if(key != 0){
      return true;
    }
    return false;
  }

  //Adds to player's key amount
  public void pickUpKey(){
    key += 1;
  }

  /* Subtracts from player's key amount
   * @return false when player uses a key
  */
  public boolean useKey(){
    key -= 1;
    return false;
  }
  /* Gives the Entity a random amount of damage
   * @param e The Entity that the magical enemy is attacking
   * @return It prints out how the Entity got attacked and how much damage it took.
   */
  @Override
  public String magicMissile(Entity e){
    int physdamage = (int)((Math.random() * 2) + 3);
    e.takeDamage(physdamage);
    return getName() + " shoots " + e.getName() + " with Magic Missel for " + physdamage + " damage.";
  }

   /*Heros fireball attack method
    *Magical damage range beetwwen 4 and 5 
    *@return string representation of magical damage dealt
   */ 
  @Override
  public String fireball(Entity e){
    int physdamage = (int)(Math.random() * 2) + 4;
    e.takeDamage(physdamage);
    return getName() + " hits " + e.getName() + " with Fireball for " + physdamage + " damage.";
  }

  /*Heros thunderclap attack method
   *Magical damage range beetwwen 2 and 4
   *@return string representation of magical damage dealt
   */ 
  @Override
  public String thunderclap(Entity e){
    int physdamage = (int)(Math.random() * 3) + 2;
    e.takeDamage(physdamage);
    return getName() + " zaps " + e.getName() + " with Thunderclap for " + physdamage + " damage.";
  }

  /* Gives the Entity a random amount of damage
   * @param e The Entity that the enemy is attacking
   * @return It prints out how the Entity got attacked and how much damage it took.
   */
  @Override
  public String attack(Entity e){
    int physdamage = (int)(Math.random() * 4) + 1;
    e.takeDamage(physdamage);
    return getName() + " attacks " + e.getName() + " with long sword for " + physdamage + " damage.";
  }

}  