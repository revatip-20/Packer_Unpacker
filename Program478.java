import MarvellousPackerUnpacker.MarvellousUnpacker;

import java.util.*;
import java.io.*;
import java.nio.file.Files;

class Program478
{
    public static void main(String A[]) 
    {
        try
        {
            Scanner sobj = new Scanner(System.in);

            System.out.println("Enter the name of file that contains packed data:");
            String PackName = sobj.nextLine();

            MarvellousUnpacker mobj = new MarvellousUnpacker(PackName);
            mobj.UnpackingActivity();
        }
        catch(Exception eobj)
        {}
    }//end of main
}//end of program467 class

//468 packer
//478 unpacker