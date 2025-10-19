import java.util.*;
import java.io.*;

class Program436
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
                FileOutputStream foobj = new FileOutputStream(fobj);
                String str = "Jay Ganesh...";

                foobj.write(str);

            }
            else
            {
                System.out.println("file not present in current directory");
                return;
            }
        }
        catch(IOException iboj)
        {}
        catch(Exception eobj)
        {}
       
    }
}