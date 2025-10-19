import java.util.*;
import java.io.*;

class MarvellousPacker
{
    private String PackName;
    private String DirName;

    public MarvellousPacker(String A,String B)
    {
        this.PackName = A;
        this.DirName = B;
    }

    public void PackingActivity()
    {
        try
        {
            System.out.println("---------------------------------------------------");
            System.out.println("------Marvellous Packer Unpacker------");
            System.out.println("---------------------------------------------------");
            System.out.println("----------Packing Activity----------");
            System.out.println("---------------------------------------------------");

            int i = 0,j = 0,iRet = 0,iCountFile = 0;

            File fobj = new File(DirName);

            //Check the existance of directory
            if((fobj.exists()) && (fobj.isDirectory()))
            {
                System.out.println(DirName+"directory is successfully opened");
                File packobj = new File(PackName);

                //Create a packed file
                boolean bRet = packobj.createNewFile();

                //Check the existance of directory
                if(bRet == false)
                {
                    System.out.println("unable to create");
                    return;
                }

                System.out.println("Packed file gets successfully created with Pack Name");

                //Retrive all files from directory
                File Arr[] = fobj.listFiles();

                FileOutputStream foobj = new FileOutputStream(packobj);

                byte Buffer[] = new byte[1024];

                String Header = null;

                for (i = 0; i < Arr.length; i++)
                {
                    Header = Arr[i].getName()+" "+Arr[i].length();
                    System.out.println(Header+"length of header :"+Header.length());

                    for(j = Header.length(); j < 100; j++)
                    {
                        Header = Header + " ";
                    }
                    foobj.write(Header.getBytes());
                    
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
                    iCountFile++;
                }
                System.out.println("Packing activity done");

                System.out.println("---------------------------------------------------");
                System.out.println("-------Statistical Report--------");
                System.out.println("---------------------------------------------------");

                // to be added
                System.out.println("total files packed:"+iCountFile);

                System.out.println("---------------------------------------------------");
                System.out.println("------Thank you for using our application-----");
                System.out.println("---------------------------------------------------");
            }
            else
            {
                System.out.println("no such directory");
            }

        }//end of try
        catch(Exception eobj)
        {

        }

    }//end of packing activity function
} //end of marvellous packer class

class Program467
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