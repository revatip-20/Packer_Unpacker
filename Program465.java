import java.util.*;
import java.io.*;
import java.nio.file.FileStore;

class Program465
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

            File packobj = new File(PackName);
            boolean bRet = packobj.createNewFile();

            if(bRet == false)
            {
                System.out.println("unable to create");
                return;
            }

            File fobj = new File(DirName);

            if((fobj.exists()) && (fobj.isDirectory()))
            {
                System.out.println("directory present");
                File Arr[] = fobj.listFiles();
                System.out.println("number of files in directory:"+Arr.length);

                int i = 0;

                FileOutputStream foobj = new FileOutputStream(packobj);

                byte Buffer[] = new byte[1024];
                int iRet = 0;

                for (i = 0; i < Arr.length; i++)
                {

                    System.out.println("File name is:"+Arr[i].getName()+" ,File size is:"+Arr[i].length());
                    
                    //open file from dir for reading
                    FileInputStream fiobj = new FileInputStream(Arr[i]);

                    //write contents of file into packed file
                    while((iRet = fiobj.read(Buffer)) != -1)
                    {
                        foobj.write(Buffer,0,iRet);
                        System.out.println("File name scanner:"+Arr[i].getName());
                        System.out.println("File size read:"+iRet);

                    }
                    fiobj.close();
                }
                System.out.println("Packing activity done");
            }
            else
            {
                System.out.println("no such directory");
            }


        }
        catch(Exception eobj)
        {

        }
    }
}