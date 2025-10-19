import java.util.*;
import java.io.*;
import java.nio.file.Files;

class Program475
{
    public static void main(String A[]) 
    {
        try
        {
            String Header = null;
            Scanner sobj = new Scanner(System.in);
            int FileSize = 0,iRet = 0,iCountFile = 0;
            File fobjnew = null;

            System.out.println("Enter the name of file that contains packed data:");
            String PackName = sobj.nextLine();

            File fobj = new File(PackName);

            //If packed file is not present
            if(!fobj.exists())
            {
                System.out.println("unable to access Packed file");
                return;
            }

            System.out.println("Packed file gets successfully opened");

            FileInputStream fiobj = new FileInputStream(fobj);

            //Buffer to read the header
            byte HeaderBuffer[] = new byte[100];

            //Scan packed file to extract the files from it
            while((iRet = fiobj.read(HeaderBuffer,0,100))!= -1)
            {
                //convert byte array to string
                Header = new String(HeaderBuffer);

                Header = Header.trim();

                //Tokenize the header into 2 parts
                String Tokens[] = Header.split(" ");

                fobjnew = new File(Tokens[0]);

                //Create new file to extract
                fobjnew.createNewFile();

                FileSize = Integer.parseInt(Tokens[1]);

                //create new buffer to store files data
                byte Buffer[] = new byte[FileSize];

                FileOutputStream foobj = new FileOutputStream(fobjnew);

                //read the data from packed file
                fiobj.read(Buffer,0,FileSize);
                
                //write data into extracted file
                foobj.write(Buffer,0,FileSize);

                System.out.println("File unpacked with:"+Tokens[0]+"having size:"+Tokens[1]);
                iCountFile++;

                foobj.close();

            }//end of while
            System.out.println("Total number of files unpacked:"+iCountFile);
            fiobj.close();
        }
        catch(Exception eobj)
        {

        }
    }//end of main
}//end of program467 class