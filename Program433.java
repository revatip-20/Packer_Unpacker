import java.util.*;
import java.io.*;

class Program433
{
    public static void main(String A[])
    {
        try
        {
            File fobj = new File("PPA.txt");

            if(fobj.exists())
            {
                System.out.println("file already exists");

            }
            else
            {
                fobj.createNewFile();
                System.out.println("file successfully created");
            }
        }
        catch(IOException iboj)
        {}
        catch(Exception eobj)
        {}
       
    }
}