public class EnemyGenerator{
  /*
   *generates random enemies on the map
   *@param level the level at which the enemies are spawned
   *@return the Enemy that the player will fight
   */
  public Enemy generateEnemy(int level){
    int randEnemy = (int)(Math.random() * 4) + 1;
    int randNum = (int)(Math.random() * 2) + 1;
    if(level > 0){
      Enemy en = new Goblin();
      if(randEnemy == (1)){
        en = new Goblin();
      } else if (randEnemy == (2)){
        en = new Froglok();
      } else if (randEnemy == (3)){
        en = new Orc();
      } else if (randEnemy == (4)){
        en = new Troll();
      }

      if (level > 1){
        int repeat = 1;
        while (repeat != level){
          if (randNum == 1){
            en = new Warrior(en);
          } else {
            en = new Warlock(en);
          }
          repeat += 1;
        }
      }
      return en;
    }
    return null;
  }
}


      