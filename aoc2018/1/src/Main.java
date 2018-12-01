import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("./input.txt"));

        int total = 0;

        while (scan.hasNextLine())
        {
            total += scan.nextInt();
        }

        System.out.println(total);
    }
}
