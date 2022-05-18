import java.util.*;
import java.io.*;

public class Map {
    private char[][] map;
    private boolean[][] revealed;
    private static Map instance = null;

    /*  Map method Represents the rooms on the map
     */
    private Map(){
      map = new char[5][5];
      revealed = new boolean[5][5];
    }

    /*Allows access to the different Maps
     *@return instance that contains the Map object
    */
    public static Map getInstance(){
      if(instance == null){
        instance = new Map();
      }
      return instance;
    }

   /*loadMap method randomly picks a map from the txt files and stores it in the character array
    *reads in in the map from the file and stores it in the character array.
    */
    public void loadMap(int mapNum){
      for(int i =0; i < revealed.length; i++)
      {
          for(int j=0; j< revealed[0].length; j++)
          {
              revealed[i][j]= false;
          }
      }
      String filename = "";
      if(mapNum == 1)
      {
          filename = "Map1.txt";
      }
      else if(mapNum == 2)
      {
          filename = "Map2.txt";
      }
      else if(mapNum == 3)
      {
          filename = "Map3.txt";
      }
      else
      {
          filename = "Map1.txt";
      }
      try{
          Scanner read = new Scanner(new File(filename));
          int startRow = 0;
          while(read.hasNext()){
            String line = read.nextLine();
            line = line.replaceAll(" ","");
            char[] chars = line.toCharArray();
            for(int i = 0; i < chars.length; i++){
              map[startRow][i] = chars[i];
            }
            startRow += 1;
          }
      }catch (FileNotFoundException fnf){
          System.out.println("File not found");
      }
    }

  /* Gets the char from the map at the same point of the player
   * @param Point p is where the player is
   * @return curLoc the char of what the player encountered
   */
  public char getCharAtLoc(Point p){
    char curLoc = map[p.y][p.x];
    return curLoc;
  }
 
 /* Converts the map to a string
  * @param Point p is where the player is
  * @return a string of the map with the heros current location
  */
  public String mapToString(Point p){
    String s = "";
    for(int i = 0; i < map.length; i++)
    {
      for(int j = 0; j< map[0].length; j++)
      {
        if(p.x==j && p.y == i)
        {
          s += "* ";
        }
        else if(revealed[i][j] == false)
        {
          s += "x ";
        }
        else if(revealed[i][j] == true)
        {
          s += map[i][j] + " ";
        }
      }
      s += "\n";

    }
    return s;
  }

 /*maps method to find starting point on the map
  *@return the hero's starting location on the map
  */
  public Point findStart(){
    int x = 0;
    int y = 0;
    for (int i = 0; i< map.length; i++){
      for(int j = 0; j<map[0].length; j++){
        if(map[i][j] == 's'){
          x = j;
          y = i;
                }
            }
        }
        Point start = new Point(x,y);
        return start ;
  }

/*Reveals the point on the map
 */ 
  public void reveal(Point p)
  {
    int x = p.x;
    int y = p.y;
    revealed [y][x] = true;
  }

/*method to remove a char from the location and replace it with 'n'
 */
  public void removeCharAtLoc(Point p){
    int x = p.x;
    int y = p.y;
    map [y][x]= 'n';

  }
}