import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws FileNotFoundException {

        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        Scanner input = new Scanner(new File("src/array.txt"));
        while(input.hasNextLine())
        {
            Scanner colReader = new Scanner(input.nextLine());
            ArrayList col = new ArrayList();
            while(colReader.hasNextInt())
            {
                col.add(colReader.nextInt());
            }
            array.add(col);
        }

        Manager manager = new Manager();

        manager.array = array;

        int thread_amount = 4;

        for (int i = 0; i < thread_amount; i++) {
            BeesThread thread = new BeesThread(manager);
            thread.start();
        }
    }
}
