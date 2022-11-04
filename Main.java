import java.io.*;
public class Main
{
  void displayBoard(int[] xplay, int[] oplay) 
  {
    char one=xplay[0]==1?'X':(oplay[0]==1?'O':' ');
    char two=xplay[1]==1?'X':(oplay[1]==1?'O':' ');
    char three=xplay[2]==1?'X':(oplay[2]==1?'O':' ');
    char four=xplay[3]==1?'X':(oplay[3]==1?'O':' ');
    char five=xplay[4]==1?'X':(oplay[4]==1?'O':' ');
    char six=xplay[5]==1?'X':(oplay[5]==1?'O':' ');
    char seven=xplay[6]==1?'X':(oplay[6]==1?'O':' ');
    char eight=xplay[7]==1?'X':(oplay[7]==1?'O':' ');
    char nine=xplay[8]==1?'X':(oplay[8]==1?'O':' ');
    System.out.println(one+" | "+two+" | "+three);
    System.out.println("-"+"-|-"+"-"+"-|-"+"-");
    System.out.println(four+" | "+five+" | "+six);
    System.out.println("-"+"-|-"+"-"+"-|-"+"-");
    System.out.println(seven+" | "+eight+" | "+nine);
  }

  int checkWinner(int turn,int[] xplay, int[] oplay)
  {
    if(turn>9)
      return -1;// -1 for draw
    int[][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};// At these positions, a player can win
    for(int i=0;i<8;++i)
      if(xplay[win[i][0]]+xplay[win[i][1]]+xplay[win[i][2]]==3)
        return 1;
      else if(oplay[win[i][0]]+oplay[win[i][1]]+oplay[win[i][2]]==3)
        return 0;
    return 2;
  }
  
  public static void main ( String args[]) throws IOException
  {
    Main ob=new Main();
    System.out.println("Welcome to Tic Tac Toe");
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    // Value at index at which a X or O plays changes to 1 for X as well as for O respectively
    int[] xplay={0,0,0,0,0,0,0,0,0};
    int[] oplay={0,0,0,0,0,0,0,0,0};
    int turn=1;
    while(true)       
    {
      ob.displayBoard(xplay,oplay);// Display Game Board after every iteration
      if(turn%2==1)
      {//Every odd turn is for X
        System.out.print("X Turn\nEnter Position : ");
        int pos=Integer.parseInt(br.readLine())-1;
        //Now checking conditions for position to be valid
        if(pos>=0&&pos<9) //This condition checks if player has entered valid value of position
        {
          if(xplay[pos]!=1 && oplay[pos]!=1) // This condition checks if the player does not enter position which is not occupied
            xplay[pos]=1;
          else
          {
            System.out.println("Position already occupied... Enter again");
          turn--;
          }
        }
        else
        {
          System.out.println("Position out of range... Enter again");
          turn--;
        }
      }
      else
      {
        System.out.print("O Turn\nEnter Position : ");
        int pos=Integer.parseInt(br.readLine())-1;
        //Now checking conditions for position to be valid
        if(pos>=0&&pos<9) //This condition checks if player has entered valid value of position
        {
          if(xplay[pos]!=1 && oplay[pos]!=1) // This condition checks if the player does not enter position which is not occupied
            oplay[pos]=1;
          else
          {
            System.out.println("Position already occupied... Enter again");
          turn--;
          }
        }
        else
        {
          System.out.println("Position out of range... Enter again");
          turn--;
        }
      }
      int c=ob.checkWinner(turn,xplay,oplay);
      if(c==1)
      {
        ob.displayBoard(xplay,oplay);;
        System.out.print("X won");
        break;
      }
      else if(c==0)
      {
        ob.displayBoard(xplay,oplay);
        System.out.print("O won");
        break;
      }
      else if(c==-1)
      {
        ob.displayBoard(xplay,oplay);
        System.out.print("Draw");
        break;
      }      
      turn++;
    }  
  }
}