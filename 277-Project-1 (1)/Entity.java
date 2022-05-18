public abstract class Entity{
  private String name;
  private int maxHp;
  private int hp;
/*
 *sets all enemies initial hp and maxhp to 0
 */
  public Entity(){
    name = "Enemy";
    hp = 0;
    maxHp = 0;
  }

  /* Constructs an Entity object with a name and max hp
   * @param n It's the name of the Entity
   * @param mHp It's the max health of the Entity
   */
  public Entity(String n, int mHp){
    name = n;
    hp = mHp;
    maxHp = mHp;
  }

  /* The regular attack for the non-magical characters
   * @param e It's the character that is being attacked
   */
  public abstract String attack(Entity e);

  /* Gets the name of the Entity
   * @return Returns the name of the Entity
   */
  public String getName(){
    return name;
  }

  /* Gets the hp of the Entity
   * @return Returns the hp of the Entity
   */
  public int getHP(){
    return hp;
  }

  /* Gets the max hp of the Entity
   * @return Returns the max hp of the Entity
   */
  public int getMaxHP(){
    return maxHp;
  }

  /* Heals the Entity by adding onto it's hp, but not exceeding the max hp
   * @param h It's the current hp of the Entity
   */
  public void heal(int h){
    hp += h;
    if(hp > maxHp){
      hp = maxHp;
    }
  }

  /* Takes the damage of the Entity by subtracting it's hp, but not going below zero.
   * @param d It's the amount of damage the Entity took
   */
  public void takeDamage(int d){
    hp -= d;
    if (hp < 0){
      hp = 0;
    }
  }

  /* Displays the name, hp, and max hp of the Entity
   * @return It displays the name and the current hp out of max hp of the Entity
   */
  public String toString(){
    return getName() + "\nHP: " + getHP() + "/" + getMaxHP();
  }

}