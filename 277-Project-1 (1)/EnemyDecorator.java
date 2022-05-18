public abstract class EnemyDecorator extends Enemy{
  private Enemy enemy;
/*Assigns the wanted name and hp
 *@param e the entity, n name of the enemy, h enemy hp
 */
  public EnemyDecorator(Enemy e, String n, int h){
    super(n, h);
    enemy = e;
  }
/*attacks for the opponent
 *@param e the entity that will attack
 *@return the entity attacked by the enemy
 */
  @Override
  public String attack(Entity e){
    return e.attack(enemy);
  }
}