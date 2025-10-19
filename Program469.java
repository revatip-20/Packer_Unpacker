import java.util.*;
import java.io.*;

class Program469
{
    public static void main(String A[]) 
    {
        try
        {
            Scanner sobj = new Scanner(System.in);

            System.out.println("Enter the name of file that contains packed data:");
            String PackName = sobj.nextLine();

            File fobj = new File(PackName);

            if(!fobj.exists())
            {
                System.out.println("unable to access Packed file");
                return;
            }

            System.out.println("Packed file gets successfully opened");

            FileInputStream fiobj = new FileInputStream(fobj);

        }
        catch(Exception eobj)
        {

        }
    }//end of main
}//end of program467 class