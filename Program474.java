import java.util.*;
import java.io.*;
import java.nio.file.Files;

class Program474
{
    public static void main(String A[]) 
    {
        try
        {
            String Header = null;
            Scanner sobj = new Scanner(System.in);
            int FileSize = 0,iRet = 0;
            File fobjnew = null;

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

            while((iRet = fiobj.read(HeaderBuffer,0,100))!= -1)
            {
                //convert byte array to string
                Header = new String(HeaderBuffer);

                Header = Header.trim();
                
                String Tokens[] = Header.split(" ");

                fobjnew = new File(Tokens[0]);

                fobjnew.createNewFile();

                FileSize = Integer.parseInt(Tokens[1]);

                byte Buffer[] = new byte[FileSize];

                FileOutputStream foobj = new FileOutputStream(fobjnew);

                fiobj.read(Buffer,0,FileSize);

                foobj.write(Buffer,0,FileSize);

                foobj.close();

            }//end of while
            fiobj.close();
        }
        catch(Exception eobj)
        {

        }
    }//end of main
}//end of program467 class