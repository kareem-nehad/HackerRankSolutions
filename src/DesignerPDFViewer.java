import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        HashMap<Integer, Integer>  lettersASCIIMap = new HashMap<>();
        char[] charArray = word.toCharArray();
        Set<Character> letters = new HashSet<Character>();
        for (char c : charArray) {
            letters.add(c);
        }
        System.out.println("letters " + letters);
        List<Integer> lettersASCII = new ArrayList<>();
        for (char c : letters) {
            lettersASCII.add((int) c);
        }
        System.out.println("letters ASCII "+lettersASCII);
        int j = 0;
        for (int i = 97; i<123;i++) {
            lettersASCIIMap.put(i, h.get(j));
            j++;
        }
        System.out.println("letters ASCII Map "+lettersASCIIMap);

        List<Integer> lettersWeights = new ArrayList<>();
        for (int i = 0; i<lettersASCII.size();i++) {
            lettersWeights.add(lettersASCIIMap.get(lettersASCII.get(i)));
        }
        System.out.println("letter weights "+lettersWeights);
        int maxHeight = Collections.max(lettersWeights);
        return maxHeight * word.length();

    }

}

public class DesignerPDFViewer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
