import java.util.*;
import java.io.*;

class Program455
{
    public static void main(String A[]) 
    {
        try
        {
            String Header = "PPA.txt 30";

            System.out.println("Header Size is:"+Header.length());

            int i = 0;

            for(i = Header.length();i < 100; i++)
            {
                Header = Header + " ";
            }
            System.out.println("Header Size after update is:"+Header.length());
            System.out.println("updated header is :"+Header);

            Header = Header.trim();

            System.out.println("Header Size after trim is:"+Header.length());
            System.out.println("updated header after trim is :"+Header);
        }
        catch(Exception eobj)
        {

        }
    }
}