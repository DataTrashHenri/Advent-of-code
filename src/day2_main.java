import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class day2_main {

    static List<String> rows = Arrays.stream(day2_input.input.split("\n")).toList();
    static int validLevels=0;

    public static void main(String[] args) {

        //Part 1+2
        IntStream.range(0,rows.size()).forEach(i-> {
            int[] currentRow= Arrays.stream(rows.get(i).split(" ")).mapToInt(Integer::parseInt).toArray();
            List <Integer> currentRowList =Arrays.stream(currentRow).boxed().toList();

            if (checkForValid(currentRowList)) {
                validLevels++;
            } else {
                if (IntStream.range(0,currentRow.length).anyMatch(inx-> {

                    List<Integer> modified = new ArrayList<>(currentRowList);
                    modified.remove(inx);

                    return checkForValid(modified);

                })) validLevels++;
            }
        });
        System.out.println(validLevels);
    }
    static boolean checkForValid(List<Integer> row) {
        if (IntStream.range(0, row.size() - 1).allMatch(i -> (row.get(i + 1) - row.get(i)) <= 3 && (row.get(i + 1) - row.get(i)) >= 1)) return true;
        return IntStream.range(0, row.size() - 1).allMatch(i -> (row.get(i + 1) - row.get(i)) >= -3 && (row.get(i + 1) - row.get(i)) <= -1);
    }

}
