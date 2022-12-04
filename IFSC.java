import java.util.*;
import java.io.*;
class Main{
  public static void main(String args[]) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter Bank Code : ");
    String code=br.readLine();
    String s=code.substring(0,4);
    FileReader fr=new FileReader(s+".json");
    Scanner sc=new Scanner(fr);    
    while(sc.hasNextLine())
    {
      StringTokenizer st=new StringTokenizer(s);
      if(!st.nextToken().equals(code))
        s=sc.next().replace('\"',' ');   
      else
      {
        sc.nextLine();
        String s2=sc.nextLine().trim();
        s2=s2.replace('\"',' ');
        while(!s2.equals("},"))
        {
          if(s2.contains("STATE")||s2.contains("BRANCH")||s2.contains("IFSC")||s2.contains("DISTRICT")||s2.contains("ADDRESS"))
          System.out.println(s2.replace(',',' '));
          s2=sc.nextLine();
          s2=s2.replace('\"',' ').trim();
        }
        sc.close();
        break;
     }
    }
  }
}
