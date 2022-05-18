/* Authors: Nathan Luy, Yousouf Conde, Breanna Le
 * Date: 3/10/2021
 * Description: A game where a player tries to go through 3 levels, encountering monsters along the way.
 */
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
    System.out.print("What's your name, traveler? ");
    String name = CheckInput.getString();
    Hero player = new Hero(name);
    Map gameMap = Map.getInstance();
    gameMap.loadMap(player.getLevel());
    int choice = 1;
    System.out.println(player.getName());
    System.out.println("HP: " + player.getHP() + "/" + player.getMaxHP());
    System.out.println("Level: " + player.getLevel());
    System.out.println(gameMap.mapToString(player.getLoc()));

    while(choice != 5 && player.getHP() > 0){
      if(gameMap.getCharAtLoc(player.getLoc()) == 's'){
        store(player);
        gameMap.reveal(player.getLoc());
      }
      
      System.out.println(player.getName());
      System.out.println("HP: " + player.getHP() + "/" + player.getMaxHP());
      System.out.println("Level: " + player.getLevel());
      System.out.println(gameMap.mapToString(player.getLoc()));

      System.out.println("1. Go North");
      System.out.println("2. Go South");
      System.out.println("3. Go East");
      System.out.println("4. Go West");
      System.out.println("5. Quit");
      choice = CheckInput.getIntRange(1,5); // Read user input
      
      if(choice == 1){
        char spot = player.goNorth();
        gameMap.reveal(player.getLoc());

        if(spot == 'x'){
          System.out.println("You cant go that way.");
        }else if (spot == 'n'){
          System.out.println("There was nothing there.");
        }else if(spot == 'f'){
          System.out.println("You found the exit door, but it's locked");
          if(player.hasKey() == true){
            player.useKey();
            player.levelUp();
            if (player.getLevel() > 3){
              System.out.println("Congrats! You Beat the Game!");
              break;
            }
            System.out.println("You used one of your keys. Proceed to the next level");
            gameMap.loadMap(player.getLevel());
          } else {
            System.out.println("You're out of keys");
          }
        }else if (spot == 's'){
          System.out.println("You are back at the start");
        }else if(spot == 'i'){
          int item = (int)(Math.random() * 2) + 1;
          if(item == 1){
            System.out.println("You found a potion, drink to recover health");
            player.heal(25);
          } else if (item == 2){
            System.out.println("You found a key");
            player.pickUpKey();
          }
          gameMap.removeCharAtLoc(player.getLoc());
        }else if(spot == 'm'){
          EnemyGenerator opponent = new EnemyGenerator();
          Enemy badGuy = opponent.generateEnemy(player.getLevel());
          monsterRoom(player, badGuy);
          gameMap.removeCharAtLoc(player.getLoc());
        }
      } 

      if(choice == 2){
        char spot = player.goSouth();
        gameMap.reveal(player.getLoc());
        
        if(spot == 'x'){
          System.out.println("You cant go that way.");
        }else if (spot == 'n'){
          System.out.println("There was nothing there");
        }else if(spot == 'f'){
          System.out.println("You found the exit door, but it's locked");
          if(player.hasKey() == true){
            player.useKey();
            player.levelUp();
            if (player.getLevel() > 3){
              System.out.println("Congrats! You Beat the Game!");
              break;
            }
            System.out.println("You used one of your keys. Proceed to the next level");
            gameMap.loadMap(player.getLevel());
          } else {
            System.out.println("You're out of keys");
          }
        }else if (spot == 's'){
          System.out.println("You are back at the start");
        }else if(spot == 'i'){
          int item = (int)(Math.random() * 2) + 1;
          if(item == 1){
            System.out.println("You found a potion, drink to recover health");
            player.heal(25);
          } else if (item == 2){
            System.out.println("You found a key");
            player.pickUpKey();
          }
          gameMap.removeCharAtLoc(player.getLoc());   
        }else if(spot == 'm'){
          EnemyGenerator opponent = new EnemyGenerator();
          Enemy badGuy = opponent.generateEnemy(player.getLevel());
          monsterRoom(player, badGuy);
          gameMap.removeCharAtLoc(player.getLoc());
        }
      }

      if(choice == 3){
        char spot = player.goEast();
        gameMap.reveal(player.getLoc());
        
        if(spot == 'x'){
          System.out.println("You cant go that way.");
        }else if (spot == 'n'){
          System.out.println("There was nothing there");
        }else if(spot == 'f'){
          System.out.println("You found the exit door, but it's locked");
          if(player.hasKey() == true){
            player.useKey();
            player.levelUp();
            if (player.getLevel() > 3){
              System.out.println("Congrats! You Beat the Game!");
              break;
            }
            System.out.println("You used one of your keys. Proceed to the next level");
            gameMap.loadMap(player.getLevel());
          } else {
            System.out.println("You're out of keys");
          }
        }else if (spot == 's'){
          System.out.println("You are back at the start");
        }else if(spot == 'i'){
          int item = (int)(Math.random() * 2) + 1;
          if(item == 1){
            System.out.println("You found a potion, drink to recover health");
            player.heal(25);
          } else if (item == 2){
            System.out.println("You found a key");
            player.pickUpKey();
          }
          gameMap.removeCharAtLoc(player.getLoc());
        }else if(spot == 'm'){
          EnemyGenerator opponent = new EnemyGenerator();
          Enemy badGuy = opponent.generateEnemy(player.getLevel());
          monsterRoom(player, badGuy);
          gameMap.removeCharAtLoc(player.getLoc());
        }
      }
      
      if(choice == 4){
        char spot = player.goWest();
        gameMap.reveal(player.getLoc());
        
        if(spot == 'x'){
          System.out.println("You cant go that way.");
        }else if (spot == 'n'){
          System.out.println("There was nothing there");
        }else if(spot == 'f'){
          System.out.println("You found the exit door, but it's locked");
          if(player.hasKey() == true){
            player.useKey();
            player.levelUp();
            if (player.getLevel() > 3){
              System.out.println("You used one of your keys");
              System.out.println("Congrats! You Beat the Game!");
              break;
            }
            System.out.println("You used one of your keys. Proceed to the next level");
            gameMap.loadMap(player.getLevel());
          } else {
            System.out.println("You're out of keys");
          }
        }else if (spot == 's'){
          System.out.println("You are back at the start");
        }else if(spot == 'i'){
          int item = (int)(Math.random() * 2) + 1;
          if(item == 1){
            System.out.println("You found a potion, drink to recover health");
            player.heal(25);
          } else if (item == 2){
            System.out.println("You found a key");
            player.pickUpKey();
          }
          gameMap.removeCharAtLoc(player.getLoc());  
        }else if(spot == 'm'){
          EnemyGenerator opponent = new EnemyGenerator();
          Enemy badGuy = opponent.generateEnemy(player.getLevel());
          monsterRoom(player, badGuy);
          gameMap.removeCharAtLoc(player.getLoc());
        }
      }
    }
    System.out.println("Game Over");
  }
  /*    Displays the enemy and prompt the user to flee or fight
  *     @ param Hero h is the player
  *     @ param Enemy e is the enemy
  *     @ return boolean
  */  
