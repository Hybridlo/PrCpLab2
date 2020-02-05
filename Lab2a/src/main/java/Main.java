import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Integer done = 0;
    static ArrayList<ArrayList<Integer>> a;

    public static void main (String args []) throws FileNotFoundException {

        a = new ArrayList<>();
        Scanner input = new Scanner(new File("src/array.txt"));
        while(input.hasNextLine())
        {
            Scanner colReader = new Scanner(input.nextLine());
            ArrayList col = new ArrayList();
            while(colReader.hasNextInt())
            {
                col.add(colReader.nextInt());
            }
            a.add(col);
        }

        int thread_amount = 4;

        for (int i = 0; i < thread_amount; i++) {
            BeesThread thread = new BeesThread();
            thread.start();
        }
    }
}
