import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class day1_main {

    static List<String> rows = List.of(day1_input.samples.split("\n"));
    static int[] leftCol = rows.stream().mapToInt(s-> Integer.parseInt(s.split("   ")[0])).sorted().toArray();
    static int[] rightCol = rows.stream().mapToInt(s-> Integer.parseInt(s.split("   ")[1])).sorted().toArray();

    static int totalDistance,similarityScore=0;

    public static void main(String[] args) {
        //part 1
        IntStream.range(0, leftCol.length).forEach(i-> totalDistance +=Math.abs(rightCol[i] - leftCol[i]));
        System.out.println("Distance: "+totalDistance);

        //part 2
        Arrays.stream(leftCol).forEach(num-> similarityScore+= (int) (num * Arrays.stream(rightCol).filter(n-> n==num).count()));
        System.out.println("SimilarityScore : "+similarityScore);
    }
}