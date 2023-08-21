import java.util.Scanner;
public class Main 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    WhackAMole game = new WhackAMole(50, 10);
    System.out.println("Max whacks: 50");
    System.out.println();

    for (int row = 0; row < game.getMoleGrid().length; row++)
    {
      game.place(row, (int)(Math.random()*10));
      if (game.getMolesLeft() == 10)
      {
         break;
      }     
    }
    game.printGridToUser();

    while (game.getAttemptsLeft() > 0)
    {
      System.out.print("Enter y coordinate: ");
      int y = input.nextInt();

      System.out.print("Enter x coordinate: ");
      int x = input.nextInt();

      boolean go = true;

      if (x > 9 || y > 9 || x < -1 || y < -1 || y == -1 && x != -1 || x == -1 && y != -1)
      {
        go = false;
        System.out.println("Invalid coordinate");
        System.out.println();
      }

      if (go)
      {

      if (x == -1 && y == -1)
      {
        System.out.println();
        System.out.println("You forfeit");
        System.out.println("Score: " + game.getScore());
        game.printGrid();
        break;
      }
        
      else
      {
        game.whack(y, x);
        
        if (game.getMolesLeft() == 0)
        {
          System.out.println("You won!");
          System.out.println("Score: " + game.getScore());
          game.printGrid();
          break;
        }        
      }
      }
    }
    
    if (game.getAttemptsLeft() == 0)
    {
      System.out.println("You lost");
      System.out.println("Score: " + game.getScore());
      game.printGrid();
    }
  }      
}