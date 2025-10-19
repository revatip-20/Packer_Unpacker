import java.util.*;
import java.io.*;
import java.nio.file.Files;

class Program473
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

            //Buffer to read the header
            byte HeaderBuffer[] = new byte[100];

            fiobj.read(HeaderBuffer,0,100);

            //convert byte array to string
            String Header = new String(HeaderBuffer);

            System.out.println(Header);

            Header = Header.trim();
            
            String Tokens[] = Header.split(" ");

            System.out.println("File name is:"+Tokens[0]);
            System.out.println("File size is:"+Tokens[1]);

            File fobjnew = new File(Tokens[0]);

            fobjnew.createNewFile();

            int FileSize = Integer.parseInt(Tokens[1]);

            byte Buffer[] = new byte[FileSize];

            FileOutputStream foobj = new FileOutputStream(fobjnew);

            fiobj.read(Buffer,0,FileSize);

            foobj.write(Buffer,0,FileSize);

        }
        catch(Exception eobj)
        {

        }
    }//end of main
}//end of program467 class