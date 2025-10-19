import MarvellousPackerUnpacker.MarvellousPacker;
import java.util.*;
import java.io.*;

class Program468
{
    public static void main(String A[]) 
    {
        try
        {
            Scanner sobj = new Scanner(System.in);

            System.out.println("Enter the name of directory that u want to PACK:");
            String DirName = sobj.nextLine();

            System.out.println("Enter the name of file that u want to create for PACKING:");
            String PackName = sobj.nextLine();

            MarvellousPacker mobj = new MarvellousPacker(PackName, DirName);
            mobj.PackingActivity();

        }
        catch(Exception eobj)
        {

        }
    }//end of main
}//end of program467 class