public static boolean monsterRoom(Hero h, Enemy e){
  System.out.println("You have encountered a " + e.getName());
  System.out.println(e.toString());
  boolean alive = true;
  while(e.getHP() !=0 ){
    System.out.println("1. Fight \n2. Run Away");
    int choice = CheckInput.getIntRange(1,2);
    if (choice==1){
      alive = fight(h,e);
      if(alive){
        System.out.println(e);
      }
      else{
        return alive;
      }
    } if(choice==2){
      int runchoice=(int)((Math.random()*4)+1);
      if(runchoice==1){
        h.goNorth();
        choice = 1;
      }else if (runchoice==2){
        h.goSouth();
        choice = 2;
      }else if (runchoice==3){
        h.goEast();
        choice = 3;
      }else if (runchoice== 4){
        h.goWest();
        choice = 4;
      }
      break;
    }
  }
  if (!(h.getHP()>0)){
    alive = false;
    return alive;
  }
  if(e.getHP()==0){
    System.out.println("You defeated the "+ e.getName());
    int randGold = (int)(Math.random() * 10) + 3;
    h.collectGold(randGold); 
    System.out.println("You won " + randGold + " pieces of gold");
    return alive;
  }
  return alive;
}

  /* Choses attack for player and opponent
   * @param Hero h Is the player
   * @param Emeny e Is the opponent
   * @return True or False if the player is alive
   */
  public static boolean fight(Hero h, Enemy e){
    System.out.println("1. Physical Attack");
    System.out.println("2. Magical Attack");
    int option = CheckInput.getIntRange(1,2);

    if(option == 1){
      System.out.println(h.attack(e));
      if(e.getHP() > 0){
        int attackNum = 0;
        while(h.getLevel() != attackNum){
          System.out.println(e.attack(h));
          attackNum += 1;
        }
      }
    }

    if(option == 2){
      // allow them to choose from the magical menu for which spell to cast
      System.out.println(h.MAGIC_MENU);
      int choice = CheckInput.getIntRange(1,3);
      if (choice == 1){
        System.out.println(h.magicMissile(e));
      }
      if (choice == 2){
        System.out.println(h.fireball(e));
      } 
      if (choice == 3){
        System.out.println(h.thunderclap(e));
      }

      if(e.getHP() > 0){
        int attackNum = 0;
        while(h.getLevel() != attackNum){
          System.out.println(e.attack(h));
          attackNum += 1;
        }
      }

    }

    if (h.getHP() > 0){ // Checks if hero is still alive
      //Return true if the hero is still alive after the entire encounter
      return true;
    } else {
      return false;
    }

  }

  /* Allows the player to buy keys or health potions at the start of each level, if they can afford it
   * @param Hero h is the player
  */
  public static void store(Hero h){
    System.out.println("Welcome to the store!");
    int store_Choice = 0;
    while(store_Choice != 3){
      System.out.println("Choose what to buy:\n1. Health Potion - 25 gold\n2. Key - 50 gold\n3. Exit store");
      store_Choice = CheckInput.getIntRange(1,3);
      if(store_Choice == 1){
        if(h.getGold() >= 25){
          System.out.println("You drank the potion");
          h.spendGold(25);
          h.heal(25);
        } else {
          System.out.println("Sorry, you can't afford this item");
        }
      } else if (store_Choice == 2){
        if(h.getGold() >= 50){
          System.out.println("You collect a key");
          h.spendGold(50);
          h.pickUpKey();
        } else {
          System.out.println("Sorry, you can't afford this item");
        }
      }
    }
  }

}