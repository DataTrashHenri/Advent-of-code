import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class day1_main {

    static List<String> rows = List.of(day1_input.samples.split("\n"));

    static int[] leftCol = rows.stream().mapToInt(s-> Integer.parseInt(s.split("   ")[0])).toArray();
    static int[] leftColSorted = Arrays.stream(leftCol).sorted().toArray();

    static int[] rightCol = rows.stream().mapToInt(s-> Integer.parseInt(s.split("   ")[1])).toArray();
    static int[] rightColSorted = Arrays.stream(rightCol).sorted().toArray();

    static int totalDistance=0;
    static int similarityScore=0;

    public static void main(String[] args) {
        IntStream.range(0, leftColSorted.length).forEach(i-> totalDistance +=Math.abs(rightColSorted[i] - leftColSorted[i]));
        System.out.println("Distance: "+totalDistance);

        Arrays.stream(leftCol).forEach(num-> similarityScore+=num * Arrays.stream(rightCol).filter(n-> n==num).count());
        System.out.println("SimilarityScore : "+similarityScore);

    }



}