import java.util.*;
import java.io.*;

class Program438
{
    public static void main(String A[])
    {
        try
        {
            Scanner sobj = new Scanner(System.in);
            System.out.println("enter name of file u want to open:");
            String Fname = sobj.nextLine();
            
            File fobj = new File(Fname);

            if(fobj.exists())
            {
                FileInputStream fiobj = new FileInputStream(fobj);

                byte Arr[] = new byte[10];

                fiobj.read(Arr);
                String str  = new String(Arr);

                System.out.println("data:"+str);

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