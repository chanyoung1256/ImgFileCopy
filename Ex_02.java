package File_Stream;
import java.io.*;
public class Ex_02 {
    public static void main(String[] args)
    {
        FileInputStream fin = null;
        FileOutputStream fout = null;

        byte[] tmp = new byte[500];

        try
        {
            fin = new FileInputStream("Test.png");
            fout = new FileOutputStream("Copy.png");
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("파일이 없어요");
        }

        while(true)
        {
            int cnt = 0;
            try
            {
                cnt = fin.read(tmp);
            }
            catch (IOException ioe)
            {
                System.out.println("읽을 수 없어요");
            }
            if(cnt <= 0)
            {
                System.out.println("복사 끝~~");
                break;
            }

            try
            {
                fout.write(tmp);
            }
            catch (IOException ioe)
            {
                System.out.println("파일에 쓸 수 없어요");
            }

            try
            {
                fin.close();
                fout.close();
            }
            catch (IOException ioe)
            {
                System.out.println("닫을 수 없어요");
            }
        }
    }
}
