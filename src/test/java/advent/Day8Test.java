package advent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static advent.util.TestUtil.openFile;

public class Day8Test {

    private static final String INPUT_FILE = "input.txt";

    private static final int[][] SAMPLE_INPUT = new int[][]{
            {3, 0, 3, 7, 3},
            {2, 5, 5, 1, 2},
            {6, 5, 3, 3, 2},
            {3, 3, 5, 4, 9},
            {3, 5 ,3, 9, 0}};

    private static final int SAMPLE_RESULT_TASK_1 = 21;

    private static final int SAMPLE_RESULT_TASK_2 = 8;

    @Test
    public void sampleTestTask1() {
        Day8Task task = Day8Task.builder(SAMPLE_INPUT)
                .solve(Day8Task.Solution.FIND_VISIBLE_TREES)
                .build();

        Assertions.assertEquals(SAMPLE_RESULT_TASK_1, task.getResult());
    }

    @Test
    public void sampleTestTask2() {
        Day8Task task = Day8Task.builder(SAMPLE_INPUT)
                .solve(Day8Task.Solution.FIND_MAX_VIEWING_SCORE)
                .build();

        Assertions.assertEquals(SAMPLE_RESULT_TASK_2, task.getResult());
    }

    @Test
    public void testTask1() {
        Day8Task task = Day8Task.builder(readInput())
                .solve(Day8Task.Solution.FIND_VISIBLE_TREES)
                .build();

        System.out.printf("Result for task 1 is: %s", task.getResult());;
    }

    @Test
    public void testTask2() {
        Day8Task task = Day8Task.builder(readInput())
                .solve(Day8Task.Solution.FIND_MAX_VIEWING_SCORE)
                .build();

        System.out.printf("Result for task 2 is: %s", task.getResult());;
    }

    private int[][] readInput() {
        Scanner scanner = openFile(this.getClass(), INPUT_FILE);

        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }

        int[][] map = new int[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.get(i).charAt(j)));
            }
        }

        return map;
    }
}
