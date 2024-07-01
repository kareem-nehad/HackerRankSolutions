import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int viralAdvertising(int n) {
        // Write your code here
        int shared = 5;
        int liked = (int) (double) (5 / 2);
        int cumulative = 2;
        if (n == 1) {
            return liked;
        } else {
            for (int i = 2 ; i <= n ; i++) {
                shared = liked * 3;
                liked = (int) (double) (shared / 2);
                cumulative += liked;
            }
            return cumulative;
        }
    }

    /*
    shared = 5
    liked = 2
    shared = 6
    liked = 2 + 3 = 5
    shared = 5
     */

}

public class ViralAdvertising {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
