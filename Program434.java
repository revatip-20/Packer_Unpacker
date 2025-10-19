import java.util.*;
import java.io.*;

class Program434
{
    public static void main(String A[])
    {
        try
        {
            Scanner sobj = new Scanner(System.in);
            System.out.println("enter name of file u want to enter:");
            String Fname = sobj.nextLine();
            
            File fobj = new File(Fname);

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