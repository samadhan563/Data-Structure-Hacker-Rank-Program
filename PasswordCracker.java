import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PasswordCracker
{
    static String login;
    static Stack stack;
    static boolean flag = false;
    static int[] lastPos;
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            stack = new Stack();
            flag = false;
            String[] pass = new String[n];
            for(int i = 0; i < n; i++)
            {
                pass[i] = sc.next();
            }
            login = sc.next();
            lastPos = new int[login.length()];
            pass = checkPasswords(pass);
            
            for(int i = 0; i < pass.length-1; i++)
            {
                int min = i;
                for(int j = i+1; j < pass.length; j++)
                {
                    if(pass[j].length() < pass[min].length())
                        min = j;
                }
                String temp = pass[min];
                pass[min] = pass[i];
                pass[i] = temp;
            }
            
            findCombination(pass, 0);
            if(stack.isEmpty())
                System.out.println("WRONG PASSWORD");
            else
            {
                while(!stack.isEmpty())
                {
                    String s = (String)stack.pop();
                    System.out.print(s);
                    if(!stack.isEmpty())
                        System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
    
    static String[] checkPasswords(String[] pass)
    {
        boolean[] marked = new boolean[pass.length];
        for(int i = 0; i < pass.length; i++)
        {
            if(!marked[i]){
                for(int j = 0; j < pass.length; j++)
                {
                    if(j != i && !marked[j] && pass[j].length()%pass[i].length() == 0)
                    {
                        
                        boolean flag = true;
                        int jpos = 0;
                        int ipos = 0;
                        
                        while(jpos < pass[j].length())
                        {
                            if(pass[j].charAt(jpos) != pass[i].charAt(ipos))
                            {
                                flag = false;
                                break;
                            }
                            jpos++;
                            ipos++;
                            if(ipos >= pass[i].length())
                                ipos = 0;
                        }
                        if(flag == true)
                        {
                            marked[j] = true;
                            //System.out.println("marked - " + j);
                        }
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0; i < pass.length; i++)
        {
            if(!marked[i])
                count++;
        }

        String[] newPass = new String[count];
        count = 0;
        for(int i = 0; i < pass.length; i++)
        {
            if(!marked[i])
            {
                newPass[count++] = pass[i];
            }
        }
        return newPass;
    }
    
    static void findCombination(String[] pass, int pos)
    {   
        if(pos == login.length())
        {
            flag = true;
        }
        else{
            int start = lastPos[pos];
            for(int i = start; i < pass.length; i++)
            {
                lastPos[pos]++;
                if(pass[i].length() <= login.length()-pos && login.regionMatches(pos, pass[i], 0,pass[i].length()))
                {
                    //System.out.println("pos = " + pos + "pass[i] = " + pass[i]);
                    findCombination(pass, pos+pass[i].length());
                    if(flag)
                    {
                        stack.push(pass[i]);
                        break;
                    }
                }
            }
        }
    }
}
