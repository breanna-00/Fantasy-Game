public interface Magical {
  
  /* 
  *Magic Menu display 
  */
  public static final String MAGIC_MENU = "1. Magic Missile\n2. Fireball\n3. Thunderclap";
   
/*
*interface method to attack with magicMissile
*/
  public String  magicMissile(Entity e);

/*
*interface method to attack with fireball
*/

  public String  fireball(Entity e);

/*
*interface method to attack with thunderclap
*/
  public String thunderclap(Entity e);

}