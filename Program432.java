import java.util.*;
import java.io.*;

class Program432
{
    public static void main(String A[])
    {
        try
        {
            File fobj = new File("Marvellous.txt");
            fobj.createNewFile();
        }
        catch(IOException iboj)
        {}
        catch(Exception eobj)
        {}
       
    }
}