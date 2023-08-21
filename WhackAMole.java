public class WhackAMole
{
  private int score;
  private int molesLeft;
  private int attemptsLeft;
  private char[][] moleGrid;

  public WhackAMole(int numAttempts, int gridDimension)
  {
    attemptsLeft = numAttempts;
    moleGrid = new char[gridDimension][gridDimension];
  }

  public boolean place(int x, int y)
  {
    if (moleGrid[x][y] == 'M')
    {
      return false;
    }     
    else
    {
      moleGrid[x][y] = 'M';
      molesLeft++;
      return true;
    }
  }

  public void whack(int x, int y)
  {
    if (moleGrid[x][y] == 'M')
    {
      System.out.println("Mole hit!");
      System.out.println(" ");
      moleGrid[x][y] = 'W';
      score++;
      attemptsLeft -= 1;
      molesLeft -= 1;   
      printGridToUser();
      System.out.println("Whacks remaining: " + attemptsLeft);
      System.out.println();
    }
      
    else
    {
      System.out.println("No mole in this hole");
      attemptsLeft -= 1;
      System.out.println("Whacks remaining: " + attemptsLeft);
      System.out.println();
    }
  }

  public void printGridToUser()
  {
    for (int row = 0; row < moleGrid.length; row++)
    {
        for (int col = 0; col < moleGrid[row].length; col++)
        {
            if (moleGrid[row][col] == 'W')
            {
              System.out.print("W");
            }
            else
            {
              System.out.print("*");
            }
        }
        System.out.println();
    }
    System.out.println();
  }

  public void printGrid()
  {
    for (int row = 0; row < moleGrid.length; row++)
    {
        for (int col = 0; col < moleGrid[row].length; col++)
        {
          if (moleGrid[row][col] != 'M' && moleGrid[row][col] != 'W')
          {
            System.out.print("*");
          }
          else
          {
            System.out.print(moleGrid[row][col]);
          }
        }
      System.out.println();
    }
    System.out.println();
  }

  public char[][] getMoleGrid()
  {
    return moleGrid;
  }

  public int getMolesLeft()
  {
    return molesLeft;
  }

  public int getAttemptsLeft()
  {
    return attemptsLeft;
  }

  public int getScore()
  {
    return score;
  }
}