import java.util.*;
import java.io.*;
class Main{
  public static void main(String args[]) throws Exception{
    FileReader fr=new FileReader("ifsc.json");
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter Bank Code : ");
    String code=br.readLine();
    Scanner sc=new Scanner(fr);
    boolean found=false;
    String s="Code ";
    while(sc.hasNextLine())
    {
      StringTokenizer st=new StringTokenizer(s);
      if(!st.nextToken().equals(code))
        s=sc.next().replace('\"',' ');   
      else
      {
        found=true;
        sc.nextLine();
        String s2=sc.nextLine().trim();
        s2=s2.replace('\"',' ');
        while(!s2.equals("},"))
        {
          System.out.println(s2.replace(',',' '));
          s2=sc.nextLine().trim();
          s2=s2.replace('\"',' ');
        }
        sc.close();
        break;
     }
    }
  }
}