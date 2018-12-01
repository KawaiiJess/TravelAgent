import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("./input2.txt"));

        String t = "+3 +3 +4 -2 -4";
        String t1 = "+1 -1";
        String t2 = "-6 +3 +8 +5 -6";
        String t3 = "+7 +7 -2 -7 -4";

        //Scanner scan = new Scanner(t3);

        long total = 0;
        int count = 0;
        Set<String> hash_set = new HashSet<>();

        while (scan.hasNextLine())
        {

            if (!hash_set.contains(Long.toString(total)))
            {
                hash_set.add(Long.toString(total));
            }
            else
            {
                System.out.println(total);
                break;
            }

            total += scan.nextInt();


            if (!scan.hasNextLine())
            {
                scan.close();
                scan = new Scanner(new File("./input2.txt"));
                count++;
            }
        }
        System.out.println(count);
    }
}
